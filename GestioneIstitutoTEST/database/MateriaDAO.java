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
    
    //costruttore di default
    public MateriaDAO(){
        super();
        this.valutazioni =new ArrayList<ValutazioneDAO>();
    }

    //costruttore con id
    public MateriaDAO(int idmaterie) {
		this.idmaterie = idmaterie;
		this.valutazioni =new ArrayList<ValutazioneDAO>();
		caricaDaDB();
	}

    //Caricamento dati Materia dal DataBase
    public void caricaDaDB() {
		
		String query = "SELECT * FROM materie WHERE idmaterie='"+this.idmaterie+"'";
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setIdmateria(rs.getInt("idmaterie"));
                this.setNome(rs.getString("nome"));
                
                ClasseDAO classe= new ClasseDAO(rs.getInt("classe"));
                
                this.setClasse(classe);

			}
		}catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
    
    //Caricamento dati Valutazioni associate da DataBase
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
     
     //Caricamento dati Classe associata dal DataBase
     public void caricaClasseDaDB(){
         
         String query= new String("SELECT * FROM classi WHERE idclassi ='"+this.classe.getIdClasse()+"'");
         System.out.println(query); //per debug

         	try {
 			
 			ResultSet rs= DBConnectionManager.selectQuery(query);
 			
 			if(rs.next()) {
 				
 				//NB:
 				ClasseDAO classe =new ClasseDAO();
 				classe.setIdClasse(rs.getInt("idclassi"));
 				classe.setSezione(rs.getString("sezione"));
 				classe.setAnno(rs.getString("anno"));
 				classe.setAnnoscolastico(rs.getInt("annoscolastico"));
 						
 				this.classe=classe;
 				
 			}	
 			
 		}catch( ClassNotFoundException | SQLException e) {
 			
 			e.printStackTrace();
 		}
     }
     
     //Caricamente dati Docente da Database
     public void caricaDocenteDaDB(){
         
         String query= new String("SELECT * FROM docenti WHERE username=\'"+this.docente.getUsername()+"'");
         System.out.println(query); //per debug

         	try {
 			
 			ResultSet rs= DBConnectionManager.selectQuery(query);
 			
 			if(rs.next()) {
 				
 				//NB:
 				DocenteDAO docente =new DocenteDAO();
 				docente.setUsername(rs.getString("username"));
 				docente.setPassword(rs.getString("password"));
 				docente.setNome(rs.getString("nome"));
 				docente.setCognome(rs.getString("cognome"));
 				docente.setDataNascita(rs.getDate("dataNascita"));
 				docente.setCodiceFiscale(rs.getString("codiceFiscale"));
 				docente.setComuneResidenza(rs.getString("comuneResidenza"));
 				docente.setNumeroCellulare(rs.getString("numeroCellulare"));
 						
 				this.docente=docente;
 				
 			}	
 			
 		}catch( ClassNotFoundException | SQLException e) {
 			
 			e.printStackTrace();
 		}
     }
     
     //Aggiornamento associazione tra materia e docente
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
