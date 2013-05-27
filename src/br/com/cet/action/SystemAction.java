package br.com.cet.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import br.com.cet.log.Log;
import br.com.cet.vo.EmpresaVo;
import br.com.cet.vo.UsuarioVo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SystemAction extends ActionSupport implements Preparable,SessionAware,RequestAware, ApplicationAware{
	
	
	protected HttpServletRequest requestOrigem;
	protected HttpServletResponse responseOrigem; 
	
	protected Map<String, Object> session;
	protected Map<String,Object> request;
	protected Map<String,Object> response;

	protected String ac;
	protected String rowid;
	
	protected Log log;
	protected UsuarioVo usuarioLogadoVo;
	protected EmpresaVo empresaLogadaVo;


	public void prepare() throws Exception{
		
		requestOrigem = ServletActionContext.getRequest();
		responseOrigem =ServletActionContext.getResponse();
		
		usuarioLogadoVo = (UsuarioVo) session.get("usuarioLogadoVo");
		empresaLogadaVo = (EmpresaVo) session.get("empresaLogadaVo");
		
		System.out.println("usuarioLogadoVo....: "+usuarioLogadoVo);
		
		
		log = new Log(usuarioLogadoVo, empresaLogadaVo);
	} 
	
	public void setEmpresaLogadaVo(EmpresaVo empresaLogadaVo) {
		this.empresaLogadaVo = empresaLogadaVo;
	}
	
	public EmpresaVo getEmpresaLogadaVo(){
		return empresaLogadaVo;
	}
	
	public UsuarioVo getUsuarioLogadoVo(){
		return usuarioLogadoVo;
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String,Object> getSession(){
		return session;
	}
	
	public Map<String,Object> getRequest(){
		return request;
	}

	public Map<String,Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String,Object> response) {
		this.response = response;
	}
	
}
