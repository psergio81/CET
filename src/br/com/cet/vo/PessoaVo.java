package br.com.cet.vo;

public class PessoaVo extends EstruturaVo{
	
	private String codigoPessoa;
	private String nome;
	private String tipoPessoa;
	private String codigoDocumento;
	
	
	public String getCodigoPessoa() {
		return codigoPessoa;
	}
	
	public void setCodigoPessoa(String codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
		
}
