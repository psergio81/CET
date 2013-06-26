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
import br.com.cet.vo.AgendamentoVo;
import br.com.cet.vo.ComboVo;
import br.com.cet.vo.PessoaVo;

public class Cad011Action extends RecursoPadraoAction {

	private Pessoa pessoa = new Pessoa();
	private List<PessoaVo> listaPessoa = null;
	private List<AgendamentoVo> listaAgendamento = null;
	private String campoBusca;
	private boolean filtrar;
	private AgendamentoVo agendamentoVo;
	Agendamento agendamento = new Agendamento();
	
	
	public void prepare() throws Exception{

		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_AGENDAMENTOS, ProgramasKey.CADASTRO_DE_AGENDAMENTOS);
	}
	
	public String browser() throws Exception{
		agendamentoVo = new AgendamentoVo();
		
		agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		listaAgendamento = agendamento.getListaAgendamento(agendamentoVo, filtrar);
	
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		PessoaVo pessoaVo = new PessoaVo() ;
		pessoaVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaPessoa =  new ArrayList<PessoaVo>();
		listaPessoa = pessoa.getListaPessoa(pessoaVo, false);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){

			

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			Agendamento agendamento = new Agendamento();
			
			agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
			agendamento.insertAgendamento(agendamentoVo);
			
			gravaLog("Log de Inserção Agendamento");
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			gravaLog("Log de Alteração Agendamento");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
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
	
	
}
