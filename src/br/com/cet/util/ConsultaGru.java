package br.com.cet.util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

import br.com.cet.vo.ConsultaGruVo;



public class ConsultaGru {
	

	private String codigoGru;

	public ConsultaGru(String codigoGru) {
		this.codigoGru = codigoGru;
	}
	
	public ConsultaGruVo consulta() {
		
		ConsultaGruVo consultaGruVo;
		Document documento;
		Elements elementosHtml;
	
		String mensagemErro;
		Map<String, String> parametros;
		String[] campos;
		String regex;
		String elementos;
		String urlDestino;
		
		parametros = new HashMap<String, String>();
	
		urlDestino = "http://dipin.inmetro.rs.gov.br/scw/pagamentos/consultar";
		parametros.put("data[Gru][num_documento]", codigoGru);
		
		documento = new ConectaUrlExterna(urlDestino).conectar(parametros);
		documento.outputSettings().escapeMode(EscapeMode.xhtml);	
		
		mensagemErro = documento.getElementsByClass("error-message").html();
		consultaGruVo = new ConsultaGruVo();
		
		if(UtString.isNullOrEmpty(mensagemErro)){
			
			elementosHtml = documento.getElementsByClass("altrow");
			elementos = elementosHtml.get(0).children().html();
			regex = "\n";
			
			campos = elementos.split(regex);
			
			consultaGruVo.setCodigoGru(campos[0]);
			consultaGruVo.setData(campos[1]);
			consultaGruVo.setSituacao(campos[3]);
			consultaGruVo.setDataConsulta(UtDataHora.getDataAtual());
			consultaGruVo.setHoraConsulta(UtDataHora.getHoraAtual());
			
		}else{
			
			consultaGruVo.setMensagemErro(mensagemErro);
		}
		
		
		return consultaGruVo;
		
	}


}