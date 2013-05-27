package br.com.cet.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.cet.action.helper.ResultJsonHelper;
import br.com.cet.business.Ensaio;
import br.com.cet.business.Pessoa;
import br.com.cet.business.Tacografo;
import br.com.cet.business.Veiculo;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.EnsaioVo;
import br.com.cet.vo.GraficoVo;
import br.com.cet.vo.UsuarioVo;


public class RecursoPadraoAction extends SystemAction{
	
	private String usuarioLogado;
	private String mensagemErro;
	private String nomePrograma;
	private String codigoPrograma;
	private String campoBusca;
	private String codigoEmpresa;
	private String quantidadeEnsaios;
	private String quantidadeVeiculos;
	private String quantidadeTacografos;
	private String quantidadePessoas;
	private String ultimosEnsaiosJson;
	private List<EnsaioVo> listaEnsaio = new ArrayList<EnsaioVo>();
	
//	protected UsuarioVo usuarioVo = new UsuarioVo();
//	protected EmpresaVo empresaVo = new EmpresaVo();

	
	public void prepare() throws Exception {
		
		super.prepare();
		
		Ensaio ensaio = new Ensaio();
		Veiculo veiculo = new Veiculo();
		Tacografo tacografo = new Tacografo();
		Pessoa pessoa = new Pessoa();
		
		System.out.println("usuarioLogadoVo... "+usuarioLogadoVo);
		
		setQuantidadeEnsaios(String.valueOf(ensaio.getQuantidadeEnsaios(usuarioLogadoVo.getCodigoEmpresa())));
		setQuantidadeVeiculos(String.valueOf(veiculo.getQuantidadeVeiculos(usuarioLogadoVo.getCodigoEmpresa())));
		setQuantidadeTacografos(String.valueOf(tacografo.getQuantidadeTacografo(usuarioLogadoVo.getCodigoEmpresa())));
		setQuantidadePessoas(String.valueOf(pessoa.getQuantidadePessoas(usuarioLogadoVo.getCodigoEmpresa())));
		
		EnsaioVo ensaioVo = new EnsaioVo();
		ensaioVo.setCodigoEmpresa(usuarioLogadoVo.getCodigoEmpresa());
		setListaEnsaio(ensaio.getListaEnsaiosPendente(ensaioVo ));
		
		HashMap<String, GraficoVo> teste = new HashMap<String, GraficoVo>();
		GraficoVo graficoVo;
		graficoVo = new GraficoVo();
		graficoVo.getValores().add("100");
		graficoVo.getValores().add("130");
		graficoVo.getValores().add("160");
		graficoVo.getValores().add("160");
		teste.put("2012", graficoVo);

		graficoVo = new GraficoVo();
		graficoVo.getValores().add("200");
		graficoVo.getValores().add("230");
		graficoVo.getValores().add("260");
		graficoVo.getValores().add("260");
		teste.put("2013", graficoVo);
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);
		resultJsonHelper.jsonDo(teste);
		String json = resultJsonHelper.getJson();
		setUltimosEnsaiosJson(json);
		
		
		
	}
	
	public void setPrograma(String codigoPrograma, String nomePrograma){
		this.codigoPrograma = codigoPrograma;
		this.nomePrograma   = nomePrograma;
	}
	
	public void gravaLog(String descricao){
		log.salvarLog(ac, descricao, codigoPrograma);
		//log.salvarLog(ac, descricao, "1");
	}
	
	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getQuantidadeEnsaios() {
		return quantidadeEnsaios;
	}

	public void setQuantidadeEnsaios(String quantidadeEnsaios) {
		this.quantidadeEnsaios = quantidadeEnsaios;
	}

	public String getQuantidadeVeiculos() {
		return quantidadeVeiculos;
	}

	public void setQuantidadeVeiculos(String quantidadeVeiculos) {
		this.quantidadeVeiculos = quantidadeVeiculos;
	}

	public String getQuantidadeTacografos() {
		return quantidadeTacografos;
	}

	public void setQuantidadeTacografos(String quantidadeTacografos) {
		this.quantidadeTacografos = quantidadeTacografos;
	}

	public String getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(String quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	
	public void setCodigoPrograma(String codigoPrograma){
		this.codigoPrograma = codigoPrograma;
	}
	
	public String getCodigoPrograma(){
		return codigoPrograma;
	}

	public String getUltimosEnsaiosJson() {
		return ultimosEnsaiosJson;
	}

	public void setUltimosEnsaiosJson(String ultimosEnsaiosJson) {
		this.ultimosEnsaiosJson = ultimosEnsaiosJson;
	}

	public List<EnsaioVo> getListaEnsaio() {
		return listaEnsaio;
	}

	public void setListaEnsaio(List<EnsaioVo> listaEnsaio) {
		this.listaEnsaio = listaEnsaio;
	}

}
