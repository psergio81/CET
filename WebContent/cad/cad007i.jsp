<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<%@ include file="/include/principal.jsp" %>

	<head>
    	<title>[cad007i.jsp] Cadastro de Tacografo</title>

	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true"/>
		   	
	   	<es:botoes codigoPrograma="cad007" />
	   	
	</div>

	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad007" action="Cad007Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="tacografoVo.codigoTacografo"/>
		        
		        <div class="control-group">
		        	<label for="codigoTacografo" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="tacografoVo.codigoTacografo" id="codigoTacografo" cssClass="span2" disabled="true"/>
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="proprietario" class="control-label"><fmt:message key="label.padrao.marca"/></label>
   					<div class="controls">
						<s:select name="tacografoVo.codigoMarca" list="listaMarca" listKey="codigoMarca" listValue="descricao" emptyOption="true" cssClass="span3"/>
						<s:a action="Cad002Action!crud.action" title="Adicionar">
							<img src="icones/add.png" width="25pt" height="25pt" alt="" >
						</s:a>
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="veiculo" class="control-label"><fmt:message key="label.padrao.modelo"/></label>
   					<div class="controls">
						<s:select name="tacografoVo.codigoModelo" list="listaModelo" listKey="codigoModelo" listValue="descricao" emptyOption="true" cssClass="span3"/>
						<s:a action="Cad003Action!crud.action" title="Adicionar">
							<img src="icones/add.png" alt="" >
						</s:a>
   					</div>
				</div>
		        
		        <div class="control-group">
		        	<label for="gru" class="control-label"><fmt:message key="label.padrao.numero.serie"/></label>
   					<div class="controls">
			         	<s:textfield name="tacografoVo.codigoSerie" id="gru" required="required" cssClass="span3" />
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

		$('#dataTacografo').mask('99/99/9999');
		
		if(acao == 'excluir'){
			irParaBrowser('cad007');
		}
		
		$('#divErros').hide();
		
		$('#cad007').validate({

			
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
            	"tacografoVo.descricao":{
                	required:true
                }
                
            },
            messages:{
            	"tacografoVo.descricao":{
                    required: "O campo Descrição é obrigatório."	
                }
            }
	    });
		
		if(acao == ''){
			
			$('#codigoTacografo').val('novo');
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
		
		var $codigo = $('#codigoTacografo').val();
		
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
		
		$('#cad007').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad007').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class*="span"][id!="codigoTacografo"],select').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoTacografo').val();
		
		if($codigo == 'novo'){
			 $("#cad007").validate().cancelSubmit = true;
			this.irParaBrowser('cad007');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class*="span"]').attr('disabled','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad007').attr("action","Cad007Action!browser.action");
		$('#cad007').validate().cancelSubmit = true;
		$('#cad007').submit();
		
	}

	
</script>
</body>
</html>