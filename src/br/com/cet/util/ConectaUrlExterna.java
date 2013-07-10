package br.com.cet.util;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ConectaUrlExterna {
	

	private String urlDestino;

	public ConectaUrlExterna(String urlDestino) {
		this.urlDestino = urlDestino;
	}

	
	public Document conectar() {

		Document post = null;
		try {
			post = Jsoup
					.connect(urlDestino)
					.method(Method.POST)
					.post();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return post;
	}

	public Document conectar(Map<String, String> parametros) {
		
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
