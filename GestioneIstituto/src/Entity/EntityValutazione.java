package entity;

public class EntityValutazione {
	
	private int idvalutazione;
	private String data;
	private String tipo;
	private float voto;

	public EntityValutazione() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	

	public EntityValutazione(int idvalutazione) {
		super();
		this.idvalutazione = idvalutazione;
	}



	public int getIdvalutazione() {
		return idvalutazione;
	}

	public void setIdvalutazione(int idvalutazione) {
		this.idvalutazione = idvalutazione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getVoto() {
		return voto;
	}

	public void setVoto(float voto) {
		this.voto = voto;
	}
	
	

}
