<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>(cad001b.jsp) Cadastro de OS</title>
	</head>
	
	<body>

		<table width="50%" border="1">

			<tr>
				<th width="20%">Codigo</th>
				<th width="*">Nome</th>
			</tr>
			
			<s:iterator  value="listaEmpresa" status="status">
				<tr>
					<td><s:property value="codigoEmpresa" /></td>
					<td><s:property value="nomeEmpresa" /></td>
				</tr>
			</s:iterator>
		</table>
	
	<s:a action="Cad001Action!crud.action">cadastro de empresa- crud</s:a>
	</body>
</html>