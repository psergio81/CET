package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.VeiculoDao;
import br.com.cet.vo.VeiculoVo;

public class Veiculo {

	public List<VeiculoVo> getListaVeiculo(VeiculoVo veiculoVo, boolean filtrar)
			throws Exception {

		List<VeiculoVo> listaVeiculo = null;

		try {

			VeiculoDao veiculoDao = new VeiculoDao();
			listaVeiculo = veiculoDao.getListaVeiculos(veiculoVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaVeiculo;

	}
	
	public VeiculoVo getVeiculoPeloCodigo(String codigoVeiculo) throws Exception{
		
		VeiculoVo veiculoVo = new VeiculoVo();
		
		try{
			
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoVo.setCodigoVeiculo(codigoVeiculo);
			
			veiculoVo = veiculoDao.getVeiculoPeloCodigo(veiculoVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return veiculoVo;
		
	}
	
	public void insertVeiculo(VeiculoVo veiculoVo) throws Exception{
		
		try{
			
			VeiculoDao veiculoDao = new VeiculoDao();
			String codigoVeiculo;
			codigoVeiculo = String.valueOf(veiculoDao.getProximoCodigo());

			veiculoVo.setCodigoVeiculo(codigoVeiculo);
			veiculoDao.insertVeiculos(veiculoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateVeiculo(VeiculoVo veiculoVo) throws Exception{
		
		try{
			
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.updateVeiculos(veiculoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVeiculo(VeiculoVo veiculoVo){
		
		try {
			
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculoDao.deleteVeiculo(veiculoVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}