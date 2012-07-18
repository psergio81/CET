<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  taglib  prefix="c"   uri="/struts-tags" %>    
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>[cad002i.jsp] Cadastro de Marca</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <sb:head/>
    
   	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

	<script src="/CET/padrao/jquery/jquery.js" type="text/javascript"></script>
	<script src="/CET/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
	<script src="/CET/padrao/jquery/jquery.validate.js" type="text/javascript"></script>
		
   	<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap-responsive.css">
   	<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        
    </style>
</head>
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
				<a id="botaoSalvar" class="btn btn-success" href="javaScript:salvarCadastro();">
					<i class="icon-ok icon-white"></i>
					<span id="textoBtnSalvarAlterar">Salvar</span>
				</a>
			</div>
			
			
			<div class="pull-right">
				<button class="descricaoTela">Cadastro Marca</button>
			</div>
		</div>
    	</div>
</div>

<div class="container-fluid">
        <div class="container">

            <s:form id="cad002" action="Cad002Action!crud.action" theme="simple" cssClass="well form-inline">
                <s:hidden name="ac" id="ac"/>
                
                <p>
                	<label for="codigoMarca" class="label">Código</label>
	                <s:textfield name="marcaVo.codigoMarca" id="codigoMarca" cssClass="input-50" readonly="true" />

                	<label for="descricao" class="label">Descrição</label>
	                <s:textfield name="marcaVo.descricao" id="descricao" required="required" cssClass="input-200" />
                
                </p>

            </s:form>
        </div>
    </div>

    <div class="navbar navbar-fixed-bottom">
    	<div class="navbar-inner"></div>
    </div>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		var $acao = $('#ac').val();
		
		if($acao == ''){
			$('#codigoMarca').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
		}else{
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoMarca"]').attr('readonly','true');
			
		}
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoMarca').val();
		
		if($codigo == 'novo'){
			$('#ac').val("saveInclusao");
		}else{
			$('#ac').val("saveAlteracao");
		}	
		
		$('#cad002').submit();
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class|="input"][id!="codigoMarca"]').removeAttr('readonly');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoMarca').val();
		
		if($codigo == 'novo'){
			this.irParaBrowser();
		}else{
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoMarca"]').attr('readonly','true');
		}
	}

	function irParaBrowser(){
		
		$('#cad002').attr("action","Cad002Action!browser.action");
		$('#cad002').submit();
		
		
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
</body>
</html>