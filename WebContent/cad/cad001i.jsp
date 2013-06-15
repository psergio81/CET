<%@ include file="/include/principal.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>
	
	    <title>[cad001i.jsp] Cadastro de Empresa</title>
	
	</head>
<body>
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true"/>
		   	
		<es:botoes codigoPrograma="cad001" />
	   		   	
	</div>

	<div class="container-fluid">
        <div class="container" id="container">

            <s:form id="cad001" action="Cad001Action!crud.action" theme="simple" cssClass="well form-horizontal">
                <s:hidden name="ac" id="ac"/>
                <s:hidden name="mensagemErro" id="mensagemErro" value="%{mensagemErro}"/>
                <s:hidden name="empresaVo.codigoEmpresa"/>

					<div class="control-group">
						<label for="codigoEmpresa" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
    					<div class="controls">
							<s:textfield name="empresaVo.codigoEmpresa" id="codigoEmpresa" cssClass="span2" disabled="true"  />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="razaoSocial" class="control-label"><fmt:message key="label.padrao.razao.social"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.razaoSocial" required="true" id="razaoSocial" cssClass="span6 required" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="cnpj" class="control-label"><fmt:message key="label.padrao.cnpj"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.cnpj" id="cnpj" required="required" cssClass=" span3 required" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="cep" class="control-label"><fmt:message key="label.padrao.cep"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.cep" id="cep" required="required" cssClass="span2" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="endereco" class="control-label"><fmt:message key="label.padrao.endereco"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.endereco" id="endereco" required="required" cssClass="span6" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="numero" class="control-label"><fmt:message key="label.padrao.numero"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.numero" id="numero" required="required" cssClass="span2" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="complemento" class="control-label"><fmt:message key="label.padrao.complemento"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.complemento" id="complemento" required="required" cssClass="span4" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="bairro" class="control-label"><fmt:message key="label.padrao.bairro"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.bairro" id="bairro" required="required" cssClass="span4" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="cidade" class="control-label"><fmt:message key="label.padrao.cidade"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.cidade" id="cidade" required="required" cssClass="span4" />
    					</div>
  					</div>

					<div class="control-group">
		               	<label for="estado" class="control-label"><fmt:message key="label.padrao.estado"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.estado" id="estado" required="required" cssClass="span1" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="telefone" class="control-label"><fmt:message key="label.padrao.telefone"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.telefone" id="telefone" required="required" cssClass="span3" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="fax" class="control-label"><fmt:message key="label.padrao.fax"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.fax" id="fax" required="required" cssClass="span3" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="website" class="control-label"><fmt:message key="label.padrao.website"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.webSite" id="website" required="required" cssClass="span4" />
    					</div>
  					</div>

					<div class="control-group">
	                	<label for="email" class="control-label"><fmt:message key="label.padrao.email"/></label>
    					<div class="controls">
			                <s:textfield name="empresaVo.email" id="email" required="required" cssClass="span4" />
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
		
		consultaCep();
		
		$('#cep').mask('99999-999');
		$('#telefone').mask('(99) 9999-9999?9');
		$('#fax').mask('(99) 9999-9999?9');
		$('#cnpj').mask('99.999.999/9999-99');
		
		var acao = $('#ac').val();
		
		if(acao == 'excluir'){
			irParaBrowser('cad001');
		}
		
		$('#divErros').hide();
		
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
                "empresaVo.cnpj":{
                	required:true,
                	cnpj: true
                }
                
            },
            messages:{
            	"empresaVo.razaoSocial":{
                    required: "O campo Razão Social é obrigatório."	
                },
                "empresaVo.cnpj":{
                    required: "O campo CNPJ é obrigatório.",
                    cnpj:"CNPJ inválido!"
                }
            }
	    });
		
		if(acao == ''){
			
			$('#codigoEmpresa').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			
			$('input[class*="span"][id!="codigoEmpresa"]').attr('disabled','true');
			
		}
		
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoEmpresa').val();
		
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
		$('input[class*="span"][id!="codigoEmpresa"]').removeAttr('disabled');
		
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
			$('input[class*="span"][id!="codigoEmpresa"]').attr('disabled','true');
			
			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad001').attr("action","Cad001Action!browser.action");
		$('#cad001').validate().cancelSubmit = true;
		$('#cad001').submit();
		
	}
	
	function consultaCep(){
		
		$("#cep").blur(function(e){
	        if($.trim($("#cep").val()) != ""){
	            $.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#cep").val(), function(){
	                if(resultadoCEP["resultado"] == 1){
	                    $("#endereco").val(unescape(resultadoCEP["tipo_logradouro"])+": "+unescape(resultadoCEP["logradouro"]));
	                    $("#bairro").val(unescape(resultadoCEP["bairro"]));
	                    $("#cidade").val(unescape(resultadoCEP["cidade"]));
	                    $("#estado").val(unescape(resultadoCEP["uf"]));
	                }else{
	                    var mensagem = "Não foi possivel encontrar o endereço";
	                    $('#divErros').html(mensagem);
	                    $("#endereco").val('');
	                    $("#bairro").val('');
	                    $("#cidade").val('');
	                    $("#estado").val('');
	                    $('#divErros').fadeIn(1000).delay(1000).fadeOut('slow');
	                }
	            });
	        }
	    });
	}
	
</script>
</body>
</html>