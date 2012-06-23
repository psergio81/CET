package br.com.ordemservico.business;

import java.util.List;

import br.com.ordemservico.dao.EmpresaDao;
import br.com.ordemservico.vo.EmpresaVo;

public class Empresa {
	
	public List<EmpresaVo> getListaEmpresa() throws Exception{
		
		List<EmpresaVo> listaEmpresa = null;
		
		try{
			
			EmpresaDao empresaDao = new EmpresaDao();
			listaEmpresa = empresaDao.getListaEmpresas();
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return listaEmpresa;
		
	}
	
	public void insertEmpresa(EmpresaVo empresaVo) throws Exception{
		
		System.out.println("Empresa.insertEmpresa()");
		
		try{
			
			EmpresaDao empresaDao = new EmpresaDao();
			 empresaDao.insertEmpresas(empresaVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
	}

}
