package br.com.cet.action.helper;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResultJsonHelper {

	private final HttpServletResponse response;
	private String json;
	private PrintWriter out;

	public ResultJsonHelper(HttpServletResponse response){
		this.response = response;
	}
	
	public <T>void jsonDo(T bean){
		
		Gson gson = new Gson();
	    this.setJson(gson.toJson(bean));
	}

	
	public String getResultTypeJson() {
		try {
			response.setContentType("json");
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			out.print(getJson());
			out.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
