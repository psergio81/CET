package br.com.cet.vo;

public class PessoaVo extends EstruturaVo{
	
	private String codigoPessoa;
	private String descricao;

	public PessoaVo(){}
	
	public PessoaVo(String codigoPessoa){
		this.codigoPessoa = codigoPessoa;
	}
	
	public String getCodigoPessoa() {
		return codigoPessoa;
	}
	
	public void setCodigoPessoa(String codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
