package br.com.cet.action.cad;

import java.util.List;

import br.com.cet.action.RecursoPadraoAction;
import br.com.cet.business.Empresa;
import br.com.cet.vo.EmpresaVo;

import com.opensymphony.xwork2.ActionSupport;

public class Cad001Action extends RecursoPadraoAction{
	
	private EmpresaVo empresaVo = new EmpresaVo();
	private Empresa empresa = new Empresa();
	private List<EmpresaVo> listaEmpresa = null;
	
	
	public void prepare(){
		
		System.out.println("passou pelo prepare.........");
		
	}
	
	public String browser() throws Exception{
		
		System.out.println("passou browser.........");
		
		listaEmpresa = empresa.getListaEmpresa();
		
		return "browser";
		
	}
	
	
	public String crud() throws Exception{
		
		System.out.println("passou crud.........");
		
		System.out.println("EmpresaVo nome "+empresaVo.getNomeEmpresa());
		System.out.println("EmpresaVo codi "+empresaVo.getCodigoEmpresa());
		
		empresa.insertEmpresa(empresaVo);
		
		return SUCCESS;
	}
	
	

	public EmpresaVo getEmpresaVo() {
		return empresaVo;
	}

	public void setEmpresaVo(EmpresaVo empresaVo) {
		this.empresaVo = empresaVo;
	}

	public List<EmpresaVo> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<EmpresaVo> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

}
