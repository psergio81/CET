package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.EnsaioDao;
import br.com.cet.vo.EnsaioVo;

public class Ensaio {

	public List<EnsaioVo> getListaEnsaio(EnsaioVo ensaioVo, boolean filtrar)
			throws Exception {

		List<EnsaioVo> listaEnsaio = null;

		try {

			EnsaioDao ensaioDao = new EnsaioDao();
			listaEnsaio = ensaioDao.getListaEnsaios(ensaioVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaEnsaio;

	}

	public List<EnsaioVo> getListaEnsaiosPendente(EnsaioVo ensaioVo)
			throws Exception {
		
		List<EnsaioVo> listaEnsaio = null;
		
		try {
			
			EnsaioDao ensaioDao = new EnsaioDao();
			listaEnsaio = ensaioDao.getListaEnsaiosPendente(ensaioVo);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		return listaEnsaio;
		
	}
	
	public EnsaioVo getEnsaioPeloCodigo(String codigoEnsaio) throws Exception{
		
		EnsaioVo ensaioVo = new EnsaioVo();
		
		try{
			
			EnsaioDao ensaioDao = new EnsaioDao();
			ensaioVo.setCodigoEnsaio(codigoEnsaio);
			
			ensaioVo = ensaioDao.getEnsaioPeloCodigo(ensaioVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return ensaioVo;
		
	}
	
	public void insertEnsaio(EnsaioVo ensaioVo) throws Exception{
		
		try{
			
			EnsaioDao ensaioDao = new EnsaioDao();
			String codigoEnsaio;
			codigoEnsaio = String.valueOf(ensaioDao.getProximoCodigo(ensaioVo.getCodigoEmpresa()));

			ensaioVo.setCodigoEnsaio(codigoEnsaio);
			ensaioDao.insertEnsaios(ensaioVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateEnsaio(EnsaioVo ensaioVo) throws Exception{
		
		try{
			
			EnsaioDao ensaioDao = new EnsaioDao();
			ensaioDao.updateEnsaios(ensaioVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEnsaio(EnsaioVo ensaioVo){
		
		try {
			
			EnsaioDao ensaioDao = new EnsaioDao();
			ensaioDao.deleteEnsaio(ensaioVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getQuantidadeEnsaios(String codigoEmpresa){

		int quantidadeEnsaios = 0 ;
		EnsaioVo ensaioVo = new EnsaioVo();
		try {
			
			EnsaioDao ensaioDao = new EnsaioDao();
			quantidadeEnsaios = ensaioDao.getQuantidadeEnsaios(ensaioVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantidadeEnsaios;
		
	}
	
	public List<EnsaioVo> verificaEnsaiosCadastrados(List<EnsaioVo> listaEnsaio) throws Exception {

		try {

			EnsaioDao ensaioDao = new EnsaioDao();
			listaEnsaio = ensaioDao.verificaEnsaiosCadastrados(listaEnsaio);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaEnsaio;

	}

	public EnsaioVo verificaGruCadastrada(EnsaioVo ensaioVo) {
		
		EnsaioDao ensaioDao = new EnsaioDao();
		
		return ensaioDao.verificaGruCadastrada(ensaioVo);
		
	}

}
