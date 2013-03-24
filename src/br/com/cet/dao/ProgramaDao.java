package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.vo.ProgramaVo;

public class ProgramaDao extends BaseDao {
	
	public int getProximoCodigo(String codigoEmpresa){
		
		return getProximoCodigo(codigoEmpresa, "programa", "cd_programa");
		
	}
	
	public ProgramaVo getProgramaPeloCodigo(ProgramaVo programaVo){
		return getPrograma(programaVo,1);
	}

	private ProgramaVo getPrograma(ProgramaVo programaVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_programa, nm_programa, nm_programa_menu, nm_programa_action FROM programa " );
		    qry.append(	"where cd_programa = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(programaVo.getCodigoPrograma()));
		    
		    rs = ps.executeQuery();  
		    
		    programaVo = null;
	    	
		    if (rs.next()) {  
		    	programaVo = new ProgramaVo();
		    	
		    	programaVo.setRowid(rs.getString("rowid"));
		    	programaVo.setCodigoPrograma(rs.getString("cd_programa"));
		    	programaVo.setDescricao(rs.getString("nm_programa"));
		    	programaVo.setDescricaoMenu(rs.getString("nm_programa_menu"));
		    	programaVo.setDescricaoAction(rs.getString("nm_programa_action"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return programaVo;
	}
	
	public List<ProgramaVo> getListaProgramas(ProgramaVo programaVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<ProgramaVo> programasList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_programa, nm_programa, nm_programa_menu, nm_programa_action FROM programa ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_programa like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, programaVo.getDescricao());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    programasList = new ArrayList<ProgramaVo>();
		    
		    while (rs.next()) {  
		    	programaVo = new ProgramaVo();
		    	programaVo.setRowid(rs.getString("rowid"));
		    	programaVo.setCodigoPrograma(String.valueOf(rs.getInt("cd_programa")));
		    	programaVo.setDescricao(rs.getString("nm_programa"));
		    	programaVo.setDescricaoMenu(rs.getString("nm_programa_menu"));
		    	programaVo.setDescricaoAction(rs.getString("nm_programa_action"));
		    	programasList.add(programaVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return programasList;
	}
	
	public void insertProgramas(ProgramaVo programaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO programa ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_programa, ");
		    qry.append(" nm_programa, ");
		    qry.append(" nm_programa_menu, ");
		    qry.append(" nm_programa_action ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(programaVo.getCodigoPrograma()));
		    ps.setString(i++, programaVo.getDescricao());
		    ps.setString(i++, programaVo.getDescricaoMenu());
		    ps.setString(i++, programaVo.getDescricaoAction());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateProgramas(ProgramaVo programaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE programa set ");
			qry.append(" nm_programa = ?, ");
			qry.append(" nm_programa_menu = ?, ");
			qry.append(" nm_programa_action = ? ");
			qry.append(" WHERE cd_programa = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, programaVo.getDescricao());
			ps.setString(i++, programaVo.getDescricaoMenu());
			ps.setString(i++, programaVo.getDescricaoAction());
			ps.setInt(i++, Integer.parseInt(programaVo.getCodigoPrograma()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deletePrograma(ProgramaVo programaVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM programa WHERE cd_programa = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(programaVo.getCodigoPrograma()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
