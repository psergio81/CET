package br.com.cet.vo;

public class VeiculoVo extends EstruturaVo{
	
	private String codigoVeiculo;
	private String descricao;

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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
