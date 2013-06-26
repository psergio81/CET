import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.make.estrutura.util.UtGeral;

public class ConsultaGru {
	

	private String codigoGru;

	public ConsultaGru(String codigoGru) {
		this.codigoGru = codigoGru;
	}
	
	public ConsultaGruVo consulta() {
		
		ConsultaGruVo consultaGruVo;
		Document documento;
		Elements elementosHtml;
	
		Map<String, String> parametros;
		String[] campos;
		String regex;
		String elementos;
		String urlDestino;
		
		parametros = new HashMap<String, String>();
	
		urlDestino = "http://dipin.inmetro.rs.gov.br/scw/pagamentos/consultar";
		
		parametros.put("data[Gru][num_documento]", codigoGru);
		
		documento = new ConectaUrlExterna(urlDestino, parametros).conectar();
		
		elementosHtml = documento.getElementsByClass("altrow");
		elementos = elementosHtml.get(0).children().html();
		regex = "\n";
	
		campos = elementos.split(regex);
	
		consultaGruVo = new ConsultaGruVo();
		consultaGruVo.setCodigoGru(campos[0]);
		consultaGruVo.setData(campos[1]);
		consultaGruVo.setSituacao(campos[3]);
		consultaGruVo.setDataConsulta(UtGeral.getDataDoDia());
		consultaGruVo.setHoraConsulta(UtGeral.getHora());
		
		return consultaGruVo;
		
	}


}