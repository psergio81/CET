package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.business.Empresa;
import br.com.cet.vo.EmpresaVo;

public class Rel001Action extends RecursoPadraoAction{
	
	private Empresa empresa = new Empresa();
	private List<EmpresaVo> listaEmpresa = null;
	private String codigoEmpresaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		//setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_AGENDAMENTOS, ProgramasKey.CADASTRO_DE_AGENDAMENTOS);		
	}
	
	public String crud() throws Exception{

//		boolean retorno;
//		
//		
//		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
//			
//			empresaVo = empresa.getEmpresaPeloCodigo(codigoEmpresaSelecionado);
//			
//		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
//			
//			retorno = empresa.insertEmpresa(empresaVo);
//			if(retorno){
//				setMensagemErro("Empresa cadastrada com sucesso!");
//			}else{
//				setMensagemErro("Erro ao cadastrar a empresa!");
//			}
//			
//		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
//			
//			empresa.updateEmpresa(empresaVo);
//			
//		}else if(AcoesKey.ACAO_EXCLUIR.equals(ac)){
//			
//			empresa.deleteEmpresa(empresaVo);
//			
//		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
//			return "principal";
//		}
//		
		return SUCCESS;
	}
	
	public String principal(){
		return "principal";
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

}
