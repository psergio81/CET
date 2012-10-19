<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>

    	<title>[cad006i.jsp] Cadastro de Pessoa</title>

	</head>
<body>

	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true"/>
		   	
	   	<es:botoes codigoPrograma="cad006" />
	   	
	</div>
	
	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad006" action="Cad006Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="pessoaVo.rowid"/>
		        <s:hidden name="pessoaVo.codigoPessoa"/>
		        
		        <div class="control-group">
		        	<label for="codigoPessoa" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="pessoaVo.codigoPessoa" id="codigoPessoa" cssClass="span2" />
   					</div>
  				</div>

		        <div class="control-group">
		        	<label for="codigoPessoa" class="control-label"><fmt:message key="label.padrao.tipo.pessoa"/></label>
   					<div class="controls">
						<s:select cssClass="input" list="#{'1':'Física','2':'Jurídica'}" name="pessoaVo.tipoPessoa" id="tipoPessoa" onchange="javascript:selecionaTipoPessoa(this.value)" cssErrorClass="span3"/>				
   					</div>
  				</div>

		        <div class="control-group">
		        	<label for="labelTipoPessoa" id="labelTipoPessoa" class="control-label"><fmt:message key="label.padrao.razao.social"/></label>
   					<div class="controls">
			         	<s:textfield name="pessoaVo.nome" id="descricao" required="required" cssClass="span6" />
   					</div>
  				</div>

		        <div class="control-group">
		        	<label for="labelDocumento" id="labelDocumento" class="control-label"><fmt:message key="label.padrao.cnpj"/></label>
   					<div class="controls">
			         	<s:textfield name="pessoaVo.codigoDocumento" id="documento" required="required" cssClass="span3" />
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

    <es:rodape descricao="${usuarioLogado}"/>

<script type="text/javascript">

	$(document).ready(function(){
		
		var acao = $('#ac').val();
		var tipoPessoa = $('#tipoPessoa').val();
		
		selecionaTipoPessoa(tipoPessoa);
		
		if(acao == 'excluir'){
			irParaBrowser('cad006');
		}
		
		$('#divErros').css('display','none');
		
		$('#cad006').validate({

			
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
            	"pessoaVo.nome":{
                	required:true
                },
                "pessoaVo.codigoDocumento":{
                	required:true
                }
                
            },
            messages:{
            	"pessoaVo.nome":{
                    required:function(e){
                    	if($('#tipoPessoa').val() == 1){
	                    	return "O campo Nome é obrigatório.";
                    	}else{
                    		return "O campo Razão Social é obrigatório.";
                    	}
                    } 	
                },
                "pessoaVo.codigoDocumento":{
                	required:function(e){
                    	if($('#tipoPessoa').val() == 1){
	                    	return "O campo CPF é obrigatório.";
                    	}else{
                    		return "O campo CNPJ é obrigatório.";
                    	}
                    }
                }
            }
	    });
		
		
		if(acao == ''){
			
			$('#codigoPessoa').val('novo');
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
		
		var $codigo = $('#codigoPessoa').val();
		
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
		
		$('#cad006').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad006').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class*="span"][id!="codigoPessoa"],select').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoPessoa').val();
		
		if($codigo == 'novo'){
			 $("#cad006").validate().cancelSubmit = true;
			this.irParaBrowser('cad006');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class*="span"][id!="codigoPessoa"],select').attr('disabled','true');
	
			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad006').attr("action","Cad006Action!browser.action");
		$('#cad006').validate().cancelSubmit = true;
		$('#cad006').submit();
		
	}
	
	function selecionaTipoPessoa(tipoPessoa){
		
		if(tipoPessoa == '1'){
			
			$('#labelTipoPessoa').html('<fmt:message key="label.padrao.nome"/>');
			$('#labelDocumento').html('<fmt:message key="label.padrao.cpf"/>');
			$('#documento').mask('999.999.999-99');
			
		}else{
			
			$('#labelTipoPessoa').html('<fmt:message key="label.padrao.razao.social"/>');
			$('#labelDocumento').html('<fmt:message key="label.padrao.cnpj"/>');
			$('#documento').mask('99.999.999/9999-99');
			
		}
		
	}

	
	
</script>
</body>
</html>