package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.VeiculoTacografoDao;
import br.com.cet.vo.VeiculoTacografoVo;

public class VeiculoTacografo {

	
	public void insertVeiculoTacografo(VeiculoTacografoVo veiculoTacografoVo) throws Exception{
		
		try{
			
			VeiculoTacografoDao veiculoTacografoDao = new VeiculoTacografoDao();
			String codigoTacografo;
			codigoTacografo = String.valueOf(veiculoTacografoDao.getProximoCodigo(veiculoTacografoVo.getCodigoEmpresa()));

			veiculoTacografoVo.setCodigoVeiculoTacografo(codigoTacografo);
			veiculoTacografoVo.setCodigoTacografo(veiculoTacografoVo.getCodigoTacografo());
			veiculoTacografoDao.inativaTacografoAtualDoVeiculo(veiculoTacografoVo);
			veiculoTacografoDao.insertVeiculoTacografo(veiculoTacografoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<VeiculoTacografoVo> getTacografosDeUmVeiculo(VeiculoTacografoVo veiculoTacografoVo) throws Exception {

		List<VeiculoTacografoVo> listaTacografo = null;

		try {

			VeiculoTacografoDao veiculoTacografoDao = new VeiculoTacografoDao();
			listaTacografo = veiculoTacografoDao.getTacografosDeUmVeiculo(veiculoTacografoVo);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaTacografo;

	}

}
