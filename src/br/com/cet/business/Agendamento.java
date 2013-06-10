package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.AgendamentoDao;
import br.com.cet.vo.AgendamentoVo;

public class Agendamento {

	public List<AgendamentoVo> getListaAgendamento(AgendamentoVo agendamentoVo, boolean filtrar)
			throws Exception {

		List<AgendamentoVo> listaAgendamento = null;

		try {

			AgendamentoDao agendamentoDao = new AgendamentoDao();
			listaAgendamento = agendamentoDao.getListaAgendamentos(agendamentoVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaAgendamento;

	}
	
	public AgendamentoVo getAgendamentoPeloCodigo(String codigoAgendamento) throws Exception{
		
		AgendamentoVo agendamentoVo = new AgendamentoVo();
		
		try{
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			agendamentoVo.setCodigoAgendamento(codigoAgendamento);
			
			agendamentoVo = agendamentoDao.getAgendamentoPeloCodigo(agendamentoVo);
			
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return agendamentoVo;
		
	}
	
	public void insertAgendamento(AgendamentoVo agendamentoVo) throws Exception{
		
		try{
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			String codigoAgendamento;
			codigoAgendamento = String.valueOf(agendamentoDao.getProximoCodigo(agendamentoVo.getCodigoEmpresa()));

			agendamentoVo.setCodigoAgendamento(codigoAgendamento);
			agendamentoDao.insertAgendamentos(agendamentoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateAgendamento(AgendamentoVo agendamentoVo) throws Exception{
		
		try{
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			agendamentoDao.updateAgendamentos(agendamentoVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAgendamento(AgendamentoVo agendamentoVo){
		
		try {
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			agendamentoDao.deleteAgendamento(agendamentoVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
