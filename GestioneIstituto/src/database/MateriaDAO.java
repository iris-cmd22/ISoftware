package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MateriaDAO {

    private int idmaterie;
    private String nome;
    private ArrayList<ValutazioneDAO> valutazioni;
    
    public MateriaDAO(){
        super();
        this.valutazioni =new ArrayList<ValutazioneDAO>();
    }

    public MateriaDAO(int idmaterie) {
		this.idmaterie = idmaterie;
		caricaDaDB();
	}

    public void caricaDaDB() {
		
		String query = "SELECT * FROM materie WHERE idmaterie='"+this.idmaterie+"';";
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setIdmateria(rs.getInt("idmaterie"));
                this.setNome(rs.getString("nome"));

			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

     public void caricaValutazioniDaDB(){
        
        String query= new String("SELECT * FROM valutazioni WHERE materia=\'"+this.idmaterie+"')");
        //System.out.println(query); //per debug

        	try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				//NB:
				ValutazioneDAO valutazione =new ValutazioneDAO();
				valutazione.setIdvalutazioni(rs.getInt("idvalutazioni"));
                valutazione.setData(rs.getString("data"));
				valutazione.setTipo(rs.getString("tipo"));
				valutazione.setVoto(rs.getFloat("voto"));
						
				this.valutazioni.add(valutazione);
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }


	public int getIdmateria() {
		return idmaterie;
	}

	public void setIdmateria(int idmateria) {
		this.idmaterie = idmateria;
	}   

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	
	public ArrayList<ValutazioneDAO> getValutazioni(){
		return valutazioni;
	}
	
	public void setValutazioni(ArrayList<ValutazioneDAO> valutazioni) {
		this.valutazioni = valutazioni;
	}
}
