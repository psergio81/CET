package br.com.cet.vo;

public class EmpresaVo {
	
	private String codigoEmpresa;
	private String nomeEmpresa;
	
	public EmpresaVo(){}
	
	public EmpresaVo(String codigoEmpresa, String nomeEmpresa){
		this.codigoEmpresa = codigoEmpresa;
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

}
