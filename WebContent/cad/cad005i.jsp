<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	    <title>[cad005i.jsp] Cadastro de Veiculos</title>
	
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
	        .icone{
	        	width: 13pt;
	        	height: 13pt;
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
					</i>&nbsp;
					<fmt:message key="label.padrao.busca"/>
				</a>
			</div>
			<div class="span4" align="center">
				<a id="botaoCancelar" class="btn btn-danger" href="javaScript:cancelarCadastro();">
					<i class="icon-remove icon-white"></i>&nbsp;
					<span id="textoBtnCancelarExcluir"><fmt:message key="label.padrao.cancelar"/></span>
				</a>
				<a id="botaoSalvar" class="btn btn-success" href="javaScript:salvarCadastro();">
					<i class="icon-ok icon-white"></i>&nbsp;
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
		        <s:hidden name="veiculoVo.codigoVeiculo"/>
		        
		        <p>
		        	<label for="codigoVeiculo" class="label"><fmt:message key="label.padrao.codigo"/></label>
		         	<s:textfield name="veiculoVo.codigoVeiculo" id="codigoVeiculo" cssClass="input-mini" disabled="true" />
		        </p>
		        <p>
		        	<label for="descricao" class="label"><fmt:message key="label.padrao.placa"/></label>
		         	<s:textfield name="veiculoVo.descricao" id="placa" required="required" cssClass="input-large maiusculo" />
		         	
		        </p>
		        
				<p>
		        	
		        	<label for="descricao" class="label"><fmt:message key="label.padrao.tacografo"/></label>

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
				</p>
		
		    </s:form>
		    
		    <div id="divErros" class="well alert alert-error" style="overflow; position:absolute; display: block; width: 300px;" >
				<ul id="listaErros" > </ul>  
			</div>
			
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
			
			$('input[class|="input"],select').attr('disabled','true');
			
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
		$('input[class|="input"][id!="codigoVeiculo"]').removeAttr('disabled');
		
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
			$('input[class|="input"][id!="codigoVeiculo"]').attr('disabled','true');

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