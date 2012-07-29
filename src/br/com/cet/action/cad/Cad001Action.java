package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Empresa;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;

public class Cad001Action extends RecursoPadraoAction{
	
	private EmpresaVo empresaVo = new EmpresaVo();
	private Empresa empresa = new Empresa();
	private List<EmpresaVo> listaEmpresa = null;
	private String codigoEmpresaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private String nomePrograma;
	
	public void prepare(){
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_EMPRESAS);
		
	}
	
	public String browser() throws Exception{
		
		
		empresaVo.setNomeFantasia(campoBusca);
		empresaVo.setRazaoSocial(campoBusca);
		
		listaEmpresa = empresa.getListaEmpresa(empresaVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{

		UsuarioVo usuarioVo = (UsuarioVo) session.get("usuarioVo");
		boolean retorno;
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
			
			empresaVo = empresa.getEmpresaPeloCodigo(codigoEmpresaSelecionado);
			
		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			retorno = empresa.insertEmpresa(empresaVo);
			if(retorno){
				setMensagemErro("Empresa cadastrada com sucesso!");
			}else{
				setMensagemErro("Erro ao cadastrar a empresa!");
			}
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			empresa.updateEmpresa(empresaVo);
			
		}else if(AcoesKey.ACAO_EXCLUIR.equals(ac)){
			
			empresa.deleteEmpresa(empresaVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			return "principal";
		}
		
		return SUCCESS;
	}
	
	

	public EmpresaVo getEmpresaVo() {
		return empresaVo;
	}

	public void setEmpresaVo(EmpresaVo empresaVo) {
		this.empresaVo = empresaVo;
	}

	public List<EmpresaVo> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<EmpresaVo> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}
	
	public String getCodigoEmpresaSelecionado() {
		return codigoEmpresaSelecionado;
	}

	public void setCodigoEmpresaSelecionado(String codigoEmpresaSelecionado) {
		this.codigoEmpresaSelecionado = codigoEmpresaSelecionado;
	}

	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	public boolean isFiltrar() {
		return filtrar;
	}

	public void setFiltrar(boolean filtrar) {
		this.filtrar = filtrar;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String programa) {
		this.nomePrograma = programa;
	}

}
