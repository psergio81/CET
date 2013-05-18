package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.ModeloDao;
import br.com.cet.vo.ModeloVo;

public class Modelo {

	public List<ModeloVo> getListaModelo(ModeloVo modeloVo, boolean filtrar)
			throws Exception {

		List<ModeloVo> listaModelo = null;

		try {

			ModeloDao modeloDao = new ModeloDao();
			listaModelo = modeloDao.getListaModelos(modeloVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaModelo;

	}
	
	public ModeloVo getModeloPeloCodigo(ModeloVo modeloVo) throws Exception{
		
		try{
			
			ModeloDao modeloDao = new ModeloDao();
			modeloVo = modeloDao.getModeloPeloCodigo(modeloVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return modeloVo;
		
	}
	
	public boolean insertModelo(ModeloVo modeloVo) throws Exception{
		
		try{
			
			ModeloDao modeloDao = new ModeloDao();
			String codigoModelo;
			codigoModelo = String.valueOf(modeloDao.getProximoCodigo(modeloVo.getCodigoEmpresa()));

			modeloVo.setCodigoModelo(codigoModelo);
			modeloDao.insertModelos(modeloVo);
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void updateModelo(ModeloVo modeloVo) throws Exception{
		
		try{
			
			ModeloDao modeloDao = new ModeloDao();
			modeloDao.updateModelos(modeloVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteModelo(ModeloVo modeloVo){
		
		try {
			
			ModeloDao modeloDao = new ModeloDao();
			modeloDao.deleteModelo(modeloVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
