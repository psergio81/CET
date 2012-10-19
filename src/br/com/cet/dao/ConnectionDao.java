package br.com.cet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao{
	
	public static Connection getConnection() throws SQLException { 
		
		return getConnectionMySql();
//		return getConnectionAccess();
		
	}

	
	@SuppressWarnings("unused")
	private static Connection getConnectionAccess() throws SQLException{
		Connection c = null;
		
	     try {
			
	    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
	    	 c = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/java/banco/access2003/banco.mdb");
			
		} catch ( InstantiationException | IllegalAccessException| ClassNotFoundException e) {
			e.printStackTrace();
		}  
	     
	     return c;
	}  
	
	
	private static Connection getConnectionMySql(){
		
		String url = "jdbc:mysql://localhost/ensaio";
		String user = "root";
//		String password = "root";
		String password = "P@ssw0rd";
//		String password = "matn06";
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
