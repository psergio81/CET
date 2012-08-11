package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Pessoa;
import br.com.cet.vo.PessoaVo;
import br.com.cet.vo.UsuarioVo;

public class Cad006Action extends RecursoPadraoAction {

	private PessoaVo pessoaVo = new PessoaVo();
	private Pessoa pessoa = new Pessoa();
	private List<PessoaVo> listaPessoa = null;
	private String codigoPessoaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare(){
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_PESSOAS);
		
		UsuarioVo usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		
		pessoaVo.setDescricao(campoBusca);
		
		listaPessoa = pessoa.getListaPessoa(pessoaVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			pessoaVo = pessoa.getPessoaPeloCodigo(codigoPessoaSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			pessoa.insertPessoa(pessoaVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			pessoa.updatePessoa(pessoaVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			pessoa.deletePessoa(pessoaVo);
			
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
