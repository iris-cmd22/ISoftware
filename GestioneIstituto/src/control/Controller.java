package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import database.DBConnectionManager;
import entity.EntityValutazione;

public class Controller {

    public Controller(){

    }

    public static int registraUtente(){

        int ret=0;

        return ret;
    }

    /*public static int inserisciClasse(int idClasse, String sezione, String anno, int annoscolastico, ArrayList<int> idmaterie){

        int ret=0;

        return ret;
    }*/

    public static int aggiungiVoto(int idvalutazioni, int matricola, int idmaterie, Date data, int voto){
    	EntityValutazione valutazione = new EntityValutazione();
    	
    	    	
    	 // Controllo se esiste uno studente con quella matricola
        if (!esisteStudente(matricola)) {
            return -1;
        }

        // Controllo se esiste una materia con idmaterie
        if (!esisteMateria(idmaterie)) {
            return -1;
        }

        // Controllo se la data è nel quadrimestre corrente
        if (!isDataValida(data)) {
            return -1;
        }

        // Controllo se il voto è compreso tra 0 e 10
        if (voto < 0 || voto > 10) {
            return -1;
        }

    	
    	
    	
    	int ret = valutazione.scriviSuDB(idvalutazioni, matricola,idmaterie,data,voto);
    	
    	if(ret!=-1) {
    		valutazione.setData(data);
    		valutazione.setVoto(voto);
    		
    		
    	}

      

        return ret;
    
    }
    
    
    
    public static boolean esisteStudente(int matricola) {
        try {
            ResultSet rs = DBConnectionManager.selectQuery("SELECT matricola FROM studenti WHERE matricola = '"+matricola+"';");;
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean esisteMateria(int idmaterie){
        try {
        	
            ResultSet rs = DBConnectionManager.selectQuery("SELECT idmaterie FROM materie WHERE idmaterie = "+idmaterie+";");

            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

      public static boolean isDataValida(Date data) {
    	 LocalDate dataCorrente = LocalDate.now();
    	    int annoCorrente = dataCorrente.getYear();
    	    int meseCorrente = dataCorrente.getMonthValue();
    	    int annoInput = data.toLocalDate().getYear();
    	    int meseInput = data.toLocalDate().getMonthValue();

    	    // Primo quadrimestre: settembre - gennaio: 
    	    if ((meseCorrente >= 9 && meseCorrente <= 12 && annoCorrente  == annoInput)) {
    	        if (meseInput >= 9 && meseInput <= 12) {
    	            return true;
    	        }
    	    }
    	    // Secondo quadrimestre: febbraio - giugno
    	    else if (meseCorrente >= 1 && meseCorrente <= 6 && annoCorrente == annoInput) {
    	        if (meseInput >= 1 && meseInput <= 6) {
    	            return true;
    	        }
    	    }

    	    return false;
    }

    
    
    
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

        ArrayList<String> valutazioni = new ArrayList<String>();

        return valutazioni;
    }


}
