package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudenteDAO {

	private String nome;
	private String cognome;
	private int matricola;
	private Date dataNascita;
	private String codiceFiscale;
	private String comuneResidenza;
	private String email;
	private String numeroCellulare;
	private String username;
	private String password;
	private GenitoreDAO genitore; //mi serve per risalire all'email del genitore per inviare una notifica in caso di insufficienza
	private ArrayList<PagellaDAO> pagelle;//mi serve per generare i quadri di fine quadrimestre
	private ArrayList<ValutazioneDAO> valutazioni;//mi serve per caricare una vista dei voti dello studente per il genitore
	
	//questo costruttore mi servira' per riempire la classe con i dati che carico nel database
	public StudenteDAO() {
		super();										//si riferisce a Object
		this.pagelle =new ArrayList<PagellaDAO>();		//devo istanziare un nuovo array che andrò a riempire con un while nel caricamento da DB attraverso il metodo add 
		this.valutazioni=new ArrayList<ValutazioneDAO>();
	}
	
	//questo costruttore mi servirà per caricare uno studente da DB a partire dalla sua PK
	public StudenteDAO(int matricola) {
		this.matricola = matricola;
		this.pagelle= new ArrayList<PagellaDAO>();
		this.valutazioni=new ArrayList<ValutazioneDAO>();
		caricaDaDB();
	}
	
	//carico solo l'anagrafica dello studente
	public void caricaDaDB() {
		
		String query = "SELECT * FROM studenti WHERE matricola='"+this.matricola+"';";
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			if(rs.next()) {
				
				//carico le colonne dello studente 
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setDataNascita(rs.getDate("dataNascita"));
				this.setCodiceFiscale(rs.getString("codiceFiscale"));
				this.setComuneResidenza(rs.getString("comuneResidenza"));
				this.setEmail(rs.getString("email"));
				this.setNumeroCellulare(rs.getString("numeroCellulare"));
				this.setUsername(rs.getString("username"));
				this.setPassword(rs.getString("password"));
				
			}
			
		}catch( ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	//devo caricare le pagelle(che sono a loro volta un oggetto)
	//ne ho una associata ad ogni studente per ogni anno
	
	public void caricaPagelleStudenteDaDB() {
		
		
		
		String query= new String("SELECT * FROM pagelle WHERE studente='"+this.matricola+"';");
		System.out.println(query); //per debug
		
		try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				//NB:
				PagellaDAO pagella =new PagellaDAO();
				pagella.setAnnoscolastico(rs.getInt("annoscolastico"));
				pagella.setStato(rs.getBoolean("stato"));
				pagella.setMediavoti(rs.getFloat("mediavoti"));
				
				pagella.caricaGiudiziDaDB();
				
				this.pagelle.add(pagella);
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	
	}
	
	public void caricaGenitoreDaDB() {
		
		String query = new String("SELECT * FROM genitori WHERE studente_figlio ='"+this.matricola+"';");
		System.out.println(query); //per debug
		
		try {
			
			ResultSet rs=DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				GenitoreDAO genitore= new GenitoreDAO();
				genitore.setNome(rs.getString("nome"));
				genitore.setCognome(rs.getString("cognome"));
				genitore.setCodiceFiscale(rs.getString("codiceFiscale"));
				genitore.setDataNascita(rs.getDate("dataNascita"));
				genitore.setComuneResidenza(rs.getString("comuneResidenza"));
				genitore.setEmail(rs.getNString("email"));
				genitore.setNumeroCellulare(rs.getString("numeroCellulare"));
				genitore.setUsername(rs.getString("username"));
				genitore.setPassword(rs.getString("password"));
				
				this.genitore=genitore;
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void caricaValutazioniDaDB(){
        
        String query= new String("SELECT * FROM valutazioni WHERE studente='"+this.matricola+"';");
        System.out.println(query); //per debug

        	try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				//NB:
				ValutazioneDAO valutazione =new ValutazioneDAO();
				valutazione.setIdvalutazioni(rs.getInt("idvalutazioni"));
                valutazione.setData(rs.getDate("data"));
				valutazione.setVoto(rs.getFloat("voto"));
				
				MateriaDAO materia= new MateriaDAO(rs.getInt("materia"));
				valutazione.setMateria(materia);
				
				valutazione.caricaMateriaDaDB(); //caricamento in cascata
				this.valutazioni.add(valutazione);
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
	
	public int SalvaInDB(int matricola) {
		
		int ret=0;
		
		String query = "INSERT INTO studenti(matricola,nome,cognome,codicefiscale, datanascita, comuneresidenza, email, numerocellulare, username, password) VALUES ( \'"+matricola+"\',"+"\'"+this.nome+"\','"+this.cognome+"\','"+this.codiceFiscale+"\','"+this.dataNascita+"\','"+this.comuneResidenza+"\','"+this.email+"\','"+this.numeroCellulare+"\','"+this.username+"\','"+this.password+"');";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public int getMatricola() {
		return matricola;
	}


	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}


	public Date getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public String getComuneResidenza() {
		return comuneResidenza;
	}


	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumeroCellulare() {
		return numeroCellulare;
	}


	public void setNumeroCellulare(String numeroCellulare) {
		this.numeroCellulare = numeroCellulare;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public ArrayList<PagellaDAO> getPagelle() {
		return pagelle;
	}


	public void setPagelle(ArrayList<PagellaDAO> pagelle) {
		this.pagelle = pagelle;
	}
	
	@Override
	public String toString() {
		return "DBStudente [nome=" + nome + ", cognome=" +cognome+ ",codice fiscale=" + codiceFiscale + ", data di nascita=" + dataNascita.toString() + ", comune di residenza=" + comuneResidenza + ", email=" + email + ", numero di cellulare=" + numeroCellulare + "]";
	}


	public GenitoreDAO getGenitore() {
		return genitore;
	}


	public void setGenitore(GenitoreDAO genitore) {
		this.genitore = genitore;
	}


	public ArrayList<ValutazioneDAO> getValutazioni() {
		return valutazioni;
	}


	public void setValutazioni(ArrayList<ValutazioneDAO> valutazioni) {
		this.valutazioni = valutazioni;
	}

	
}