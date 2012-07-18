package br.com.cet.vo;

public class MarcaVo {
	
	private String rowid;
	private String codigoMarca;
	private String descricao;

	public MarcaVo(){}
	
	public MarcaVo(String codigoMarca){
		this.codigoMarca = codigoMarca;
	}
	
	public String getRowid() {
		return rowid;
	}
	
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	public String getCodigoMarca() {
		return codigoMarca;
	}
	
	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
