package br.com.cet.business;

public enum TipoPessoa {

	FISICA(1,"Fisica"),
	JURIDICA(2,"Juridica");

	
	private final int codigo;
	private final String descricao;

	public int getNumero() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}


	public String getTipoPessoa(int codigo) {
		return this.getDescricao();
	}
	
	private TipoPessoa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
}
