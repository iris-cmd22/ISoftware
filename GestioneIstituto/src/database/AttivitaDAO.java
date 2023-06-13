package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttivitaDAO {

	private int idattivita;
	private String data;
	private String descrizione;
	private DocenteDAO docente;
	
	public AttivitaDAO() {
		super();
	}
	
	public AttivitaDAO(int idattivita) {
		this.idattivita = idattivita;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query = "SELECT * FROM attivita WHERE idattivita='"+this.idattivita+"';";
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setData(rs.getString("data"));
				this.setDescrizione(rs.getString("descrizione"));
			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	//In progress
	public void caricaDocenteDaDB(){
		
	}


	public int SalvaInDB(int idattivita) {
		
		int ret=0;
		
		String query = "INSERT INTO attivita(idattivita,data, descrizione) VALUES ( \'"+idattivita+"\','"+"\'"+this.data+"\','"+this.descrizione+"')";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
	}
		

	public int getIdattivita() {
		return idattivita;
	}

	public void setIdattivita(int idattivita) {
		this.idattivita = idattivita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public DocenteDAO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDAO docente) {
		this.docente = docente;
	}
	

}