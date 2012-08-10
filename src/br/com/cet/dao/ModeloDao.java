package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.ModeloVo;

public class ModeloDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(){
		
		return getProximoCodigo("modelo", "cd_modelo");
		
	}
	
	public ModeloVo getModeloPeloCodigo(ModeloVo modeloVo){
		return getModelo(modeloVo,1);
	}

	private ModeloVo getModelo(ModeloVo modeloVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_modelo, nm_modelo FROM modelo " );
		    qry.append(	"where cd_modelo = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(modeloVo.getCodigoModelo()));
		    
		    rs = ps.executeQuery();  
		    
		    modeloVo = null;
	    	
		    if (rs.next()) {  
		    	modeloVo = new ModeloVo();
		    	
		    	modeloVo.setRowid(rs.getString("rowid"));
		    	modeloVo.setCodigoModelo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_modelo"))));
		    	modeloVo.setDescricao(rs.getString("nm_modelo"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return modeloVo;
	}
	
	public List<ModeloVo> getListaModelos(ModeloVo modeloVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<ModeloVo> modelosList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_modelo, nm_modelo FROM modelo ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_modelo like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, modeloVo.getDescricao());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    modelosList = new ArrayList<ModeloVo>();
		    
		    while (rs.next()) {  
		    	modeloVo = new ModeloVo();
		    	modeloVo.setRowid(rs.getString("rowid"));
		    	modeloVo.setCodigoModelo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_modelo"))));
		    	modeloVo.setDescricao(rs.getString("nm_modelo"));
		    	modelosList.add(modeloVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return modelosList;
	}
	
	public void insertModelos(ModeloVo modeloVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO modelo ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_modelo, ");
		    qry.append(" nm_modelo ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(modeloVo.getCodigoModelo()));
		    ps.setString(i++, modeloVo.getDescricao());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateModelos(ModeloVo modeloVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE modelo set ");
			qry.append(" nm_modelo = ? ");
			qry.append(" WHERE cd_modelo = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, modeloVo.getDescricao());
			ps.setInt(i++, Integer.parseInt(modeloVo.getCodigoModelo()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteModelo(ModeloVo modeloVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM modelo WHERE cd_modelo = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(modeloVo.getCodigoModelo()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
