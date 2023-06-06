package entity;

import java.util.ArrayList;

import database.AttivitaDAO;

public class EntityRegistro {
	
	private int idRegistro;
	private ArrayList<EntityAttivita> attivita;

	public EntityRegistro() {
		// TODO Auto-generated constructor stub
		super();
		this.attivita= new ArrayList<EntityAttivita>();
	}
	
	

	public EntityRegistro(int idRegistro) {
		super();
		this.idRegistro = idRegistro;
	}



	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public ArrayList<EntityAttivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(ArrayList<EntityAttivita> attivita) {
		this.attivita = attivita;
	}
	
	

}
