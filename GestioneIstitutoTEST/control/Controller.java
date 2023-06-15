package control;

import java.sql.Date;
import java.util.ArrayList;

import entity.EntityIstituto;

public class Controller {

	public Controller() {
		
		super();
	}
	
	//Funzione di Registrazione Utente (richiamata nel boundary Segreteria)
    public static int registraUtente(String ruolo,String nome,String cognome,Date dataNascita, String codiceFiscale, 
    								String comuneResidenza, String email,String numeroCellulare, String username,
    								String password,ArrayList<Integer> materie, int figlio, int classe ){
    	int ret=0;
    	
    	EntityIstituto singleton = EntityIstituto.getInstance();
    	
    	if(ruolo=="Docente") {
    		//In base al ruolo viene richiamata la funzione di creazione rispettiva dalla classe Entity façade
    		
    		ret=singleton.creaDocente(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password,materie);
    		
    	}else if(ruolo=="Studente") {
    		
    		ret=singleton.creaStudente(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password, classe);
    		
    	}else if(ruolo=="Genitore") {
    		
    		ret=singleton.creaGenitore(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password,figlio);
    	}else {
    		
    		System.out.println("Ruolo non valido");
    		ret=-1;
    	}
    	
        return ret;
    }

    //Funzione di inserimento del voto (richiamata nel boundary Docente)
    public static int aggiungiVoto(String docente, int matricola, int materia, Date data, float voto){
    	
    	
    	EntityIstituto singleton = EntityIstituto.getInstance();
        int ret=singleton.aggiungiVoto(docente,matricola,materia,data,voto);

        return ret;
    }
    
    //Funzione di visualizzazione voti dell'alunno associato al genitore (richiamata nel boundary Genitore)
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> valutazioni = new ArrayList<String>();
        
        valutazioni= singleton.getListaValutazioni(usernameGenitore);

        return valutazioni;
    }

    //Funzione per controllare che la materia in input esista e sia insegnata dal docente in input 
	public static boolean controllomateria_insegnata(int idmateria, String docente) {
				
				EntityIstituto singleton = EntityIstituto.getInstance();
				return singleton.controllomateria_insegnata(idmateria, docente);
			}
	
	//Funzione per controllare che la materia in input esista
	public static boolean controllomateria(int idmateria) {
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllomateria(idmateria);
	}
	
	//Funzione per controllare che lo studente (matricola) in input esista
	public static boolean controllostudente(int matricola) {
			
			EntityIstituto singleton = EntityIstituto.getInstance();
			return singleton.controllostudente(matricola);
		}
	
	//Funzione per controllare che lo studente (matricola) in input abbia già un genitore associato
	public static boolean controllogenitoreStudente(int matricola) {
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllogenitoreStudente(matricola);
		
	}
	
	//Funzione per controllare che lo studente (matricola) in input sa cui si vuole aggiungere il voto sia nella classe dove la materia è insegnata
	public static boolean controllostudenteInClasse(int matricola,int materia) {

		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllostudenteInClasse(matricola,materia);
		}
	
	//Funzione per controllare che la classe in input esista
	public static boolean controlloclasse(int classe) {
			
			EntityIstituto singleton = EntityIstituto.getInstance();
			return singleton.controlloclasse(classe);
		}
	
	//Funzione per controllare che l'username in input esista
	public static int CercaUsername(String username, String ruolo) {
	
		int ret = 0;
		EntityIstituto singleton = EntityIstituto.getInstance();
		ret = singleton.CercaUsername(username, ruolo);
	
		return ret;
	    }
	
	//Funzione per controllare che la data della valutazione in input sia presente
	public static boolean controllodata(Date data) {
			
			EntityIstituto singleton = EntityIstituto.getInstance();
			return singleton.controllodata(data);
		}
	
	//Funzione per controllare che il docente in input esista
	public static boolean controllodocente(String username) {
	
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllodocente(username);
		
	    }
	
	//Funzione per ottenere la stringa di tutte le materie esistenti
	 public static ArrayList<String> visualizzamaterie(){
		 
	    	EntityIstituto singleton = EntityIstituto.getInstance();
	        ArrayList<String> materie = new ArrayList<String>();
	        
	        materie=singleton.visualizzamaterie();
	        
	        		return materie;
	    }
	 
	 //Funzione per ottenere la stringa di tutte le materie insegnate dal docente in input
	 public static ArrayList<String> visualizzamateriePerDocente(String docente){
		 
    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> materie = new ArrayList<String>();
        
        materie=singleton.visualizzamateriePerDocente(docente);
        
        		return materie;
	 }
	 
	 //Funzione per ottenere la stringa di tutti gli studenti esistenti
	 public static ArrayList<String> visualizzastudenti(){
		 
		 EntityIstituto singleton = EntityIstituto.getInstance();
		 ArrayList<String> studenti = new ArrayList<String>();
		 
		 studenti = singleton.visualizzastudenti();
		 
		 return studenti;
	 }

	 //Funzione per ottenere la stringa di tutti gli studenti presenti nella classe in cui la materia che ha come identificativo quello in ingresso è insegnata
	 public static ArrayList<String> visualizzastudentiPerMateria(int idmateria){
	 
		 EntityIstituto singleton = EntityIstituto.getInstance();
		 ArrayList<String> studenti = new ArrayList<String>();
		 
		 studenti = singleton.visualizzastudentiPerMateria(idmateria);
		 
		 return studenti;
	 }
	
	 //Funzione per ottenere la stringa di tutte le classi esistenti
	 public static ArrayList<String> visualizzaclassi(){
		 
		 EntityIstituto singleton = EntityIstituto.getInstance();
		 ArrayList<String> classi = new ArrayList<String>();
		 
		 classi = singleton.visualizzaclassi();
		 
		 return classi;
	 }

}
