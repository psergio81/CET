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
	private String qry;
	
	
	public static void main(String[] args) {
		
		Atualiza atualiza = new Atualiza();
		
		atualiza.criarCampo(TipoCampo.VARCHAR, NOME_BANCO, "teste","campoVARCHAR",300, true);
		atualiza.criarCampo(TipoCampo.INTEIRO, NOME_BANCO, "teste","campoINTEIRO",300, true);
		atualiza.criarCampo(TipoCampo.INTEIRO, NOME_BANCO, "teste","campoINTEIRO2",300, true);
		
	}
	
	@SuppressWarnings("unused")
	private void criarTabela(String nomeBanco, String nomeTabela) {
	    try {  
	    	connection = getConnection();

		    qry = String.format("CREATE TABLE %s.%s (rowid VARCHAR(10) NULL);", nomeBanco,nomeTabela);
		    
		    Statement statement = connection.createStatement();
		    statement.execute(qry);
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	}

	
	private void criarCampo(TipoCampo tipoCampo, String nomeBanco, String nomeTabela, String nomeCampo, int tamanho, boolean campoCriado) {
		
		if(campoCriado){
			return;
		}
		
		
		printLog(tipoCampo, nomeBanco, nomeTabela, nomeCampo, tamanho);
		
		switch (tipoCampo) {
		case INTEIRO:
			
			criarCampoInteiro(nomeBanco, nomeTabela, nomeCampo);
			break;
			
		case VARCHAR:
			
			criarCampoCaracter(nomeBanco, nomeTabela, nomeCampo, tamanho);
			break;

		default:
			break;
		}
	}

	private void criarCampoInteiro(String nomeBanco, String nomeTabela, String nomeCampo) {
		try {  
			connection = getConnection();
			
			qry = String.format("ALTER TABLE %s.%s ADD COLUMN %s INT NULL ;", nomeBanco,nomeTabela,nomeCampo);
			
			Statement statement = connection.createStatement();
			statement.execute(qry);
			
		}catch (Exception e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps, rs);
		} 
	}

	private void criarCampoCaracter(String nomeBanco, String nomeTabela, String nomeCampo, int tamanho) {
		try {  
			connection = getConnection();
			
			qry = String.format("ALTER TABLE %s.%s ADD COLUMN %s VARCHAR(%s) NULL ;", nomeBanco,nomeTabela,nomeCampo,tamanho);
			
			Statement statement = connection.createStatement();
			statement.execute(qry);
			
		}catch (Exception e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps, rs);
		} 
	}
	
	private void printLog(TipoCampo tipoCampo, String nomeBanco, String nomeTabela, String nomeCampo, int tamanho) {
		
		System.out.println("======================================================================================");
		System.out.println("                             CRIANDO CAMPO                                            ");
		System.out.println("======================================================================================");
		System.out.println("NOME BANCO	:		"+nomeBanco);
		System.out.println("NOME TABELA	:		"+nomeTabela);
		System.out.println("NOME CAMPO	:		"+nomeCampo);
		System.out.println("TAMANHO		:		"+tamanho);
		System.out.println("TIPO		:		"+tipoCampo);
		System.out.println("--------------------------------------------------------------------------------------");
		
	}
	
	
}
