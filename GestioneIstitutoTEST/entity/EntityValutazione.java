package entity;

import java.sql.Date;

import Exception.VotoNotValid;
import database.ValutazioneDAO;
import database.StudenteDAO;
import database.MateriaDAO;

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
		//valutazione.caricaStudenteDaDB();
		//caricaStudente(valutazione);
		
	}

	public EntityValutazione(ValutazioneDAO valutazione) {
		this.data=valutazione.getData();
		this.voto=valutazione.getVoto();
		this.idvalutazioni=valutazione.getIdvalutazioni();
		valutazione.caricaMateriaDaDB();
		caricaMateria(valutazione);
		//valutazione.caricaStudenteDaDB();
		//caricaStudente(valutazione);
		
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
		public int scriviSuDB(int idvalutazioni) {
			
			ValutazioneDAO v= new ValutazioneDAO(idvalutazioni); //DAO
			
			v.setData(this.data);
			v.setVoto(this.voto);
			
			StudenteDAO s= new StudenteDAO(studente.getMatricola());
			v.setStudente(s);
			
			MateriaDAO m=new MateriaDAO(materia.getIdmaterie());
			v.setMateria(m);
			
			int i = v.SalvaInDB(idvalutazioni);
			
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

	public void setVoto(float voto) throws VotoNotValid {
		if(voto<1) {
			throw new VotoNotValid("Il voto deve essere almeno pari a 1!");
		}
		if(voto>10) {
			throw new VotoNotValid("Il voto deve essere al massimo pari a 10!");
		}
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