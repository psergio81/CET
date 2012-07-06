<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <sb:head/>
</head>

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
	      
	      .label{
	      	width: 150px;
	      }
	      
	    </style>
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap-responsive.css">

<body>



	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="row">
				<div class="span4">
					<a class="btn btn-info" href="javaScript:irParaBrowser();">
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
		<s:form action="Cad001Action!crud.action" theme="bootstrap" cssClass="well form-horizontal" >
			
			<s:textfield name="empresaVo.nomeEmpresa" label="Razão Social" id="razaoSocial" required="required" cssClass="input-500 "/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Nome Fantasia" id="razaoSocial" required="required" cssClass="input-500"/>

			<s:textfield name="empresaVo.nomeEmpresa" label="Endereço" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Número" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Complemento" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Bairro" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Cidade" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Estado" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Telefone" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Fax" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="WebSite" id="razaoSocial" required="required" cssClass="input-500"/>
			<s:textfield name="empresaVo.nomeEmpresa" label="Email" id="razaoSocial" required="required" cssClass="input-500"/>
			
		</s:form>
	</div>

	<div id="classeErro" class="alert alert-error" hidden="true">
		<a class="close" data-dismiss="alert" href="#">×</a>
		<h4 class="alert-heading">Erro!</h4>
	  		Campos Obrigatórios!
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
				
				$('#classeErro').fadeIn(3000,function(){
					$('#classeErro').fadeOut(3000);		
				});
				
				this.focus();
				return false;
			}
			
		});
	}
	
</script>
	
</html>