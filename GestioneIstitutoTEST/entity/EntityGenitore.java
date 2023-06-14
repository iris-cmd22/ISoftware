package entity;

import java.sql.Date;

import Exception.CodiceFiscaleNotValid;
import Exception.CognomeNotValid;
import Exception.ComuneDiResidenzaNotValid;
import Exception.EmailNotValid;
import Exception.NomeNotValid;
import Exception.NumeroDiCellulareNotValid;
import Exception.PasswordNotValid;
import Exception.UsernameNotValid;
import database.GenitoreDAO;
import database.StudenteDAO;

public class EntityGenitore {

	private String nome;
	private String cognome;
	private int matricola;
	private Date dataNascita;
	private String codiceFiscale;
	private String comuneResidenza;
	private String email;
	private String numeroCellulare;
	private String username;
	private String password;
	private EntityStudente studente;
	
	//costruttore di default
	public EntityGenitore() {
		super();
	}
	


	//costruttore con PK
	public EntityGenitore(String username) {
		
		GenitoreDAO genitore =new GenitoreDAO(username); //creo un oggetto DAO per comunicare con il DB
		
		this.username=username;
		this.password=genitore.getPassword();
		this.nome=genitore.getNome();
		this.cognome=genitore.getCognome();
		this.dataNascita=genitore.getDataNascita();
		this.codiceFiscale=genitore.getCodiceFiscale();
		this.comuneResidenza=genitore.getComuneResidenza();
		this.email=genitore.getEmail();
		this.numeroCellulare=genitore.getNumeroCellulare();
		
		genitore.caricaStudenteDaDB();
		caricaStudente(username);
		
	}
	
	//costruttore che prende in ingresso la DAO
	public EntityGenitore(GenitoreDAO genitore) {
		this.nome=genitore.getNome();
		this.cognome=genitore.getCognome();
		this.dataNascita=genitore.getDataNascita();
		this.codiceFiscale=genitore.getCodiceFiscale();
		this.comuneResidenza=genitore.getComuneResidenza();
		this.email=genitore.getEmail();
		this.numeroCellulare=genitore.getNumeroCellulare();
		this.username=genitore.getUsername();
		this.password=genitore.getPassword();

	}
	
	public void caricaStudente(String username) {
			
			GenitoreDAO genitore =new GenitoreDAO(username);
			genitore.caricaStudenteDaDB();
			
			EntityStudente studente =new EntityStudente(genitore.getStudente().getMatricola());
			this.studente=studente;
	
		}
		


	public int scriviSuDB(String username) {
		
		GenitoreDAO s= new GenitoreDAO(username); //DAO
		StudenteDAO ss=new StudenteDAO(studente.getMatricola());
		
		s.setPassword(this.password);
		s.setNome(this.nome);
		s.setCognome(this.cognome);
		s.setDataNascita(this.dataNascita);
		s.setCodiceFiscale(this.codiceFiscale);
		s.setComuneResidenza(this.comuneResidenza);
		s.setEmail(this.email);
		s.setNumeroCellulare(this.numeroCellulare);
		s.setStudente(ss);
		int i = s.SalvaInDB(username);
		
		return i;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NomeNotValid{
		
		if(nome.length()>100) {
			throw new NomeNotValid("Nome non valido");
		}
		
		if(nome.length()==0) {
			throw new NomeNotValid("Nome vuoto");
		}
		
		if(!Character.isUpperCase(nome.charAt(0))) {
			throw new NomeNotValid("Il nome deve iniziare con una maiuscola");
		}
		
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) throws CognomeNotValid{
		
		if(cognome.length()>100) {
			throw new CognomeNotValid("Cognome non valido");
		}	
		
		if(cognome.length()==0) {
			throw new CognomeNotValid("Cognome vuoto");
		}
		
		if(!Character.isUpperCase(cognome.charAt(0))) {
			throw new CognomeNotValid("Il cognome deve iniziare con una maiuscola");
		}
		
		this.cognome = cognome;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) throws CodiceFiscaleNotValid{
		
		//Regex per verificare che la stringa contenga solo lettere maiuscole e numeri
		String regex = "^[A-Z0-9]+$"; 
		
		if(codiceFiscale.length()!=16) {
			throw new CodiceFiscaleNotValid("Codice fiscale: lunghezza non valida");
		}
		
		if(!codiceFiscale.matches(regex)) {
			throw new CodiceFiscaleNotValid("Codice fiscale: formato non valido");
		}
		
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getComuneResidenza() {
		return comuneResidenza;
	}
	
	public void setComuneResidenza(String comuneResidenza) throws ComuneDiResidenzaNotValid{
		
		// Verifica se la stringa contiene solo caratteri alfanumerici e spazi vuoti
        String regex = "^[A-Za-z0-9\\s]+$";
        
        if(comuneResidenza.length()>50) {
        	throw new ComuneDiResidenzaNotValid("Comune di residenza: lunghezza non valida");
        }
        
        if(!comuneResidenza.matches(regex)) {
        	throw new ComuneDiResidenzaNotValid("Comune di residenza: formato non valido");
        }
		
		this.comuneResidenza = comuneResidenza;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws EmailNotValid{
		
		if(!email.contains("@")) {
			throw new EmailNotValid("Email non valida");
		}
		
		this.email = email;
	}
	
	public String getNumeroCellulare() {
		return numeroCellulare;
	}
	
	public void setNumeroCellulare(String numeroCellulare) throws NumeroDiCellulareNotValid{
		
		if(numeroCellulare.length()>15) {
			throw new NumeroDiCellulareNotValid("Numero di cellulare non valido: numero troppo lungo");
		}
		
		if(numeroCellulare.length()==0) {
			throw new NumeroDiCellulareNotValid("Numero di cellulare vuoto");
		}
		
		this.numeroCellulare = numeroCellulare;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) throws UsernameNotValid{
		
		if(username.length()>20) {
			throw new UsernameNotValid("Username troppo lungo");
		}
		
		if(username.length()==0) {
			throw new UsernameNotValid("Username vuoto");
		}
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws PasswordNotValid{
		
		if(password.length()>20) {
			throw new PasswordNotValid("Password troppo lunga");
		}
		
		if(password.length()==0) {
			throw new PasswordNotValid("Password vuoto");
		}
		
		this.password = password;
	}
	
	public EntityStudente getStudente() {
		return studente;
	}

	public void setStudente(EntityStudente studente) {
		this.studente = studente;
	}




	@Override
	public String toString() {
		return "EntityGenitore [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", dataNascita="
				+ dataNascita + ", codiceFiscale=" + codiceFiscale + ", comuneResidenza=" + comuneResidenza + ", email="
				+ email + ", numeroCellulare=" + numeroCellulare + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
	
}