package br.com.cet.action;

import br.com.cet.business.Ensaio;
import br.com.cet.business.Pessoa;
import br.com.cet.business.Tacografo;
import br.com.cet.business.Veiculo;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;


public class RecursoPadraoAction extends SystemAction{
	
	private String usuarioLogado;
	private String mensagemErro;
	private String nomePrograma;
	private String campoBusca;
	private String codigoEmpresa;
	private String quantidadeEnsaios;
	private String quantidadeVeiculos;
	private String quantidadeTacografos;
	private String quantidadePessoas;
	
	protected UsuarioVo usuarioVo = new UsuarioVo();
	protected EmpresaVo empresaVo = new EmpresaVo();

	
	public void prepare() throws Exception {
		
		Ensaio ensaio = new Ensaio();
		Veiculo veiculo = new Veiculo();
		Tacografo tacografo = new Tacografo();
		Pessoa pessoa = new Pessoa();
		
		setQuantidadeEnsaios(String.valueOf(ensaio.getQuantidadeEnsaios(usuarioVo.getCodigoEmpresa())));
		setQuantidadeVeiculos(String.valueOf(veiculo.getQuantidadeVeiculos(usuarioVo.getCodigoEmpresa())));
		setQuantidadeTacografos(String.valueOf(tacografo.getQuantidadeTacografo(usuarioVo.getCodigoEmpresa())));
		setQuantidadePessoas(String.valueOf(pessoa.getQuantidadePessoas(usuarioVo.getCodigoEmpresa())));
		
		super.prepare();
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

}
