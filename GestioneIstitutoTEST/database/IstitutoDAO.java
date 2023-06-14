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
	
	public int getultimamatricola() {
		
		int matricola=0;
		
		String query="SELECT COUNT(*) AS num_studenti FROM studenti";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			if(rs.next()) {
			
				matricola=rs.getInt("num_studenti");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return matricola;
	}
	
public int getultimoidvalutazioni() {
		
		int id=0;
		
		String query="SELECT COUNT(*) AS num_valutazioni FROM valutazioni";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			if(rs.next()) {
				
				id=rs.getInt("num_valutazioni");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return id;
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
		
		String query="SELECT * FROM classi WHERE idclassi='"+idclasse+"';";
		
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
	
	public boolean esisteGenitoreStudente(int matricola) {
		 try {
	            ResultSet rs = DBConnectionManager.selectQuery("SELECT * FROM genitori WHERE studente_figlio = '"+matricola+"';");;
	            return rs.next();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }
	}
    
	
	public boolean esisteStudenteInClasse(int matricola, int idmateria) {  //serve per la funzionalità aggiungiVoto: controlla che l'utente al quale si vuole aggiungere il voto
		//sia appartenente alla classe in cui la materia (nella quale è stato valutato) sia insegnata in quella classe 
	    try {
	        ResultSet rs = DBConnectionManager.selectQuery("SELECT s.matricola " +
	                "FROM studenti s " +
	                "JOIN studente_in_classe sc ON s.matricola = sc.studente " +
	                "JOIN classi c ON sc.classe = c.idclassi " +
	                "JOIN materie m ON c.idclassi = m.classe " +
	                "WHERE s.matricola = '" + matricola + "' AND m.idmaterie = '" + idmateria + "';");
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
    	    
     	    

            //Si controlla che la data della valutazione sia nel quadrimestre (e anno) corrente, e che non sia successiva alla data corrente
          
    	    // Primo quadrimestre: settembre - gennaio: 
    	    if (((meseCorrente >= 9 && meseCorrente <= 12) ||meseCorrente==1) && (annoCorrente  == annoInput || annoCorrente == annoInput +1) && Date.valueOf(dataCorrente).compareTo(data)>=0) {
    	        if ((meseInput >= 9 && meseInput <= 12) || meseInput == 1) {
    	            return true;
    	        }
    	    }
    	    // Secondo quadrimestre: febbraio - giugno
    	    else if (meseCorrente >= 2 && meseCorrente <= 6 && annoCorrente == annoInput && Date.valueOf(dataCorrente).compareTo(data)>=0) {
    	        if (meseInput >= 2 && meseInput <= 6) {
    	            return true;
    	        }
    	    }

    	    return false;
    }   
      
    public boolean esisteDocente(String username) {
    	
   	 
   		 try {
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM docenti WHERE username = '"+username+"';");
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
				 	ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM docenti WHERE username = '"+username+"';");
					 
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
   			 
   			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM studenti WHERE username = '"+username+"';");
					 
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
   			 
   			 
				 ResultSet rs = DBConnectionManager.selectQuery("SELECT username FROM genitori WHERE username = '"+username+"';");
					 
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
	
		public ArrayList<Integer> visualizzamaterie() {
		
		ArrayList<Integer> idmaterie = new ArrayList<Integer>();
		
		String query="SELECT * FROM materie";
		
		try {
			
			ResultSet rs =DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			while(rs.next()) {
				
				Integer idmateria;
				
				idmateria=rs.getInt("idmaterie");
				
				idmaterie.add(idmateria);
				
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return idmaterie;
	}
	
	public ArrayList<StudenteDAO> visualizzastudenti(){
		
		ArrayList<StudenteDAO> studenti = new ArrayList<StudenteDAO>();
		
		String query="SELECT * FROM studenti";
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			while(rs.next()) {
				
				StudenteDAO studente = new StudenteDAO();
				
				studente.setMatricola(rs.getInt("matricola"));
				studente.setUsername(rs.getString("username"));
				studente.setNome(rs.getString("nome"));
				studente.setNome(rs.getString("cognome"));
				
				studenti.add(studente);
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return studenti;
	}
	
	public ArrayList<ClasseDAO> visualizzaclassi(){
		
		ArrayList<ClasseDAO> classi = new ArrayList<ClasseDAO>();
		
		String query="SELECT * FROM classi";
		
		try {
			
			ResultSet rs = DBConnectionManager.selectQuery(query);
			System.out.println(query); //per debug
			
			while(rs.next()) {
				
				ClasseDAO classe = new ClasseDAO();
				
				classe.setIdClasse(rs.getInt("idclassi"));
				classe.setSezione(rs.getString("sezione"));
				classe.setAnno(rs.getString("anno"));
				classe.setAnnoscolastico(rs.getInt("annoScolastico"));
				
				classi.add(classe);
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return classi;
	}
	
	public int scrivi_studente_in_classe(int matricola, int idclasse) {
		int ret=0;
		
		String query = "INSERT INTO studente_in_classe(studente,classe) VALUES ( \'"+matricola+"\',"+"\'"+idclasse+"\');";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		
		
		return ret;
	}
}
