package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao extends ConnectionDao{


	public void validaQuantidadeParametros(StringBuilder qry, int i) throws Exception {
		
		int length = qry.toString().replaceAll("[^?]*", "").length();
		
		if(length != --i){
			throw new Exception("Numero parametros na query: "+length+" - "+"informado: "+i);
		}
	}
	
	public String getValues(StringBuilder qry) throws Exception {

		int abertura;
		int fechamento;
		
		String busca = qry.toString();
		
		abertura = busca.indexOf("(");
		fechamento = busca.indexOf(")");
		
		if(abertura == -1 || fechamento == -1){
			throw new Exception("Falta algum parentese na query");
		}
		
		busca = busca.substring(abertura, fechamento+1);
		
		abertura = busca.replaceAll("[^(]*", "").length();
		fechamento = busca.replaceAll("[^)]*", "").length();
		
		if(abertura != 1  || fechamento != 1){
			throw new Exception("Verifique os colcehetes de abertura e fechamento da query ( )");
		}
		
		busca = busca.replaceAll("[^,()]*"," ").replaceAll("  ", " ?");
		
		busca = "values".concat(busca);

		return busca;
	}

	
	public void releaseResouces(Connection connection, PreparedStatement ps, ResultSet rs) {
		this.releaseResoucesAll(connection, ps, rs);
	}

	public void releaseResouces(Connection connection, PreparedStatement ps) {
		this.releaseResoucesAll(connection, ps, null);
	}

	public void releaseResouces(Connection connection, ResultSet rs) {
		this.releaseResoucesAll(connection, null, rs);
	}
	
	
	private void releaseResoucesAll(Connection connection, PreparedStatement ps, ResultSet rs) {
		try {  
	
			if (connection != null){
				connection.close();
			}
			
			if(ps != null){
				ps.close();
			}

			if(rs != null){
				rs.close();
			}
			
		}catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	
	public int getProximoCodigo(String nomeTabela, String nomeCampo){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int retorno = 0;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("select max("+nomeCampo+") "+nomeCampo+" FROM "+nomeTabela);
		    
		    ps = connection.prepareStatement(qry.toString());  
		    rs = ps.executeQuery();  
		    
		    if (rs.next()) {
				retorno = rs.getInt("cd_empresa");
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    }
		
		return ++retorno;
	}
	
	public static String getNovaSimulacaoRowid(){
		String caracteres[] = {"A","Z","#","-","@","P","C","M","a","L"};
		String numeros[] = {"1","2","3","4","5","6","7","8","9","0"};
		
		String token = "";
		int nroSorteado1 = 0;
		int nroSorteado2 = 0;
		
		for(int i = 0; i < 9; i++){
			nroSorteado1 =  (int) (1 + (Math.random() * 9));
			nroSorteado2 =  (int) (1 + (Math.random() * 9));  
			
			if(i % 2 == 0){
				token += caracteres[nroSorteado1];
				token += numeros[nroSorteado2];
			}else{
				token += caracteres[nroSorteado2];
				token += numeros[nroSorteado1];
			}
		}
		
		
		return token;
	}
	
}
