<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>[cad003i.jsp] Cadastro de Modelo</title>

   	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
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
		<div class="row">
			<div class="span4">
				<a class="btn btn-info" href="javaScript:irParaBrowser('cad003');">
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
		
		    <s:form id="cad003" action="Cad003Action!crud.action" theme="simple" cssClass="well form-inline">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="modeloVo.codigoModelo"/>
		        
		        <p>
		        	<label for="codigoModelo" class="label"><fmt:message key="label.padrao.codigo"/></label>
		         	<s:textfield name="modeloVo.codigoModelo" id="codigoModelo" cssClass="input-mini" disabled="true" />
		
		        	<label for="descricao" class="label"><fmt:message key="label.padrao.descricao"/></label>
		         	<s:textfield name="modeloVo.descricao" id="descricao" required="required" cssClass="input-xxlarge" />
		        
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
			irParaBrowser('cad003');
		}
		
		$('#divErros').css('display','none');
		
		$('#cad003').validate({

			
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
            	"modeloVo.descricao":{
                	required:true
                }
                
            },
            messages:{
            	"modeloVo.descricao":{
                    required: "O campo Descrição é obrigatório."	
                }
            }
	    });
		
		var $acao = $('#ac').val();
		
		if($acao == ''){
			
			$('#codigoModelo').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			
			$('input[class|="input"][id!="codigoModelo"]').attr('disabled','true');
			
		}
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoModelo').val();
		
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
		
		$('#cad003').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad003').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class|="input"][id!="codigoModelo"]').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoModelo').val();
		
		if($codigo == 'novo'){
			 $("#cad003").validate().cancelSubmit = true;
			this.irParaBrowser('cad003');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoModelo"]').attr('disabled','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad003').attr("action","Cad003Action!browser.action");
		$('#cad003').validate().cancelSubmit = true;
		$('#cad003').submit();
		
	}

	
</script>
</body>
</html>