package Exception;

public class CodiceFiscaleNotValid {
		
		private String messaggio;//serve a mostrare a video il messaggio di errore
		
		public CodiceFiscaleNotValid(String m) { //costruttore che prende in ingresso il messaggio 
			
			messaggio = m;
		}
		
		public CodiceFiscaleNotValid() {
			
		}
		
		public String toString() { //override del metodo toString
			
			return messaggio;
		}

}
