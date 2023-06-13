package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagellaDAO {
		
	//dichiaro le variabili della classe
	private boolean stato;
	private int annoscolastico;
	private float mediavoti;
	private StudenteDAO studente;
	private ArrayList<GiudizioDAO> giudizi; //ogni pagella avrà un array dei suoi giudizi, uno per ogni materia
	
	
	public PagellaDAO() {
		super();
		this.giudizi= new ArrayList<GiudizioDAO>();
	}
	
	//costruttore
	public PagellaDAO(StudenteDAO studente, int anno) {
		this.stato=false;
		this.studente=studente;
		this.annoscolastico=anno;
		caricaDaDB();
	}
	
	
	//copy constructor
	public PagellaDAO(PagellaDAO pagella) {
		this.stato= pagella.stato;
		this.annoscolastico= pagella.annoscolastico;
		this.studente = pagella.studente;
		
	}
	
	public void caricaDaDB() {
		
		//Mando la query di select per importare i dati da db
		String query = new String("select * from giudizi where pagella="+this.studente.getMatricola());
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setStato(rs.getBoolean("stato"));
				this.setMediavoti(rs.getFloat("mediavoti"));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	
	}
	
	public void caricaGiudiziDaDB() {
		
		
		String query = new String("select * from giudizi where pagella="+this.studente.getMatricola());
		
		try {
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				GiudizioDAO giudizio = new GiudizioDAO();
				giudizio.setQuadrimestre(rs.getString("quadrimestre"));
				giudizio.setVoto(rs.getFloat("voto"));
				
				giudizio.caricaMateriaDaDB();
				
				this.giudizi.add(giudizio);
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int SalvaINDB(StudenteDAO studente, int anno) {
		
		int ret=0;
		
		String query= "INSERT INTO studenti(studente, annoscolastico, stato) VALUES (\'"+studente+"\','"+anno+"\'.'"+this.stato+"')";
		System.out.println(query); //per debug
		
		try {
			ret=DBConnectionManager.updateQuery(query);
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			ret=-1;
		}
		
		return ret;
	
	}


	public boolean isStato() {
		return stato;
	}


	public void setStato(boolean stato) {
		this.stato = stato;
	}


	public float getMediavoti() {
		return mediavoti;
	}


	public void setMediavoti(float mediavoti) {
		this.mediavoti = mediavoti;
	}


	public int getAnnoscolastico() {
		return annoscolastico;
	}


	public void setAnnoscolastico(int annoscolastico) {
		this.annoscolastico = annoscolastico;
	}


	public StudenteDAO getStudente() {
		return studente;
	}


	public void setStudente(StudenteDAO studente) {
		this.studente = studente;
	}


	public ArrayList<GiudizioDAO> getGiudizi() {
		return giudizi;
	}


	public void setGiudizi(ArrayList<GiudizioDAO> giudizi) {
		this.giudizi = giudizi;
	}
	
	
}
