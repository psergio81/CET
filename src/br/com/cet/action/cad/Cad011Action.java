package br.com.cet.action.cad;

import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.action.key.TipoServico;
import br.com.cet.business.Agendamento;
import br.com.cet.business.Pessoa;
import br.com.cet.business.TipoPessoa;
import br.com.cet.business.Veiculo;
import br.com.cet.util.UtCollection;
import br.com.cet.vo.AgendamentoVo;
import br.com.cet.vo.ComboVo;
import br.com.cet.vo.PessoaVo;
import br.com.cet.vo.VeiculoVo;

public class Cad011Action extends RecursoPadraoAction {

	private Pessoa pessoa = new Pessoa();
	private List<PessoaVo> listaPessoa = null;
	private List<AgendamentoVo> listaAgendamento = null;
	private String campoBusca;
	private boolean filtrar;
	private AgendamentoVo agendamentoVo = new AgendamentoVo();
	Agendamento agendamento = new Agendamento();
	private String dataBuscaAgendamento;
	private List<AgendamentoVo> listaAgendamentos;
	private String codigoAgendamentoSelecionado;
	private List<VeiculoVo> listaVeiculos = new ArrayList<VeiculoVo>();
	private Veiculo veiculo;
	
	
	public void prepare() throws Exception{

		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_AGENDAMENTOS, ProgramasKey.CADASTRO_DE_AGENDAMENTOS);
	}
	
	public String browser() throws Exception{
		
		if(dataBuscaAgendamento == null){
			return "browser";
		}
		agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		agendamentoVo.setCampoBusca(campoBusca);
		agendamentoVo.setDataAgendamento(dataBuscaAgendamento);

		listaAgendamento = agendamento.getListaAgendamento(agendamentoVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		VeiculoVo veiculoVo;
		PessoaVo pessoaVo = new PessoaVo() ;

		pessoaVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaPessoa =  new ArrayList<PessoaVo>();
		listaPessoa = pessoa.getListaPessoa(pessoaVo, false);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){

			veiculo = new Veiculo();
			
			agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			agendamentoVo.setCodigoAgendamento(codigoAgendamentoSelecionado);
			
			agendamentoVo = agendamento.getAgendamentoPeloCodigo(agendamentoVo);
			
			veiculoVo = new VeiculoVo();
			veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			veiculoVo.setCodigoProprietario(agendamentoVo.getCodigoProprietario());
			
			listaVeiculos = veiculo.getListaVeiculosPorCliente(veiculoVo ); 

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){

			veiculo = new Veiculo();
			agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			
			agendamento.insertAgendamento(agendamentoVo);
			
			veiculoVo = new VeiculoVo();
			veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			veiculoVo.setCodigoProprietario(agendamentoVo.getCodigoProprietario());
			
			listaVeiculos = veiculo.getListaVeiculosPorCliente(veiculoVo ); 
			
			
			gravaLog("Log de Inserção Agendamento");
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			veiculo = new Veiculo();
			agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			agendamento.updateAgendamento(agendamentoVo);
			
			veiculoVo = new VeiculoVo();
			veiculoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			veiculoVo.setCodigoProprietario(agendamentoVo.getCodigoProprietario());
			
			listaVeiculos = veiculo.getListaVeiculosPorCliente(veiculoVo ); 
			
			gravaLog("Log de Alteração Agendamento");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			agendamento.deleteAgendamento(agendamentoVo);
			
			gravaLog("Log de Deleção Agendamento");
			
		}
		
		return SUCCESS;
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

	public List<PessoaVo> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<PessoaVo> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public List<ComboVo> getListaTipoServico() {
		
		List<ComboVo> listaTipo = new ArrayList<ComboVo>();
		
		for (TipoServico tipo : TipoServico.values()) {
			listaTipo.add(new ComboVo(String.valueOf(tipo.getCodigo()), tipo.getDescricao()));
		}
		
		return listaTipo;
	}
	
	public List<ComboVo> getListaTipoPessoa() {
		
		List<ComboVo> listaTipo = new ArrayList<ComboVo>();
		
		for (TipoPessoa tipo : TipoPessoa.values()) {
			listaTipo.add(new ComboVo(String.valueOf(tipo.getCodigo()), tipo.getDescricao()));
		}
		
		return listaTipo;
	}
	
	public String buscarAgendamentos(){
		
		
		Agendamento agendamento = new Agendamento();
		AgendamentoVo agendamentoVo = new AgendamentoVo();
		
		agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		agendamentoVo.setDataAgendamento(dataBuscaAgendamento);
		
		listaAgendamentos = new ArrayList<AgendamentoVo>();
		listaAgendamentos = agendamento.getAgendamentosPorDia(agendamentoVo);

		if(UtCollection.isNullOrEmpty(listaAgendamentos)){
			return null;
		}
		
		return "agendamentos";
	}

	public AgendamentoVo getAgendamentoVo() {
		return agendamentoVo;
	}

	public void setAgendamentoVo(AgendamentoVo agendamentoVo) {
		this.agendamentoVo = agendamentoVo;
	}

	public List<AgendamentoVo> getListaAgendamento() {
		return listaAgendamento;
	}

	public void setListaAgendamento(List<AgendamentoVo> listaAgendamento) {
		this.listaAgendamento = listaAgendamento;
	}

	public String getDataBuscaAgendamento() {
		return dataBuscaAgendamento;
	}

	public void setDataBuscaAgendamento(String dataBuscaAgendamento) {
		this.dataBuscaAgendamento = dataBuscaAgendamento;
	}

	public List<AgendamentoVo> getListaAgendamentos() {
		return listaAgendamentos;
	}

	public void setListaAgendamentos(List<AgendamentoVo> listaAgendamentos) {
		this.listaAgendamentos = listaAgendamentos;
	}

	public String getCodigoAgendamentoSelecionado() {
		return codigoAgendamentoSelecionado;
	}

	public void setCodigoAgendamentoSelecionado(
			String codigoAgendamentoSelecionado) {
		this.codigoAgendamentoSelecionado = codigoAgendamentoSelecionado;
	}

	public List<VeiculoVo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<VeiculoVo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	
}
