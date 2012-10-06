package br.com.cet.vo;

public class VeiculoTacografoVo extends EstruturaVo{

	private String codigoVeiculoTacografo;
	private String codigoVeiculo;
	private String codigoTacografo;
	private String serie;
	private String dataInicio;
	private String dataFim;
	private String horaInicio;
	private String horaFim;	
	
	
	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public String getCodigoTacografo() {
		return codigoTacografo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	public void setCodigoTacografo(String codigoTacografo) {
		this.codigoTacografo = codigoTacografo;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCodigoVeiculoTacografo() {
		return codigoVeiculoTacografo;
	}
	public void setCodigoVeiculoTacografo(String codigoVeiculoTacografo) {
		this.codigoVeiculoTacografo = codigoVeiculoTacografo;
	}

}
