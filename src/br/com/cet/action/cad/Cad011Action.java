package br.com.cet.action.cad;

import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Pessoa;
import br.com.cet.vo.PessoaVo;

public class Cad011Action extends RecursoPadraoAction {

	private Pessoa pessoa = new Pessoa();
	private List<PessoaVo> listaPessoa = null;
	private String campoBusca;
	private boolean filtrar;
	
	
	public void prepare() throws Exception{

		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_AGENDAMENTOS, ProgramasKey.CADASTRO_DE_AGENDAMENTOS);
		
	}
	
	public String browser() throws Exception{
		
		
		PessoaVo pessoaVo = new PessoaVo() ;
		pessoaVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaPessoa =  new ArrayList<PessoaVo>();
		listaPessoa = pessoa.getListaPessoa(pessoaVo, false);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		PessoaVo pessoaVo = new PessoaVo() ;
		pessoaVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		
		listaPessoa =  new ArrayList<PessoaVo>();
		listaPessoa = pessoa.getListaPessoa(pessoaVo, false);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
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
	
	
}
