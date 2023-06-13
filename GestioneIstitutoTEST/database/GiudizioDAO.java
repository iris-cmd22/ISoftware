package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiudizioDAO {
	
	private String quadrimestre;
	private float voto;
	private MateriaDAO materia;
	private PagellaDAO pagella;
	
	public GiudizioDAO() {
		super();
	}

	public GiudizioDAO( MateriaDAO materia, PagellaDAO pagella) {
		
		this.materia=materia;
		this.pagella=pagella;
		caricaDaDB();
	}
	
	public GiudizioDAO(GiudizioDAO giudizio) {
		
		this.materia=giudizio.getMateria();
		this.pagella=giudizio.getPagella();
		this.voto=giudizio.getVoto();
		this.quadrimestre=giudizio.getQuadrimestre();
	}
	
	public void caricaDaDB() {
		
		String query =new String("SELECT * FROM giudizi_finali WHERE materia='"+materia.getIdmateria()+"')");
		System.out.println(query); //per debug
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setVoto(rs.getInt("voto"));
				this.setQuadrimestre(rs.getString("quadrimestre"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void caricaMateriaDaDB() {
		String query= new String("SELECT * FROM materie WHERE idmaterie =\'"+this.materia.getIdmateria()+"')");
        //System.out.println(query); //per debug

        	try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				//NB:
				MateriaDAO materia =new MateriaDAO();
				materia.setNome(rs.getString("nome"));
				materia.caricaValutazioniDaDB();
						
				this.materia=materia;
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	public String getQuadrimestre() {
		return quadrimestre;
	}

	public void setQuadrimestre(String quadrimestre) {
		this.quadrimestre = quadrimestre;
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

	public void setMateria(MateriaDAO materia) {
		this.materia = materia;
	}
	
	public PagellaDAO getPagella() {
		return pagella;
	}

	public void setPagella(PagellaDAO pagella) {
		this.pagella = pagella;
	}

}