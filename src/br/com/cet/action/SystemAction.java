package br.com.cet.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SystemAction extends ActionSupport implements Preparable,SessionAware,RequestAware, ApplicationAware{
	
//	protected HttpServletRequest request;
//	protected HttpServletResponse response; 
	
	protected Map<String, Object> session;
	protected Map<String,Object> request;

	protected String ac;
	protected String rowid;
	
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

	@Override
	public void prepare() throws Exception {
		
	}
	
	public Map<String,Object> getSession(){
		return session;
	}
	
	public Map<String,Object> getRequest(){
		return request;
	}


	
}
