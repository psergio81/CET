package br.com.cet.business.relatorio;

import java.util.List;

import br.com.cet.dao.LogDao;
import br.com.cet.vo.filtro.FiltroLogVo;
import br.com.cet.vo.log.LogVo;

public class RelatorioLog{

	public List<LogVo> getRelatorioLog(FiltroLogVo filtroVo){
		
		LogDao logDao = new LogDao();
		
		List<LogVo> lista = logDao.getListaLogPorTodos(filtroVo.getCodigoEmpresa(), filtroVo.getCodigoPrograma(), filtroVo.getCodigoUsuario(), filtroVo.getBuscaTextoPadrao(), filtroVo.getDataInicial(), filtroVo.getDataFinal());
		
		
		return lista;
	}
	

}
