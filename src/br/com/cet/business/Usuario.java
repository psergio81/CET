package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.UsuarioDao;
import br.com.cet.vo.UsuarioVo;

public class Usuario {
	
	
	public UsuarioVo autenticacao(String nick, String senha) throws Exception{
		
		UsuarioVo usuarioVo = new UsuarioVo();
		UsuarioVo usuarioVoAux = null;
		
		try{
			
			usuarioVo.setNick(nick);
			usuarioVo.setSenha(senha);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioVoAux = usuarioDao.getUsuarioPorNickSenha(usuarioVo);
			
			
		}catch (Exception e) {
			throw new Exception("Usuario -> autenticacao -> "+e);
		}
		
		return usuarioVoAux;
		
	}
	
	
	
	public List<UsuarioVo> getListaUsuario(UsuarioVo usuarioVo, boolean filtrar)
			throws Exception {

		List<UsuarioVo> listaUsuario = null;

		try {

			UsuarioDao usuarioDao = new UsuarioDao();
			listaUsuario = usuarioDao.getListaUsuarios(usuarioVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaUsuario;

	}
	
	public UsuarioVo getUsuarioPeloCodigo(String codigoUsuario) throws Exception{
		
		UsuarioVo usuarioVo = new UsuarioVo();
		
		try{
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioVo.setCodigoUsuario(codigoUsuario);
			
			usuarioVo = usuarioDao.getUsuarioPeloCodigo(usuarioVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return usuarioVo;
		
	}
	
	public void insertUsuario(UsuarioVo usuarioVo) throws Exception{
		
		try{
			
			UsuarioDao usuarioDao = new UsuarioDao();
			String codigoUsuario;
			codigoUsuario = String.valueOf(usuarioDao.getProximoCodigo());

			usuarioVo.setCodigoUsuario(codigoUsuario);
			usuarioDao.insertUsuario(usuarioVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUsuario(UsuarioVo usuarioVo) throws Exception{
		
		try{
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.updateUsuario(usuarioVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUsuario(UsuarioVo usuarioVo){
		
		try {
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.deleteUsuario(usuarioVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
