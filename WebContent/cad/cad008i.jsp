<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
    	<title>[cad008i.jsp] Cadastro de Usuário</title>

	</head>
	
<body>
	<div class="navbar navbar-fixed-top">
	
		<es:menu mostrarNomePrograma="true"/>
	
		<es:botoes codigoPrograma="cad008" />   	
   	   	
	</div>

	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad008" action="Cad008Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
	         	<s:hidden name="mensagemErro" id="mensagemErro" value="%{mensagemErro}"/>
		        <s:hidden name="usuarioDadosVo.codigoUsuario"/>
		        
		        <div class="control-group">
		        	<label for="codigoUsuario" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="usuarioDadosVo.codigoUsuario" id="codigoUsuario" cssClass="span2" disabled="true"/>
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="empresa" class="control-label"><fmt:message key="label.padrao.empresa"/></label>
   					<div class="controls">
						<s:select name="usuarioDadosVo.codigoEmpresa" list="listaEmpresa" listKey="codigoEmpresa" listValue="razaoSocial" emptyOption="true" cssClass="span4"/>
						<s:a action="Cad001Action!crud.action" title="Adicionar">
							<img src="icones/add.png" width="25pt" height="25pt" alt="" >
						</s:a>
   					</div>
				</div>
		        
		        <div class="control-group">
		        	<label for="nomeUsuario" class="control-label"><fmt:message key="label.padrao.nome"/></label>
   					<div class="controls">
			         	<s:textfield name="usuarioDadosVo.nomeUsuario" id="nomeUsuario" cssClass="span4" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="nick" class="control-label"><fmt:message key="label.padrao.nick"/></label>
   					<div class="controls">
			         	<s:textfield name="usuarioDadosVo.nick" id="nick" cssClass="span4" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="senha" class="control-label"><fmt:message key="label.padrao.senha"/></label>
   					<div class="controls">
			         	<input type="password" name="usuarioDadosVo.senha" id="senha" class="span4" value="${usuarioDadosVo.senha}">
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
		var mensagem = $('#mensagemErro').val();
		

		if(mensagem != null && mensagem != ''){
			$('#mensagem').html(mensagem);
			$('#modalMensagem').modal('show');
		}
		
		
		if(acao == 'excluir'){
			irParaBrowser('cad008');
		}
		
		$('#divErros').hide();
		
		$('#cad008').validate({

			
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
            	"usuarioDadosVo.codigoEmpresa":{
                	required:true
                },
            	"usuarioDadosVo.nomeUsuario":{
                	required:true
                },
            	"usuarioDadosVo.senha":{
                	required:true
                },
            	"usuarioDadosVo.nick":{
                	required:true
                }
                
            },
            messages:{
            	"usuarioDadosVo.codigoEmpresa":{
                    required: "O campo Empresa é obrigatório."	
                },
            	"usuarioDadosVo.nomeUsuario":{
                    required: "O campo Nome é obrigatório."	
                },
            	"usuarioDadosVo.senha":{
                    required: "O campo Senha é obrigatório."	
                },
            	"usuarioDadosVo.nick":{
                    required: "O campo Nick é obrigatório."	
                }
            }
	    });
		
		if(acao == ''){
			
			$('#codigoUsuario').val('novo');
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
		
		var senha = $('#senha').val();
		senha = $.md5(senha);
		
		$('#senha').val(senha);
		
		var $codigo = $('#codigoUsuario').val();
		
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
		
		$('#cad008').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad008').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class*="span"][id!="codigoUsuario"],select').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoUsuario').val();
		
		if($codigo == 'novo'){
			 $("#cad008").validate().cancelSubmit = true;
			this.irParaBrowser('cad008');
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
		
		$('#cad008').attr("action","Cad008Action!browser.action");
		$('#cad008').validate().cancelSubmit = true;
		$('#cad008').submit();
		
	}

	
</script>
</body>
</html>