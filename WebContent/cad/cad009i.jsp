<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	
	    <title>[cad009i.jsp] Cadastro de Programa</title>

	</head>
<body>
	<div class="navbar navbar-fixed-top">
	
		<es:menu mostrarNomePrograma="true"/>
		
		<es:botoes codigoPrograma="cad009" />
   	
	</div>

	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad009" action="Cad009Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="programaVo.codigoPrograma"/>
		        
		        <div class="control-group">
		        	<label for="codigoPrograma" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="programaVo.codigoPrograma" id="codigoPrograma" cssClass="input-mini" disabled="true" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="descricao" class="control-label"><fmt:message key="label.padrao.descricao"/></label>
   					<div class="controls">
			         	<s:textfield name="programaVo.descricao" id="descricao" required="required" cssClass="span4" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="descricao" class="control-label"><fmt:message key="label.padrao.descricao.menu"/></label>
   					<div class="controls">
			         	<s:textfield name="programaVo.descricaoMenu" id="descricaoMenu" required="required" cssClass="span4" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="descricao" class="control-label"><fmt:message key="label.padrao.descricao.action"/></label>
   					<div class="controls">
			         	<s:textfield name="programaVo.descricaoAction" id="descricaoAction" required="required" cssClass="span4" />
   					</div>
				</div>
		
		    </s:form>
		    
			<es:mensagemErro />
			
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

	<es:rodape descricao="${usuarioLogadoVo.nomeUsuario}"/>

<script type="text/javascript">

	$(document).ready(function(){
		
		var acao = $('#ac').val();
		
		if(acao == 'excluir'){
			irParaBrowser('cad009');
		}
		
		$('#divErros').hide();
		
		$('#cad009').validate({

			
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
            	"programaVo.descricao":{
                	required:true
                }
                
            },
            messages:{
            	"programaVo.descricao":{
                    required: "O campo Descrição é obrigatório."	
                }
            }
	    });
		
		
		if(acao == ''){
			
			$('#codigoPrograma').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			
			$('input[class*="span"],select').attr('disabled','true');
			
		}
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoPrograma').val();
		
		if(buscaProximoCampo() == true){
			
			$('#divErros').slideUp(function(){
				$('#divErros').hide();
			});
			
		}else{
			
			$('#divErros').fadeIn(1000).delay(1000).fadeOut('slow');
			
		}
		
		if($codigo == 'novo'){
			$('#ac').val("saveInclusao");
		}else{
			$('#ac').val("saveAlteracao");
		}	
		
		$('#cad009').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad009').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class*="span"][id!="codigoPrograma"]').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoPrograma').val();
		
		if($codigo == 'novo'){
			 $("#cad009").validate().cancelSubmit = true;
			this.irParaBrowser('cad009');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoPrograma"]').attr('disabled','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad009').attr("action","Cad009Action!browser.action");
		$('#cad009').validate().cancelSubmit = true;
		$('#cad009').submit();
		
	}

	
</script>
</body>
</html>