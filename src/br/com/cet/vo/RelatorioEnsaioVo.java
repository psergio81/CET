package br.com.cet.vo;

import java.util.List;

public class RelatorioEnsaioVo extends EstruturaVo{
	
	private String periodo;
	private String quantidadeEnsaios;
	private List<EnsaioVo> listaEnsaio;
	
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getQuantidadeEnsaios() {
		return quantidadeEnsaios;
	}
	public void setQuantidadeEnsaios(String quantidadeEnsaios) {
		this.quantidadeEnsaios = quantidadeEnsaios;
	}
	public List<EnsaioVo> getListaEnsaio() {
		return listaEnsaio;
	}
	public void setListaEnsaio(List<EnsaioVo> listaEnsaio) {
		this.listaEnsaio = listaEnsaio;
	}
		
}
