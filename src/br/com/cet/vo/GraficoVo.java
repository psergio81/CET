package br.com.cet.vo;

import java.util.ArrayList;
import java.util.List;

public class GraficoVo {

	private String mes;
	private List<String> valores = new ArrayList<>();

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public List<String> getValores() {
		return valores;
	}

	public void setValores(List<String> valores) {
		this.valores = valores;
	}
	
}
