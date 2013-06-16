package br.com.cet.vo;
import br.com.cet.business.TipoPessoa;
import br.com.cet.util.UtString;

public class PessoaVo extends EstruturaVo{
	
	private String codigoPessoa;
	private String nome;
	private String tipoPessoa;
	private String descricaoTipoPessoa;
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

	public String getDescricaoTipoPessoa() {
		System.out.println("no GET");
		
		for (TipoPessoa tipo : TipoPessoa.values()) {
			
			if (UtString.equals(this.tipoPessoa, String.valueOf(tipo.getCodigo()))) {
				descricaoTipoPessoa = tipo.getDescricao();
			}
			
		}
		
		return descricaoTipoPessoa;
	}

	public void setDescricaoTipoPessoa(String descricaoTipoPessoa) {
		System.out.println("no SET");
		this.descricaoTipoPessoa = "note";
	}
		
}
