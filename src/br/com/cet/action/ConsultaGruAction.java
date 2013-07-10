package br.com.cet.action;
import br.com.cet.action.helper.ResultJsonHelper;
import br.com.cet.business.Agendamento;
import br.com.cet.util.ConsultaGru;
import br.com.cet.vo.AgendamentoVo;
import br.com.cet.vo.ConsultaGruVo;

public class ConsultaGruAction extends RecursoPadraoAction{
	
	private String codigoGru;

	public String buscar() throws Exception{
		
		ConsultaGruVo consultaGruVo = new ConsultaGru(codigoGru).consulta();
		
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);
		resultJsonHelper.jsonDo(consultaGruVo);
		
		Agendamento agendamento = new Agendamento();
		
		agendamento.updateStatusGru(consultaGruVo);
		
		return resultJsonHelper.getResultTypeJson();
		
	}

	public String isExisteGruCadastradoMesmoCodigo() throws Exception{

		Agendamento agendamento = new Agendamento();
		
		AgendamentoVo agendamentoVo = new AgendamentoVo();
		agendamentoVo.setCodigoEmpresa(empresaLogadaVo.getCodigoEmpresa());
		agendamentoVo.setGru(codigoGru);
		
		
		boolean cadastradoMesmoCodigo = agendamento.isExisteGruCadastradoMesmoCodigo(agendamentoVo);
		
		ResultJsonHelper resultJsonHelper = new ResultJsonHelper(responseOrigem);
		resultJsonHelper.jsonDo(cadastradoMesmoCodigo);
		
		return resultJsonHelper.getResultTypeJson();
		
	}

	public String getCodigoGru() {
		return codigoGru;
	}

	public void setCodigoGru(String codigoGru) {
		this.codigoGru = codigoGru;
	}

}
