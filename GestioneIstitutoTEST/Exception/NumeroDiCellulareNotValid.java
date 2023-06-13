package Exception;

public class NumeroDiCellulareNotValid extends Exception{

	private String messaggio;//serve a mostrare a video il messaggio di errore
	
	public NumeroDiCellulareNotValid(String m) { //costruttore che prende in ingresso il messaggio 
		
		messaggio = m;
	}
	
	public NumeroDiCellulareNotValid() {
		
	}
	
	public String toString() { //override del metodo toString
		
		return messaggio;
	}
}