import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ConectaUrlExterna {
	

	private String urlDestino;
	private Map<String, String> parametros;

	public ConectaUrlExterna(String urlDestino) {
		this.urlDestino = urlDestino;
	}

	public ConectaUrlExterna(String urlDestino, Map<String, String> parametros) {
		
		this.urlDestino = urlDestino;
		this.parametros = parametros;
	}
	
	public Document conectar() {
		
		Document post = null;
		try {
			post = Jsoup
					.connect(urlDestino)
					.data(parametros)
					.post();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return post;
	}
	
}
