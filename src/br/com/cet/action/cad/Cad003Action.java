package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Modelo;
import br.com.cet.vo.ModeloVo;
import br.com.cet.vo.UsuarioVo;

public class Cad003Action extends RecursoPadraoAction {

	private ModeloVo modeloVo = new ModeloVo();
	private Modelo modelo = new Modelo();
	private List<ModeloVo> listaModelo = null;
	private String codigoModeloSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare() throws Exception{
		
		super.prepare();
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_MODELOS);
		
		usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		modeloVo.setCodigoEmpresa(usuarioVo.getCodigoEmpresa());
		
		modeloVo.setDescricao(campoBusca);
		
		listaModelo = modelo.getListaModelo(modeloVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		modeloVo.setCodigoEmpresa(usuarioVo.getCodigoEmpresa());
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
			
			modeloVo.setCodigoModelo(codigoModeloSelecionado);
			modeloVo = modelo.getModeloPeloCodigo(modeloVo);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			modelo.insertModelo(modeloVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			modelo.updateModelo(modeloVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			modelo.deleteModelo(modeloVo);
			
		}
		
		return SUCCESS;
	}

	public ModeloVo getModeloVo() {
		return modeloVo;
	}

	public void setModeloVo(ModeloVo modeloVo) {
		this.modeloVo = modeloVo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<ModeloVo> getListaModelo() {
		return listaModelo;
	}

	public void setListaModelo(List<ModeloVo> listaModelo) {
		this.listaModelo = listaModelo;
	}

	public String getCodigoModeloSelecionado() {
		return codigoModeloSelecionado;
	}

	public void setCodigoModeloSelecionado(String codigoModeloSelecionado) {
		this.codigoModeloSelecionado = codigoModeloSelecionado;
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
