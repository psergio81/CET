<%@ include file="/include/principal.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>

    	<title>[cad004i.jsp] Cadastro de Ensaio</title>

	</head>
<body>
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true"/>
		   	
		<es:botoes codigoPrograma="cad004"/>
	   	
	</div>
	
	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad004" action="Cad004Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="ensaioVo.codigoEnsaio"/>
		        
        		<div class="control-group">
		        	<label for="codigoEnsaio" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="ensaioVo.codigoEnsaio" id="codigoEnsaio" cssClass="span2" disabled="true"/>
   					</div>
				</div>

        		<div class="control-group">
					<label for="data" class="control-label"><fmt:message key="label.padrao.data"/></label>
   					<div class="controls input-append">
			         	<s:textfield id="dataEnsaio" name="ensaioVo.data" cssClass="span2 data "/>
			         	<span class="add-on btn" id="dataAtual"><i class="icon-calendar"></i></span>
   					</div>
				</div>
        		
        		
        		<div class="control-group">
					<label for="hora" class="control-label"><fmt:message key="label.padrao.hora.inicio"/></label>
   					<div class="controls input-append">
			         	<s:textfield id="horaInicioEnsaio" name="ensaioVo.horaInicio" cssClass="span2"/>
			         	<span class="add-on btn" onclick="javascript:setHoraAtual('horaInicioEnsaio')">
			         	   <i class="icon-time"></i>
			         	</span>
   					</div>
				</div>

        		<div class="control-group">
					<label for="hora" class="control-label"><fmt:message key="label.padrao.hora.fim"/></label>
   					<div class="controls input-append">
			         	<s:textfield id="horaFimEnsaio" name="ensaioVo.horaFim" cssClass="span2"/>
			         	<span class="add-on btn" onclick="javascript:setHoraAtual('horaFimEnsaio')">
			         	   <i class="icon-time"></i>
			         	</span>
   					</div>
				</div>

        		<div class="control-group">
		        	<label for="proprietario" class="control-label"><fmt:message key="label.padrao.proprietario"/></label>
   					<div class="controls input-append">
						<s:select name="ensaioVo.codigoProprietario" list="listaPessoa" listKey="codigoPessoa" listValue="nome" emptyOption="true" cssClass="span4"/>
						<span class="add-on btn" id="adicionaProprietario">
                           <i class="icon-plus"></i>
                        </span>
   					</div>
				</div>
		        
        		<div class="control-group">
		        	<label for="veiculo" class="control-label"><fmt:message key="label.padrao.veiculo"/></label>
   					<div class="controls input-append">
						<s:select name="ensaioVo.codigoVeiculo" list="listaVeiculo" listKey="codigoVeiculo" listValue="placa" emptyOption="true" cssClass="span4"/>
						<span class="add-on btn" id="adicionaVeiculo">
                           <i class="icon-plus"></i>
                        </span>
   					</div>
				</div>

        		<div class="control-group">
		        	<label for="veiculo" class="control-label"><fmt:message key="label.padrao.tipo.servico"/></label>
   					<div class="controls input-append">
						<s:select name="ensaioVo.codigoTipoServico" list="#{'1':'Calibração','2':'Ensaio','3':'Selagem'}" emptyOption="true" cssClass="span4" value="%{ensaioVo.codigoTipoServico }"/>
   					</div>
				</div>

        		<div class="control-group">
		        	<label for="gru" class="control-label"><fmt:message key="label.padrao.gru"/></label>
   					<div class="controls">
			         	<s:textfield name="ensaioVo.gru" id="gru" required="required" cssClass="span4" />
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
		
		$('#horaEnsaio').mask('99:99');
		
		$('#dataAtual').click(function(){
			
			setDataAtual('dataEnsaio');
			
		});

		$('#adicionaVeiculo').click(function(){
			
			var newForm = $('<form>', {
	            'action': 'Cad005Action!crud.action',
	            'method': 'Post',
	            'target': '_blank'
	        });
	        
	        newForm.submit();
			
		});

		$('#adicionaProprietario').click(function(){
			
			var newForm = $('<form>', {
	            'action': 'Cad006Action!crud.action',
	            'method': 'Post',
	            'target': '_blank'
	        });
	        
	        newForm.submit();
			
		});

		
		if(acao == 'excluir'){
			irParaBrowser('cad004');
		}else if(acao == 'incluir'){
			setDataAtual('dataEnsaio');
		}
		
		$('#divErros').hide();
		
		$('#cad004').validate({

			
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
            	"ensaioVo.data":{
                	required:true
                },
                "ensaioVo.codigoProprietario":{
                	required:true
                },
                "ensaioVo.codigoVeiculo":{
                	required:true
                },
                "ensaioVo.gru":{
                	required:true
                },
                "ensaioVo.horaInicio":{
                	timeBR:true,
                	required:true
                }
                
            },
            messages:{
            	"ensaioVo.data":{
                    required: "O campo Data é obrigatório."	
                },
                "ensaioVo.codigoProprietario":{
                	required:"O campo Proprietário é obrigatório."
                },
                "ensaioVo.codigoVeiculo":{
                	required:"O campo Veículo é obrigatório."
                },
                "ensaioVo.gru":{
                	required:"O campo GRU é obrigatório."
                },
                "ensaioVo.horaInicio":{
                	timeBR:"Informe uma hora válida",
                	required:"O campo Hora é obrigatório."
                }
                
            }
	    });
		
		if(acao == ''){
			
			$('#codigoEnsaio').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			
			$('input[class*="span"],select, span, i').attr('disabled','true');
			
		}
	});

	function salvarCadastro(){
		
		var $codigo = $('#codigoEnsaio').val();
		
		if(buscaProximoCampo() == 'true'){
			
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
		
		$('#cad004').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad004').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:salvarCadastro();');
		$('input[class*="span"][id!="codigoEnsaio"],select, span, i').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoEnsaio').val();
		
		if($codigo == 'novo'){
			 $("#cad004").validate().cancelSubmit = true;
			this.irParaBrowser('cad004');
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
		
		$('#cad004').attr("action","Cad004Action!browser.action");
		$('#cad004').validate().cancelSubmit = true;
		$('#cad004').submit();
		
	}
	
</script>
</body>
</html>