package br.com.cet.main;

import java.util.List;

import br.com.cet.dao.BaseDao;
import br.com.cet.dao.EmpresaDao;
import br.com.cet.vo.EmpresaVo;

public class Main {
	
	public static void main(String[] args) {
		testeInsert();
		testeConexaoBanco();
		System.out.println("Michell vovo...");
		System.out.println("Michell vovo...");
	}
	
	public static void testeConexaoBanco(){
		EmpresaDao empresaDao = new EmpresaDao();
		
		EmpresaVo empresaVo2 = new EmpresaVo();
		List<EmpresaVo> lista = empresaDao.getListaEmpresas(empresaVo2,false);
		
		for (EmpresaVo empresaVo : lista) {
			System.out.println("Codigo Empresa........: "+empresaVo.getCodigoEmpresa());
			System.out.println("Nome Empresa..........: "+empresaVo.getRazaoSocial());
			System.out.println("--------- || ---------");
			
			System.out.println(BaseDao.getNovaSimulacaoRowid());
		}
		
		
		
	}
	
	public static void testeInsert(){
		EmpresaDao empresaDao = new EmpresaDao();

		EmpresaVo empresaVo = new EmpresaVo("4");
		empresaVo.setRazaoSocial("TESTE 4");
		
		try {
			empresaDao.insertEmpresas(empresaVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
