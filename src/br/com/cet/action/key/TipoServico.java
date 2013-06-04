package br.com.cet.action.key;

public enum TipoServico {
	
	ENSAIO(1, "Ensaio"), 
	LACRACAO(2, "Lacração"),
	SELAGEM(3, "Selagem");

	private int codigo;
	private String descricao;

	private TipoServico(int codigo, String descricao) {

		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

