package Exception;

public class CognomeNotValid extends Exception{

	private String messaggio;//serve a mostrare a video il messaggio di errore
	
	public CognomeNotValid(String m) { //costruttore che prende in ingresso il messaggio 
		
		messaggio = m;
	}
	
	public CognomeNotValid() {
		
	}
	
	public String toString() { //override del metodo toString
		
		return messaggio;
	}
}
