package entity;

import java.sql.Date;

import database.ValutazioneDAO;

public class EntityValutazione {
	
	private int idvalutazioni;
	private Date data;
	private float voto;
	private EntityMateria materia;
	private EntityStudente studente;

	public EntityValutazione() {
		super();
	}
	
	

	public EntityValutazione(int idvalutazioni) {
		ValutazioneDAO valutazione= new ValutazioneDAO(idvalutazioni);
		
		this.data=valutazione.getData();
		this.voto=valutazione.getVoto();
		this.idvalutazioni=idvalutazioni;
		
		valutazione.caricaMateriaDaDB();
		caricaMateria(valutazione);
		valutazione.caricaStudenteDaDB();
		caricaStudente(valutazione);
		
	}

	public EntityValutazione(ValutazioneDAO valutazione) {
		this.data=valutazione.getData();
		this.voto=valutazione.getVoto();
		this.idvalutazioni=valutazione.getIdvalutazioni();
		valutazione.caricaMateriaDaDB();
		caricaMateria(valutazione);
		valutazione.caricaStudenteDaDB();
		caricaStudente(valutazione);
		
	}
	
	
	public void caricaMateria(ValutazioneDAO valutazione) {
		EntityMateria materia = new EntityMateria(valutazione.getMateria());
		this.materia=materia;
		
	}
	
	public void caricaStudente(ValutazioneDAO valutazione) {
		EntityStudente studente = new EntityStudente(valutazione.getStudente());
		this.studente=studente;
	}

	//aggiunto per implementare aggiungiVoto
		public int scriviSuDB(int idvalutazioni, int matricola,int idmaterie, Date data, float voto ) {
			
			ValutazioneDAO v= new ValutazioneDAO(); //DAO
			
			
			v.setData(this.data);
			v.setVoto(this.voto);
			
			
			int i = v.SalvaInDB(idvalutazioni, matricola, idmaterie, data, voto );
			
			return i;
		}

	public int getIdvalutazioni() {
		return idvalutazioni;
	}

	public void setIdvalutazioni(int idvalutazioni) {
		this.idvalutazioni = idvalutazioni;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}



	public EntityMateria getMateria() {
		return materia;
	}



	public void setMateria(EntityMateria materie) {
		this.materia = materie;
	}



	public EntityStudente getStudente() {
		return studente;
	}



	public void setStudente(EntityStudente studenti) {
		this.studente = studenti;
	}



	@Override
	public String toString() {
		return "data=" + data.toString() + ", materia="+ materia.getNome()+ ", voto=" + voto + "\n";
	}
	
	
	
	

}
