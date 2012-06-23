package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.vo.EmpresaVo;

public class EmpresaDao extends BaseDao {
	
	public List<EmpresaVo> getListaEmpresas(){
		
		Connection connection = null;
		ResultSet rs;  
	    Statement stmt;  
	    StringBuilder sql = new StringBuilder(); 
	    List<EmpresaVo> empresasList = null;
	    EmpresaVo empresaVo = null;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    sql.append("SELECT cd_empresa, nm_empresa FROM empresa");
		    
		    stmt = connection.createStatement();  
		    rs = stmt.executeQuery(sql.toString());  
		  
		    empresasList = new ArrayList<EmpresaVo>();
		    
		    while (rs.next()) {  
		    	empresaVo = new EmpresaVo();
		    	empresaVo.setCodigoEmpresa(rs.getString("cd_empresa"));
		        empresaVo.setNomeEmpresa(rs.getString("nm_empresa"));
		    	empresasList.add(empresaVo);
		    }  
		    
		    rs.close();  
		    stmt.close(); 
		    
	    }catch (Exception e) {  
	    	
	        e.printStackTrace();
	        
	    }finally {
	    	
	    	try {  
	    		if (connection != null) connection.close();  
	    	}catch (Exception e) { 
	    		e.printStackTrace();
	    	} 
	    	
	    } 
	    return empresasList;
	}
	
	
	public void insertEmpresas(EmpresaVo empresaVo){
		
		System.out.println("EmpresaDao.insertEmpresas()");
		System.out.println("EmpresaVo nome "+empresaVo.getNomeEmpresa());
		System.out.println("EmpresaVo codi "+empresaVo.getCodigoEmpresa());
		
		Connection connection = null;
		PreparedStatement  ps;  
	    StringBuilder sql = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    sql.append(" INSERT INTO empresa ( ");
		    sql.append(" cd_empresa, ");
		    sql.append(" nm_empresa) ");
		    sql.append(" VALUES (?,?) ");
		    
		    ps = connection.prepareStatement(sql.toString());  
		    
		    ps.setInt(i++, Integer.parseInt(empresaVo.getCodigoEmpresa()));
		    ps.setString(i++, empresaVo.getNomeEmpresa());
		    
		    ps.executeUpdate();
		    
		    ps.close(); 
		    
	    }catch (Exception e) {  
	    	
	        e.printStackTrace();
	        
	    }finally {
	    	
	    	try {  
	    		if (connection != null) connection.close();  
	    	}catch (Exception e) { 
	    		e.printStackTrace();
	    	} 
	    	
	    } 
	}
	

}
