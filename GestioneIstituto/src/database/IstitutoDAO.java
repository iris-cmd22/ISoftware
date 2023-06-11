package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class IstitutoDAO {


	private static IstitutoDAO instance=null; //servirà per verificare che l'istanza sia unica

	protected IstitutoDAO() {
		// costruttore
	}
	
	//Pattern singleton
	public static IstitutoDAO getInstance() {
		if(instance==null) {
			instance = new IstitutoDAO();
		}
		return instance;
	}
	
	public int verificamaterie(int idmaterie) {
		
		int ret=0;
		
		String query="SELECT * FROM materie WHERE idmaterie='"+idmaterie+"';";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			if(rs.next()) {
				System.out.println("Materia verificata");
			}
			
		}catch( ClassNotFoundException | SQLException e){
			e.printStackTrace();
			ret=-1;
		}
		
		return ret;
	}

	public int verificaclassi(int idclasse) {
		
		int ret=0;
		
		String query="SELECT * FROM classi WHERE idcasse='"+idclasse+"';";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			if(rs.next()) {
				System.out.println("Classe verificata");
			}
			
		}catch( ClassNotFoundException | SQLException e){
			e.printStackTrace();
			ret=-1;
		}
		
		return ret;
	}
	
	public boolean esisteStudente(int matricola) {
        try {
            ResultSet rs = DBConnectionManager.selectQuery("SELECT matricola FROM studenti WHERE matricola = '"+matricola+"';");;
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    

	  public boolean esisteMateria(int idmaterie){
	        try {
	        	
	        	ResultSet rs = DBConnectionManager.selectQuery("SELECT idmaterie FROM materie WHERE idmaterie = " + idmaterie + "';"); //controlla se la materia esiste ed è insegnata dal docente che vuole aggiungere il voto

	            

	            return rs.next();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	

	
    public boolean esisteMateriaInsegnata(int idmaterie, String docente){
        try {
        	
        	ResultSet rs = DBConnectionManager.selectQuery("SELECT idmaterie FROM materie WHERE idmaterie = " + idmaterie + " AND docente = '" + docente + "';"); //controlla se la materia esiste ed è insegnata dal docente che vuole aggiungere il voto

            

            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
	

      public boolean isDataValida(Date data) { //in ingresso c'è la data della valutazione, che non è necessariamente la data corrente
    	 LocalDate dataCorrente = LocalDate.now();
    	    int annoCorrente = dataCorrente.getYear();
    	    int meseCorrente = dataCorrente.getMonthValue();
    	    int annoInput = data.toLocalDate().getYear();
    	    int meseInput = data.toLocalDate().getMonthValue();
    	    LocalDate convertedDate = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            //Si controlla che la data della valutazione sia nel quadrimestre (e anno) corrente, e che non sia successiva alla data corrente
          
    	    // Primo quadrimestre: settembre - gennaio: 
    	    if ((meseCorrente >= 9 || meseCorrente <= 1) && (annoCorrente  == annoInput || annoCorrente == annoInput +1) && dataCorrente.compareTo(convertedDate)<=0) {
    	        if (meseInput >= 9 || meseInput <= 1) {
    	            return true;
    	        }
    	    }
    	    // Secondo quadrimestre: febbraio - giugno
    	    else if (meseCorrente >= 2 && meseCorrente <= 6 && annoCorrente == annoInput && dataCorrente.compareTo(convertedDate)<=0) {
    	        if (meseInput >= 2 && meseInput <= 6) {
    	            return true;
    	        }
    	    }

    	    return false;
    }
	
	
	
	
	      
      
    public boolean esisteDocente(String username) {
    	
   	 
   		 try {
			 
			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM docenti WHERE username = "+username+";");
					 
					return rs.next();	 
		         
		         
		     } catch (SQLException | ClassNotFoundException e) {
		         e.printStackTrace();
		         return false;
		         
		     }
		  	
    }
      
    
	
	public int esisteUsername(String username, String ruolo) {
    	
    	 int ret = 0;
    	
    	 if(ruolo == "Docente") {
    		 try {
			 
			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM docenti WHERE username = "+username+";");
					 
					 if(rs.next()) {
						 ret=1;
					 }				 
		         
		         
		     } catch (SQLException | ClassNotFoundException e) {
		         e.printStackTrace();
		         ret = -1;
		         
		     }
		}
    	 
    	if(ruolo == "Studente") {
    		try {
   			 
   			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM studenti WHERE username = "+username+";");
					 
					 if(rs.next()) {
						 ret=1;
					 }				 
		         
		         
		     } catch (SQLException | ClassNotFoundException e) {
		         e.printStackTrace();
		         ret = -1;
		         
		     }
    	}
    	
    	if(ruolo == "Genitore") {
    		try {
   			 
   			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM genitori WHERE username = "+username+";");
					 
					 if(rs.next()) {
						 ret=1;
					 }				 
		         
		         
		     } catch (SQLException | ClassNotFoundException e) {
		         e.printStackTrace();
		         ret = -1;
		         
		     }
    	}
    	 
    	return ret;
    }
	
	public ArrayList<MateriaDAO> visualizzamaterie() {
		
		ArrayList<MateriaDAO> materie = new ArrayList<MateriaDAO>();
		
		String query="SELECT * FROM materie";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			while(rs.next()) {
				
				MateriaDAO materia = new MateriaDAO();
				
				materia.setIdmateria(rs.getInt("idmaterie"));
				materia.setNome(rs.getString("nome"));
				
				materie.add(materia);
				
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return materie;
	}
	
	public ArrayList<String> visualizzastudenti(){
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		ArrayList<String> studenti = new ArrayList<String>();
		
		for(int i=0; i<singleton.visualizzastudenti().size(); i++) {
			EntityStudente studente = new EntityStudente(singleton.visualizzastudenti().get(i).getMatricola());
			studenti.add(studente.toString());
		}
		
		return studenti;
	}
	
	public ArrayList<String> visualizzaclassi(){
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		ArrayList<String> classi = new ArrayList<String>();
		
		for(int i=0; i<singleton.visualizzaclassi().size(); i++) {
			EntityClasse classe = new EntityClasse(singleton.visualizzaclassi().get(i).getIdClasse());
			classi.add(classe.toString());
		}
		
		return classi;
	}
}
