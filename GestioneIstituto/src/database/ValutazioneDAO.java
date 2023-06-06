package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValutazioneDAO {
	
	private int idvalutazione;
	private String data;
	private String tipo;
	private float voto;
	
	
	public ValutazioneDAO() {
		super();
	}
	
	public ValutazioneDAO(int idvalutazioni) {
		
		this.idvalutazione=idvalutazioni;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query="SELECT * FROM valutazioni WHERE idvalutazioni='"+this.idvalutazione+"')";
		try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setData(rs.getString("data"));
				this.setTipo(rs.getString("tipo"));
				this.setVoto(rs.getFloat("voto"));
			
			}
			
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();	
		}
	}

	public int getIdvalutazioni() {
		return idvalutazione;
	}

	public void setIdvalutazioni(int idvalutazioni) {
		this.idvalutazione = idvalutazioni;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}
	
	
}
