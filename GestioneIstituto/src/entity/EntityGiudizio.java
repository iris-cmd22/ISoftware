package entity;

import database.MateriaDAO;

public class EntityGiudizio {
	
	private String quadrimestre;
	private float voto;
	private MateriaDAO materia;

	public EntityGiudizio() {
		// TODO Auto-generated constructor stub
	}

	public String getQuadrimestre() {
		return quadrimestre;
	}

	public void setQuadrimestre(String quadrimestre) {
		this.quadrimestre = quadrimestre;
	}

	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}

	public MateriaDAO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDAO materia) {
		this.materia = materia;
	}

	
}
