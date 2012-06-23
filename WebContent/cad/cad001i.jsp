<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>(cad001i.jsp) Cadastro de OS</title>
</head>
<body>
cadastro empresa
 <br><br>
	<s:form action="Cad001Action!crud.action">
	   <s:textfield name="empresaVo.nomeEmpresa" label="Nome Empresa" /><br/>
	   <s:textfield name="empresaVo.codigoEmpresa" label="Codigo Empresa" /><br/>
	   <s:submit/>
	</s:form>
	<br>
	<s:a action="Cad001Action!browser.action">ir ao browser</s:a>
</body>
</html>