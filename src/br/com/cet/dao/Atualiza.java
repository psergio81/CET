package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Atualiza extends BaseDao {

	private static final String NOME_BANCO = "ensaio";
	private Connection connection;
	private ResultSet rs;
	private PreparedStatement ps;
	private StringBuilder qry;
	
	
	public static void main(String[] args) {
		
		Atualiza atualiza = new Atualiza();
		
		atualiza.criarCampoInteiro(NOME_BANCO, "teste","campoInteiro");
		
	}
	
	

	public void criarTabela(String nomeBanco, String nomeTabela) {
	    try {  
	    	connection = getConnection();

	    	qry = new StringBuilder();
		    qry.append("CREATE  TABLE "+nomeBanco+"."+nomeTabela+" (rowid VARCHAR(10) NULL );");
		    
		    Statement statement = connection.createStatement();
		    statement.execute(qry.toString());
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	}

	public void criarCampoInteiro(String nomeBanco, String nomeTabela, String nomeCampo) {
		try {  
			connection = getConnection();
			
			qry = new StringBuilder();
			qry.append("ALTER TABLE "+nomeBanco+"."+nomeTabela+" ADD COLUMN "+nomeCampo+" INT NULL ;");
			
			Statement statement = connection.createStatement();
			statement.execute(qry.toString());
			
		}catch (Exception e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps, rs);
		} 
	}
	
	
}
