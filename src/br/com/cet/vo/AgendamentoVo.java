package br.com.cet.vo;

import br.com.cet.action.key.TipoServico;
import br.com.cet.util.UtString;




public class AgendamentoVo extends EstruturaVo{
	
	private String codigoAgendamento;
	private String codigoProprietario;
	private String nomeProprietario;
	private String codigoVeiculo;
	private String codigoTipoServico;
	private String nomeTipoServico;
	private String dataAgendamento;
	private String horaAgendamento;
	private String gru;
	private String statusGru;
	
	
	public String getCodigoAgendamento() {
		return codigoAgendamento;
	}
	public void setCodigoAgendamento(String codigoAgendamento) {
		this.codigoAgendamento = codigoAgendamento;
	}
	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public String getHoraAgendamento() {
		return horaAgendamento;
	}
	public void setHoraAgendamento(String horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}
	public String getCodigoProprietario() {
		return codigoProprietario;
	}
	public void setCodigoProprietario(String codigoProprietario) {
		this.codigoProprietario = codigoProprietario;
	}
	public String getCodigoTipoServico() {
		return codigoTipoServico;
	}
	public void setCodigoTipoServico(String codigoTipoServico) {
		this.codigoTipoServico = codigoTipoServico;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getNomeTipoServico() {
		
		for (TipoServico tipo : TipoServico.values()) {
			if(UtString.equals(codigoTipoServico, String.valueOf(tipo.getCodigo()))){
				return tipo.getDescricao();
			}
		}
		return "";
	}
	
	public void setNomeTipoServico(String nomeTipoServico) {
		this.nomeTipoServico = nomeTipoServico;
	}
	public String getGru() {
		return gru;
	}
	public void setGru(String gru) {
		this.gru = gru;
	}
	public String getStatusGru() {
		return statusGru;
	}
	public void setStatusGru(String statusGru) {
		this.statusGru = statusGru;
	}
	
	
		
}
