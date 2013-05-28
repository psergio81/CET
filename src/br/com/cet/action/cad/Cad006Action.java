package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Pessoa;
import br.com.cet.vo.PessoaVo;

public class Cad006Action extends RecursoPadraoAction {

	private PessoaVo pessoaVo = new PessoaVo();
	private Pessoa pessoa = new Pessoa();
	private List<PessoaVo> listaPessoa = null;
	private String codigoPessoaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_PESSOAS, ProgramasKey.CADASTRO_DE_PESSOAS);
		
	}
	
	public String browser() throws Exception{
		
		
		pessoaVo.setNome(campoBusca);
		
		listaPessoa = pessoa.getListaPessoa(pessoaVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		boolean retorno;
		
		pessoaVo.setCodigoEmpresa(usuarioLogadoVo.getCodigoEmpresa());
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			pessoaVo = pessoa.getPessoaPeloCodigo(codigoPessoaSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			retorno = pessoa.insertPessoa(pessoaVo);
			
			if(retorno){
				setMensagemErro("Pessoa cadastrada com sucesso!");
				gravaLog("Log de Inser  o Pessoa");
			}else{
				setMensagemErro("Erro ao cadastrar Pessoa!");
			}
			
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			pessoa.updatePessoa(pessoaVo);
			gravaLog("Log de Altera  o Pessoa");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			pessoa.deletePessoa(pessoaVo);
			gravaLog("Log de Dele  o Pessoa");
			
		}
		
		return SUCCESS;
	}

	public PessoaVo getPessoaVo() {
		return pessoaVo;
	}

	public void setPessoaVo(PessoaVo pessoaVo) {
		this.pessoaVo = pessoaVo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<PessoaVo> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<PessoaVo> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public String getCodigoPessoaSelecionado() {
		return codigoPessoaSelecionado;
	}

	public void setCodigoPessoaSelecionado(String codigoPessoaSelecionado) {
		this.codigoPessoaSelecionado = codigoPessoaSelecionado;
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
