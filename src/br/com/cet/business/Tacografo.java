package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.TacografoDao;
import br.com.cet.vo.TacografoVo;

public class Tacografo {

	public List<TacografoVo> getListaTacografo(TacografoVo tacografoVo, boolean filtrar)
			throws Exception {

		List<TacografoVo> listaTacografo = null;

		try {

			TacografoDao tacografoDao = new TacografoDao();
			listaTacografo = tacografoDao.getListaTacografos(tacografoVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaTacografo;

	}

	public List<TacografoVo> getListaTacografosNaoAssociados(TacografoVo tacografoVo)
			throws Exception {
		
		List<TacografoVo> listaTacografo = null;
		
		try {
			
			TacografoDao tacografoDao = new TacografoDao();
			listaTacografo = tacografoDao.getListaTacografosNaoAssociados(tacografoVo);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		return listaTacografo;
		
	}
	
	public TacografoVo getTacografoPeloCodigo(String codigoTacografo) throws Exception{
		
		TacografoVo tacografoVo = new TacografoVo();
		
		try{
			
			TacografoDao tacografoDao = new TacografoDao();
			tacografoVo.setCodigoTacografo(codigoTacografo);
			
			tacografoVo = tacografoDao.getTacografoPeloCodigo(tacografoVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return tacografoVo;
		
	}
	
	public void insertTacografo(TacografoVo tacografoVo) throws Exception{
		
		try{
			
			TacografoDao tacografoDao = new TacografoDao();
			String codigoTacografo;
			codigoTacografo = String.valueOf(tacografoDao.getProximoCodigo(tacografoVo.getCodigoEmpresa()));

			tacografoVo.setCodigoTacografo(codigoTacografo);
			tacografoDao.insertTacografos(tacografoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTacografo(TacografoVo tacografoVo) throws Exception{
		
		try{
			
			TacografoDao tacografoDao = new TacografoDao();
			tacografoDao.updateTacografos(tacografoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTacografo(TacografoVo tacografoVo){
		
		try {
			
			TacografoDao tacografoDao = new TacografoDao();
			tacografoDao.deleteTacografo(tacografoVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getQuantidadeTacografo(String codigoEmpresa){

		int quantidadeTacografos = 0 ;
		TacografoVo tacografoVo = new TacografoVo();
		try {
			
			TacografoDao tacografoDao = new TacografoDao();
			quantidadeTacografos = tacografoDao.getQuantidadeTacografo(tacografoVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantidadeTacografos;
		
	}

}
