package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.vo.log.LogVo;

/**
 * Dao de Log
 * @author Michell Sarno
 *
 */
public class LogDao extends BaseDao {
	
	private static final int POR_TODOS 				= 1;
	private static final int POR_EMPRESA 			= 2;
	private static final int POR_PROGRAMA 			= 3;
	private static final int POR_USUARIO 			= 4;
	private static final int POR_EMPRESA_USUARIO 	= 5;
	private static final int POR_EMPRESA_PROGRAMA 	= 6;

	public int getProximoCodigo(){
		
		return getProximoCodigo("0", "log", "cd_log");
		
	}
	
	
	public List<LogVo> getListLog(String codigoEmpresa, String codigoPrograma, String codigoUsuario, String busca){
		return getListaLog(codigoEmpresa, codigoPrograma, codigoUsuario, busca, POR_TODOS	);
	}
	
	private List<LogVo> getListaLog(String codigoEmpresa, String codigoPrograma, String codigoUsuario, String busca, int criterio){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    List<LogVo> listaLog = null;
	    LogVo logVo = null;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(	"SELECT cd_empresa, cd_programa, cd_usuario, cd_log, dt_log, hora_log, acao_log, ds_log, ip_log ");
		    qry.append(	"FROM log " );
		    
		    switch (criterio) {
		    
				case POR_TODOS:
					
					qry.append(	"where cd_empresa = ? " );
				    qry.append(	"and cd_programa = ? " );
				    qry.append(	"and cd_usuario = ? " );
				    qry.append(	"and ds_log like '%' ? '%' " );
				    
				    ps = connection.prepareStatement(qry.toString());  
				    
				    ps.setInt(i++, UtConverte.stringToInteiro(codigoEmpresa));
				    ps.setInt(i++, UtConverte.stringToInteiro(codigoPrograma));
				    ps.setInt(i++, UtConverte.stringToInteiro(codigoUsuario));
				    ps.setString(i++, busca);
				    
					break;

			default:
				break;
			}
		    
		    
		    rs = ps.executeQuery();  
		    
		    listaLog = new ArrayList<LogVo>();
		    
		    while (rs.next()) {  
		    	
		    	logVo = new LogVo();
		    	
		    	logVo.setCodigoEmpresa(rs.getString("cd_empresa"));
		    	logVo.setCodigoPrograma(rs.getString("cd_programa"));
		    	logVo.setCodigoUsuarioCriador(rs.getString("cd_usuario"));
		    	logVo.setCodigoLog(rs.getString("cd_log"));
		    	logVo.setDataLog(rs.getString("dt_log"));
		    	logVo.setHoraLog(rs.getString("hr_log"));
		    	logVo.setAcaoLog(rs.getString("acao_log"));
		    	logVo.setDescricaoLog(rs.getString("ds_log"));
		    	logVo.setIpLog(rs.getString("ip_log"));
		    	
		    	listaLog.add(logVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return listaLog;
	}
	
	
	public void insertLog(LogVo logVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO log ");
		    qry.append(" (cd_empresa, ");
		    qry.append(" cd_programa, ");
		    qry.append(" cd_usuario, ");
		    qry.append(" cd_log, ");
		    qry.append(" acao_log, ");
		    qry.append(" ds_log, ");
		    qry.append(" dt_log, ");
		    qry.append(" hr_log, ");
		    qry.append(" ip_log) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setInt(i++, UtConverte.stringToInteiro(logVo.getCodigoEmpresa()));
		    ps.setInt(i++, UtConverte.stringToInteiro(logVo.getCodigoPrograma()));
		    ps.setInt(i++, UtConverte.stringToInteiro(logVo.getCodigoUsuarioCriador()));
		    ps.setInt(i++, UtConverte.stringToInteiro(logVo.getCodigoLog()));
		    ps.setString(i++, logVo.getAcaoLog());
		    ps.setString(i++, logVo.getDescricaoLog());
		    ps.setDate(i++, UtConverte.dataStringToDateSql(logVo.getDataLog()));
		    ps.setInt(i++, UtConverte.stringToInteiro(logVo.getHoraLog()));
		    ps.setString(i++, logVo.getIpLog());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
}
