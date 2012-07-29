<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  taglib  prefix="c"   uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>[cad001i.jsp] Cadastro de Empresa</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
   	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

	<script src="/CET/padrao/jquery/jquery.js" type="text/javascript"></script>
	<script src="/CET/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
	<script src="/CET/padrao/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="/CET/padrao/bootstrap/js/bootstrap-modal.js" type="text/javascript"></script>
	<script src="/CET/padrao/scripts/script.js"></script>

   	<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap-responsive.css">
   	<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
   	
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        
        label{
        	width: 100px;
        }
        
        p{
        	height: 40px;
        }
        
    </style>
</head>
<body>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="row">
			<div class="span4">
				<a class="btn btn-info" href="javaScript:irParaBrowser('cad001');">
					<i class="icon-search icon-white">
					</i>
					<fmt:message key="label.padrao.busca"/>
				</a>
			</div>
			<div class="span4" align="center">
				<a id="botaoCancelar" class="btn btn-danger" href="javaScript:cancelarCadastro();">
					<i class="icon-remove icon-white"></i>
					<span id="textoBtnCancelarExcluir"><fmt:message key="label.padrao.cancelar"/></span>
				</a>
				<a id="botaoSalvar" class="btn btn-success" href="javaScript:salvarCadastro();">
					<i class="icon-ok icon-white"></i>
					<span id="textoBtnSalvarAlterar"><fmt:message key="label.padrao.salvar"/></span>
				</a>
			</div>
			
			
			<div class="pull-right">
				<button class="descricaoTela"><s:property value="nomePrograma"/></button>
			</div>
		</div>
    	</div>
</div>

<div class="container-fluid">
        <div class="container" id="container">

            <s:form id="cad001" action="Cad001Action!crud.action" theme="simple" cssClass="well form-inline">
                <s:hidden name="ac" id="ac"/>
                <s:hidden name="mensagemErro" id="mensagemErro" value="%{mensagemErro}"/>

                <p>
					<label for="codigoEmpresa" class="label"><fmt:message key="label.padrao.codigo"/></label>
					<s:textfield name="empresaVo.codigoEmpresa" id="codigoEmpresa" cssClass="input-mini" readonly="true" />

                	<label for="razaoSocial" class="label"><fmt:message key="label.padrao.razao.social"/></label>
	                <s:textfield name="empresaVo.razaoSocial" required="true" id="razaoSocial" cssClass="input-xlarge required" />

                	<label for="nomeFantasia" class="label"><fmt:message key="label.padrao.nome.fantasia"/></label>
	                <s:textfield name="empresaVo.nomeFantasia" id="nomeFantasia" required="required" cssClass="input-305 required" />
				</p>


				<p>
                	<label for="cep" class="label"><fmt:message key="label.padrao.cep"/></label>
	                <s:textfield name="empresaVo.cep" id="cep" required="required" cssClass="input-small" />
				
                	<label for="endereco" class="label"><fmt:message key="label.padrao.endereco"/></label>
	                <s:textfield name="empresaVo.endereco" id="endereco" required="required" cssClass="input-xxlarge" />
				
                	<label for="numero" class="label"><fmt:message key="label.padrao.numero"/></label>
	                <s:textfield name="empresaVo.numero" id="numero" required="required" cssClass="input-small" />
				</p>

				<p>
                	<label for="complemento" class="label"><fmt:message key="label.padrao.complemento"/></label>
	                <s:textfield name="empresaVo.complemento" id="complemento" required="required" cssClass="input-large" />
				
                	<label for="bairro" class="label"><fmt:message key="label.padrao.bairro"/></label>
	                <s:textfield name="empresaVo.bairro" id="bairro" required="required" cssClass="input-large" />
				
                	<label for="cidade" class="label"><fmt:message key="label.padrao.cidade"/></label>
	                <s:textfield name="empresaVo.cidade" id="cidade" required="required" cssClass="input-275" />
				</p>

				<p>
	               	<label for="estado" class="label"><fmt:message key="label.padrao.estado"/></label>
	                <s:textfield name="empresaVo.estado" id="estado" required="required" cssClass="input-large" />
				
                	<label for="telefone" class="label"><fmt:message key="label.padrao.telefone"/></label>
	                <s:textfield name="empresaVo.telefone" id="telefone" required="required" cssClass="input-large" />
				
                	<label for="fax" class="label"><fmt:message key="label.padrao.fax"/></label>
	                <s:textfield name="empresaVo.fax" id="fax" required="required" cssClass="input-275" />
				</p>


				<p>
                	<label for="website" class="label"><fmt:message key="label.padrao.website"/></label>
	                <s:textfield name="empresaVo.webSite" id="website" required="required" cssClass="input-xxlarge" />
				
                	<label for="email" class="label"><fmt:message key="label.padrao.email"/></label>
	                <s:textfield name="empresaVo.email" id="email" required="required" cssClass="input-400" />
				</p>
	
            </s:form>

			<div id="divErros" class="well alert alert-error" style="overflow; position:absolute; display: block; width: 300px;" >
				<ul id="listaErros" > </ul>  
			</div>
			
        </div>
    </div>

	<div class="modal hide" id="myModal">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal">×</button>
	    <h3>Confirmação de exclusão</h3>
	  </div>
	  <div class="modal-body">
	    <p>Deseja realmente excluir este cadastro?</p>
	  </div>
	  <div class="modal-footer">
	    <a href="#" class="btn" data-dismiss="modal"><fmt:message key="label.padrao.cancelar"/></a>
	    <a href="javascript:excluirCadastro()" class="btn btn-primary"><fmt:message key="label.padrao.ok"/></a>
	  </div>
	</div>

	<div class="modal hide" id="modalMensagem">
	  <div class="modal-body">
	    <h3 id="mensagem"></h3>
	  </div>
	  <div class="modal-footer">
	    <a href="#" class="btn btn-primary" data-dismiss="modal"><fmt:message key="label.padrao.ok"/></a>
	  </div>
	</div>

    <div class="navbar navbar-fixed-bottom">
    	<div class="navbar-inner">
    		<div class="pull-right">
				<button class="descricaoTela"><s:property value="usuarioLogado"/></button>
			</div>
    	
    	</div>
    </div>

