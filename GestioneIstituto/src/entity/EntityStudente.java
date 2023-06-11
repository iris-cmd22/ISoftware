package entity;

import java.sql.Date;

import java.util.ArrayList;

import database.StudenteDAO;


public class EntityStudente {

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
		private ArrayList<EntityPagella> pagelle;
		private ArrayList<EntityValutazione> valutazioni;
		//private EntityGenitore genitore;
		
		public EntityStudente() {
			super();
			this.pagelle =new ArrayList<EntityPagella>();
			this.valutazioni= new ArrayList<EntityValutazione>();
		}
		
		
		public EntityStudente(int matricola) {
			StudenteDAO studente = new StudenteDAO(matricola);
			
			this.nome=studente.getNome();
			this.cognome=studente.getCognome();
			this.matricola=matricola;
			this.dataNascita=studente.getDataNascita();
			this.codiceFiscale=studente.getCodiceFiscale();
			this.comuneResidenza=studente.getComuneResidenza();
			this.email=studente.getEmail();
			this.numeroCellulare=studente.getNumeroCellulare();
			this.username=studente.getUsername();
			this.password=studente.getPassword();
			this.pagelle= new ArrayList<EntityPagella>(); //devo inizializzare gli arrayList vuoti
			this.valutazioni= new ArrayList<EntityValutazione>();
			
			studente.caricaPagelleStudenteDaDB();
			caricaPagelle(studente);
			studente.caricaValutazioniDaDB();
			caricaValutazioni(studente);
			//studente.caricaGenitoreDaDB();
			//caricaGenitore(studente);
			
		}

		public EntityStudente(StudenteDAO studente) {
			this.nome=studente.getNome();
			this.cognome=studente.getCognome();
			this.matricola=studente.getMatricola();
			this.dataNascita=studente.getDataNascita();
			this.codiceFiscale=studente.getCodiceFiscale();
			this.comuneResidenza=studente.getComuneResidenza();
			this.email=studente.getEmail();
			this.numeroCellulare=studente.getNumeroCellulare();
			this.username=studente.getUsername();
			this.password=studente.getPassword();
			this.pagelle= new ArrayList<EntityPagella>(); 
			this.valutazioni= new ArrayList<EntityValutazione>();
			
			studente.caricaPagelleStudenteDaDB();
			caricaPagelle(studente);
			studente.caricaValutazioniDaDB();
			caricaValutazioni(studente);
			//studente.caricaGenitoreDaDB();
			//caricaGenitore(studente);

		}

		public void caricaValutazioni(StudenteDAO studente) {
			
			
			for(int i=0;i<studente.getValutazioni().size();i++) {
				
				EntityValutazione valutazione = new EntityValutazione(studente.getValutazioni().get(i));
				this.valutazioni.add(valutazione);
			}
		}
		
		
	public void caricaPagelle(StudenteDAO studente) {
			
			
			for(int i=0;i<studente.getPagelle().size();i++) {
				
				EntityPagella pagelle = new EntityPagella(studente.getPagelle().get(i));
				this.pagelle.add(pagelle);
			}
		}
		/*
		public void caricaGenitore(StudenteDAO studente) {
			
			
			EntityGenitore genitore = new EntityGenitore(studente.getGenitore());		
			this.genitore = genitore;
			
		}
		*/
		public int scriviSuDB(int matricola) {
			
			StudenteDAO s= new StudenteDAO(); //DAO
			
			s.setNome(this.nome);
			s.setCognome(this.cognome);
			s.setDataNascita(this.dataNascita);
			s.setCodiceFiscale(this.codiceFiscale);
			s.setComuneResidenza(this.comuneResidenza);
			s.setDataNascita(this.dataNascita);
			s.setEmail(this.email);
			s.setNumeroCellulare(this.numeroCellulare);
			s.setUsername(this.username);
			s.setPassword(this.password);
			
			int i = s.SalvaInDB(matricola);
			
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


		public ArrayList<EntityPagella> getPagelle() {
			return pagelle;
		}


		public void setPagelle(ArrayList<EntityPagella> pagelle) {
			this.pagelle = pagelle;
		}


		public ArrayList<EntityValutazione> getValutazioni() {
			return valutazioni;
		}


		public void setValutazioni(ArrayList<EntityValutazione> valutazioni) {
			this.valutazioni = valutazioni;
		}


	/*
		public EntityGenitore getGenitore() {
			return genitore;
		}


		public void setGenitore(EntityGenitore genitore) {
			this.genitore = genitore;
		}
*/

		@Override
		public String toString() {
			return "EntityStudente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola
					+ ", dataNascita=" + dataNascita + ", codiceFiscale=" + codiceFiscale + ", comuneResidenza="
					+ comuneResidenza + ", email=" + email + ", numeroCellulare=" + numeroCellulare + ", username="
					+ username + ", password=" + password + "]";
		}
			

}
