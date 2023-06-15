package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenitoreDAO {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String comuneResidenza;
	private String email;
	private String numeroCellulare;
	private String username;
	private String password;
	private StudenteDAO studente; //mi serve per risalire alle valutazioni dello studente
	
	//costruttore di default
	public GenitoreDAO() {
		super();
	}
	
	//costruttore con username
	public GenitoreDAO(String username) {
		
		this.username=username;
		caricaDaDB();
	}
	
	//costruttore con GenitoreDAO
	public GenitoreDAO(GenitoreDAO genitore) {
		
		this.username=genitore.getUsername();
		this.password=genitore.getPassword();
		this.nome=genitore.getNome();
		this.cognome=genitore.getCognome();
		this.dataNascita=genitore.getDataNascita();
		this.codiceFiscale=genitore.getCodiceFiscale();
		this.comuneResidenza=genitore.getComuneResidenza();
		this.email=genitore.getEmail();
		this.numeroCellulare=genitore.getNumeroCellulare();
		
	}
	
	//Caricamento dati Genitore da DataBase
	public void caricaDaDB() {
		
		String query =new String("SELECT * FROM genitori WHERE username = '"+this.username+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setDataNascita(rs.getDate("dataNascita"));
				this.setCodiceFiscale(rs.getString("codiceFiscale"));
				this.setComuneResidenza(rs.getString("comuneResidenza"));
				this.setNumeroCellulare(rs.getString("numeroCellulare"));
				this.setUsername(rs.getString("username"));
				this.setPassword(rs.getString("password"));
				
			}
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//Caricamento dati Studente associato da DataBase
	public void caricaStudenteDaDB() {
		String query= new String("SELECT * FROM studenti WHERE matricola in (SELECT studente_figlio FROM genitori WHERE username =\'"+this.username+"')");
        System.out.println(query); //per debug

        	try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			//Uso un if perchè mi aspetto un solo risultato
			if(rs.next()) {
				
				//NB:
				StudenteDAO studente =new StudenteDAO();
				
				studente.setMatricola(rs.getInt("matricola"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setCodiceFiscale(rs.getString("codiceFiscale"));
				studente.setDataNascita(rs.getDate("dataNascita"));
				studente.setComuneResidenza(rs.getString("comuneResidenza"));
				studente.setEmail(rs.getString("email"));
				studente.setNumeroCellulare(rs.getString("numeroCellulare"));
				studente.caricaValutazioniDaDB();
						
				this.studente=studente;
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//Inserimento dati Genitore nel DB
	public int SalvaInDB(String username) {
		
		int ret=0;
		
		String query = "INSERT INTO genitori(username, password,nome,cognome,codicefiscale, datanascita, comuneresidenza, email, numerocellulare, studente_figlio) VALUES ( \'"+username+"\','"+this.password+"\','"+this.nome+"\','"+this.cognome+"\','"+this.codiceFiscale+"\','"+this.dataNascita+"\','"+this.comuneResidenza+"\','"+this.email+"\','"+this.numeroCellulare+"','"+ studente.getMatricola()+"')";
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
	
	public StudenteDAO getStudente() {
		return studente;
	}

	public void setStudente(StudenteDAO studente) {
		this.studente = studente;
	}
}
