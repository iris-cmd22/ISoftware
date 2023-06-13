package entity;

import java.sql.Date;
import java.util.ArrayList;

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
		// TODO Auto-generated constructor stub
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