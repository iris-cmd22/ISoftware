package entity;

import java.util.ArrayList;

import database.PagellaDAO;
import database.StudenteDAO;

public class EntityPagella {
	
	//dichiaro le variabili della classe
		private boolean stato;
		private int annoscolastico;
		private float mediavoti;
		private StudenteDAO studente;
		private ArrayList<EntityGiudizio> giudizi; //ogni pagella avrà un array dei suoi giudizi, uno per ogni materia
		

	public EntityPagella() {
		// TODO Auto-generated constructor stub
		super();
		this.giudizi= new ArrayList<EntityGiudizio>();
	}
	
	


	public EntityPagella(StudenteDAO studente) {
		super();
		this.studente = studente;
	}

	public EntityPagella(PagellaDAO pagella) {
		super();
	}


	public boolean isStato() {
		return stato;
	}


	public void setStato(boolean stato) {
		this.stato = stato;
	}


	public int getAnnoscolastico() {
		return annoscolastico;
	}


	public void setAnnoscolastico(int annoscolastico) {
		this.annoscolastico = annoscolastico;
	}


	public float getMediavoti() {
		return mediavoti;
	}


	public void setMediavoti(float mediavoti) {
		this.mediavoti = mediavoti;
	}


	public StudenteDAO getStudente() {
		return studente;
	}


	public void setStudente(StudenteDAO studente) {
		this.studente = studente;
	}


	public ArrayList<EntityGiudizio> getGiudizi() {
		return giudizi;
	}


	public void setGiudizi(ArrayList<EntityGiudizio> giudizi) {
		this.giudizi = giudizi;
	}

	
}