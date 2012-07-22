package br.com.cet.business;

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
	

}
