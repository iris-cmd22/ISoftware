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
        if (!isDataNelQuadrimestreCorrente(data)) {
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
            ResultSet rs = DBConnectionManager.selectQuery("SELECT matricola FROM studenti WHERE matricola = "+matricola+"';");
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean esisteMateria(int idmaterie){
        try {
        	
            ResultSet rs = DBConnectionManager.selectQuery("SELECT idmaterie FROM materie WHERE idmaterie = ?"+idmaterie+"';");
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isDataNelQuadrimestreCorrente(Date data) {
        LocalDate localDate = data.toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        // Verifica se la data appartiene al primo quadrimestre (settembre-gennaio) dell'anno scolastico corrente
        if (month >= 9 && month <= 1 && Year.now().getValue() == year) {
            return true;
        }

        // Verifica se la data appartiene al secondo quadrimestre (febbraio-giugno) dell'anno scolastico successivo
        if (month >= 2 && month <= 6 && Year.now().getValue() + 1 == year) {
            return true;
        }

        return false;
    }

    
    
    
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

        ArrayList<String> valutazioni = new ArrayList<String>();

        return valutazioni;
    }


}
