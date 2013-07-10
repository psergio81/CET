package br.com.cet.action;

import java.util.Map;

import br.com.cet.util.UtString;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor extends SystemAction implements Interceptor{

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 
		
		try{ 
			
			 Map<String, Object> session = invocation.getInvocationContext().getSession(); 
			
			 
	         if (session.containsKey("usuarioLogadoVo")) {
	        	 
//	        	 System.out.println("Usuario Existe na Sessao");
	        	 
	        	//esta if é para verificar os acessos do usuario, quando o mesmo for implementado
	        	
	         } else { 
//	        	 System.out.println("Usuario nao existe na sessao");
//	        	 System.out.println(invocation.getInvocationContext().getName());
	        	 
	        	 if(!UtString.equals(invocation.getInvocationContext().getName(), "LoginAction")){
	        		 return "login";
	        	 }
	        	 
	        	 
	         } 
	         
	        return invocation.invoke(); 
        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
    }  
	
//	@Override
//	public String intercept(ActionInvocation invocation) throws Exception {
//		 
//		System.out.println("Interceptor Login");
//		
//		try{ 
//			
//			 Map<String, Object> session = invocation.getInvocationContext().getSession(); 
//			
//	         if (session.containsKey("usuarioVo")) {
//	        	 
//	        	 System.out.println("Usuario Existe na Sessao");
//	        	 
//	        	//esta if é para verificar os acessos do usuario, quando o mesmo for implementado
//	        	
//	         } else {  
//	        	
//	            Map<String,Object> userParameters = ActionContext.getContext().getParameters();  
//	            
//	            String nick = userParameters.get("usuarioVo.nick").toString();
//	        	String senha = userParameters.get("usuarioVo.senha").toString();
//	            
//	            if (userParameters.size() > 0 && !UtString.isNullOrEmpty(nick) && !UtString.isNullOrEmpty(senha)) {  
//	            	
//	            	Usuario usuario = new Usuario();  
//	            	UsuarioVo usuarioVo = usuario.autenticacao(nick, senha);
//	                
//	                if (usuarioVo != null) {  
//	                	
//	                	System.out.println("Colocando Usuario Na Sesssao");
//	                	
//	                    invocation.getInvocationContext().getSession().put("usuarioVo", usuarioVo);  
//	                } else {  
//	                    try {  
//	                        throw new UsuarioNaoExisteException("Usuario ou senha não existem, tente novamente.");  
//	                    } catch (UsuarioNaoExisteException e) {  
//	                        e.printStackTrace();  
//	                    }  
//	                }  
//	            }else{
//	            	System.out.println("AQUIII ");
//	                return "login";  
//	            }  
//	        } 
//	         
//	        return invocation.invoke(); 
//        
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "login";
//    }  
}
