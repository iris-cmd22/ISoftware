package entity;

import java.util.ArrayList;

import database.ClasseDAO;
import database.RegistroDAO;

public class EntityClasse {
	
	private int idClasse;
	private int annoscolastico;
	private String sezione;
	private String anno;
	private EntityRegistro registro;
	private ArrayList<EntityStudente> studenti;
	private ArrayList<EntityMateria> materie;

	public EntityClasse() {
		// TODO Auto-generated constructor stub
		super();
		this.studenti= new ArrayList<EntityStudente>();
		this.materie = new ArrayList<EntityMateria>();
	
	}
	

	//costruttore con la PK
	public EntityClasse(int idClasse) {
		
		ClasseDAO classe = new ClasseDAO(idClasse);
		
		this.idClasse=idClasse;
		this.annoscolastico=classe.getAnnoscolastico();
		this.sezione=classe.getSezione();
		this.anno=classe.getAnno();
		this.studenti= new ArrayList<EntityStudente>();
		this.materie = new ArrayList<EntityMateria>();
		
		/*
		classe.caricaMaterieDaDB();
		caricaMaterie(classe);
		
		classe.caricaStudentiDaDB();
		caricaStudenti(classe);
		
		classe.caricaRegistroDaDB();
		caricaRegistro(classe);
		*/
	}
	
	//costruttore con DAO
	public EntityClasse(ClasseDAO classe) {
		
		this.idClasse=classe.getIdClasse();
		this.annoscolastico=classe.getAnnoscolastico();
		this.sezione=classe.getSezione();
		this.anno=classe.getAnno();
		this.studenti= new ArrayList<EntityStudente>();
		this.materie = new ArrayList<EntityMateria>();
		
	}



	private void caricaMaterie(ClasseDAO classe) {
		
		for(int i=0;i<classe.getMaterie().size();i++) {
			
			EntityMateria materia =new EntityMateria(classe.getMaterie().get(i));
			this.materie.add(materia);
	
		}
	}
 

	private void caricaStudenti(ClasseDAO classe) {
		
		for(int i=0;i<classe.getStudenti().size();i++) {
			
			EntityStudente studente =new EntityStudente(classe.getStudenti().get(i));
			this.studenti.add(studente);
	
		}
		
	}

	
	private void caricaRegistro(ClasseDAO classe) {
		
		EntityRegistro registro= new EntityRegistro(classe.getRegistro().getIdRegistro());
		this.registro=registro;
		
	} 

	public int scriviSuDB(int idClasse) {
		
		ClasseDAO s= new ClasseDAO(idClasse); //DAO
		
		s.setAnno(this.anno);
		s.setSezione(this.sezione);
		s.setAnnoscolastico(this.annoscolastico);
		int i = s.SalvaInDB(idClasse);
		
		return i;
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

	public EntityRegistro getRegistro() {
		return registro;
	}

	public void setRegistro(EntityRegistro registro) {
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


	@Override
	public String toString() {
		return "Classe [idClasse=" + idClasse + ", annoscolastico=" + annoscolastico + ", sezione=" + sezione
				+ ", anno=" + anno + ", registro=" + registro + ", studenti=" + studenti + ", materie=" + materie + "]\n";
	}
	
	
	
	

}
