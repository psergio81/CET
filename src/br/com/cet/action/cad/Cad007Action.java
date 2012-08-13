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
import br.com.cet.vo.UsuarioVo;

public class Cad007Action extends RecursoPadraoAction {

	private TacografoVo tacografoVo = new TacografoVo();
	private Tacografo tacografo = new Tacografo();
	private List<TacografoVo> listaTacografo = null;
	private String codigoTacografoSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private UsuarioVo usuarioVo;
	private List<MarcaVo> listaMarca = null;
	private List<ModeloVo> listaModelo = null;
	
	public void prepare(){
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_TACOGRAFOS);
		
		usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		
		listaTacografo = tacografo.getListaTacografo(tacografoVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		
		Marca marca = new Marca();
		listaMarca = new ArrayList<MarcaVo>();
		listaMarca = marca.getListaMarca(null, false);
		
		Modelo modelo = new Modelo();
		setListaModelo(new ArrayList<ModeloVo>());
		setListaModelo(modelo.getListaModelo(null, false));
		
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			tacografoVo = tacografo.getTacografoPeloCodigo(codigoTacografoSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			tacografoVo.setCodigoUsuarioCriador(usuarioVo.getCodigoUsuario());
			tacografo.insertTacografo(tacografoVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			tacografo.updateTacografo(tacografoVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			tacografo.deleteTacografo(tacografoVo);
			
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
	
}
