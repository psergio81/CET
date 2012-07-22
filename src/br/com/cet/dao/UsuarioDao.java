package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;

public class UsuarioDao extends BaseDao {
	
	
	public int getProximoCodigo(){
		
		return getProximoCodigo("usuario", "cd_usuario");
		
	}
	
	
	public UsuarioVo getUsuarioPeloCodigo(UsuarioVo usuarioVo){
		return getUsuario(usuarioVo, 1);
	}
	
	public UsuarioVo getUsuarioPeloRowid(UsuarioVo usuarioVo){
		return getUsuario(usuarioVo, 2);
	}
	
	public UsuarioVo getUsuarioPorNickSenha(UsuarioVo usuarioVo){
		return getUsuario(usuarioVo, 3);
	}
	
	private UsuarioVo getUsuario(UsuarioVo usuarioVo, int criterio){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(	"SELECT rowid, cd_empresa, nm_usuario, cd_usuario, nm_nick, nm_senha ");
		    qry.append(	"FROM usuario ");
		    
		    
		    switch (criterio) {
			case 1:
				qry.append(" WHERE cd_usuario = ? " );
				ps = connection.prepareStatement(qry.toString());
				ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoUsuario()));
				break;
			case 2:
				qry.append(" WHERE rowid = ? " );
				ps = connection.prepareStatement(qry.toString());
				ps.setString(i++, usuarioVo.getRowid());
				break;
			case 3:
				qry.append(" WHERE nm_nick = ? " );
				qry.append(" AND nm_senha 	= ? " );
				ps = connection.prepareStatement(qry.toString());
				ps.setString(i++, usuarioVo.getNick());
				ps.setString(i++, usuarioVo.getSenha());
				break;

			default:
				break;
			}
		    
		    rs = ps.executeQuery();  
		    
		    usuarioVo = null;
		    
		    if (rs.next()) {  
		    	usuarioVo = new UsuarioVo();
		    	
		    	usuarioVo.setRowid(rs.getString("rowid"));
		    	usuarioVo.setCodigoUsuario(String.valueOf(rs.getInt("cd_usuario")));
		    	usuarioVo.setCodigoEmpresa(String.valueOf(rs.getInt("cd_empresa")));
		    	usuarioVo.setSenha(rs.getString("nm_senha"));
		    	usuarioVo.setNick(rs.getString("nm_nick"));
		    	usuarioVo.setNomeUsuario(rs.getString("nm_usuario"));
		    	
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return usuarioVo;
	}
	
}
