package br.com.cet.vo;

public class VeiculoVo extends EstruturaVo{
	
	private String codigoVeiculo;
	private String codigoProprietario;
	private String placa;

	public VeiculoVo(){}
	
	public VeiculoVo(String codigoVeiculo){
		this.codigoVeiculo = codigoVeiculo;
	}
	
	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}
	
	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCodigoProprietario() {
		return codigoProprietario;
	}

	public void setCodigoProprietario(String codigoProprietario) {
		this.codigoProprietario = codigoProprietario;
	}
	
		
}
