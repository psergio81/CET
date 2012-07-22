package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseAtualiza extends BaseDao {

	private static final String LINHA = "--------------------------------------------------------------------------------------";
	private static final String LINHA_DUPLA = "======================================================================================";
	private static final String TAMANHO_DO_CAMPO = "Tamanho do Campo";
	private static final String TIPO_DO_CAMPO = "Tipo do Campo";
	private static final String NOME_DO_CAMPO = "Nome do Campo";
	private static final String NOME_DA_TABELA = "Nome da Tabela";
	private static final String NOME_DO_BANCO = "Nome do Banco";
	private static final String CRIANDO_SCHEMA = "Criando Schema";
	private static final String CRIANDO_TABELA = "Criando Tabela";
	private static final String CRIANDO_CAMPO = "Criando Campo";
	private Connection connection;
	private ResultSet rs;
	private PreparedStatement ps;
	private String qry;
	
	public void executarComandoSql(String comando){
		
	  try {  
	    	connection = getConnection();

		    qry = String.format(comando);
		    
		    Statement statement = connection.createStatement();
		    statement.execute(qry);
		    
		    System.out.println("comando: "+qry.toString());
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	}
	
	
	public void criarTabela(String nomeBanco, String nomeTabela) {
		printLog(CRIANDO_TABELA, nomeBanco, nomeTabela);
	    try {  
	    	connection = getConnection();

		    qry = String.format("CREATE TABLE %s.%s (rowid VARCHAR(20) NULL);", nomeBanco,nomeTabela);
		    
		    Statement statement = connection.createStatement();
		    statement.execute(qry);
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	}

	public void criarSchema(String nomeBanco) {
		printLog(CRIANDO_SCHEMA,nomeBanco);
		try {  
			connection = getConnection();
			
			qry = String.format("CREATE SCHEMA %s ;", nomeBanco);
			
			Statement statement = connection.createStatement();
			statement.execute(qry);
			
		}catch (Exception e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps, rs);
		} 
	}

	public void criarCampo(TipoCampo tipoCampo, String nomeBanco, String nomeTabela, String nomeCampo, int tamanho, boolean campoCriado) {
		
		if(campoCriado){
			return;
		}
		
		printLog(CRIANDO_CAMPO,tipoCampo, nomeBanco, nomeTabela, nomeCampo, tamanho);
		
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

	private void printLog(String mensagem, String nomeBanco, String nomeTabela) {
		this.printLog(mensagem, null, nomeBanco, nomeTabela, null, 0);
	}
	
	private void printLog(String mensagem, String nomeBanco) {
		this.printLog(mensagem, null, nomeBanco, null, null, 0);
	}
	
	private void printLog(String mensagem, TipoCampo tipoCampo, String nomeBanco, String nomeTabela, String nomeCampo, int tamanho) {
		
		System.out.println(LINHA_DUPLA);
		System.out.println("                             "+mensagem+"                                             ");
		System.out.println(LINHA_DUPLA);
		imprimeCampo(NOME_DO_BANCO, nomeBanco);
		imprimeCampo(NOME_DA_TABELA, nomeTabela);	
		imprimeCampo(NOME_DO_CAMPO, nomeCampo);
		imprimeCampo(TIPO_DO_CAMPO, tipoCampo);
		imprimeCampo(TAMANHO_DO_CAMPO, tamanho);
		System.out.println(LINHA);
		
	}

	private void imprimeCampo(String mensagem, TipoCampo parametro) {
		if(parametro != null){
			System.out.println(mensagem + "	:		"+parametro);
		}
	}

	private void imprimeCampo(String mensagem, String parametro) {
		if(parametro != null && parametro != ""){
			System.out.println(mensagem + "	:		"+parametro);
		}
	}

	private void imprimeCampo(String mensagem, int parametro) {
		if(parametro != 0){
			System.out.println(mensagem + "	:		"+parametro);
		}
	}
	
	
}
