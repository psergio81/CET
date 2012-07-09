<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  taglib  prefix="c"   uri="/struts-tags" %>    
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>[cad001i.jsp] Cadastro de Empresa</title>

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
				<button class="descricaoTela">Cadastro Empresa</button>
			</div>
		</div>
    	</div>
</div>

<div class="container-fluid">
        <div class="container">

            <s:form id="cad001" action="Cad001Action!crud.action" theme="simple" cssClass="well form-inline">
                <s:hidden name="ac" id="ac"/>
                
                <p>
                	<label for="codigoEmpresa" class="label">Código</label>
	                <s:textfield name="empresaVo.codigoEmpresa" id="codigoEmpresa" cssClass="input-50" readonly="true" />

                	<label for="razaoSocial" class="label">Razão social</label>
	                <s:textfield name="empresaVo.razaoSocial" id="razaoSocial" required="required" cssClass="input-400" />
                
                	<label for="nomeFantasia" class="label">Nome fantasia</label>
	                <s:textfield name="empresaVo.nomeFantasia" id="nomeFantasia" required="required" cssClass="input-200" />
                </p>

				<p>
                	<label for="cep" class="label">CEP</label>
	                <s:textfield name="empresaVo.cep" id="cep" required="required" cssClass="input-100" />
	                
                	<label for="endereco" class="label">Endereço</label>
	                <s:textfield name="empresaVo.endereco" id="endereco" required="required" cssClass="input-500" />

                	<label for="numero" class="label">Número</label>
	                <s:textfield name="empresaVo.numero" id="numero" required="required" cssClass="input-50" />

                
                </p>

                <p>
                	<label for="complemento" class="label">Complemento</label>
	                <s:textfield name="empresaVo.complemento" id="complemento" required="required" cssClass="input-400" />
                	<label for="bairro" class="label">Bairro</label>
	                <s:textfield name="empresaVo.bairro" id="bairro" required="required" cssClass="input-400" />

                
                </p>

                <p>
                	<label for="cidade" class="label">Cidade</label>
	                <s:textfield name="empresaVo.cidade" id="cidade" required="required" cssClass="input-255" />

                	<label for="estado" class="label">Estado</label>
	                <s:textfield name="empresaVo.estado" id="estado" required="required" cssClass="input-50" />
	                
                	<label for="telefone" class="label">Telefone</label>
	                <s:textfield name="empresaVo.telefone" id="telefone" required="required" cssClass="input-100" />

                	<label for="fax" class="label">Fax</label>
	                <s:textfield name="empresaVo.fax" id="fax" required="required" cssClass="input-100" />
                
                </p>
                
                <p>
                	<label for="website" class="label">Web Site</label>
	                <s:textfield name="empresaVo.webSite" id="website" required="required" cssClass="input-500" />

                	<label for="email" class="label">E-mail</label>
	                <s:textfield name="empresaVo.email" id="email" required="required" cssClass="input-300" />
                
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
			$('#codigoEmpresa').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
		}else{
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoEmpresa"]').attr('readonly','true');
			
		}
		
		$('#cep').mask('99999-999');
		$('#telefone').mask('(99) 9999-9999?9');
		$('#fax').mask('(99) 9999-9999?9');
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoEmpresa').val();
		
		if($codigo == 'novo'){
			$('#ac').val("save_inc");
		}else{
			alert('Função de salvar alteração não implementada! - Clique em cancelar');
			$('#ac').val("save_alt");
			return;
		}	
		
		$('#cad001').submit();
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class|="input"][id!="codigoEmpresa"]').removeAttr('readonly');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoEmpresa').val();
		
		if($codigo == 'novo'){
			this.irParaBrowser();
		}else{
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoEmpresa"]').attr('readonly','true');
		}
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
</body>
</html>