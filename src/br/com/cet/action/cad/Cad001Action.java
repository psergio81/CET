package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.business.Empresa;
import br.com.cet.vo.EmpresaVo;

public class Cad001Action extends RecursoPadraoAction{
	
	private EmpresaVo empresaVo = new EmpresaVo();
	private Empresa empresa = new Empresa();
	private List<EmpresaVo> listaEmpresa = null;
	private String codigoEmpresaSelecionado;
	
	
	public void prepare(){
		
		System.out.println("passou pelo prepare.........");
		
	}
	
	public String browser() throws Exception{
		
		listaEmpresa = empresa.getListaEmpresa();
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
			
			empresaVo = empresa.getEmpresaPeloCodigo(codigoEmpresaSelecionado);
			
		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			empresa.insertEmpresa(empresaVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			empresa.updateEmpresa(empresaVo);
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

}
