package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistroDAO {
	
	private int idRegistro;
	private ArrayList<AttivitaDAO> attivita;
	
	public RegistroDAO() {
		super();
		this.attivita= new ArrayList<AttivitaDAO>();
	}
	
	public RegistroDAO(int idRegistro) {
		this.idRegistro=idRegistro;
		this.attivita= new ArrayList<AttivitaDAO>();
	}
	
	public void caricaAttivitaDaDB() {
		
		String query="SELECT * FROM attivita WHERE idregistro=\'"+this.idRegistro+"')";
		System.out.println(query); //per debug
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				//istanzia attività
				AttivitaDAO attivita1= new AttivitaDAO();
				attivita1.setIdattivita(rs.getInt("attivita"));
				attivita1.setData(rs.getString("data"));
				attivita1.setDescrizione(rs.getString("descrizione"));
				
				this.attivita.add(attivita1);
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public ArrayList<AttivitaDAO> getAttivita() {
		return attivita;
	}

	public void setAttivita(ArrayList<AttivitaDAO> attivita) {
		this.attivita = attivita;
	}
	
}
