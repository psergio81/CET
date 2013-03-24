package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.UsuarioVo;

public class UsuarioDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;
	
	public int getProximoCodigo(String codigoEmpresa){
		
		return getProximoCodigo(codigoEmpresa, "usuario", "cd_usuario");
		
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
	
	public List<UsuarioVo> getListaUsuarios(UsuarioVo usuarioVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<UsuarioVo> listaUsuarios = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_usuario, cd_empresa, nm_usuario, nm_nick FROM usuario ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_usuario like '%' ? '%' ");
		    	qry.append(" OR nm_nick like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, usuarioVo.getCampoBusca());
		    	ps.setString(i++, usuarioVo.getCampoBusca());
		    	
		    }
		    
		    rs = ps.executeQuery();  
		  
		    listaUsuarios = new ArrayList<UsuarioVo>();
		    
		    while (rs.next()) {  
		    	usuarioVo = new UsuarioVo();
		    	
		    	
		    	usuarioVo.setRowid(rs.getString("rowid"));
		    	usuarioVo.setCodigoUsuario(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_usuario"))));
		    	usuarioVo.setCodigoEmpresa(String.valueOf(rs.getInt("cd_empresa")));
		    	usuarioVo.setNick(rs.getString("nm_nick"));
		    	usuarioVo.setNomeUsuario(rs.getString("nm_usuario"));
		    	
		    	
		    	listaUsuarios.add(usuarioVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return listaUsuarios;
	}
	
	public void insertUsuario(UsuarioVo usuarioVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO usuario ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_usuario, ");
		    qry.append(" cd_empresa, ");
		    qry.append(" nm_usuario, ");
		    qry.append(" nm_nick, ");
		    qry.append(" nm_senha) ");
		    
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoUsuario()));
		    ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoEmpresa()));
		    ps.setString(i++, usuarioVo.getNomeUsuario());
		    ps.setString(i++, usuarioVo.getNick());
		    ps.setString(i++, usuarioVo.getSenha());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateUsuario(UsuarioVo usuarioVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE usuario set ");
			qry.append(" cd_empresa = ?, ");
			qry.append(" nm_usuario = ?, ");
			qry.append(" nm_nick = ?, ");
			qry.append(" nm_senha = ? ");
			qry.append(" WHERE cd_usuario = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoEmpresa()));
			ps.setString(i++, usuarioVo.getNomeUsuario());
			ps.setString(i++, usuarioVo.getNick());
			ps.setString(i++, usuarioVo.getSenha());

			ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoUsuario()));
			
			ps.executeUpdate();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteUsuario(UsuarioVo usuarioVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM usuario WHERE cd_usuario = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
			ps.setInt(i++, UtConverte.stringToInteiro(usuarioVo.getCodigoUsuario()));

		    
			ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
