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
    								String comuneResidenza, String email,int numeroCellulare, String username,
    								String password,ArrayList<Integer> materie, String figlio, int classe ){
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


    public static int aggiungiVoto(int matricola, int materia, Date data, float voto){
    	
    	
    	EntityIstituto singleton = EntityIstituto.getInstance();
        int ret=singleton.aggiungiVoto(matricola,materia,data,voto);

        return ret;
    }
    
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> valutazioni = new ArrayList<String>();
        
        valutazioni= singleton.getListaValutazioni(usernameGenitore);

        return valutazioni;
    }
	
public static ArrayList<String> visualizzaVoti(String usernameGenitore){

    	EntityIstituto singleton = EntityIstituto.getInstance();
        ArrayList<String> valutazioni = new ArrayList<String>();
        
        valutazioni= singleton.getListaValutazioni(usernameGenitore);

        return valutazioni;
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


}

