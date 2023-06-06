package entity;

import java.util.ArrayList;

import database.ValutazioneDAO;

public class EntityMateria {
	
    private int idmaterie;
    private String nome;
    private ArrayList<EntityValutazione> valutazioni;

    public EntityMateria(int idmaterie) {
		this.idmaterie = idmaterie;
		
	}

	public EntityMateria() {
		// TODO Auto-generated constructor stub
		super();
        this.valutazioni =new ArrayList<EntityValutazione>();
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
	
	

}
