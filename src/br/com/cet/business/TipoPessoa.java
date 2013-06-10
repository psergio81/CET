package br.com.cet.business;

public enum TipoPessoa {

	FISICA(1,"Física"),
	JURIDICA(2,"Jurídica");

	
	private int codigo;
	private String descricao;



	public String getTipoPessoa(int codigo) {
		return this.getDescricao();
	}
	
	private TipoPessoa(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
