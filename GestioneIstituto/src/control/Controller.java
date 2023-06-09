package control;

import java.sql.Date;
import java.util.ArrayList;
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
    	
    	int ret = valutazione.scriviSuDB(idvalutazioni);
    	
    	if(ret!=-1) {
    		valutazione.setData(data);
    		valutazione.setVoto(voto);
    	}

       

        return ret;
    }
    
    public static ArrayList<String> visualizzaVoti(String usernameGenitore){

        ArrayList<String> valutazioni = new ArrayList<String>();

        return valutazioni;
    }


}
