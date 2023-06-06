package entity;

import java.util.ArrayList;

import database.MateriaDAO;
import database.RegistroDAO;
import database.StudenteDAO;

public class EntityClasse {
	
	private int idClasse;
	private int annoscolastico;
	private String sezione;
	private String anno;
	private RegistroDAO registro;
	private ArrayList<EntityStudente> studenti;
	private ArrayList<EntityMateria> materie;

	public EntityClasse() {
		// TODO Auto-generated constructor stub
		super();
		this.studenti= new ArrayList<EntityStudente>();
		this.materie = new ArrayList<EntityMateria>();
	}
	

	public EntityClasse(int idClasse) {
		super();
		this.idClasse = idClasse;
	}



	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getAnnoscolastico() {
		return annoscolastico;
	}

	public void setAnnoscolastico(int annoscolastico) {
		this.annoscolastico = annoscolastico;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public RegistroDAO getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroDAO registro) {
		this.registro = registro;
	}

	public ArrayList<EntityStudente> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<EntityStudente> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<EntityMateria> getMaterie() {
		return materie;
	}

	public void setMaterie(ArrayList<EntityMateria> materie) {
		this.materie = materie;
	}
	
	

}
