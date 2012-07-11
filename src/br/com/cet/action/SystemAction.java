package br.com.cet.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SystemAction extends ActionSupport implements Preparable,SessionAware,RequestAware, ApplicationAware{

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
	public void setRequest(Map<String, Object> arg0) {
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		
	}

	@Override
	public void prepare() throws Exception {
		
	}


	
}
