<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>

	    <title>[cad005i.jsp] Cadastro de Veiculos</title>
	
	</head>
<body>
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true"/>
		   	
	   	<es:botoes codigoPrograma="cad005" />
	   	
	</div>
	
	<div class="container-fluid">
		<div class="container">
		
		    <s:form id="cad005" action="Cad005Action!crud.action" theme="simple" cssClass="well form-horizontal">
		        <s:hidden name="ac" id="ac"/>
		        <s:hidden name="veiculoVo.codigoVeiculo"/>
		        
		        <div class="control-group">
		        	<label for="codigoVeiculo" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
   					<div class="controls">
			         	<s:textfield name="veiculoVo.codigoVeiculo" id="codigoVeiculo" cssClass="span2" disabled="true" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="placa" class="control-label"><fmt:message key="label.padrao.placa"/></label>
   					<div class="controls">
			         	<s:textfield name="veiculoVo.placa" id="placa" required="required" cssClass="span2 maiusculo" />
   					</div>
				</div>

		        <div class="control-group">
		        	<label for="descricao" class="control-label"><fmt:message key="label.padrao.tacografo"/></label>
   					<div class="controls">
						<s:select name="tacografosDisponiveis" id="tacografosDisponiveis" list="listaTacografo" listKey="codigoTacografo" listValue="codigoSerie" emptyOption="true" ></s:select>
						<span style="display: none;" class="associarTacografo" title="Cancelar">
							<a href="javascript:cancelarAssociacao();">
								<img src="icones/cancel.png" alt="" class="icone">
							</a>
							&nbsp;
							<a href="javascript:associar();" title="Confirmar">
								<img src="icones/ok.png" alt="" class="icone">
							</a>
						</span>
						<span class="associarTacografo">
							<a href="javascript:alternaIcones('3');" title="Associar tacógrafo">
								<img src="icones/zoomIn.png" alt="" class="icone">
							</a>
						</span>
   					</div>
				</div>
		    </s:form>
		    
		    <es:mensagemErro />
			
		</div>
	</div>
	
	<div class="container" id="divAssociados"></div>
	

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

		
		$('#placa').mask('aaa-9999');
		
		carregaTacografosAssociados();
		
		
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
            	"veiculoVo.placa":{
                	required:true
                }
                
            },
            messages:{
            	"veiculoVo.placa":{
                    required: "O campo Placa é obrigatório."	
                }
            }
	    });
		
		
		if(acao == ''){
			
			$('#codigoVeiculo').val('novo');
			$('#textoBtnSalvarAlterar').html('Salvar');
			$('.associarTacografo').attr('disabled','true');
			
			
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
		$('input[class*="span"][id!="codigoVeiculo"]').removeAttr('disabled');
		
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
			$('input[class*="span"][id!="codigoVeiculo"]').attr('disabled','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad005').attr("action","Cad005Action!browser.action");
		$('#cad005').validate().cancelSubmit = true;
		$('#cad005').submit();
		
	}
	
	function cancelarAssociacao(){
		alternaIcones('1');
	}

	function associar(){
		alternaIcones('2');
		var $codigoTacografo = $('#tacografosDisponiveis').find("option:selected").val();
		
		if($codigoTacografo == ''){
			return;
		}
		
		$.ajax({
		      url: "Cad005Action!associarTacografo.action",
		      type: "POST",
		      dataType: "json",  
		      data: {
		    	  codigoVeiculo: $('#codigoVeiculo').val(),
		    	  codigoTacografo: $('#tacografosDisponiveis').find("option:selected").val()
		      },
		      success: function(data){   

		    	  carregaTacografosAssociados();
		    	  
		      },
		      error: function(){  
		          alert('Error');
		      }
		  });
	}

	function carregaTacografosAssociados(){
		
		$.ajax({
		      url: "Cad005Action!carregaTacografosAssociados.action",
		      type: "POST",
		      dataType: "html",  
		      data: {
		    	  codigoVeiculo: $('#codigoVeiculo').val()
		    	  
		      },
		      success: function(data){   

		    	  $('#divAssociados').slideUp('slow').html(data).slideDown('slow');
		    	  
		      },
		      error: function(){  
		          alert('Error');
		      }
		  });
	}

	function carregaTacografosNaoAssociados(){
		
		$.ajax({
		      url: "Cad005Action!carregaTacografosNaoAssociados.action",
		      type: "POST",
		      dataType: "html",  
		      data: {
		    	  codigoVeiculo: $('#codigoVeiculo').val()
		    	  
		      },
		      success: function(json){   
		    	  
		    	  var obj = jQuery.parseJSON(json);

		    	  var options = "<option value=''></option>";
		    	  
		    	  $.each(obj, function(obj){
		    		  options += "<option value="+this.codigoTacografo+">"+this.codigoSerie+"</option>";
		            });

		    	  $('#tacografosDisponiveis').html(options);
		    	  
		      },
		      error: function(){  
		          alert('Error');
		      }
		  });
	}
	
	
	function alternaIcones(origem){
		$('.associarTacografo').toggle();
		
		if(origem == '1'){
		
			$('#tacografosDisponiveis').attr('disabled','true');
			$('#tacografosDisponiveis').val('');
		
		}else if(origem == '2'){

			$('#tacografosDisponiveis').attr('disabled','true');
			
		}else{
			
			carregaTacografosNaoAssociados();
			$('#tacografosDisponiveis').removeAttr('disabled');
			
		}
	}


</script>
</body>
</html>