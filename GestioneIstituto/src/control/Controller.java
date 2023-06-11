package control;

import java.sql.Date;
import java.util.ArrayList;

import entity.EntityIstituto;

public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
		super();
	}
	
    public static int registraUtente(String ruolo,String nome,String cognome,Date dataNascita, String codiceFiscale, 
    								String comuneResidenza, String email,String numeroCellulare, String username,
    								String password,ArrayList<Integer> materie, int figlio, int classe ){
    	int ret=0;
    	
    	EntityIstituto singleton = EntityIstituto.getInstance();
    	
    	if(ruolo=="docente") {
    		
    		ret=singleton.creaDocente(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password,materie);
    		
    	}else if(ruolo=="genitore") {
    		
    		ret=singleton.creaStudente(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password, classe);
    		
    	}else if(ruolo=="studente") {
    		
    		ret=singleton.creaGenitore(nome,cognome,dataNascita, codiceFiscale, 
					comuneResidenza,email,numeroCellulare,username,password,figlio);
    	}else {
    		
    		System.out.println("Ruolo non valido");
    		ret=-1;
    	}
    	
        return ret;
    }


    public static int aggiungiVoto(String docente, int matricola, int materia, Date data, float voto){
    	
    	
    	EntityIstituto singleton = EntityIstituto.getInstance();
        int ret=singleton.aggiungiVoto(docente, matricola,materia,data,voto);

        return ret;
    }
    
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> valutazioni = new ArrayList<String>();
        
        valutazioni= singleton.getListaValutazioni(usernameGenitore);

        return valutazioni;
    }


public static boolean controllomateria_insegnata(int idmateria, String docente) {
			
			EntityIstituto singleton = EntityIstituto.getInstance();
			return singleton.controllomateria_insegnata(idmateria, docente);
		}
	
public static boolean controllomateria(int idmateria) {
	
	EntityIstituto singleton = EntityIstituto.getInstance();
	return singleton.controllomateria(idmateria);
}



public static boolean controllostudente(int matricola) {
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllostudente(matricola);
	}
	
public static boolean controlloclasse(int classe) {
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controlloclasse(classe);
	}

public static int CercaUsername(String username, String ruolo) {

	int ret = 0;
	EntityIstituto singleton = EntityIstituto.getInstance();
	ret = singleton.CercaUsername(username, ruolo);

	return ret;
    }
public static boolean controllodata(Date data) {
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		return singleton.controllodata(data);
	}

public static boolean controllodocente(String username) {

	EntityIstituto singleton = EntityIstituto.getInstance();
	return singleton.controllodocente(username);
	
    }
	
 public static ArrayList<String> visualizzamaterie(){
    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> materie = new ArrayList<String>();
        
        materie=singleton.visualizzamaterie();
        
        		return materie;
    }
	
public static ArrayList<String> visualizzastudenti(){
		 
		 EntityIstituto singleton = EntityIstituto.getInstance();
		 ArrayList<String> studenti = new ArrayList<String>();
		 
		 studenti = singleton.visualizzastudenti();
		 
		 return studenti;
	 }
	 
 public static ArrayList<String> visualizzaclassi(){

	 EntityIstituto singleton = EntityIstituto.getInstance();
	 ArrayList<String> classi = new ArrayList<String>();

	 classi = singleton.visualizzaclassi();

	 return classi;
 }

}
