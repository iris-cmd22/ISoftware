package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenitoreDAO {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String comuneResidenza;
	private String email;
	private String numeroCellulare;
	private String username;
	private String password;
	
	public GenitoreDAO() {
		super();
	}
	
	public GenitoreDAO(String username) {
		
		this.username=username;
		caricaDaDB();
	}
	
	
	public GenitoreDAO(GenitoreDAO genitore) {
		
		this.username=genitore.getUsername();
		this.password=genitore.getPassword();
		this.nome=genitore.getNome();
		this.cognome=genitore.getCognome();
		this.dataNascita=genitore.getDataNascita();
		this.codiceFiscale=genitore.getCodiceFiscale();
		this.comuneResidenza=genitore.getComuneResidenza();
		this.email=genitore.getEmail();
		this.numeroCellulare=genitore.getNumeroCellulare();
		
	}
	
	public void caricaDaDB() {
		
		String query =new String("SELECT * FROM genitori WHERE username = '"+this.username+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setDataNascita(rs.getDate("dataNascita"));
				this.setCodiceFiscale(rs.getString("codiceFiscale"));
				this.setComuneResidenza(rs.getString("comuneResidenza"));
				this.setNumeroCellulare(rs.getString("numeroCellulare"));
				this.setUsername(rs.getString("username"));
				this.setPassword(rs.getString("password"));
				
			}
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int SalvaInDB(String username) {
		
		int ret=0;
		
		String query = "INSERT INTO genitori(username, password,nome,cognome,codicefiscale, datanascita, comuneresidenza, email, numerocellulare) VALUES ( \'"+username+"\','"+this.password+"\','"+this.nome+"\','"+this.cognome+"\','"+this.codiceFiscale+"\','"+this.dataNascita+"\','"+this.comuneResidenza+"\','"+this.email+"\','"+this.numeroCellulare+"')";
		System.out.println(query);
		try {
			ret=DBConnectionManager.updateQuery(query);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1; //per l'errore di scrittura
		}
		return ret;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getComuneResidenza() {
		return comuneResidenza;
	}

	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroCellulare() {
		return numeroCellulare;
	}

	public void setNumeroCellulare(String numeroCellulare) {
		this.numeroCellulare = numeroCellulare;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

