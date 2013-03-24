package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtDataHora;
import br.com.cet.vo.VeiculoTacografoVo;

public class VeiculoTacografoDao extends BaseDao {
	
	
	public int getProximoCodigo(String codigoEmpresa){
		
		return getProximoCodigo(codigoEmpresa, "veiculo_tacografo", "cd_veiculo_tacografo");
		
	}

	public void insertVeiculoTacografo(VeiculoTacografoVo veiculoTacografoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO veiculo_tacografo ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_veiculo_tacografo, ");
		    qry.append(" cd_veiculo, ");
		    qry.append(" cd_tacografo, ");
		    qry.append(" dt_inicio,  ");
		    qry.append(" hr_inicio	) ");
		    
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, UtConverte.stringToInteiro(veiculoTacografoVo.getCodigoVeiculoTacografo()));
		    ps.setInt(i++, UtConverte.stringToInteiro(veiculoTacografoVo.getCodigoVeiculo()));
		    ps.setInt(i++, UtConverte.stringToInteiro(veiculoTacografoVo.getCodigoTacografo()));
		    ps.setString(i++, UtDataHora.getDataAtual());
		    ps.setString(i++, UtDataHora.getHoraAtual());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	
	public List<VeiculoTacografoVo> getTacografosDeUmVeiculo(VeiculoTacografoVo veiculoTacografoVo)throws Exception {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    List<VeiculoTacografoVo> listaRetorno = new ArrayList<VeiculoTacografoVo>();
	    
	    try {
	    	
	    	connection = getConnection();  
	    	
	    	
		    qry.append(	" SELECT vt.rowid, vt.cd_tacografo vtcodigotacografo, vt.dt_inicio vtdtinicio, vt.hr_inicio vthrinicio, ");
		    qry.append(	" vt.dt_fim vtdtfim, vt.hr_fim vthrfim, t.serie tserie ");
		    qry.append(	" from veiculo_tacografo vt, tacografo t ");
		    qry.append(	" where vt.cd_veiculo = ? and ");
		    qry.append(	" vt.cd_tacografo = t.cd_tacografo ");
		    qry.append(	" order by vt.cd_veiculo_tacografo desc ");
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, UtConverte.stringToInteiro(veiculoTacografoVo.getCodigoVeiculo()));
		    
		    rs = ps.executeQuery();  
		    
	    	
		    while (rs.next()) {  
		    	veiculoTacografoVo = new VeiculoTacografoVo();
		    	
		    	veiculoTacografoVo.setCodigoTacografo(rs.getString("vtcodigotacografo"));
		    	veiculoTacografoVo.setSerie(rs.getString("tserie"));
		    	veiculoTacografoVo.setDataInicio(rs.getString("vtdtinicio"));
		    	veiculoTacografoVo.setHoraInicio(rs.getString("vthrinicio"));
		    	veiculoTacografoVo.setDataFim(rs.getString("vtdtfim"));
		    	veiculoTacografoVo.setHoraFim(rs.getString("vthrfim"));
		    	
		    	listaRetorno.add(veiculoTacografoVo);
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return listaRetorno;
	}
	
	public void inativaTacografoAtualDoVeiculo(VeiculoTacografoVo veiculoTacografoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE veiculo_tacografo set ");
			qry.append(" dt_fim = ?, ");
			qry.append(" hr_fim = ? ");
			qry.append(" WHERE cd_veiculo = ? ");
			qry.append(" and hr_fim is null ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, UtDataHora.getDataAtual());
			ps.setString(i++, UtDataHora.getHoraAtual());
			ps.setInt(i++, UtConverte.stringToInteiro(veiculoTacografoVo.getCodigoVeiculo()));

			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
}
