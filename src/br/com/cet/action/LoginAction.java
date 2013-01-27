package br.com.cet.action;

import java.util.Map;

import br.com.cet.business.Empresa;
import br.com.cet.business.Usuario;
import br.com.cet.util.UtString;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends RecursoPadraoAction{
	
	private UsuarioVo usuarioVo = new UsuarioVo();
	private EmpresaVo empresaVo = new EmpresaVo();

	public void prepare() throws Exception{
		super.prepare();
	}
	
	
	public String autenticacao() throws Exception{
		
		Usuario usuario = new Usuario();
		Empresa empresa = new Empresa();
		
		String nick = usuarioVo.getNick();
		String senha = usuarioVo.getSenha();
		
		System.out.println("nick "+nick);
		System.out.println("senha "+senha);
		
		
		if(!UtString.isNullOrEmpty(nick) && !UtString.isNullOrEmpty(senha)){
		
			usuarioVo = usuario.autenticacao(nick, senha);
			empresaVo = empresa.getEmpresaPeloCodigo(usuarioVo.getCodigoEmpresa());
			
			if(usuarioVo != null){
				
				Map<String, Object> session = ActionContext.getContext().getSession();
				
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


	public EmpresaVo getEmpresaVo() {
		return empresaVo;
	}


	public void setEmpresaVo(EmpresaVo empresaVo) {
		this.empresaVo = empresaVo;
	}

}
