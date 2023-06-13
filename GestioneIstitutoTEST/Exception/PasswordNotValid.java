package Exception;

public class PasswordNotValid extends Exception{

		private String messaggio;
			
			public PasswordNotValid(String m) {
				messaggio=m;
			}

			public PasswordNotValid() {
				
			}
			
			public String toString() {
		  
				return messaggio;
			}
}
