package br.com.cet.vo;

import java.io.Serializable;

public class EstruturaVo implements Serializable {
	
	private String rowid;
	private String codigoUsuarioCriador;
	private String codigoUsuario;
	private String campoBusca;
	private String codigoEmpresa;

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getCodigoUsuarioCriador() {
		return codigoUsuarioCriador;
	}

	public void setCodigoUsuarioCriador(String codigoUsuarioCriador) {
		this.codigoUsuarioCriador = codigoUsuarioCriador;
	}

	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

}