<script type="text/javascript">

	$(document).ready(function(){
		
		var acao = $('#ac').val();
		var mensagem = $('#mensagemErro').val();
		
		
		if(mensagem != null && mensagem != ''){
			$('#mensagem').html(mensagem);
			$('#modalMensagem').modal('show');
		}
		
		
		if(acao == 'excluir'){
			irParaBrowser('cad001');
		}
		
		$('#divErros').css('display','none');
		
		$('#cad001').validate({

			
		  unhighlight: function(element, errorClass) {
		    if (this.numberOfInvalids() == 0) {
		      $("#divErros").hide();
		    }
		    $(element).removeClass(errorClass);
		  },
		  errorPlacement: function(error,element) {
			  return true;
		  },
			
			errorLabelContainer: "#listaErros",
			errorElement: "li",
			
            rules:{
            	"empresaVo.razaoSocial":{
                	required:true
                },
                "empresaVo.nomeFantasia":{
                	required:true
                }
                
            },
            messages:{
            	"empresaVo.razaoSocial":{
                    required: "O campo Razão Social é obrigatório."	
                },
                "empresaVo.nomeFantasia":{
                    required: "O campo Nome Fantasia é obrigatório."	
                }
            }
	    });
		
		var $acao = $('#ac').val();
		
		if($acao == ''){
			
			$('#codigoEmpresa').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
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
		
		if(buscaProximoCampo() == true){
			
			$('#divErros').slideUp(function(){
				$('#divErros').css('display','none');
			});
			
		}else{
			
			$('#divErros').fadeIn(1000).delay(1000).fadeOut('slow');
			
		}
		
		if($codigo == 'novo'){
			$('#ac').val("saveInclusao");
		}else{
			$('#ac').val("saveAlteracao");
		}	
		
		$('#cad001').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad001').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class|="input"][id!="codigoEmpresa"]').removeAttr('readonly');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoEmpresa').val();
		
		if($codigo == 'novo'){
			 $("#cad001").validate().cancelSubmit = true;
			this.irParaBrowser('cad001');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoEmpresa"]').attr('readonly','true');
			
			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad001').attr("action","Cad001Action!browser.action");
		$('#cad001').validate().cancelSubmit = true;
		$('#cad001').submit();
		
	}

	
</script>
</body>
</html>