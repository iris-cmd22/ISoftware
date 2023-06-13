package Exception;

public class UsernameNotValid extends Exception{

private String messaggio;
	
	public UsernameNotValid(String m) {
		messaggio=m;
	}

	public UsernameNotValid() {
		
	}
	
	public String toString() {
  
		return messaggio;
	}

}
