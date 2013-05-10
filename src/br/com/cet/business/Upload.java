package br.com.cet.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import br.com.cet.vo.EnsaioVo;
import br.com.cet.vo.RelatorioEnsaioVo;


public class Upload {
	
	private String data;
	private String gru;
	private String codigoEnsaio;
	private String nomeProprietario;
	private String renavam;
	private String placa;
	private String modelo;
	private String marca;
	private String serie;
	
	
	public RelatorioEnsaioVo getEnsaiosDoArquivo(String caminhoArquivo) throws Exception{
		
		String texto = getTexto(caminhoArquivo);
		
		int total = getTotal(texto);
		String periodo = getPeriodo(texto);
		
		String regex = "(\\r|\\n){2}";
		
		String[] split = texto.split(regex);
		List<String> retorno = new ArrayList<>();

		int j = 1;
		
		for (int i = 0; j <= total; i++) {
			
			if(split[i].startsWith(String.valueOf(j))){
				String string = split[i]+"#"+split[i+1];
				string = string.replaceAll("  ", " ");
				retorno.add(string);
				j++;
			}
		}
		
		RelatorioEnsaioVo relatorioEnsaioVo = new RelatorioEnsaioVo();
		relatorioEnsaioVo.setPeriodo(periodo);
		relatorioEnsaioVo.setQuantidadeEnsaios(String.valueOf(total));
		
		List<EnsaioVo> listaEnsaio = new ArrayList<EnsaioVo>();
		EnsaioVo ensaioVo;
		for (String string : retorno) {
			
			ensaioVo = new EnsaioVo();
			
			string = getData(string);
			string = getGRU(string);
			string = getCodigo(string);
			string = getProprietario(string);
			string = getRenavam(string);
			string = getPlaca(string);
			string = getMarca(string);
			string = getSerie(string);
			string = getModelo(string);
			
			imprimeEnsaio();
			
			ensaioVo.setCodigoEnsaio(codigoEnsaio);
			ensaioVo.setNomeProprietario(nomeProprietario);
			ensaioVo.setRenavam(renavam);
			ensaioVo.setPlaca(placa);
			ensaioVo.setMarca(marca);
			ensaioVo.setModelo(modelo);
			ensaioVo.setSerie(serie);
			ensaioVo.setGru(gru);
			ensaioVo.setData(data);
			
			
			listaEnsaio.add(ensaioVo);
		}
		
		
		listaEnsaio = verificaEnsaiosCadastrados(listaEnsaio);
		
		relatorioEnsaioVo.setListaEnsaio(listaEnsaio);
		
		return relatorioEnsaioVo;
	}

	private List<EnsaioVo> verificaEnsaiosCadastrados(List<EnsaioVo> listaEnsaio) throws Exception {

		Ensaio ensaio = new Ensaio();
		
		listaEnsaio = ensaio.verificaEnsaiosCadastrados(listaEnsaio);
		
		for (EnsaioVo ensaioVo : listaEnsaio) {
			if(ensaioVo.isCadastrado()){
				ensaioVo.setClasseCss("info");
			}else{
				ensaioVo.setClasseCss("error");
			}
		}
		
		return listaEnsaio;
	}

	private void imprimeEnsaio() {
		System.out.println("codigo: "+codigoEnsaio);
		System.out.println("proprietario: "+nomeProprietario);
		System.out.println("renavam: "+renavam);
		System.out.println("placa: "+placa);
		System.out.println("marca: "+marca);
		System.out.println("modelo: "+modelo);
		System.out.println("serie: "+serie);
		System.out.println("gru: "+gru);
		System.out.println("data: "+data);
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	private String getTexto(String caminhoArquivo) {
		
		String textoRetorno = "";
		
		try {
			
			FileInputStream inputStream = new FileInputStream(new File(caminhoArquivo));
			PDDocument pdfDocument = null;
				
			PDFParser parser = new PDFParser(inputStream);
			parser.parse();
			
			pdfDocument = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            textoRetorno = stripper.getText(pdfDocument);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textoRetorno;
	}
	
	private String getData(String string) {
		data = string.substring(string.lastIndexOf(" ")+1);
		string = string.substring(0, (string.lastIndexOf(" ")));
		return string;
	}

	private String getGRU(String string) {
		gru = string.substring(string.lastIndexOf(" ")+1);
		string = string.substring(0, (string.lastIndexOf(" ")));
		return string;
	}
	private String getCodigo(String string) {
		codigoEnsaio = string.substring(0,string.indexOf(" "));
		string = string.substring(string.indexOf(" ")+1);
		return string;
	}
	private String getProprietario(String string) {
		nomeProprietario = string.substring(0,string.indexOf("#"));
		string = string.substring(string.indexOf("#")+2);
		return string;
	}
	private String getRenavam(String string) {
		renavam = string.substring(0,string.indexOf(" "));
		string = string.substring(string.indexOf(" ")+1);
		return string;
	}
	private String getPlaca(String string) {
		placa = string.substring(0,string.indexOf(" "));
		string = string.substring(string.indexOf(" ")+1);
		return string;
	}

	private String getModelo(String string) {
		modelo = string;
		
		return string;
	}

	private String getMarca(String string) {
		marca = string.substring(0,string.indexOf(" "));
		string = string.substring(string.indexOf(" ")+1);
		return string;
	}
	
	private String getSerie(String string) {
		serie = string.substring(string.lastIndexOf(" ")+1);
		string = string.substring(0, (string.lastIndexOf(" ")));
		return string;
	}


	private String getPeriodo(String string) throws IOException {
		Pattern pattern = Pattern.compile("Período: (.*? )");     
		
		Matcher matcher = pattern.matcher(string);  
		if(matcher.find()){
			return matcher.group(1);   
		}
		return "";
	}
	private int getTotal(String string) throws IOException {
		Pattern pattern = Pattern.compile("total: (.*)");     
		
		Matcher matcher = pattern.matcher(string);  
		if(matcher.find()){
			
			String total = matcher.group(1);
			if(total != null){
				return Integer.parseInt(total);
			}
			
		}
		return 0;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGru() {
		return gru;
	}

	public void setGru(String gru) {
		this.gru = gru;
	}

	public String getCodigoEnsaio() {
		return codigoEnsaio;
	}

	public void setCodigoEnsaio(String codigo) {
		this.codigoEnsaio = codigo;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String proprietario) {
		this.nomeProprietario = proprietario;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}
