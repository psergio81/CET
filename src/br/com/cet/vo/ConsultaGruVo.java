import java.io.Serializable;


public class ConsultaGruVo implements Serializable{

	private String codigoGru;
	private String data;
	private String situacao;
	private String dataConsulta;
	private String horaConsulta;

	public ConsultaGruVo() {
	}
	
	
	public ConsultaGruVo(String codigoGru, String data, String situacao) {
		this.setCodigoGru(codigoGru);
		this.setData(data);
		this.setSituacao(situacao);
	}

	public String getCodigoGru() {
		return codigoGru;
	}

	public void setCodigoGru(String codigoGru) {
		this.codigoGru = codigoGru;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public String getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public String getHoraConsulta() {
		return horaConsulta;
	}


	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
}
