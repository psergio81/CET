package br.com.cet.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionDao{
	
	public static Connection getConnection() throws Exception { 
		
	     Driver d = (Driver) Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();  
	     Connection c = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/java/banco/access2003/banco.mdb");  
	     return c;  
	     /* 
	     To use an already defined ODBC Datasource :     
	      
	        String URL = "jdbc:odbc:myDSN"; 
	        Connection c = DriverManager.getConnection(URL, "user", "pwd");  
	         
	     */       
	    }  

}
