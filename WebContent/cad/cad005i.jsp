<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-tags" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ensaio" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>[cad005i.jsp] Cadastro de Veiculos</title>

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
        
    </style>
</head>
<body>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="row">
			<div class="span4">
				<a class="btn btn-info" href="javaScript:irParaBrowser('cad005');">
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
		<div class="container">
		
		    <s:form id="cad005" action="Cad005Action!crud.action" theme="simple" cssClass="well form-inline">
		        <s:hidden name="ac" id="ac"/>
		        
		        <p>
		        	<label for="codigoVeiculo" class="label"><fmt:message key="label.padrao.codigo"/></label>
		         	<s:textfield name="veiculoVo.codigoVeiculo" id="codigoVeiculo" cssClass="input-mini" readonly="true" />
		
		        	<label for="descricao" class="label"><fmt:message key="label.padrao.descricao"/></label>
		         	<s:textfield name="veiculoVo.descricao" id="descricao" required="required" cssClass="input-xxlarge" />
		        
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

    <ensaio:rodape descricao="${usuarioLogado}"/>

<script type="text/javascript">

	$(document).ready(function(){
		
		var acao = $('#ac').val();
		var mensagem = $('#mensagemErro').val();
		
		
		if(mensagem != null && mensagem != ''){
			$('#mensagem').html(mensagem);
			$('#modalMensagem').modal('show');
		}
		
		
		if(acao == 'excluir'){
			irParaBrowser('cad005');
		}
		
		$('#divErros').css('display','none');
		
		$('#cad005').validate({

			
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
            	"veiculoVo.descricao":{
                	required:true
                }
                
            },
            messages:{
            	"veiculoVo.descricao":{
                    required: "O campo Descrição é obrigatório."	
                }
            }
	    });
		
		var $acao = $('#ac').val();
		
		if($acao == ''){
			
			$('#codigoVeiculo').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			
			$('input[class|="input"][id!="codigoVeiculo"]').attr('readonly','true');
			
		}
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoVeiculo').val();
		
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
		
		$('#cad005').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad005').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class|="input"][id!="codigoVeiculo"]').removeAttr('readonly');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoVeiculo').val();
		
		if($codigo == 'novo'){
			 $("#cad005").validate().cancelSubmit = true;
			this.irParaBrowser('cad005');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoVeiculo"]').attr('readonly','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad005').attr("action","Cad005Action!browser.action");
		$('#cad005').validate().cancelSubmit = true;
		$('#cad005').submit();
		
	}

	
</script>
</body>
</html>