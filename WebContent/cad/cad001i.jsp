
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
	      	width: 120px;
	      
	      }
	      
	      .input, select{
			margin-right: 20px;	      
	      }
	      
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
			 		<label class="label">Razão Social</label>
					<input type="text" class="input-500 focused input" required="required">

			 		<label class="label">Nome Fantasia</label>
					<input type="text" class="input-320 focused input">
				</p>
				<p>
			 		<label class="label">Endereço</label>
					<input type="text" class="input-700 focused input">
	
			 		<label class="label">Número</label>
					<input type="text" id="numero" name="numero" class="input input-120">
				</p>
				<p>
			 		<label class="label">Complemento</label>
					<input type="text" class="input-300 focused input">
	
			 		<label class="label">Bairro</label>
					<input type="text" class="input-245 focused input">

			 		<label class="label">CEP</label>
					<input type="text" id="cep" name="cep" class="input-120 focused input">
				</p>
	
				<p>
			 		<label class="label">Cidade</label>
					<input type="text" class="input-300 focused input">
	
			 		<label class="label">Estado</label>
			 		<select class="input-245 focused">
			 			<option value="0"></option>
			 			<option value="1">São Paulo</option>
			 		</select>

			 		<label class="label">Telefone</label>
					<input id="telefone" type="tel" class="input-120 focused input">
				</p>

				<p>
			 		<label class="label">Fax</label>
					<input type="tel" class="input-120 focused input">
					
			 		<label class="label">Site</label>
					<input type="text" class="input-300 focused input">
	
			 		<label class="label">E-mail</label>
					<input type="email" class="input-245 focused input">

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
		$('#telefone').mask('(99) 9999-9999?9');
		$('#fax').mask('(99) 9999-9999?9');
	
	});

	function salvarCadastro(){
		alert('função não implementada!');		
	}

	function cancelarCadastro(){
		alert('função não implementada!');		
	}
	
</script>
	
</html>