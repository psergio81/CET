package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.MarcaDao;
import br.com.cet.vo.MarcaVo;

public class Marca {

	public List<MarcaVo> getListaMarca(MarcaVo marcaVo, boolean filtrar)
			throws Exception {

		List<MarcaVo> listaMarca = null;

		try {

			MarcaDao marcaDao = new MarcaDao();
			listaMarca = marcaDao.getListaMarcas(marcaVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaMarca;

	}
	
	public MarcaVo getMarcaPeloCodigo(MarcaVo marcaVo) throws Exception{
		
		try{
			
			MarcaDao marcaDao = new MarcaDao();
			marcaVo = marcaDao.getMarcaPeloCodigo(marcaVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return marcaVo;
		
	}
	
	public void insertMarca(MarcaVo marcaVo) throws Exception{
		
		try{
			
			MarcaDao marcaDao = new MarcaDao();
			String codigoMarca;
			codigoMarca = String.valueOf(marcaDao.getProximoCodigo(marcaVo.getCodigoEmpresa()));

			marcaVo.setCodigoMarca(codigoMarca);
			marcaDao.insertMarcas(marcaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMarca(MarcaVo marcaVo) throws Exception{
		
		try{
			
			MarcaDao marcaDao = new MarcaDao();
			marcaDao.updateMarcas(marcaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMarca(MarcaVo marcaVo){
		
		try {
			
			MarcaDao marcaDao = new MarcaDao();
			marcaDao.deleteMarca(marcaVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
