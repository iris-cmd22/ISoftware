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
			String comuneResidenza, String email,String numeroCellulare, String username,
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
		
		if(ret == -1) {
			
			System.out.println("Materie non verificate");
			return ret;
		}
		
		ret=docente.scriviSuDB(username);
		
		if(ret == -1) {
			
			System.out.println("Docente non aggiunto");
			return ret;
		}
		
		ret=docente.aggiornaMaterieSuDB(username);
		
		if(ret == -1) {
			
			System.out.println("Materia non aggiornata");
			return ret;
		}
		
		return ret;
		
	}
	
	public int creaStudente(String nome,String cognome,Date dataNascita, String codiceFiscale, 
			String comuneResidenza, String email,String numeroCellulare, String username,
			String password, int classe) {
		
		int ret=0;
		
		matricola++;
	
		EntityStudente studente= new EntityStudente();
		
				studente.setMatricola(matricola);
				studente.setUsername(username);
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
				
				if(ret == -1) {
					
					System.out.println("Classe non verificata");
					return ret;
				}
				
				EntityClasse c = new EntityClasse(classe);
				c.getStudenti().add(studente);
				
				
				ret=studente.scriviSuDB(matricola);
				if(ret == -1) {
					
					System.out.println("Studente non aggiunto");
					return ret;
				}
				
				
				
				ret=singleton.scrivi_studente_in_classe(matricola, c.getIdClasse());
				
				if(ret == -1) {
					
					System.out.println("Collegamento non aggiunto");
					return ret;
				}
				
				return ret;
		
	}
	

	public int creaGenitore(String nome,String cognome,Date dataNascita, String codiceFiscale, 
	            String comuneResidenza, String email,String numeroCellulare, String username,
	            String password,int figlio ) {
	        

	        int ret=0;	        

	        EntityGenitore genitore= new EntityGenitore();
	        

	        genitore.setMatricola(matricola);
	        genitore.setPassword(password);
	        genitore.setNome(nome);
	        genitore.setCognome(cognome);
	        genitore.setDataNascita(dataNascita);
	        genitore.setCodiceFiscale(codiceFiscale);
	        genitore.setComuneResidenza(comuneResidenza);
	        genitore.setEmail(email);
	        genitore.setNumeroCellulare(numeroCellulare);
	        
	            

	        IstitutoDAO singleton = IstitutoDAO.getInstance();
	        

	        if(singleton.esisteStudente(figlio)) {	            

	            EntityStudente s=new EntityStudente(figlio);
            

	            genitore.setStudente(s);
	            ret=genitore.scriviSuDB(username);

	        }else {

	            System.out.println("Studente figlio non trovato");
	            ret=-1;

	        }


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
		System.out.println(media);
		
		valutazioni.add("La media complessiva dello studente nel quadrimestre risulta: "+media+" \n");
		
		return valutazioni;
		
	}
	
	
	
//UPDATE Aggiungivoto

public int aggiungiVoto(String docente, int matricola, int idmaterie, Date data, float voto) {
		
		idvalutazione++; //variabile statica per assegnare univocamente l'id
		
		EntityValutazione valutazione = new EntityValutazione();
		valutazione.setIdvalutazioni(idvalutazione);
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		if(!singleton.esisteDocente(docente)) {
			System.out.println("Docente non trovato");
			return -1;
		}
    	
   	 	// Controllo se esiste uno studente con quella matricola
       if (!singleton.esisteStudenteInClasse(matricola,idmaterie)) {
    	   System.out.println("Studente non trovato");
           return -1;
       }

       EntityStudente studente_valutato = new EntityStudente(matricola);
       valutazione.setStudente(studente_valutato);

       // Controllo se esiste una materia con idmaterie
       if (!singleton.esisteMateriaInsegnata(idmaterie,docente)) {
    	   System.out.println("Materia non trovata");
           return -1;
       }

       EntityMateria materia_valutata = new EntityMateria(idmaterie);
       valutazione.setMateria(materia_valutata);

       
       // Controllo se la data è nel quadrimestre corrente
       if (!singleton.isDataValida(data)) {
    	   System.out.println("Data non valida");
           return -1;
       }
       
       
       valutazione.setData(data);

       // Controllo se il voto è compreso tra 0 e 10
       if (voto < 0 || voto > 10) {
           return -1;
       }
   	
       valutazione.setVoto(voto);
       
   		int ret = valutazione.scriviSuDB(idvalutazione);
  
       return ret;
	}

	
public boolean controllomateria_insegnata(int idmateria, String docente) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteMateriaInsegnata(idmateria, docente);
	}
	
public boolean controllomateria(int idmateria) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteMateria(idmateria);
	}
	
	
	
	public boolean controllostudente(int matricola) {
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteStudente(matricola);
	}
	

public boolean controllostudenteInClasse(int matricola,int materia) {
	IstitutoDAO singleton = IstitutoDAO.getInstance();
	
	return singleton.esisteStudenteInClasse(matricola,materia);
}



	
	public boolean controlloclasse(int classe) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		if((singleton.verificaclassi(classe))!=-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean controllodata(Date data) {
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		return singleton.isDataValida(data);
	}
	
	public int CercaUsername(String username, String ruolo) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		int ret = singleton.esisteUsername(username, ruolo);
		
		return ret;
	}
	
	
	
public boolean controllodocente(String username) {
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		
		return singleton.esisteDocente(username);
		
		
	}


public ArrayList<String> visualizzamaterie(){
    	
    	IstitutoDAO singleton = IstitutoDAO.getInstance();
        ArrayList<String> materie = new ArrayList<String>();
        
        for(int i=0;i<singleton.visualizzamaterie().size();i++) {
        	EntityMateria materia=new EntityMateria(singleton.visualizzamaterie().get(i));
        	
        	materie.add(materia.toString());
        }
        
        return materie;
    }
	
public ArrayList<String> visualizzastudenti(){
		
		IstitutoDAO singleton = IstitutoDAO.getInstance();
		ArrayList<String> studenti = new ArrayList<String>();
		
		for(int i=0; i<singleton.visualizzastudenti().size(); i++) {
			EntityStudente studente = new EntityStudente(singleton.visualizzastudenti().get(i).getMatricola());
			studenti.add(studente.toString());
		}
		
		return studenti;
	}
	
public ArrayList<String> visualizzaclassi(){

	IstitutoDAO singleton = IstitutoDAO.getInstance();
	ArrayList<String> classi = new ArrayList<String>();

	for(int i=0; i<singleton.visualizzaclassi().size(); i++) {
		EntityClasse classe = new EntityClasse(singleton.visualizzaclassi().get(i).getIdClasse());
		classi.add(classe.toString());
	}

	return classi;
}



}
