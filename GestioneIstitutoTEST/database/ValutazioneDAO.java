package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValutazioneDAO {
	
	private int idvalutazioni;
	private Date data;
	private float voto;
	private MateriaDAO materia;
	private StudenteDAO studente;
	
	//costruttore di Default
	public ValutazioneDAO() {
		super();
	}
	
	//costruttore con id
	public ValutazioneDAO(int idvalutazioni) {
		
		this.idvalutazioni=idvalutazioni;
		caricaDaDB();
	}
	
	//caricamento dati Valutazione nel DataBase
	public void caricaDaDB() {
		
		String query="SELECT * FROM valutazioni WHERE idvalutazioni='"+this.idvalutazioni+"'";
		try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setData(rs.getDate("data"));
				this.setVoto(rs.getFloat("voto"));
			
			}
			
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();	
		}
	}
	
	//Caricamento dati Materia associata dal DataBase
	public void caricaMateriaDaDB() {
	
		String query = new String("SELECT * FROM materie WHERE idmaterie =\'"+this.materia.getIdmateria()+"'");
	
		
		try {
			
			ResultSet rs=DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				MateriaDAO materie= new MateriaDAO();
				materie.setIdmateria(rs.getInt("idmaterie"));
				materie.setNome(rs.getString("nome"));				
				
				this.materia=materie;
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//Caricamento dati Studente associato dal DataBase
	public void caricaStudenteDaDB() {
		
		
		String query = new String("SELECT * FROM studenti WHERE matricola =\'"+this.studente.getMatricola()+"'");
	
		
		try {
			
			ResultSet rs=DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				StudenteDAO studente=new StudenteDAO();
				studente.setMatricola(rs.getInt("matricola"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setCodiceFiscale(rs.getString("codiceFiscale"));
				studente.setDataNascita(rs.getDate("dataNascita"));
				studente.setComuneResidenza(rs.getString("comuneResidenza"));
				studente.setEmail(rs.getString("email"));
				studente.setNumeroCellulare(rs.getString("numeroCellulare"));
				
				
				this.studente=studente;			
				
				
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//Inserimento dati Valutazione nel DB
		//aggiunto per implementare la funzione AggiungiVoto	
	public int SalvaInDB(int idvalutazioni) {
		
		int ret=0;
		
		String query = "INSERT INTO valutazioni(idvalutazioni,studente,materia,data,voto) VALUES ( \'"+idvalutazioni+"\','"+this.studente.getMatricola()+"\','"+this.materia.getIdmateria()+"\','"+this.data+"\','"+this.voto+"')";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
	}

	public StudenteDAO getStudente() {
		return studente;
	}

	public void setStudente(StudenteDAO studente) {
		this.studente = studente;
	}

	public int getIdvalutazioni() {
		return idvalutazioni;
	}

	public void setIdvalutazioni(int idvalutazioni) {
		this.idvalutazioni = idvalutazioni;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}

	public MateriaDAO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDAO materie) {
		this.materia = materie;
	}
	

}
