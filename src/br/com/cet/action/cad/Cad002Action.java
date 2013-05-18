package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Marca;
import br.com.cet.vo.MarcaVo;
import br.com.cet.vo.UsuarioVo;

public class Cad002Action extends RecursoPadraoAction {

	private MarcaVo marcaVo = new MarcaVo();
	private Marca marca = new Marca();
	private List<MarcaVo> listaMarca = null;
	private String codigoMarcaSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare() throws Exception{

		super.prepare();
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_MARCAS);
		
		usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		marcaVo.setCodigoEmpresa(usuarioVo.getCodigoEmpresa());
		
		marcaVo.setDescricao(campoBusca);
		
		listaMarca = marca.getListaMarca(marcaVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		boolean retorno;
		
		marcaVo.setCodigoEmpresa(usuarioVo.getCodigoEmpresa());
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
			marcaVo.setCodigoMarca(codigoMarcaSelecionado);
		
			marcaVo = marca.getMarcaPeloCodigo(marcaVo);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			retorno = marca.insertMarca(marcaVo);
			
			if(retorno){
				setMensagemErro("Marca cadastrada com sucesso!");
			}else{
				setMensagemErro("Erro ao cadastrar marca!");
			}
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			marca.updateMarca(marcaVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			marca.deleteMarca(marcaVo);
			
		}
		
		return SUCCESS;
	}

	public MarcaVo getMarcaVo() {
		return marcaVo;
	}

	public void setMarcaVo(MarcaVo marcaVo) {
		this.marcaVo = marcaVo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<MarcaVo> getListaMarca() {
		return listaMarca;
	}

	public void setListaMarca(List<MarcaVo> listaMarca) {
		this.listaMarca = listaMarca;
	}

	public String getCodigoMarcaSelecionado() {
		return codigoMarcaSelecionado;
	}

	public void setCodigoMarcaSelecionado(String codigoMarcaSelecionado) {
		this.codigoMarcaSelecionado = codigoMarcaSelecionado;
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
