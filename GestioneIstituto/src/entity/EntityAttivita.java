package entity;

import database.DocenteDAO;

public class EntityAttivita {
	
	private int idattivita;
	private String data;
	private String descrizione;
	private DocenteDAO docente;

	public EntityAttivita() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	public EntityAttivita(int idattivita) {
		super();
		this.idattivita = idattivita;
	}



	public int getIdattivita() {
		return idattivita;
	}

	public void setIdattivita(int idattivita) {
		this.idattivita = idattivita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public DocenteDAO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDAO docente) {
		this.docente = docente;
	}

	
}
