package br.com.cet.business;

import br.com.cet.dao.ParametroUsuarioDao;
import br.com.cet.vo.UsuarioVo;

public class ParametroUsuario {
	
	
	public UsuarioVo getParametroUsuario(UsuarioVo usuarioVo) throws Exception{
		
		try{
			
			ParametroUsuarioDao parametroUsuarioDao = new ParametroUsuarioDao();
			parametroUsuarioDao.getParametroUsuario(usuarioVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return usuarioVo;
	}
}
