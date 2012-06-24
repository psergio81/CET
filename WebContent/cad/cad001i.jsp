
<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">

<meta charset="utf-8">
	    <title>(cad001i.jsp) Cadastro de OS</title>
	   
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
		<script src="/CET/padrao/jquery/jquery.js" type="text/javascript"></script>
		<script src="/CET/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
		<script src="/CET/padrao/bootstrap/js/bootstrap.js"></script>
		
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
		<style type="text/css">
	      body {
	        padding-top: 60px;
	        padding-bottom: 40px;
	        background-color: #f5f5f5;
	      }
	      
	      .btn{
	      	 width: 80px;
	      }
	      
	      .btn-large{
	      	width: 300px;
	      	
	      }
	      .label{
	      	width: 85px;
	      
	      .
	      
	    </style>
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap-responsive.css">

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
				<div class="span4" align="center">
					<a class="btn btn-danger" href="javaScript:cancelarCadastro();">
						<i class="icon-remove icon-white">
						</i>
						Cancelar
					</a>
					<a class="btn btn-success" href="javaScript:salvarCadastro();">
						<i class="icon-ok icon-white">
						</i>
						Salvar
					</a>
				</div>
				<div class="span4" align="right">
					<button class="btn btn-large disabled">Cadastro Empresa</button>
				</div>
			</div>
     	</div>
	</div>
	
	<div class="container">
		<form action="Cad001Action!crud.action" class="well form-inline">
			<fieldset>
				<p>
			 		<label class="label">Nome</label>
					<input type="text" class="input-600 focused input">
		
				</p>
				<p>
			 		<label class="label">Endereço</label>
					<input type="text" class="input-400 focused">
	
			 		<label class="label">Número</label>
					<input type="text" id="numero" name="numero" class="input input-100">
				</p>
				<p>
			 		<label class="label">Complemento</label>
					<input type="text" class="input-300 focused">
	
			 		<label class="label">Bairro</label>
					<input type="text" class="input-200 focused">
				</p>
	
				<p>
			 		<label class="label">CEP</label>
					<input type="text" id="cep" name="cep" class="input-100 focused">
	
			 		<label class="label">Cidade</label>
					<input type="text" class="input-200 focused">
	
			 		<label class="label">Estado</label>
					<input type="text" class="input-100 focused">
				</p>
				
			</fieldset>
		</form>
	</div>

	<s:form action="Cad001Action!crud.action">
	   <s:textfield name="empresaVo.codigoEmpresa" label="Codigo" /><br/>
	   <s:textfield name="empresaVo.nomeEmpresa" label="Nome" /><br/>
	   <s:submit/>
	</s:form>
	<br>
	<s:a action="Cad001Action!browser.action">ir ao browser</s:a>
	
	<div class="navbar navbar-fixed-bottom">
		<div class="navbar-inner">
     	</div>
	</div>
</body>

<script type="text/javascript">

	$(function($){
		
		$('#cep').mask('99999-999');
	
	});

	function salvarCadastro(){
		alert('função não implementada!');		
	}

	function cancelarCadastro(){
		alert('função não implementada!');		
	}
	
</script>
	
</html>