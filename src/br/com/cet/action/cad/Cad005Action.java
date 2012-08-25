package br.com.cet.action.cad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.action.ResultJsonHelper;
import br.com.cet.action.key.AcoesKey;
import br.com.cet.action.key.ProgramasKey;
import br.com.cet.business.Tacografo;
import br.com.cet.business.Veiculo;
import br.com.cet.vo.TacografoVo;
import br.com.cet.vo.UsuarioVo;
import br.com.cet.vo.VeiculoVo;

public class Cad005Action extends RecursoPadraoAction {

	private VeiculoVo veiculoVo = new VeiculoVo();
	private Veiculo veiculo = new Veiculo();
	private List<VeiculoVo> listaVeiculo = null;
	private String codigoVeiculoSelecionado;
	private String campoBusca;
	private boolean filtrar;
	private List<TacografoVo> listaTacografo = null;
	
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

		Tacografo tacografo = new Tacografo();
		TacografoVo tacografoVo = new TacografoVo();
		
		listaTacografo = tacografo.getListaTacografosNaoAssociados(tacografoVo);
		
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
	
	
	public void associarTacografo() throws IOException{
		System.out.println("Cad005Action.associarTacografo()");
	        
		JettisonMappedXmlDriver driver;
		XStream xstream;

		driver = new JettisonMappedXmlDriver();
		xstream = new XStream(driver);
		
		xstream.setMode(XStream.NO_REFERENCES);
        String alias = "Chave";
		Object bean = "Valor";
		
		xstream.alias(alias, bean.getClass());
		
		String xml = xstream.toXML(bean);
	    
	    System.out.println("xml: "+xml);
		
	    System.out.println("response: "+response);
	    System.out.println("responseOrigem: "+responseOrigem);

	    System.out.println("requestt: "+request);
	    System.out.println("requestOrigem: "+requestOrigem);

	    //TODO Michell o objeto ta pronto mas os "responses" estão nulos 
//	    responseOrigem.setContentType("json");
//		responseOrigem.setCharacterEncoding("utf-8");
//
//		PrintWriter out = responseOrigem.getWriter();
//		out.print(responseOrigem.getContentType());
//		out.flush();
	    
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

	public List<TacografoVo> getListaTacografo() {
		return listaTacografo;
	}

	public void setListaTacografo(List<TacografoVo> listaTacografo) {
		this.listaTacografo = listaTacografo;
	}
	
}
