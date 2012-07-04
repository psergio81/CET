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
		<script src="/CET/padrao/bootstrap/js/bootstrap.js"></script>
		<script src="/CET/padrao/bootstrap/js/bootstrap-dropdown.js"></script>
		
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
		
		 <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
   		 <!--[if lt IE 9]>
	      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
		
		<style>
		 body {
        	padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      	 }
      	 </style>
      	 
	</head>
	
	<body>
	
	
	
	<div class="navbar navbar-fixed-top">
	
		<div class="navbar-inner">
		
			 <div class="container">
			 
			 	<a class="brand" href="#">
  					Ensaio
				</a>
				
				<ul class="nav nav-pills">
				
					<li class="active"><a href="#">Regular link</a></li>
					
				  	<li class="dropdown" id="menu1">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">Dropdown<b class="caret"></b></a>
					    <ul class="dropdown-menu">
					    	<li><a href="#">Action</a></li>
					      	<li><a href="#">Another action</a></li>
					      	<li><a href="#">Something else here</a></li>
					      	<li class="divider"></li>
					      	<li><s:a action="Cad001Action!crud.action">cadastro de empresa- crud</s:a></li>
					    </ul>
				  	</li>
				</ul>
				
				<form class="navbar-search pull-left">
  					<input type="text" class="search-query" placeholder="Search">
				</form>
			 </div>
		
     	</div>
     	
	</div>
	
	<div class="container">
		
		<table width="100%" class="table table-bordered table-striped ">

			<thead>
				<tr>
					<th width="20%">Codigo</th>
					<th width="*">Nome</th>
				</tr>
			</thead>
			
			<tbody>
				<s:iterator  value="listaEmpresa" status="status">
					<tr>
						<td><s:property value="codigoEmpresa" /></td>
						<td><a href="Cad001Action!crud.action?ac=con&codigoEmpresaSelecionado=1"><s:property value="nomeEmpresa" /></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	
	</div>
	
	<div class="navbar navbar-fixed-bottom">
		<div class="navbar-inner">
     	</div>
	</div>
	
	</body>
</html>

<script>
$('.dropdown-toggle').dropdown();

function selBrowser(codigo){
	
}
</script>