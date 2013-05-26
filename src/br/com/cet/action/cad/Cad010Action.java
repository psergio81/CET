package br.com.cet.action.cad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Upload;
import br.com.cet.vo.EnsaioVo;
import br.com.cet.vo.RelatorioEnsaioVo;

public class Cad010Action extends RecursoPadraoAction {

	private File upload;   
    private String uploadFileName; //nome do arquivo enviado  
    private String uploadContentType; //contexto do arquivo, imagem, txt etc...
	private List<EnsaioVo> listaEnsaioVo = new ArrayList<EnsaioVo>();
	private String periodo;
	private String quantidadeEnsaiosRelatorio;
	
	public void prepare() throws Exception{

		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_UPLOAD_ARQUIVOS, ProgramasKey.UPLOAD_ARQUIVOS);
		
	}
	
	public String browser() throws Exception{
		
		return SUCCESS;
		
	}
	
	public String upload() {
		
		
		Upload uploadBusiness = new Upload();
		RelatorioEnsaioVo ensaiosDoArquivo;
		
		try {
			String caminhoArquivo = upload.getAbsolutePath();
			ensaiosDoArquivo = uploadBusiness.getEnsaiosDoArquivo(caminhoArquivo);
		
			listaEnsaioVo = ensaiosDoArquivo.getListaEnsaio();
			quantidadeEnsaiosRelatorio = ensaiosDoArquivo.getQuantidadeEnsaios();
			periodo = ensaiosDoArquivo.getPeriodo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	
	
	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<EnsaioVo> getListaEnsaioVo() {
		return listaEnsaioVo;
	}

	public void setListaEnsaioVo(List<EnsaioVo> listaEnsaioVo) {
		this.listaEnsaioVo = listaEnsaioVo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getQuantidadeEnsaiosRelatorio() {
		return quantidadeEnsaiosRelatorio;
	}

	public void setQuantidadeEnsaiosRelatorio(String quantidadeEnsaiosRelatorio) {
		this.quantidadeEnsaiosRelatorio = quantidadeEnsaiosRelatorio;
	}
}
