package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.ProgramaDao;
import br.com.cet.vo.ProgramaVo;

public class Programa {

	public List<ProgramaVo> getListaPrograma(ProgramaVo programaVo, boolean filtrar)
			throws Exception {

		List<ProgramaVo> listaPrograma = null;

		try {

			ProgramaDao programaDao = new ProgramaDao();
			listaPrograma = programaDao.getListaProgramas(programaVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaPrograma;

	}
	
	public ProgramaVo getProgramaPeloCodigo(String codigoPrograma) throws Exception{
		
		ProgramaVo programaVo = new ProgramaVo();
		
		try{
			
			ProgramaDao programaDao = new ProgramaDao();
			programaVo.setCodigoPrograma(codigoPrograma);
			
			programaVo = programaDao.getProgramaPeloCodigo(programaVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return programaVo;
		
	}
	
	public void insertPrograma(ProgramaVo programaVo) throws Exception{
		
		try{
			
			ProgramaDao programaDao = new ProgramaDao();
			String codigoPrograma;
			codigoPrograma = String.valueOf(programaDao.getProximoCodigo());

			programaVo.setCodigoPrograma(codigoPrograma);
			programaDao.insertProgramas(programaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatePrograma(ProgramaVo programaVo) throws Exception{
		
		try{
			
			ProgramaDao programaDao = new ProgramaDao();
			programaDao.updateProgramas(programaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePrograma(ProgramaVo programaVo){
		
		try {
			
			ProgramaDao programaDao = new ProgramaDao();
			programaDao.deletePrograma(programaVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
