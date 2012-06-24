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
}
