package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.VeiculoVo;

public class VeiculoDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(){
		
		return getProximoCodigo("veiculo", "cd_veiculo");
		
	}
	
	public VeiculoVo getVeiculoPeloCodigo(VeiculoVo veiculoVo){
		return getVeiculo(veiculoVo,1);
	}

	private VeiculoVo getVeiculo(VeiculoVo veiculoVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_veiculo, nm_veiculo FROM veiculo " );
		    qry.append(	"where cd_veiculo = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(veiculoVo.getCodigoVeiculo()));
		    
		    rs = ps.executeQuery();  
		    
		    veiculoVo = null;
	    	
		    if (rs.next()) {  
		    	veiculoVo = new VeiculoVo();
		    	
		    	veiculoVo.setRowid(rs.getString("rowid"));
		    	veiculoVo.setCodigoVeiculo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_veiculo"))));
		    	veiculoVo.setDescricao(rs.getString("nm_veiculo"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return veiculoVo;
	}
	
	public List<VeiculoVo> getListaVeiculos(VeiculoVo veiculoVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<VeiculoVo> veiculosList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_veiculo, nm_veiculo FROM veiculo ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_veiculo like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, veiculoVo.getDescricao());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    veiculosList = new ArrayList<VeiculoVo>();
		    
		    while (rs.next()) {  
		    	veiculoVo = new VeiculoVo();
		    	veiculoVo.setRowid(rs.getString("rowid"));
		    	veiculoVo.setCodigoVeiculo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_veiculo"))));
		    	veiculoVo.setDescricao(rs.getString("nm_veiculo"));
		    	veiculosList.add(veiculoVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return veiculosList;
	}
	
	public void insertVeiculos(VeiculoVo veiculoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO veiculo ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_veiculo, ");
		    qry.append(" nm_veiculo ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(veiculoVo.getCodigoVeiculo()));
		    ps.setString(i++, veiculoVo.getDescricao());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateVeiculos(VeiculoVo veiculoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE veiculo set ");
			qry.append(" nm_veiculo = ? ");
			qry.append(" WHERE cd_veiculo = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, veiculoVo.getDescricao());
			ps.setInt(i++, Integer.parseInt(veiculoVo.getCodigoVeiculo()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteVeiculo(VeiculoVo veiculoVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM veiculo WHERE cd_veiculo = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(veiculoVo.getCodigoVeiculo()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
