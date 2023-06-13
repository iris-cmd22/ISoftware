package Exception;

public class EmailNotValid extends Exception{
	
	private String messaggio;//serve a mostrare a video il messaggio di errore
	
	public EmailNotValid(String m) { //costruttore che prende in ingresso il messaggio 
		
		messaggio = m;
	}
	
	public EmailNotValid() {
		
	}
	
	public String toString() { //override del metodo toString
		
		return messaggio;
	}
	
	
}