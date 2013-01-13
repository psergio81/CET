package br.com.cet.action;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends RecursoPadraoAction{
	
	public void prepare() throws Exception{
		super.prepare();
	}
	
	
	public String logout() throws Exception{
	
		SessionMap sessao = (SessionMap)ActionContext.getContext().get(ActionContext.SESSION);
		sessao.invalidate();
		
		return SUCCESS;
		
	}
}
