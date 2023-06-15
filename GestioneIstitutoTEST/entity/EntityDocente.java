package entity;

import java.sql.Date;
import java.util.ArrayList;

import Exception.CodiceFiscaleNotValid;
import Exception.CognomeNotValid;
import Exception.ComuneDiResidenzaNotValid;
import Exception.EmailNotValid;
import Exception.NomeNotValid;
import Exception.NumeroDiCellulareNotValid;
import Exception.PasswordNotValid;
import Exception.UsernameNotValid;
import database.DocenteDAO;
import database.MateriaDAO;

public class EntityDocente {
	
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
	private ArrayList<EntityMateria> materie;

	public EntityDocente() {
		
		super();
		this.setMaterie(new ArrayList<EntityMateria>());
	}
	
	
	//costruttore con la PK
	public EntityDocente(String username) {
		
		DocenteDAO docente = new DocenteDAO(username);
		
		this.username = username;
		this.password = docente.getPassword();
		this.nome = docente.getNome();
		this.cognome = docente.getCognome();
		this.dataNascita = docente.getDataNascita();
		this.codiceFiscale = docente.getCodiceFiscale();
		this.comuneResidenza = docente.getComuneResidenza();
		this.email = docente.getEmail();
		this.numeroCellulare = docente.getNumeroCellulare();
		this.materie = new ArrayList<EntityMateria>();
		
		//System.out.println("EntityDocente: "+docente.toString());
		docente.caricaMaterieDaDB();
		//System.out.println("EntityDocente ->: "+docente.toString());
		caricaMaterie(docente);
	}

	public void caricaMaterie(DocenteDAO docente) {
		
		for(int i=0; i<docente.getMaterie().size(); i++) {
			
			EntityMateria materia = new EntityMateria(docente.getMaterie().get(i).getIdmateria());
			
			this.materie.add(materia);
			
		}
	}
	
	public int scriviSuDB(String username) {
		
		DocenteDAO d = new DocenteDAO(username);
		
		d.setNome(this.nome);
		d.setCognome(this.cognome);
		d.setComuneResidenza(this.comuneResidenza);
		d.setCodiceFiscale(this.codiceFiscale);
		d.setDataNascita(this.dataNascita);
		d.setEmail(this.email);
		d.setNumeroCellulare(this.numeroCellulare);
		d.setPassword(this.password);
		
		int i = d.SalvaInDB(username);
		
		return i;
	}
	
	public int aggiornaMaterieSuDB(String username) {
		
			int ret=1;
			DocenteDAO d = new DocenteDAO(username);
			
			d.setNome(this.nome);
			d.setCognome(this.cognome);
			d.setComuneResidenza(this.comuneResidenza);
			d.setCodiceFiscale(this.codiceFiscale);
			d.setDataNascita(this.dataNascita);
			d.setEmail(this.email);
			d.setNumeroCellulare(this.numeroCellulare);
			d.setPassword(this.password);
			
			ArrayList<MateriaDAO> materie_temp = new ArrayList<MateriaDAO>();
			for(int i=0;i<this.materie.size();i++) {
				
				MateriaDAO m = new MateriaDAO(materie.get(i).getIdmaterie());
				
				m.setDocente(d);
				ret=m.SalvaDocenteInDB();
				System.out.println(ret);
				
				materie_temp.add(m);
			}
			
			d.setMaterie(materie_temp);
			
			return ret;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeNotValid {
		
		if(nome.length()>100) { //se la lunghezza della stringa maggiore di 100
			throw new NomeNotValid("Nome non valido");
		}
		
		if(nome.length()==0) { //se la stringa è vuota
			throw new NomeNotValid("Nome vuoto");
		}
		
		if(!Character.isUpperCase(nome.charAt(0))) {//se il primo carattere della stringa non è maiuscola
			throw new NomeNotValid("Il nome deve iniziare con una maiuscola");
		}
		
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) throws CognomeNotValid{
		
		if(cognome.length()>100) {//se la lunghezza della stringa maggiore di 100
			throw new CognomeNotValid("Cognome non valido");
		}	
		
		if(cognome.length()==0) {//se la stringa è vuota
			throw new CognomeNotValid("Cognome vuoto");
		}
		
		if(!Character.isUpperCase(cognome.charAt(0))) {//se il primo carattere della stringa non è maiuscola
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
		
		if(codiceFiscale.length()!=16) { //se la lunghezza della stringa è diversa da 16
			throw new CodiceFiscaleNotValid("Codice fiscale: lunghezza non valida");
		}
		
		if(!codiceFiscale.matches(regex)) {//regex per verificare il formato
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
        
        if(comuneResidenza.length()>50) {//se la lunghezza della stringa è maggiore di 50
        	throw new ComuneDiResidenzaNotValid("Comune di residenza: lunghezza non valida");
        }
        
        if(comuneResidenza.length()==0) {//se la stringa è vuota
        	throw new ComuneDiResidenzaNotValid("Comune di residenza: vuoto");
        }
        
        if(!comuneResidenza.matches(regex)) {//regex per verificare il formato
        	throw new ComuneDiResidenzaNotValid("Comune di residenza: formato non valido");
        }
		
		this.comuneResidenza = comuneResidenza;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailNotValid{
		
		if(!email.contains("@")) {//se la stringa contiene la @
			throw new EmailNotValid("Email non valida");
		}
		
		this.email = email;
	}

	public String getNumeroCellulare() {
		return numeroCellulare;
	}

	public void setNumeroCellulare(String numeroCellulare) throws NumeroDiCellulareNotValid{
		
		if(numeroCellulare.length()>15) {//se la lunghezza della stringa è maggiore di 15
			throw new NumeroDiCellulareNotValid("Numero di cellulare non valido: numero troppo lungo");
		}
		
		if(numeroCellulare.length()==0) {//se la stringa è vuota
			throw new NumeroDiCellulareNotValid("Numero di cellulare vuoto");
		}
		
		this.numeroCellulare = numeroCellulare;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws UsernameNotValid{
		
		if(username.length()>20) {//se la lunghezza della stringa è maggiore di 20
			throw new UsernameNotValid("Username troppo lungo");
		}
		
		if(username.length()==0) {//se la stringa è vuota
			throw new UsernameNotValid("Username vuoto");
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PasswordNotValid{
		
		if(password.length()>20) {//se la lunghezza della stringa è maggiore di 20
			throw new PasswordNotValid("Password troppo lunga");
		}
		
		if(password.length()==0) {//se la stringa è vuota
			throw new PasswordNotValid("Password vuoto");
		}
		
		this.password = password;
	}



	public ArrayList<EntityMateria> getMaterie() {
		return materie;
	}

	public void setMaterie(ArrayList<EntityMateria> materie) {
		this.materie = materie;
	}


	@Override
	public String toString() {
		return "EntityDocente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", dataNascita="
				+ dataNascita + ", codiceFiscale=" + codiceFiscale + ", comuneResidenza=" + comuneResidenza + ", email="
				+ email + ", numeroCellulare=" + numeroCellulare + ", username=" + username + ", password=" + password
				+ ", materie=" + materie + "]";
	}
	
	
	
}
