package entity;

import java.util.ArrayList;

import database.MateriaDAO;

public class EntityMateria {
	
    private int idmaterie;
    private String nome;
    private EntityClasse classe;
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
		valutazioni = new ArrayList<EntityValutazione>();
		
		materia.caricaValutazioniDaDB();
		caricaValutazione(materia);
					
	}
	

	//costruttore copia
	public EntityMateria(MateriaDAO materia) {
		
		this.idmaterie = materia.getIdmateria();
		this.nome = materia.getNome();
		valutazioni = new ArrayList<EntityValutazione>();
		
		caricaValutazione(materia);
		
	}
	
	public void caricaValutazione(MateriaDAO materia) {
		for(int i=0; i<materia.getValutazioni().size(); i++) {
			
			EntityValutazione valutazione = new EntityValutazione(materia.getValutazioni().get(i)); //va implementato il copy in Valutazioni
			this.valutazioni.add(valutazione);
		}
	}
	
	public void caricaClasse(MateriaDAO materia) {
			
			EntityClasse classe = new EntityClasse(materia.getClasse()); //va implementato il copy in Valutazioni
			this.classe=classe;
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
		return "idmaterie=" + idmaterie + ", nome=" + nome+ ", classe=" + classe ;
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}
	
	

}
