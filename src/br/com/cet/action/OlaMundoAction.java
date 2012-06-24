package br.com.cet.action;
import com.opensymphony.xwork2.ActionSupport;

public class OlaMundoAction extends ActionSupport{
	
	public void prepare(){
		
		System.out.println("passou pelo prepare.........");
		
	}
	
	public String BoasVindas() throws Exception{
		
		System.out.println("passou pelo boas vindas.........");
		
		return SUCCESS;
	}

}
