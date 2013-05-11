package br.com.cet.vo.log;

import br.com.cet.vo.EstruturaVo;

public class LogVo extends EstruturaVo{

	private String acaoLog;
	private String descricaoLog;
	private String ipLog;
	private String codigoLog;
	private String dataLog;
	private String horaLog;
	private String codigoPrograma;
	
	public String getIpLog() {
		return ipLog;
	}
	public void setIpLog(String ipLog) {
		this.ipLog = ipLog;
	}
	public String getDescricaoLog() {
		return descricaoLog;
	}
	public void setDescricaoLog(String descricaoLog) {
		this.descricaoLog = descricaoLog;
	}
	public String getAcaoLog() {
		return acaoLog;
	}
	public void setAcaoLog(String acaoLog) {
		this.acaoLog = acaoLog;
	}
	public String getCodigoLog() {
		return codigoLog;
	}
	public void setCodigoLog(String codigoLog) {
		this.codigoLog = codigoLog;
	}
	public String getDataLog() {
		return dataLog;
	}
	public void setDataLog(String dataLog) {
		this.dataLog = dataLog;
	}
	public String getHoraLog() {
		return horaLog;
	}
	public void setHoraLog(String horaLog) {
		this.horaLog = horaLog;
	}
	public String getCodigoPrograma() {
		return codigoPrograma;
	}
	public void setCodigoPrograma(String codigoPrograma) {
		this.codigoPrograma = codigoPrograma;
	}
	
	
}
