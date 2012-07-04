package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.EmpresaDao;
import br.com.cet.vo.EmpresaVo;

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
	
	public EmpresaVo getEmpresaPeloCodigo(String codigoEmpresa) throws Exception{
		
		EmpresaVo empresaVo = new EmpresaVo(codigoEmpresa);
		
		try{
			
			EmpresaDao empresaDao = new EmpresaDao();
		
			empresaVo = empresaDao.getEmpresaPeloCodigo(empresaVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return empresaVo;
		
	}
	
	public void insertEmpresa(EmpresaVo empresaVo) throws Exception{
		
		try{
			
			EmpresaDao empresaDao = new EmpresaDao();
			 empresaDao.insertEmpresas(empresaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
