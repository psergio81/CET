package br.com.cet.vo;

public class ComboVo {

	private String chave;
	private String valor;
	
	public ComboVo(String chave, String valor) {

		this.chave = chave;
		this.valor = valor;
	}
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}
