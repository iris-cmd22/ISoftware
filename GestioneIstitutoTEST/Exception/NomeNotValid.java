package Exception;

public class NomeNotValid extends Exception{
	
	private String messaggio;//serve a mostrare a video il messaggio di errore
	
	public NomeNotValid(String m) { //costruttore che prende in ingresso il messaggio 
		
		messaggio = m;
	}
	
	public NomeNotValid() {
		
	}
	
	public String toString() { //override del metodo toString
		
		return messaggio;
	}
}
