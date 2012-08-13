package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.MarcaVo;

public class MarcaDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(){
		
		return getProximoCodigo("marca", "cd_marca");
		
	}
	
	public MarcaVo getMarcaPeloCodigo(MarcaVo marcaVo){
		return getMarca(marcaVo,1);
	}

	private MarcaVo getMarca(MarcaVo marcaVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_marca, nm_marca FROM marca " );
		    qry.append(	"where cd_marca = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(marcaVo.getCodigoMarca()));
		    
		    rs = ps.executeQuery();  
		    
		    marcaVo = null;
	    	
		    if (rs.next()) {  
		    	marcaVo = new MarcaVo();
		    	
		    	marcaVo.setRowid(rs.getString("rowid"));
		    	marcaVo.setCodigoMarca(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_marca"))));
		    	marcaVo.setDescricao(rs.getString("nm_marca"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return marcaVo;
	}
	
	public List<MarcaVo> getListaMarcas(MarcaVo marcaVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<MarcaVo> marcasList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_marca, nm_marca FROM marca ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_marca like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, marcaVo.getDescricao());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    marcasList = new ArrayList<MarcaVo>();
		    
		    while (rs.next()) {  
		    	marcaVo = new MarcaVo();
		    	marcaVo.setRowid(rs.getString("rowid"));
		    	marcaVo.setCodigoMarca(String.valueOf(rs.getInt("cd_marca")));
		    	marcaVo.setDescricao(rs.getString("nm_marca"));
		    	marcasList.add(marcaVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return marcasList;
	}
	
	public void insertMarcas(MarcaVo marcaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO marca ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_marca, ");
		    qry.append(" nm_marca ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(marcaVo.getCodigoMarca()));
		    ps.setString(i++, marcaVo.getDescricao());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateMarcas(MarcaVo marcaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE marca set ");
			qry.append(" nm_marca = ? ");
			qry.append(" WHERE cd_marca = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, marcaVo.getDescricao());
			ps.setInt(i++, Integer.parseInt(marcaVo.getCodigoMarca()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteMarca(MarcaVo marcaVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM marca WHERE cd_marca = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(marcaVo.getCodigoMarca()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
