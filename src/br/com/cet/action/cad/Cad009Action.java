package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Programa;
import br.com.cet.vo.ProgramaVo;

public class Cad009Action extends RecursoPadraoAction {

	private ProgramaVo programaVo = new ProgramaVo();
	private Programa programa = new Programa();
	private List<ProgramaVo> listaPrograma = null;
	private String codigoProgramaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare() throws Exception{

		super.prepare();
		
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_PROGRAMAS, ProgramasKey.CADASTRO_DE_PROGRAMAS);
		
	}
	
	public String browser() throws Exception{
		
		
		programaVo.setDescricao(campoBusca);
		
		listaPrograma = programa.getListaPrograma(programaVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			programaVo = programa.getProgramaPeloCodigo(codigoProgramaSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			programa.insertPrograma(programaVo);
			
			gravaLog("Log de Inser  o Programa");
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			programa.updatePrograma(programaVo);
			
			gravaLog("Log de Altera  o Programa");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			programa.deletePrograma(programaVo);
			gravaLog("Log de Dele  o Programa");
			
		}
		
		return SUCCESS;
	}

	public ProgramaVo getProgramaVo() {
		return programaVo;
	}

	public void setProgramaVo(ProgramaVo programaVo) {
		this.programaVo = programaVo;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<ProgramaVo> getListaPrograma() {
		return listaPrograma;
	}

	public void setListaPrograma(List<ProgramaVo> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}

	public String getCodigoProgramaSelecionado() {
		return codigoProgramaSelecionado;
	}

	public void setCodigoProgramaSelecionado(String codigoProgramaSelecionado) {
		this.codigoProgramaSelecionado = codigoProgramaSelecionado;
	}

	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	public boolean isFiltrar() {
		return filtrar;
	}

	public void setFiltrar(boolean filtrar) {
		this.filtrar = filtrar;
	}
	
	
}
