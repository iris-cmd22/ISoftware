package entity;

import java.sql.Date;

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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
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
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getComuneResidenza() {
		return comuneResidenza;
	}
	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroCellulare() {
		return numeroCellulare;
	}
	public void setNumeroCellulare(String numeroCellulare) {
		this.numeroCellulare = numeroCellulare;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
