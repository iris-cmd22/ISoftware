package Exception;

public class VotoNotValid extends Exception{

	private String messaggio;
	
	public VotoNotValid(String m) {
		messaggio=m;
	}

	public VotoNotValid() {
		
	}
	
	public String toString() {
  
		return messaggio;
	}

}