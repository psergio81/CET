package br.com.cet.action.cad;

import java.util.ArrayList;
import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Marca;
import br.com.cet.business.Modelo;
import br.com.cet.business.Tacografo;
import br.com.cet.vo.MarcaVo;
import br.com.cet.vo.ModeloVo;
import br.com.cet.vo.TacografoVo;

public class Cad007Action extends RecursoPadraoAction {

	private TacografoVo tacografoVo = new TacografoVo();
	private Tacografo tacografo = new Tacografo();
	private List<TacografoVo> listaTacografo = null;
	private String codigoTacografoSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private List<MarcaVo> listaMarca = null;
	private List<ModeloVo> listaModelo = null;
	private String codigoVeiculo;
	
	public void prepare() throws Exception{
		super.prepare();
		
		setPrograma(ProgramasKey.CODIGO_CADASTRO_DE_TACOGRAFOS, ProgramasKey.CADASTRO_DE_TACOGRAFOS);
		
	}
	
	public String browser() throws Exception{
		
		
		listaTacografo = tacografo.getListaTacografo(tacografoVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		boolean retorno;
		MarcaVo marcaVo = new MarcaVo();
		marcaVo.setCodigoEmpresa(usuarioLogadoVo.getCodigoEmpresa());
		
		Marca marca = new Marca();
		listaMarca = new ArrayList<MarcaVo>();
		listaMarca = marca.getListaMarca(marcaVo, false);
		
		Modelo modelo = new Modelo();
		setListaModelo(new ArrayList<ModeloVo>());
		setListaModelo(modelo.getListaModelo(null, false));
		
		tacografoVo.setCodigoEmpresa(usuarioLogadoVo.getCodigoEmpresa());
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			tacografoVo = tacografo.getTacografoPeloCodigo(codigoTacografoSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			tacografoVo.setCodigoUsuarioCriador(usuarioLogadoVo.getCodigoUsuario());
			retorno = tacografo.insertTacografo(tacografoVo);
			
			if(retorno){
				setMensagemErro("Tac grafo cadastrado com sucesso!");
				gravaLog("Log de Inser  o Tacografo");
			}else{
				setMensagemErro("Erro ao cadastrar tac grafo!");
			}
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			tacografo.updateTacografo(tacografoVo);
			gravaLog("Log de Altera  o Tacografo");
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			tacografo.deleteTacografo(tacografoVo);
			gravaLog("Log de Dele  o Tacografo");
			
		}else if(AcoesKey.ACAO_ASSOCIAR.equals(ac)){
			
		}
		
		return SUCCESS;
	}
	
	
	public TacografoVo getTacografoVo() {
		return tacografoVo;
	}

	public void setTacografoVo(TacografoVo tacografoVo) {
		this.tacografoVo = tacografoVo;
	}

	public Tacografo getTacografo() {
		return tacografo;
	}

	public void setTacografo(Tacografo tacografo) {
		this.tacografo = tacografo;
	}

	public List<TacografoVo> getListaTacografo() {
		return listaTacografo;
	}

	public void setListaTacografo(List<TacografoVo> listaTacografo) {
		this.listaTacografo = listaTacografo;
	}

	public String getCodigoTacografoSelecionado() {
		return codigoTacografoSelecionado;
	}

	public void setCodigoTacografoSelecionado(String codigoTacografoSelecionado) {
		this.codigoTacografoSelecionado = codigoTacografoSelecionado;
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

	public List<MarcaVo> getListaMarca() {
		return listaMarca;
	}

	public void setListaMarca(List<MarcaVo> listaMarca) {
		this.listaMarca = listaMarca;
	}

	public List<ModeloVo> getListaModelo() {
		return listaModelo;
	}

	public void setListaModelo(List<ModeloVo> listaModelo) {
		this.listaModelo = listaModelo;
	}

	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	
}
