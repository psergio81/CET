package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.EnsaioVo;

public class EnsaioDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(){
		
		return getProximoCodigo("ensaio", "cd_ensaio");
		
	}
	
	public EnsaioVo getEnsaioPeloCodigo(EnsaioVo ensaioVo){
		return getEnsaio(ensaioVo,1);
	}

	private EnsaioVo getEnsaio(EnsaioVo ensaioVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_ensaio, nm_ensaio FROM ensaio " );
		    qry.append(	"where cd_ensaio = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(ensaioVo.getCodigoEnsaio()));
		    
		    rs = ps.executeQuery();  
		    
		    ensaioVo = null;
	    	
		    if (rs.next()) {  
		    	ensaioVo = new EnsaioVo();
		    	
		    	ensaioVo.setRowid(rs.getString("rowid"));
		    	ensaioVo.setCodigoEnsaio(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_ensaio"))));
		    	ensaioVo.setDescricao(rs.getString("nm_ensaio"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return ensaioVo;
	}
	
	public List<EnsaioVo> getListaEnsaios(EnsaioVo ensaioVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<EnsaioVo> ensaiosList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_ensaio, nm_ensaio FROM ensaio ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_ensaio like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, ensaioVo.getDescricao());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    ensaiosList = new ArrayList<EnsaioVo>();
		    
		    while (rs.next()) {  
		    	ensaioVo = new EnsaioVo();
		    	ensaioVo.setRowid(rs.getString("rowid"));
		    	ensaioVo.setCodigoEnsaio(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_ensaio"))));
		    	ensaioVo.setDescricao(rs.getString("nm_ensaio"));
		    	ensaiosList.add(ensaioVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return ensaiosList;
	}
	
	public void insertEnsaios(EnsaioVo ensaioVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO ensaio ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_ensaio, ");
		    qry.append(" nm_ensaio ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(ensaioVo.getCodigoEnsaio()));
		    ps.setString(i++, ensaioVo.getDescricao());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateEnsaios(EnsaioVo ensaioVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE ensaio set ");
			qry.append(" nm_ensaio = ? ");
			qry.append(" WHERE cd_ensaio = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, ensaioVo.getDescricao());
			ps.setInt(i++, Integer.parseInt(ensaioVo.getCodigoEnsaio()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteEnsaio(EnsaioVo ensaioVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM ensaio WHERE cd_ensaio = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(ensaioVo.getCodigoEnsaio()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
