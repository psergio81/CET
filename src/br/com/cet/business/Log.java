package br.com.cet.business;

import java.net.InetAddress;
import java.net.UnknownHostException;

import br.com.cet.dao.LogDao;
import br.com.cet.util.UtDataHora;
import br.com.cet.util.UtString;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;
import br.com.cet.vo.log.LogVo;

public class Log {
	
	private LogVo logVo = null;
	private UsuarioVo usuarioLogadoVo;
	private EmpresaVo empresaLogadaVo;
	
	public Log(UsuarioVo usuarioLogadoVo, EmpresaVo empresaLogadaVo){
		
		logVo 				 = new LogVo();
		this.empresaLogadaVo = empresaLogadaVo;
		this.usuarioLogadoVo = usuarioLogadoVo;
		
	}
	
	
	
	public void salvarLog(String acao, String descricao, String codigoPrograma  ){
		
		logVo.setCodigoEmpresa( empresaLogadaVo.getCodigoEmpresa() );
		logVo.setAcaoLog(acao);
		logVo.setDescricaoLog(descricao);
		logVo.setIpLog( this.getIp() );
		logVo.setDataLog( UtDataHora.getDataAtual() );
		logVo.setHoraLog( null );
		logVo.setCodigoPrograma( codigoPrograma );
		logVo.setCodigoUsuarioCriador( usuarioLogadoVo.getCodigoUsuario() );
		
		if(informacoesValidasParaGravarLog()){
			
			this.gravarLog(logVo);
			
		}else{
			
			System.out.println("Nao gravou log, por nao ter todas informacoes validas");
			
		}
	}
	
	private void gravarLog(LogVo logVo) {
		
		LogDao logDao = new LogDao();
		
		logVo.setCodigoLog( String.valueOf( logDao.getProximoCodigo() ) );
		
		try {
			
			logDao.insertLog(logVo);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private boolean informacoesValidasParaGravarLog(){
		
		if(UtString.isNullOrEmpty(logVo.getCodigoEmpresa())){
			return false;
		}
		
		if(UtString.isNullOrEmpty(logVo.getCodigoPrograma())){
			return false;
		}
		
		if(UtString.isNullOrEmpty(logVo.getCodigoUsuarioCriador())){
			return false;
		}
		
		if(UtString.isNullOrEmpty(logVo.getAcaoLog())){
			return false;
		}
		
		return true;
		
	}
	
	private String getIp(){
		
		try {
			
			return InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
