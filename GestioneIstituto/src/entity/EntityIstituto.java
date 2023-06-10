package entity;

import java.sql.Date;
import java.util.ArrayList;

import database.IstitutoDAO;

//class facade del package entity: viene richiamata nel controller come singleton
public class EntityIstituto {

	private static EntityIstituto instance=null; //servirà per verificare che l'istanza sia unica
	
	//gli id vengono definiti dal sistema in modo che siano univoci
	public static int matricola=0; 
	public static int idvalutazione=0;
	
	
	private EntityIstituto() {
		//costruttore
	}
	
	//Pattern singleton
	public static EntityIstituto getInstance() {
		if(instance==null) {
			instance = new EntityIstituto();
		}
		return instance;
	}
	
	public int creaDocente(String nome,String cognome,Date dataNascita, String codiceFiscale, 
			String comuneResidenza, String email,int numeroCellulare, String username,
			String password,ArrayList<Integer> materie) {
		
		int ret=0;
		
		EntityDocente docente= new EntityDocente(username);
		
		docente.setPassword(password);
		docente.setNome(nome);
		docente.setCognome(cognome);
		docente.setDataNascita(dataNascita);
		docente.setCodiceFiscale(codiceFiscale);
		docente.setComuneResidenza(comuneResidenza);
		docente.setEmail(email);
		docente.setNumeroCellulare(numeroCellulare);
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		for(int i=0; i<materie.size();i++) {
			
			ret=singleton.verificamaterie(materie.get(i));
		}
		
		if(ret != -1) {
			
			ret=docente.scriviSuDB(username);
			
		}else {
			
			System.out.println("Materie non verificate");
		}
		
		return ret;
		
	}
	
	public int creaStudente(String nome,String cognome,Date dataNascita, String codiceFiscale, 
			String comuneResidenza, String email,int numeroCellulare, String username,
			String password, int classe) {
		
		int ret=0;
		
		matricola++;
	
		EntityStudente studente= new EntityStudente();
		
				studente.setMatricola(matricola);
				studente.setPassword(password);
				studente.setNome(nome);
				studente.setCognome(cognome);
				studente.setDataNascita(dataNascita);
				studente.setCodiceFiscale(codiceFiscale);
				studente.setComuneResidenza(comuneResidenza);
				studente.setEmail(email);
				studente.setNumeroCellulare(numeroCellulare);
				
					
				IstitutoDAO singleton = IstitutoDAO.getInstance();
				ret=singleton.verificaclassi(classe);
				
				if(ret != -1) {
					
					ret=studente.scriviSuDB(matricola);
					
				}else {
					
					System.out.println("Materie non verificate");
				}
		
		return ret;
		
	}
	
	public int creaGenitore(String nome,String cognome,Date dataNascita, String codiceFiscale, 
			String comuneResidenza, String email,int numeroCellulare, String username,
			String password,String figlio ) {
		
		int ret=0;
		
		return ret;
		
	}
	
	//stampa nome, data e voto per ogni materia più una media
	public ArrayList<String> getListaValutazioni(String usernameGenitore){
		
		ArrayList<String> valutazioni = new ArrayList<String>();		
		
		EntityGenitore utente= new EntityGenitore(usernameGenitore);
		
		float media=0;
		
		for (int i=0; i<utente.getStudente().getValutazioni().size();i++) {
			
			valutazioni.add(utente.getStudente().getValutazioni().get(i).toString()+" \n");
			//nel tostring verrà stampato anche il nome della materia di riferimento
			
			media += utente.getStudente().getValutazioni().get(i).getVoto();
			
		}
		
		media = media/ utente.getStudente().getValutazioni().size();
		
		valutazioni.add("La media complessiva dello studente nel quadrimestre risulta: "+media+" \n");
		
		return valutazioni;
		
	}
	
	
	
	public int aggiungiVoto(int matricola, int idmaterie, Date data, float voto) {
		
		idvalutazione++;
		
		EntityValutazione valutazione = new EntityValutazione();
		IstitutoDAO singleton = IstitutoDAO.getInstance();
    	
   	 	// Controllo se esiste uno studente con quella matricola
       if (!singleton.esisteStudente(matricola)) {
           return -1;
       }

       // Controllo se esiste una materia con idmaterie
       if (!singleton.esisteMateria(idmaterie)) {
           return -1;
       }

       // Controllo se la data è nel quadrimestre corrente
       if (!singleton.isDataValida(data)) {
           return -1;
       }

       // Controllo se il voto è compreso tra 0 e 10
       if (voto < 0 || voto > 10) {
           return -1;
       }
   	
   	int ret = valutazione.scriviSuDB(idvalutazione, matricola,idmaterie,data,voto);
   	
	   	if(ret!=-1) {
	   		valutazione.setData(data);
	   		valutazione.setVoto(voto);
	   	}
       return ret;
	}
	
	public boolean controllomateria(int idmateria) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteMateria(idmateria);
	}
	
	public boolean controllostudente(int matricola) {
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteStudente(matricola);
	}
	
	public boolean controlloclasse(int classe) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		if((singleton.verificaclassi(classe))!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public int CercaUsername(String username, String ruolo) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		int ret = singleton.esisteUsername(username, ruolo);
		
		return ret;
	}

}
