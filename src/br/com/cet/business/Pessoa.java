package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.PessoaDao;
import br.com.cet.vo.PessoaVo;

public class Pessoa {

	public List<PessoaVo> getListaPessoa(PessoaVo pessoaVo, boolean filtrar)
			throws Exception {

		List<PessoaVo> listaPessoa = null;

		try {

			PessoaDao pessoaDao = new PessoaDao();
			listaPessoa = pessoaDao.getListaPessoas(pessoaVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaPessoa;

	}
	
	public PessoaVo getPessoaPeloCodigo(String codigoPessoa) throws Exception{
		
		PessoaVo pessoaVo = new PessoaVo();
		
		try{
			
			PessoaDao pessoaDao = new PessoaDao();
			pessoaVo.setCodigoPessoa(codigoPessoa);
			
			pessoaVo = pessoaDao.getPessoaPeloCodigo(pessoaVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return pessoaVo;
		
	}
	
	public void insertPessoa(PessoaVo pessoaVo) throws Exception{
		
		try{
			
			PessoaDao pessoaDao = new PessoaDao();
			String codigoPessoa;
			codigoPessoa = String.valueOf(pessoaDao.getProximoCodigo());

			pessoaVo.setCodigoPessoa(codigoPessoa);
			pessoaDao.insertPessoas(pessoaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatePessoa(PessoaVo pessoaVo) throws Exception{
		
		try{
			
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.updatePessoas(pessoaVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePessoa(PessoaVo pessoaVo){
		
		try {
			
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.deletePessoa(pessoaVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getQuantidadePessoas(String codigoEmpresa){

		int quantidadePessoas = 0 ;
		PessoaVo pessoaVo = new PessoaVo();
		try {
			
			PessoaDao pessoaDao = new PessoaDao();
			quantidadePessoas = pessoaDao.getQuantidadePessoas(pessoaVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantidadePessoas;
	}

}
