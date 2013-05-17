package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cet.util.UtConverte;
import br.com.cet.vo.UsuarioVo;

public class ParametroUsuarioDao extends BaseDao {
	
	
	public UsuarioVo getParametroUsuario(UsuarioVo usuarioVo){
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(	"SELECT ic_mostra_atalhos, ic_mostra_grafico ");
		    qry.append(	"FROM parametro_usuario ");
			qry.append(" WHERE cd_empresa = ? " );
			qry.append(" AND cd_usuario = ? " );
			
			ps = connection.prepareStatement(qry.toString());
			ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoEmpresa()));
			ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoUsuario()));
		    
		    rs = ps.executeQuery();  
		    
		    if (rs.next()) {  
		    			    	
		    	usuarioVo.setMostraAtalhosTelaInicial(rs.getBoolean("ic_mostra_atalhos"));
		    	usuarioVo.setMostraGraficoTelaInicial(rs.getBoolean("ic_mostra_grafico"));
		    	
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return usuarioVo;
	}
}
