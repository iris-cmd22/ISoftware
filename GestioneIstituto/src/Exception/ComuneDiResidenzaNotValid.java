package Exception;

public class ComuneDiResidenzaNotValid {

	private String messaggio;//serve a mostrare a video il messaggio di errore
	
	public ComuneDiResidenzaNotValid(String m) { //costruttore che prende in ingresso il messaggio 
		
		messaggio = m;
	}
	
	public ComuneDiResidenzaNotValid() {
		
	}
	
	public String toString() { //override del metodo toString
		
		return messaggio;
	}
}
