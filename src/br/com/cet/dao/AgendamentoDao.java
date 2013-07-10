package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtDataHora;
import br.com.cet.util.UtString;
import br.com.cet.vo.AgendamentoVo;
import br.com.cet.vo.ConsultaGruVo;

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
	  	  
		    qry.append(	"SELECT rowid, cd_agendamento, cd_pessoa, cd_servico, cd_veiculo, data, hora, gru FROM agendamento " );
		    qry.append(	" where cd_empresa = ? " );
		    qry.append(	" and cd_agendamento = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoAgendamento()));
		    
		    rs = ps.executeQuery();  
		    
		    agendamentoVo = null;
	    	
		    if (rs.next()) {  
		    	agendamentoVo = new AgendamentoVo();
		    	
		    	agendamentoVo.setRowid(rs.getString("rowid"));
		    	agendamentoVo.setCodigoAgendamento(rs.getString("cd_agendamento"));
		    	agendamentoVo.setCodigoProprietario(rs.getString("cd_pessoa"));
		    	agendamentoVo.setCodigoTipoServico(rs.getString("cd_servico"));
		    	agendamentoVo.setCodigoVeiculo(rs.getString("cd_veiculo"));
		    	agendamentoVo.setDataAgendamento(UtConverte.dateSqlTodataString(rs.getDate("data")));
		    	agendamentoVo.setHoraAgendamento(UtDataHora.segundosInteiroToStringHora(rs.getInt("hora")));
		    	agendamentoVo.setGru(rs.getString("gru"));
		    	
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
	  
		    qry.append(" SELECT a.rowid, a.cd_agendamento, a.cd_pessoa, a.cd_servico, a.data, a.hora, p.nm_pessoa, a.status_gru ");
		    qry.append(" FROM agendamento a, pessoa p ");
	    	qry.append(" WHERE a.cd_empresa = ? ");
	    	qry.append(" AND a.cd_empresa = p.cd_empresa ");
	    	
	    	if(filtrar){
	    		if(!UtString.isNullOrEmpty(agendamentoVo.getCampoBusca())){
	    			qry.append(" AND p.nm_pessoa like '%' ? '%' ");
	    		}
	    		
	    		if(!UtString.isNullOrEmpty(agendamentoVo.getDataAgendamento())){
	    			qry.append(" AND a.data = ? ");
	    		}
	    		
	    		if(!UtString.isNullOrEmpty(agendamentoVo.getStatusGru())){
	    			qry.append(" AND a.status_gru = ? ");
	    		}
	    	}
		
	    	qry.append(" AND  a.cd_pessoa = p.cd_pessoa ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    
		    if (filtrar) {
		    	if(!UtString.isNullOrEmpty(agendamentoVo.getCampoBusca())){
		    		ps.setString(i++, agendamentoVo.getCampoBusca());
		    	}
				if(!UtString.isNullOrEmpty(agendamentoVo.getDataAgendamento())){
					ps.setDate(i++, UtConverte.dataStringToDateSql(agendamentoVo.getDataAgendamento()));
				}
	    		if(!UtString.isNullOrEmpty(agendamentoVo.getStatusGru())){
	    			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getStatusGru()));
	    		}
			}
		    
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
		    	agendamentoVo.setStatusGru(rs.getString("status_gru"));
		    	
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
		    qry.append( " hora," );
		    qry.append( " gru )" );
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoAgendamento()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoProprietario()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoVeiculo()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoTipoServico()));
		    ps.setDate(i++, UtConverte.dataStringToDateSql( agendamentoVo.getDataAgendamento()));
		    ps.setInt(i++, UtDataHora.horaToInteiro(agendamentoVo.getHoraAgendamento()));
		    ps.setString(i++, agendamentoVo.getGru());
		    
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
			qry.append(" cd_pessoa = ?, ");
			qry.append(" cd_veiculo = ?, ");
			qry.append(" cd_servico = ?, ");
			qry.append(" data = ?, ");
			qry.append(" hora = ?, ");
			qry.append(" gru = ? ");
			qry.append(" WHERE cd_empresa = ? " );
			qry.append(" and cd_agendamento = ? ");
			
			
			ps = connection.prepareStatement(qry.toString());
			
			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoProprietario()));
			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoVeiculo()));
			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoTipoServico()));
			ps.setDate(i++, UtConverte.dataStringToDateSql(agendamentoVo.getDataAgendamento()));
			ps.setInt(i++, UtDataHora.horaToInteiro(agendamentoVo.getHoraAgendamento()));
			ps.setString(i++, agendamentoVo.getGru());
			
			
			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
			ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoAgendamento()));
			ps.executeUpdate();
			
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
	  
		    qry.append(" DELETE FROM agendamento " );
		    qry.append(" WHERE cd_empresa = ? " );
		    qry.append(" AND cd_agendamento = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoAgendamento()));
		    
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}

	public List<AgendamentoVo> getAgendamentosPorDia(AgendamentoVo agendamentoVo) {
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    List<AgendamentoVo> listaRetorno = new ArrayList<AgendamentoVo>();
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_agendamento, cd_veiculo, cd_servico, data, hora " );
		    qry.append(	"FROM agendamento " );
		    qry.append(	"WHERE cd_empresa = ? " );
		    qry.append(" AND data = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    ps.setDate(i++, UtConverte.dataStringToDateSql(agendamentoVo.getDataAgendamento()));
		    
		    rs = ps.executeQuery();  
		    
		    agendamentoVo = null;
	    	
		    while (rs.next()) {  
		    	agendamentoVo = new AgendamentoVo();
		    	
		    	agendamentoVo.setRowid(rs.getString("rowid"));
		    	agendamentoVo.setCodigoAgendamento(rs.getString("cd_agendamento"));
		    	agendamentoVo.setCodigoTipoServico(rs.getString("cd_servico"));
		    	agendamentoVo.setHoraAgendamento(UtDataHora.segundosInteiroToStringHora(rs.getInt("hora")));
		    	agendamentoVo.setDataAgendamento(UtConverte.dateSqlTodataString(rs.getDate("data")));
		    	
		    	listaRetorno.add(agendamentoVo);
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    }
		return listaRetorno;
	}

	public void updateStatusGru(ConsultaGruVo consultaGruVo) {
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE agendamento set ");
			qry.append(" data_consulta_gru = ?, ");
			qry.append(" hora_consulta_gru = ?, ");
			qry.append(" status_gru = ? ");
			qry.append(" WHERE gru = ? " );
			
			ps = connection.prepareStatement(qry.toString());
			
			ps.setDate(i++, UtConverte.dataStringToDateSql(consultaGruVo.getDataConsulta()));
			ps.setInt(i++, UtDataHora.horaToInteiro(consultaGruVo.getHoraConsulta()));
			ps.setInt(i++, consultaGruVo.getSituacaoInteiro());
			
			ps.setString(i++, consultaGruVo.getCodigoGru());
			ps.executeUpdate();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
		
	}

	public boolean isExisteGruCadastradoMesmoCodigo(AgendamentoVo agendamentoVo) {
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid " );
		    qry.append(	"FROM agendamento " );
		    qry.append(	"WHERE cd_empresa = ? " );
		    qry.append(" AND gru = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, UtConverte.stringToInteiro(agendamentoVo.getCodigoEmpresa()));
		    ps.setString(i++, agendamentoVo.getGru());
		    
		    rs = ps.executeQuery();  
		    
		    agendamentoVo = null;
	    	
		    if (rs.next()) {  
		    	return true;
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    }
		return false;
	}
	
}
