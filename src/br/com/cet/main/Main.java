package br.com.cet.main;

import java.util.List;

import br.com.cet.dao.EmpresaDao;
import br.com.cet.vo.EmpresaVo;

public class Main {
	
	public static void main(String[] args) {
		testeConexaoBanco();
	}
	
	public static void testeConexaoBanco(){
		EmpresaDao empresaDao = new EmpresaDao();
		
		List<EmpresaVo> lista = empresaDao.getListaEmpresas();
		
		for (EmpresaVo empresaVo : lista) {
			System.out.println("Codigo Empresa........: "+empresaVo.getCodigoEmpresa());
			System.out.println("Nome Empresa..........: "+empresaVo.getNomeEmpresa());
			System.out.println("--------- || ---------");
		}
	}

}
