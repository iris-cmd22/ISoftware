package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MateriaDAO {

    private int idmaterie;
    private String nome;
    private ClasseDAO classe;
    private DocenteDAO docente;
    private ArrayList<ValutazioneDAO> valutazioni;
    
    public MateriaDAO(){
        super();
        this.valutazioni =new ArrayList<ValutazioneDAO>();
    }

    public MateriaDAO(int idmaterie) {
		this.idmaterie = idmaterie;
		this.valutazioni =new ArrayList<ValutazioneDAO>();
		caricaDaDB();
	}

    public void caricaDaDB() {
		
		String query = "SELECT * FROM materie WHERE idmaterie='"+this.idmaterie+"'";
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
        
        String query= new String("SELECT * FROM valutazioni WHERE materia=\'"+this.idmaterie+"'");
        //System.out.println(query); //per debug

        	try {
			
			ResultSet rs= DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				//NB:
				ValutazioneDAO valutazione =new ValutazioneDAO();
				valutazione.setIdvalutazioni(rs.getInt("idvalutazioni"));
                valutazione.setData(rs.getDate("data"));
				valutazione.setVoto(rs.getFloat("voto"));
						
				this.valutazioni.add(valutazione);
				
			}	
			
		}catch( ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
     
     public void caricaClasseDaDB(){
         
         String query= new String("SELECT * FROM classi WHERE materia=\'"+this.idmaterie+"'");
         //System.out.println(query); //per debug

         	try {
 			
 			ResultSet rs= DBConnectionManager.selectQuery(query);
 			
 			if(rs.next()) {
 				
 				//NB:
 				ClasseDAO classe =new ClasseDAO();
 				classe.setIdClasse(rs.getInt("idclasse"));
 				classe.setSezione(rs.getString("sezione"));
 				classe.setSezione(rs.getString("sezione"));
 				classe.setAnnoscolastico(rs.getInt("annoscolastico"));
 						
 				this.classe=classe;
 				
 			}	
 			
 		}catch( ClassNotFoundException | SQLException e) {
 			
 			e.printStackTrace();
 		}
     }
     
     public void caricaDocenteDaDB(){
         
         String query= new String("SELECT * FROM docenti WHERE username=\'"+this.docente.getUsername()+"'");
         System.out.println(query); //per debug

         	try {
 			
 			ResultSet rs= DBConnectionManager.selectQuery(query);
 			
 			if(rs.next()) {
 				
 				//NB:
 				ClasseDAO classe =new ClasseDAO();
 				classe.setIdClasse(rs.getInt("idclasse"));
 				classe.setSezione(rs.getString("sezione"));
 				classe.setSezione(rs.getString("sezione"));
 				classe.setAnnoscolastico(rs.getInt("annoscolastico"));
 						
 				this.classe=classe;
 				
 			}	
 			
 		}catch( ClassNotFoundException | SQLException e) {
 			
 			e.printStackTrace();
 		}
     }
     
	public int SalvaDocenteInDB() {
		
		int ret=0;
		
		String query = "UPDATE materie SET docente= '"+docente.getUsername()+"' WHERE idmaterie='"+idmaterie+"';";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
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

	public ClasseDAO getClasse() {
		return classe;
	}

	public void setClasse(ClasseDAO classe) {
		this.classe = classe;
	}

	public DocenteDAO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDAO docente) {
		this.docente = docente;
	}
}
