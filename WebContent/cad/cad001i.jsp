
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
					<a class="btn btn-info" href="javaScript:irParaBrowser();">
						<i class="icon-search icon-white"/>
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
		<s:form id="cad001" name="cad001" action="Cad001Action!crud.action" class="well form-inline">
			<fieldset>
				<p>
			 		<label class="label">Razão Social</label>
					<input id="razaoSocial" name="razaoSocial" type="text" class="input-500 focused input" required="required">

			 		<label class="label">Nome Fantasia</label>
					<s:textfield name="empresaVo.nomeEmpresa"  id="nomeEmpresa" class="input-320 focused input"/>
				</p>
				<p>
			 		<label class="label">Endereço</label>
					<input id="endereco" name="endereco" type="text" class="input-700 focused input">
	
			 		<label class="label">Número</label>
					<input id="numero" name="numero" type="text" class="input input-120">
				</p>
				<p>
			 		<label class="label">Complemento</label>
					<input id="complemento" name="complemento" type="text" class="input-300 focused input">
	
			 		<label class="label">Bairro</label>
					<input id="bairro" name="bairro" type="text" class="input-245 focused input">

			 		<label class="label">CEP</label>
					<input  id="cep" name="cep" type="text" class="input-120 focused input">
				</p>
	
				<p>
			 		<label class="label">Cidade</label>
					<input id="cidade" name="cidade" type="text" class="input-300 focused input" required="required">
	
			 		<label class="label">Estado</label>
			 		<select id="estado" name="estado" class="text required">
			 			<option value="">Selecione um Estado...</option>
			 			<option value="1">São Paulo</option>
			 		</select>

			 		<label class="label">Telefone</label>
					<input id="telefone" name="telefone" type="tel" class="input-120 focused input" required="required">
				</p>

				<p>
			 		<label class="label">Fax</label>
					<input id="fax" name="fax" type="tel" class="input-120 focused input" required="required">
					
			 		<label class="label">Site</label>
					<input id="site" name="site" type="text" class="input-300 focused input">
	
			 		
			 		<div class="input-prepend">
			 		
			 			<label class="label">E-mail</label>
			 			
				 		<span class="add-on">
				 			<i class="icon-envelope"></i>
				 		</span>
				 		
						<input id="email" name="email" type="email" class="input-245 focused input">
						
					</div>
				</p>
				
			</fieldset>
		</s:form>
	</div>


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
		buscaProximoCampo();
	}

	function cancelarCadastro(){
		alert('função não implementada!');		
	}

	function irParaBrowser(){
		
		$('#cad001').attr("action","Cad001Action!browser.action");
		$('#cad001').submit();
		
	}

	// Busca os campos requeridos no formulario e caso não esteja preenchido emite um alerta(provisório) e move o foco para o campo
	function buscaProximoCampo(){
		
		$('input:required, .required').each(function(i,obj){

			if(this.value == ''){
				alert("Campo Obrigatório!");
				this.focus();
				return false;
			}
			
		});
		
	}
	
</script>
	
</html>