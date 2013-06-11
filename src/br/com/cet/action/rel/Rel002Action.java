package br.com.cet.action.rel;

import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Usuario;
import br.com.cet.business.relatorio.RelatorioLog;
import br.com.cet.util.UtDataHora;
import br.com.cet.vo.ComboVo;
import br.com.cet.vo.UsuarioVo;
import br.com.cet.vo.filtro.FiltroLogVo;
import br.com.cet.vo.log.LogVo;

/**
 * Relatório de Log Ação
 * @author Michell Sarno
 *
 */
public class Rel002Action extends RecursoPadraoAction{
	
	private List<LogVo> 	listaLog 		= null;
	private RelatorioLog 	relatorioLog	= new RelatorioLog();
	private FiltroLogVo  	filtroVo		= new FiltroLogVo();
	private List<UsuarioVo> listaUsuario	= null;
	private List<ComboVo>	listaPrograma	= null;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_RELATORIO_LOG_ACAO, ProgramasKey.RELATORIO_LOG_ACAO);
		
	}
	

	public String browser() throws Exception{
		
		Usuario usuario = new Usuario();
		listaUsuario = usuario.getListaUsuario(null, false);
		
		listaPrograma = this.getListPrograma();
		
		filtroVo.setDataFinal(UtDataHora.getDataAtual());
		filtroVo.setDataInicial(UtDataHora.getDataAtual());
		
		return "browser";
		
	}
	
	
	public String relatorio() throws Exception{

		filtroVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaLog = relatorioLog.getRelatorioLog(filtroVo);
		
		return SUCCESS;
	}
	
	
	private List<ComboVo> getListPrograma(){
		List<ComboVo> lista = new ArrayList<>();
		
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_EMPRESAS, ProgramasKey.CODIGO_CADASTRO_DE_EMPRESAS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_MARCAS, ProgramasKey.CODIGO_CADASTRO_DE_MARCAS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_MODELOS, ProgramasKey.CADASTRO_DE_MODELOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_ENSAIOS, ProgramasKey.CADASTRO_DE_ENSAIOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_USUARIOS, ProgramasKey.CADASTRO_DE_USUARIOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_VEICULOS, ProgramasKey.CADASTRO_DE_VEICULOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_PESSOAS, ProgramasKey.CADASTRO_DE_PESSOAS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_TACOGRAFOS, ProgramasKey.CADASTRO_DE_TACOGRAFOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_PROGRAMAS, ProgramasKey.CADASTRO_DE_PROGRAMAS));
		lista.add(new ComboVo(ProgramasKey.UPLOAD_ARQUIVOS, ProgramasKey.UPLOAD_ARQUIVOS));
		lista.add(new ComboVo(ProgramasKey.CADASTRO_DE_AGENDAMENTOS, ProgramasKey.CADASTRO_DE_AGENDAMENTOS));
		
		return lista;
		
	}
	
	
	
	
	
	
	public FiltroLogVo getFiltroVo() {
		return filtroVo;
	}

	public void setFiltroVo(FiltroLogVo filtroVo) {
		this.filtroVo = filtroVo;
	}

	public List<UsuarioVo> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuarioVo> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<LogVo> getListaLog() {
		return listaLog;
	}

	public void setListaLog(List<LogVo> listaLog) {
		this.listaLog = listaLog;
	}


	public List<ComboVo> getListaPrograma() {
		return listaPrograma;
	}


	public void setListaPrograma(List<ComboVo> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}
	
	

}
