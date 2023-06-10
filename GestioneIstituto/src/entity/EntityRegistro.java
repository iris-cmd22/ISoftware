package entity;

import java.util.ArrayList;

public class EntityRegistro {
	
	private int idRegistro;
	private ArrayList<EntityAttivita> attivita;

	public EntityRegistro() {
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
