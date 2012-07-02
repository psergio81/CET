<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		   
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
		<title>(cad001b.jsp) Cadastro de OS</title>
		
		<script src="/CET/padrao/jquery/jquery.js" type="text/javascript"></script>
		<script src="/CET/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
		<script src="/CET/padrao/bootstrap/js/bootstrap.js"></script>
		
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
		
	</head>
	
	<body>
	
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="row">
				<div class="span4">
					<a class="btn btn-info" href="#">
						<i class="icon-search icon-white">
						</i>
						Browser
					</a>
				</div>
				
				<div class="span12" align="right">
					<button class="btn btn-large disabled">Cadastro Empresa</button>
				</div>
			</div>
     	</div>
	</div>
	
	<div class="container">
	
		<div><br><br><br></div>
		
		<table width="100%" class="table table-bordered">

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
	</div>
	
	<div class="navbar navbar-fixed-bottom">
		<div class="navbar-inner">
     	</div>
	</div>
	
	</body>
</html>