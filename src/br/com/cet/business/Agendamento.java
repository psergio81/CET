package br.com.cet.business;

import java.util.List;

import br.com.cet.dao.AgendamentoDao;
import br.com.cet.vo.AgendamentoVo;
import br.com.cet.vo.ConsultaGruVo;

public class Agendamento {

	public List<AgendamentoVo> getListaAgendamento(AgendamentoVo agendamentoVo, boolean filtrar) throws Exception {

		List<AgendamentoVo> listaAgendamento = null;

		try {

			AgendamentoDao agendamentoDao = new AgendamentoDao();
			listaAgendamento = agendamentoDao.getListaAgendamentos(agendamentoVo, filtrar);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return listaAgendamento;

	}
	
	public AgendamentoVo getAgendamentoPeloCodigo(AgendamentoVo agendamentoVo) throws Exception{
		
		try{
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			
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

	public List<AgendamentoVo> getAgendamentosPorDia(AgendamentoVo agendamentoVo) {
		
		try {
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			return agendamentoDao.getAgendamentosPorDia(agendamentoVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateStatusGru(ConsultaGruVo consultaGruVo){
		
		try {
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			agendamentoDao.updateStatusGru(consultaGruVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExisteGruCadastradoMesmoCodigo(AgendamentoVo agendamentoVo) {
		
		try {
			
			AgendamentoDao agendamentoDao = new AgendamentoDao();
			return agendamentoDao.isExisteGruCadastradoMesmoCodigo(agendamentoVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
