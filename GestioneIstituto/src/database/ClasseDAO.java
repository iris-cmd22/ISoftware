package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasseDAO {
	
	private int idClasse;
	private int annoscolastico;
	private String sezione;
	private String anno;
	private RegistroDAO registro;
	private ArrayList<StudenteDAO> studenti;
	private ArrayList<MateriaDAO> materie;
	
	public ArrayList<MateriaDAO> getMaterie() {
		return materie;
	}

	public void setMaterie(ArrayList<MateriaDAO> materie) {
		this.materie = materie;
	}

	public ClasseDAO() {
		super();
		this.studenti= new ArrayList<StudenteDAO>();
		this.materie = new ArrayList<MateriaDAO>();
	}
	
	public ClasseDAO(int idclasse) {
		
		this.idClasse=idclasse;
		this.studenti= new ArrayList<StudenteDAO>();
		this.materie = new ArrayList<MateriaDAO>();
		caricaDaDB();
		
	}
	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM classi WHERE idclassi='"+ this.idClasse+"';";
		
		try {
			
			ResultSet rs=DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				//carico colonne della classe
				this.setAnnoscolastico(rs.getInt("annoscolastico"));
				this.setSezione(rs.getString("sezione"));
				this.setAnno(rs.getString("anno"));
			}
			
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	//devo caricare gli studenti che sono a loro volta degli oggetti, 
	//quindi mi servirà fare una query con la corrispondente FK
	
	
	public void caricaStudentiDaDB() {
		
		String query = new String ("select * from studenti where matricola IN (select * from studenti_in_classe where classe=\'"+this.idClasse+"')");
		System.out.println(query); //per debug
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			while(rs.next()) { //uso un while perchè ho più classi
				
				//Dobbiamo istanziare l'oggetto Studente
				StudenteDAO studente=new StudenteDAO();
				studente.setMatricola(rs.getInt("matricola"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setCodiceFiscale(rs.getString("codiceFiscale"));
				studente.setDataNascita(rs.getDate("dataNascita"));
				studente.setComuneResidenza(rs.getString("comuneResidenza"));
				studente.setEmail(rs.getString("email"));
				studente.setNumeroCellulare(rs.getInt("numeroCellulare"));
				
				
				this.studenti.add(studente); //aggiungo l'oggetto all'array
			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void caricaMaterieDaDB(){

		String query = new String ("select * from materie where classe=\'"+this.idClasse+"')");
		System.out.println(query); //per debug
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			while(rs.next()) { //uso un while perchè ho più classi
				
				//Dobbiamo istanziare l'oggetto Materia
				MateriaDAO materia =new MateriaDAO();
				materia.setNome(rs.getString("nome"));  

				this.materie.add(materia); //aggiungo l'oggetto all'array
			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void caricaRegistroDaDB(){

		String query = new String ("SELECT * FROM registri_elettronici WHERE classe=\'"+this.idClasse+"')");
		System.out.println(query); //per debug

		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			if(rs.next()) { //uso un if perchè ho un solo registro
				
				//Dobbiamo istanziare l'oggetto Registro
				RegistroDAO registro=new RegistroDAO();
				registro.setIdRegistro(rs.getInt("idregistro"));
				registro.caricaAttivitaDaDB();

				this.registro=registro;
			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	

	}

	public int SalvaInDB(int idClasse) {
		
		int ret=0;
		
		String query = "INSERT INTO classi(idclassi, sezione, anno, annoscolastico) VALUES ( \'"+idClasse+"\','"+"\'"+this.sezione+"\','"+this.anno+"\','"+this.annoscolastico+"')";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getAnnoscolastico() {
		return annoscolastico;
	}

	public void setAnnoscolastico(int annoscolastico) {
		this.annoscolastico = annoscolastico;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public RegistroDAO getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroDAO registro) {
		this.registro = registro;
	}

	public ArrayList<StudenteDAO> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<StudenteDAO> studenti) {
		this.studenti = studenti;
	}
	
	
	
	
}
