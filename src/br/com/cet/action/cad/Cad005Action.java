package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Veiculo;
import br.com.cet.vo.VeiculoVo;
import br.com.cet.vo.UsuarioVo;

public class Cad005Action extends RecursoPadraoAction {

	private VeiculoVo veiculoVo = new VeiculoVo();
	private Veiculo veiculo = new Veiculo();
	private List<VeiculoVo> listaVeiculo = null;
	private String codigoVeiculoSelecionado;
	private String campoBusca;
	private boolean filtrar;
	
	public void prepare(){
		
		setNomePrograma(ProgramasKey.CADASTRO_DE_VEICULOS);
		
		UsuarioVo usuarioVo = (UsuarioVo) session.get("usuarioVo");
		
		if(usuarioVo != null){
			setUsuarioLogado(usuarioVo.getNomeUsuario());
		}
		
	}
	
	public String browser() throws Exception{
		
		
		veiculoVo.setDescricao(campoBusca);
		
		listaVeiculo = veiculo.getListaVeiculo(veiculoVo, filtrar);
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		if(AcoesKey.ACAO_CONSULTAR.equals(ac)){
		
			veiculoVo = veiculo.getVeiculoPeloCodigo(codigoVeiculoSelecionado);

		}else if(AcoesKey.ACAO_SALVAR_INCLUSAO.equals(ac)){
			
			veiculo.insertVeiculo(veiculoVo);
			
		}else if(AcoesKey.ACAO_SALVAR_ALTERACAO.equals(ac)){
			
			veiculo.updateVeiculo(veiculoVo);
			
		}else if (AcoesKey.ACAO_PRINCIPAL.equals(ac)) {
			
			return "principal";
			
		}else if (AcoesKey.ACAO_EXCLUIR.equals(ac)) {
			
			veiculo.deleteVeiculo(veiculoVo);
			
		}
		
		return SUCCESS;
	}

	public VeiculoVo getVeiculoVo() {
		return veiculoVo;
	}

	public void setVeiculoVo(VeiculoVo veiculoVo) {
		this.veiculoVo = veiculoVo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<VeiculoVo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<VeiculoVo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public String getCodigoVeiculoSelecionado() {
		return codigoVeiculoSelecionado;
	}

	public void setCodigoVeiculoSelecionado(String codigoVeiculoSelecionado) {
		this.codigoVeiculoSelecionado = codigoVeiculoSelecionado;
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
