package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "mydb_argo";
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root"; 
	public static String password = "Cifrescula20!";
	
	
	//Serve a connetterci
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;		//capisco se la connessione è andata a buon fine o meno
		Class.forName(driver); //com.mysql.cj.jdbc.Driver
		
		conn = DriverManager.getConnection(url+dbName,userName,password); //gli attributi della nostra classe andranno in input 
		
		return conn;
	}
	
	//prendo in ingresso la connessione da chiudere
	public static void closeConnection(Connection c) throws SQLException {
		
		c.close();
	}
	
	//
	public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		
		Statement statment = conn.createStatement(); //tramite connessione ci andiamo a prendere lo statement
		
		ResultSet ret = statment.executeQuery(query); //tramite statement posso eseguire lo statement
		
		//conn.close(); non si deve chiudere ancora
		
		return ret;
	}
	
	//prendo in ingresso una query e restituisce un intero
	public static int updateQuery(String query) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		Statement statement = conn.createStatement();
		int ret = statement.executeUpdate(query);
		conn.close();
		return ret;
	}
	
	public static Integer updateQueryReturnGeneratedKey(String query) throws ClassNotFoundException, SQLException {
		Integer ret = null;
		
		Connection conn = getConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = statement.getGeneratedKeys();
		if (rs.next()){
		    ret = rs.getInt(1);
		}
		
		conn.close();
		
		return ret;
	}
}
