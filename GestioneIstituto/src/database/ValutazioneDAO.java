package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValutazioneDAO {
	
	private int idvalutazioni;
	private String data;
	private float voto;
	private MateriaDAO materia;
	private StudenteDAO studente;
	
	
	public ValutazioneDAO() {
		super();
	}
	
	public ValutazioneDAO(int idvalutazioni) {
		
		this.idvalutazioni=idvalutazioni;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query="SELECT * FROM valutazioni WHERE idvalutazioni='"+this.idvalutazioni+"')";
		try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setData(rs.getString("data"));
				this.setVoto(rs.getFloat("voto"));
			
			}
			
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();	
		}
	}
	
	public void caricaMateriaDaDB() {
		
	
	
		String query = new String("SELECT * FROM materie WHERE valutazioni =\'"+this.idvalutazioni+"'");
	
		
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
	
	public void caricaStudenteDaDB() {
		
		
		
		String query = new String("SELECT * FROM studenti WHERE valutazioni =\'"+this.idvalutazioni+"'");
	
		
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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
