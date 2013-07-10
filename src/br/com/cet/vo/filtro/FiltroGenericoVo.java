package br.com.cet.vo.filtro;

import br.com.cet.vo.EstruturaVo;

public class FiltroGenericoVo extends EstruturaVo{
	
	private String buscaTextoPadrao;
	private String dataInicial;
	private String dataFinal;
	
	public String getBuscaTextoPadrao() {
		return buscaTextoPadrao;
	}
	public void setBuscaTextoPadrao(String buscaTextoPadrao) {
		this.buscaTextoPadrao = buscaTextoPadrao;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

}
