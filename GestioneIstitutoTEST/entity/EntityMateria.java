package entity;

import java.util.ArrayList;

import database.MateriaDAO;

public class EntityMateria {
	
    private int idmaterie;
    private String nome;
    private EntityClasse classe;
    private EntityDocente docente;
    private ArrayList<EntityValutazione> valutazioni;

	public EntityMateria() {
		// TODO Auto-generated constructor stub
		super();
        this.valutazioni =new ArrayList<EntityValutazione>();
	}
	
	//costruttore con la PK
	public EntityMateria(int idmaterie) {
		
		this.idmaterie = idmaterie;//nel db potremmo chiamarlo idMateria
		MateriaDAO materia = new MateriaDAO(idmaterie); //carico dal DB con la PK
		this.nome = materia.getNome();
		
		materia.caricaClasseDaDB();
		caricaClasse(materia);
		
		valutazioni = new ArrayList<EntityValutazione>();
		//materia.caricaValutazioniDaDB();
		//caricaValutazioni(materia);
					
	}
	

	//costruttore copia
	public EntityMateria(MateriaDAO materia) {
		
		this.idmaterie = materia.getIdmateria();
		this.nome = materia.getNome();
		valutazioni = new ArrayList<EntityValutazione>();
		
		caricaValutazioni(materia);
		
	}
	
	public void caricaValutazioni(MateriaDAO materia) {
		
		for(int i=0; i<materia.getValutazioni().size(); i++) {
			
			EntityValutazione valutazione = new EntityValutazione(materia.getValutazioni().get(i)); //va implementato il copy in Valutazioni
			this.valutazioni.add(valutazione);
		}
	}
	
	public void caricaClasse(MateriaDAO materia) {
		
			EntityClasse classe = new EntityClasse(materia.getClasse()); //va implementato il copy in Classe
			this.classe=classe;
			
			System.out.println(classe.toString());
	}
	
	public void caricaDocente(MateriaDAO materia) {
		
		materia.caricaDocenteDaDB();
		
		EntityDocente docente = new EntityDocente(materia.getDocente().getUsername()); //va implementato il copy in Valutazioni
		this.docente=docente;
	}
	
	public int getIdmaterie() {
		return idmaterie;
	}

	public void setIdmaterie(int idmaterie) {
		this.idmaterie = idmaterie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<EntityValutazione> getValutazioni() {
		return valutazioni;
	}

	public void setValutazioni(ArrayList<EntityValutazione> valutazioni) {
		this.valutazioni = valutazioni;
	}

	@Override
	public String toString() {
		return "\n idmaterie=" + idmaterie + ", nome=" + nome+ ", classe=" + classe.getIdClasse();
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}

	public EntityDocente getDocente() {
		return docente;
	}

	public void setDocente(EntityDocente docente) {
		this.docente = docente;
	}
	
	

}