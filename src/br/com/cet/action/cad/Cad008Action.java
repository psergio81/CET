package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Empresa;
import br.com.cet.business.Usuario;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;

public class Cad008Action extends RecursoPadraoAction {

	private UsuarioVo usuarioDadosVo = new UsuarioVo();
	private Usuario usuario = new Usuario();
	private List<UsuarioVo> listaUsuario= null;
	private String codigoUsuarioSelecionado;
	private boolean filtrar;
	private List<EmpresaVo> listaEmpresa = null;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_USUARIOS);
		
		usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		usuarioDadosVo.setCampoBusca(getCampoBusca());
		listaUsuario = usuario.getListaUsuario(usuarioDadosVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		boolean retorno;
		
		Empresa empresa = new Empresa();
		listaEmpresa = empresa.getListaEmpresa(null, false);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			usuarioDadosVo = usuario.getUsuarioPeloCodigo(codigoUsuarioSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			usuarioDadosVo.setCodigoUsuarioCriador(usuarioVo.getCodigoUsuario());
			retorno = usuario.insertUsuario(usuarioDadosVo);
			
			if(retorno){
				setMensagemErro("Usuário cadastrado com sucesso!");
			}else{
				setMensagemErro("Erro ao cadastrar o usuário!");
			}
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			usuario.updateUsuario(usuarioDadosVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			usuario.deleteUsuario(usuarioDadosVo);
			
		}
		
		return SUCCESS;
	}
	
	public UsuarioVo getUsuarioDadosVo() {
		return usuarioDadosVo;
	}

	public void setUsuarioDadosVo(UsuarioVo usuarioDadosVo) {
		this.usuarioDadosVo = usuarioDadosVo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioVo> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuarioVo> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String getCodigoUsuarioSelecionado() {
		return codigoUsuarioSelecionado;
	}

	public void setCodigoUsuarioSelecionado(String codigoUsuarioSelecionado) {
		this.codigoUsuarioSelecionado = codigoUsuarioSelecionado;
	}

	public boolean isFiltrar() {
		return filtrar;
	}

	public void setFiltrar(boolean filtrar) {
		this.filtrar = filtrar;
	}

	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}

	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}

	public List<EmpresaVo> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<EmpresaVo> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

}
