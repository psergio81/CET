package br.com.cet.action.cad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.helper.ResultJsonHelper;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Pessoa;
import br.com.cet.business.Tacografo;
import br.com.cet.business.Veiculo;
import br.com.cet.business.VeiculoTacografo;
import br.com.cet.vo.PessoaVo;
import br.com.cet.vo.TacografoVo;
import br.com.cet.vo.VeiculoTacografoVo;
import br.com.cet.vo.VeiculoVo;

public class Cad005Action extends RecursoPadraoAction {

	private VeiculoVo veiculoVo = new VeiculoVo();
	private Veiculo veiculo = new Veiculo();
	private List<VeiculoVo> listaVeiculo = null;
	private String codigoVeiculoSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private List<TacografoVo> listaTacografo = null;
	private List<VeiculoTacografoVo> listaTacografosAssociados = null;
	private String codigoVeiculo;
	private String codigoTacografo;
	private String codigoEmpresaSelecionada;
	private Pessoa pessoa;
	private PessoaVo pessoaVo;
	private List<PessoaVo> listaPessoa;
	
	public void prepare() throws Exception{
		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_VEICULOS, ProgramasKey.CADASTRO_DE_VEICULOS);
		
	}
	
	public String browser() throws Exception{
		
		
		veiculoVo.setPlaca(campoBusca);
		veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaVeiculo = veiculo.getListaVeiculo(veiculoVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		boolean retorno;
		Tacografo tacografo = new Tacografo();
		TacografoVo tacografoVo = new TacografoVo();
		veiculoVo.setCodigoEmpresa(usuarioLogadoVo.getCodigoEmpresa());
		
		pessoaVo = new PessoaVo();
		pessoaVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		pessoa = new Pessoa();
		listaPessoa = pessoa.getListaPessoa(pessoaVo , false);
		
		listaTacografo = tacografo.getListaTacografosNaoAssociados(tacografoVo);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			veiculoVo = new VeiculoVo();
			veiculoVo.setCodigoVeiculo(codigoVeiculoSelecionado);
			veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			
			veiculoVo = veiculo.getVeiculoPeloCodigo(veiculoVo);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			retorno = veiculo.insertVeiculo(veiculoVo);
			
			if(retorno){
				setMensagemErro("Veículo cadastrado com sucesso!");
				gravaLog("Log de Inserção de Veiculos");
			}else{
				setMensagemErro("Erro ao cadastrar veículo!");
			}
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			veiculo.updateVeiculo(veiculoVo);
			gravaLog("Log de Alteração Veiculo");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			veiculo.deleteVeiculo(veiculoVo);
			gravaLog("Log de Deleção Veiculo");
			
		}
		
		return SUCCESS;
	}
	
	
	public String associarTacografo(){
		
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);

		try {
			

			VeiculoTacografo veiculoTacografo = new VeiculoTacografo();
			VeiculoTacografoVo veiculoTacografoVo = new VeiculoTacografoVo();

			veiculoTacografoVo.setCodigoVeiculo(codigoVeiculo);
			veiculoTacografoVo.setCodigoTacografo(getCodigoTacografo());
			
			veiculoTacografo.insertVeiculoTacografo(veiculoTacografoVo);
			
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("teste", "casa");
			
			resultJsonHelper.jsonDo(map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultJsonHelper.getResultTypeJson();
		
	}
	
	
	public String carregaTacografosAssociados() throws Exception{
		
		
		VeiculoTacografoVo veiculoTacografoVo = new VeiculoTacografoVo();
		VeiculoTacografo veiculoTacografo = new VeiculoTacografo();
		veiculoTacografoVo.setCodigoVeiculo(getCodigoVeiculo());
		
		setListaTacografosAssociados(veiculoTacografo.getTacografosDeUmVeiculo(veiculoTacografoVo));
		
		return "associados";
		
	}

	public String carregaTacografosNaoAssociados() throws Exception{
		
		Tacografo tacografo = new Tacografo();
		TacografoVo tacografoVo = new TacografoVo();
		tacografoVo.setCodigoTacografo(codigoVeiculo);
		
		listaTacografo = tacografo.getListaTacografosNaoAssociados(tacografoVo);
		
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);
		resultJsonHelper.jsonDo(listaTacografo);
		
		return resultJsonHelper.getResultTypeJson();
	}

	public String carregaVeiculosPorCliente() throws Exception{
		
		veiculoVo = new VeiculoVo();
		veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		veiculoVo.setCodigoProprietario(codigoEmpresaSelecionada);
		
		listaVeiculo = veiculo.getListaVeiculosPorCliente(veiculoVo);
		
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);
		resultJsonHelper.jsonDo(listaVeiculo);
		
		return resultJsonHelper.getResultTypeJson();
	}
	
	public VeiculoVo getVeiculoVo() {
		return veiculoVo;
	}

	public void setVeiculoVo(VeiculoVo veiculoVo) {
		this.veiculoVo = veiculoVo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<VeiculoVo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<VeiculoVo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public String getCodigoVeiculoSelecionado() {
		return codigoVeiculoSelecionado;
	}

	public void setCodigoVeiculoSelecionado(String codigoVeiculoSelecionado) {
		this.codigoVeiculoSelecionado = codigoVeiculoSelecionado;
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

	public List<TacografoVo> getListaTacografo() {
		return listaTacografo;
	}

	public void setListaTacografo(List<TacografoVo> listaTacografo) {
		this.listaTacografo = listaTacografo;
	}

	public List<VeiculoTacografoVo> getListaTacografosAssociados() {
		return listaTacografosAssociados;
	}

	public void setListaTacografosAssociados(
			List<VeiculoTacografoVo> listaTacografosAssociados) {
		this.listaTacografosAssociados = listaTacografosAssociados;
	}

	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public String getCodigoTacografo() {
		return codigoTacografo;
	}

	public void setCodigoTacografo(String codigoTacografo) {
		this.codigoTacografo = codigoTacografo;
	}

	public String getCodigoEmpresaSelecionada() {
		return codigoEmpresaSelecionada;
	}

	public void setCodigoEmpresaSelecionada(String codigoEmpresaSelecionada) {
		this.codigoEmpresaSelecionada = codigoEmpresaSelecionada;
	}

	public List<PessoaVo> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<PessoaVo> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
	
}
