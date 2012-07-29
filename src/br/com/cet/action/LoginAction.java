package br.com.cet.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import br.com.cet.business.Usuario;
import br.com.cet.util.UtString;
import br.com.cet.vo.UsuarioVo;

public class LoginAction extends RecursoPadraoAction{
	
	private UsuarioVo usuarioVo = new UsuarioVo();

	public void prepare(){
		
		System.out.println("login action");
	}
	
	
	
	public String autenticacao() throws Exception{
		
		Usuario usuario = new Usuario();
		
		String nick = usuarioVo.getNick();
		String senha = usuarioVo.getSenha();
		
		System.out.println("nick "+nick);
		System.out.println("senha "+senha);
		
		if(!UtString.isNullOrEmpty(nick) && !UtString.isNullOrEmpty(senha)){
		
			usuarioVo = usuario.autenticacao(nick, senha);
			
			if(usuarioVo != null){
//				Map<String,Object> session = new HashMap<String,Object>();
//				session.put("usuarioVo", usuarioVo);
//				setSession(session);
				
				Map session = ActionContext.getContext().getSession();
				
				session.put("usuarioVo", usuarioVo);  
				
				return SUCCESS;
			}
		
		}
		
		return ERROR;
	}
	
	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}



	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}
	
	


}
