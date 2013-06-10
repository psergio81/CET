package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtDataHora;
import br.com.cet.vo.AgendamentoVo;

public class AgendamentoDao extends BaseDao {
	
	public int getProximoCodigo(String codigoEmpresa){
		
		return getProximoCodigo(codigoEmpresa, "agendamento", "cd_agendamento");
		
	}
	
	public AgendamentoVo getAgendamentoPeloCodigo(AgendamentoVo agendamentoVo){
		return getAgendamento(agendamentoVo,1);
	}

	private AgendamentoVo getAgendamento(AgendamentoVo agendamentoVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_agendamento, nm_agendamento, nm_agendamento_menu, nm_agendamento_action FROM agendamento " );
		    qry.append(	"where cd_agendamento = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoAgendamento()));
		    
		    rs = ps.executeQuery();  
		    
		    agendamentoVo = null;
	    	
		    if (rs.next()) {  
		    	agendamentoVo = new AgendamentoVo();
		    	
		    	agendamentoVo.setRowid(rs.getString("rowid"));
		    	agendamentoVo.setCodigoAgendamento(rs.getString("cd_agendamento"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return agendamentoVo;
	}
	
	public List<AgendamentoVo> getListaAgendamentos(AgendamentoVo agendamentoVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<AgendamentoVo> agendamentosList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" SELECT a.rowid, a.cd_agendamento, a.cd_pessoa, a.cd_servico, a.data, a.hora, p.nm_pessoa ");
		    qry.append(" FROM agendamento a, pessoa p");
	    	qry.append(" WHERE a.cd_empresa = ? ");
	    	qry.append(" AND  a.cd_pessoa = p.cd_pessoa ");
		
		    
		    ps = connection.prepareStatement(qry.toString());

		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    
		    rs = ps.executeQuery();  
		  
		    agendamentosList = new ArrayList<AgendamentoVo>();
		    
		    while (rs.next()) {  
		    	agendamentoVo = new AgendamentoVo();
		    	agendamentoVo.setRowid(rs.getString("rowid"));
		    	agendamentoVo.setCodigoAgendamento(String.valueOf(rs.getInt("cd_agendamento")));
		    	agendamentoVo.setCodigoProprietario(rs.getString("cd_pessoa"));
		    	agendamentoVo.setNomeProprietario(rs.getString("nm_pessoa"));
		    	agendamentoVo.setCodigoTipoServico(rs.getString("cd_servico"));
		    	agendamentoVo.setDataAgendamento(UtConverte.dateSqlTodataString(rs.getDate("data")));
		    	agendamentoVo.setHoraAgendamento(UtDataHora.segundosInteiroToStringHora(rs.getInt("hora")));
		    	
		    	agendamentosList.add(agendamentoVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return agendamentosList;
	}
	
	public void insertAgendamentos(AgendamentoVo agendamentoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO agendamento ");
		    qry.append( "( rowid, " );
		    qry.append( " cd_agendamento, " );
		    qry.append( " cd_empresa, " );
		    qry.append( " cd_pessoa, " );
		    qry.append( " cd_veiculo, " );
		    qry.append( " cd_servico, " );
		    qry.append( " data, " );
		    qry.append( " hora )" );
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoAgendamento()));
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoEmpresa()));
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoProprietario()));
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoVeiculo()));
		    ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoTipoServico()));
		    ps.setDate(i++, UtConverte.dataStringToDateSql( agendamentoVo.getDataAgendamento()));
		    ps.setInt(i++, UtDataHora.dataToInteiro(agendamentoVo.getHoraAgendamento()));
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateAgendamentos(AgendamentoVo agendamentoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE agendamento set ");
			qry.append(" nm_agendamento = ?, ");
			qry.append(" nm_agendamento_menu = ?, ");
			qry.append(" nm_agendamento_action = ? ");
			qry.append(" WHERE cd_agendamento = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setInt(i++, Integer.parseInt(agendamentoVo.getCodigoAgendamento()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteAgendamento(AgendamentoVo agendamentoVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM agendamento WHERE cd_agendamento = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoAgendamento()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
