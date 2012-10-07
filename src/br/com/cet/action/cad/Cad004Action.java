package br.com.cet.action.cad;

import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Ensaio;
import br.com.cet.business.Pessoa;
import br.com.cet.business.Veiculo;
import br.com.cet.vo.EnsaioVo;
import br.com.cet.vo.PessoaVo;
import br.com.cet.vo.UsuarioVo;
import br.com.cet.vo.VeiculoVo;

public class Cad004Action extends RecursoPadraoAction {

	private EnsaioVo ensaioVo = new EnsaioVo();
	private Ensaio ensaio = new Ensaio();
	private List<EnsaioVo> listaEnsaio = null;
	private String codigoEnsaioSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private List<PessoaVo> listaPessoa = null;
	private List<VeiculoVo> listaVeiculo = null;
	private UsuarioVo usuarioVo;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_ENSAIOS);
		
		usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		
		listaEnsaio = ensaio.getListaEnsaio(ensaioVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		
		Pessoa pessoa = new Pessoa();
		listaPessoa = new ArrayList<PessoaVo>();
		listaPessoa = pessoa.getListaPessoa(null, false);

		Veiculo veiculo = new Veiculo();
		listaVeiculo = new ArrayList<VeiculoVo>();
		listaVeiculo = veiculo.getListaVeiculo(null, false);
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			ensaioVo = ensaio.getEnsaioPeloCodigo(codigoEnsaioSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			ensaioVo.setCodigoUsuarioCriador(usuarioVo.getCodigoUsuario());
			ensaio.insertEnsaio(ensaioVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			ensaio.updateEnsaio(ensaioVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			ensaio.deleteEnsaio(ensaioVo);
			
		}
		
		return SUCCESS;
	}

	public EnsaioVo getEnsaioVo() {
		return ensaioVo;
	}

	public void setEnsaioVo(EnsaioVo ensaioVo) {
		this.ensaioVo = ensaioVo;
	}

	public Ensaio getEnsaio() {
		return ensaio;
	}

	public void setEnsaio(Ensaio ensaio) {
		this.ensaio = ensaio;
	}

	public List<EnsaioVo> getListaEnsaio() {
		return listaEnsaio;
	}

	public void setListaEnsaio(List<EnsaioVo> listaEnsaio) {
		this.listaEnsaio = listaEnsaio;
	}

	public String getCodigoEnsaioSelecionado() {
		return codigoEnsaioSelecionado;
	}

	public void setCodigoEnsaioSelecionado(String codigoEnsaioSelecionado) {
		this.codigoEnsaioSelecionado = codigoEnsaioSelecionado;
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

	public List<VeiculoVo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<VeiculoVo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}
	
}
