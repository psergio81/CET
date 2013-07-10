<%@ include file="/include/principal.jsp" %>


<html lang="en">
	<head>
	
	    <title>[cad011i.jsp] Cadastro de Agendamento</title>

	</head>
<body>
	<div class="navbar navbar-fixed-top">
	
		<es:menu mostrarNomePrograma="true"/>
		<es:botoes codigoPrograma="cad011" />
   	
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
		     <div class="span8 offset1">
			    <s:form id="cad011" action="Cad011Action!crud.action" theme="simple" cssClass="well form-horizontal">
			        <s:hidden name="ac" id="ac"/>
			        <s:hidden id="codigoTipoInclusao" name="codigoTipoInclusao" value="1"/>
			         <s:hidden name="agendamentoVo.codigoAgendamento"/>
			       
			       
			        <div class="control-group">
			        	<label for="codigoAgendamento" class="control-label"><fmt:message key="label.padrao.codigo"/></label>
	   					<div class="controls">
				         	<s:textfield name="agendamentoVo.codigoAgendamento" id="codigoAgendamento" cssClass="input-mini" disabled="true" />
	   					</div>
					</div>
	
			        <div class="control-group" id="botaoTipoInclusao">
			        	<label for="codigoAgendamento" class="control-label"><fmt:message key="label.padrao.tipo.inclusao"/></label>
	   					<div class="controls input-append">
				         	 <a class="btn" id="botaoTipoInclusao" onclick="javascript:alterarTipoInclusao()" style="width: 120px; text-align: left;">
	                            <fmt:message key="label.padrao.cliente.cadastrado" />
	                        </a>
	   					</div>
					</div>
						
			       <div class="tipoInclusao" id="clienteCadastrado">
		                <div class="control-group">
		                    <label for="proprietario" class="control-label"><fmt:message key="label.padrao.proprietario"/></label>
		                    <div class="controls input-append">
		                        <s:select name="agendamentoVo.codigoProprietario" id="agendamentoVo.codigoProprietario" list="listaPessoa" listKey="codigoPessoa" listValue="nome" emptyOption="true" onchange="javascript:buscaVeiculosPorCliente(this.value);" cssClass="span4"/>
		                        <span class="hide busca" id="spanProprietario">
			                        <s:textfield name="campoBuscaProprietario" id="descricaoMenu" required="required" cssClass="span4" />
			                        <span class="add-on btn" id="adicionaProprietario">
			                           <i class="icon-search"></i>
			                        </span>
		                        </span>
		                    </div>
		                </div>
		
		                <div class="control-group">
		                    <label for="veiculo" class="control-label"><fmt:message key="label.padrao.veiculo"/></label>
		                    <div id="selecaoVeiculo" class="controls input-append">
		                        <s:select name="agendamentoVo.codigoVeiculo"  id="listaVeiculos" list="listaVeiculos" listKey="codigoVeiculo" listValue="placa" cssClass="span4"/>
		                        <span class="hide busca" id="spanVeiculo">
			                        <s:textfield name="campoBuscaVeiculo" id="descricaoMenu" required="required" cssClass="span4" />
			                        <span class="add-on btn" id="adicionaProprietario">
			                           <i class="icon-search"></i>
			                        </span>
		                        </span>
		                    </div>
	                        <div id="inclusaoPorPlaca" class="controls input-append" style="display: none;">
	                             <s:textfield name="placaVeiculo" id="placaVeiculo" cssClass="span4" />
	                        </div>
		                </div>
	                </div> 
	                    
	                <div class="tipoInclusao hide">
	                    
		                <div class="control-group">
		                    <label for="codigoProprietario" class="control-label"><fmt:message key="label.padrao.tipo.pessoa"/></label>
		                    <div class="controls">
		                        <s:select cssClass="input" list="listaTipoPessoa" listKey="chave" listValue="valor" id="tipoPessoa" onchange="javascript:selecionaTipoPessoa(this.value)" cssErrorClass="span3"/>               
		                    </div>
		                </div>
	
	                    <div class="control-group">
	                        <label for="codigoAgendamento" id="labelTipoPessoa" class="control-label"><fmt:message key="label.padrao.nome"/></label>
	                        <div class="controls">
	                            <s:textfield name="nomePessoa" id="nomePessoa" cssClass="span4" />
	                        </div>
	                    </div>
	
	                    <div class="control-group">
	                        <label for="codigoAgendamento" id="labelDocumento" class="control-label"><fmt:message key="label.padrao.cpf"/></label>
	                        <div class="controls">
	                            <s:textfield name="documento" id="documento" cssClass="span4" />
	                        </div>
	                    </div>
	
	                    <div class="control-group">
	                        <label for="codigoAgendamento" class="control-label"><fmt:message key="label.padrao.placa"/></label>
	                        <div class="controls">
	                            <s:textfield name="placa" id="placa" cssClass="span4" />
	                        </div>
	                    </div>
	               </div>
		
	               <div class="control-group">
	                   <label for="tipoServico" class="control-label"><fmt:message key="label.padrao.tipo.servico"/></label>
	                   <div class="controls input-append">
	                       <s:select name="agendamentoVo.codigoTipoServico" list="listaTipoServico" listKey="chave" listValue="valor" emptyOption="true" cssClass="span4"/>
	                   </div>
	               </div>
	               
	               <div class="control-group">
	                   <label for="data" class="control-label"><fmt:message key="label.padrao.data"/></label>
	                   <div class="controls input-append">
	                       <s:textfield id="dataAgendamento" name="agendamentoVo.dataAgendamento" cssClass="span2 data "/>
	                   </div>
	               </div>
	               
	               <div class="control-group">
	                   <label for="hora" class="control-label"><fmt:message key="label.padrao.hora.inicio"/></label>
	                   <div class="controls input-append">
	                       <s:textfield id="horaInicioEnsaio" name="agendamentoVo.horaAgendamento" cssClass="span2"/>
	                   </div>
	               </div>
	               <div class="control-group">
	                    <label for="gru" class="control-label"><fmt:message key="label.padrao.gru"/></label>
	                    <div id="divConsultar" class="controls input-append">
	                        <s:textfield name="agendamentoVo.gru" maxlength="18" id="numeroGru" required="required" cssClass="span4" />
	                        <a id="consultar" class="btn">Consultar</a>
	                    </div>
	                </div>
			       <div id="divAviso" class="alert alert-block" style="overflow; position:absolute; display: none; width: 300px; top: 150px; right: 10px;">
	                    <h4>Aviso!!!</h4>
		               <div id="mensagemAviso"></div>
	                </div>
			        
			    </s:form>
		    </div>
		   <div id="horariosAgendados" class=" span2 alert alert-info" style="overflow-y: scroll; height: 390px;">
           <button type="button" class="close" onclick="javascript:fechar('horariosAgendados')">&times;</button>
        
        <table class="table table-condensed">
            <thead style="font-size: x-small;">
                <tr>
                    <th colspan="2" style="text-align: center; font-size: small;">
                        Agendamentos para o dia <span id="spanData"></span>
                    </th>
                </tr>
                <tr >
                    <th>
                        Horario
                    </th>
                    <th>
                        Tipo Serviço
                    </th>
                </tr>
            </thead>
            
            <tbody id="regitros"  style="font-size: small;">
            
            
            </tbody>
        </table>    
    
    </div>
		    
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
		$('#botaoSalvar').attr('href','javaScript:isExisteGruCadastradoMesmoCodigo();');
		
		mostrarAgendamentos();

		if(acao == 'excluir'){
			irParaBrowser('cad011');
		}

		// desabilitado temporariamente depois colocar para desabilitar na consulta
		$('#botaoTipoInclusao').hide();
		
		$('#divErros').hide();
		
		
	    $('#dataAtual').click(function(){
            
            setDataAtual('dataAgendamento');
            
        });
	    
	    $('#dataAgendamento').change(function(){
	    	
	    	mostrarAgendamentos();
	    	
	    });
	    
	    $('#dataAgendamento').mask('99/99/9999');
	    $('#horaInicioEnsaio').mask('99:99');
        
		
		$('#cad011').validate({

			
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
            	"agendamentoVo.codigoProprietario":{
                	required:true
                },
            	"agendamentoVo.codigoVeiculo":{
                	required:true
                },
            	"agendamentoVo.codigoTipoServico":{
                	required:true
                },
                "agendamentoVo.dataAgendamento":{
                    required:true,
                    dateBR:true
                },
                "agendamentoVo.horaAgendamento":{
                    required:true,
                    timeBR:true
                },
                "agendamentoVo.gru":{
                    minlength:18,
                    number:true
                }
                
            },
            messages:{
            	"agendamentoVo.codigoProprietario":{
                    required: "O campo Descrição é obrigatório."	
                },
            	"agendamentoVo.codigoVeiculo":{
                    required: "O campo Veículo é obrigatório."	
                },
            	"agendamentoVo.codigoTipoServico":{
                    required: "O campo Tipo de Serviço é obrigatório."	
                },
            	"agendamentoVo.dataAgendamento":{
                    required: "O campo Data Agendamento é obrigatório."	
                },
            	"agendamentoVo.horaAgendamento":{
                    required: "O campo Hora Agendamento é obrigatório."	
                },
            	"agendamentoVo.gru":{
                    minlength: "O campo GRU deve conter {0} números",
                    number: "O campo GRU deve ser preechido apenas por números."
                }
            }
	    });
		
		
		if(acao == ''){
			
			$('#codigoAgendamento').val('novo');
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
		
		var $codigo = $('#codigoAgendamento').val();
		
		
		if(buscaProximoCampo() == 'true'){
			
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
		
		$('#cad011').submit();
	}
	
	
	function abrirConfirmacao(){
		$('#myModal').modal('show');
	}


	function excluirCadastro(){
		
		$('#ac').val("excluir");
		$('#cad011').submit();
		
	}
	
	function liberarCamposAlteracao(){
		
		$('#textoBtnCancelarExcluir').html('Cancelar');
		$('#botaoCancelar').attr('href','javaScript:cancelarCadastro();');
		
		$('#textoBtnSalvarAlterar').html('Salvar');
		$('#botaoSalvar').removeClass('btn-primary').addClass('btn-success');
		$('#botaoSalvar').attr('href','javaScript:isExisteGruCadastradoMesmoCodigo();');
		$('input[class*="span"][id!="codigoAgendamento"],select, span, i').removeAttr('disabled');
		
	}

	function cancelarCadastro(){
		
		var $codigo = $('#codigoAgendamento').val();
		
		if($codigo == 'novo'){
			 $("#cad011").validate().cancelSubmit = true;
			this.irParaBrowser('cad011');
		}else{
			
			$('#textoBtnCancelarExcluir').html('Excluir');
			$('#botaoCancelar').attr('href','javaScript:abrirConfirmacao();');
			
			$('#textoBtnSalvarAlterar').html('Alterar');
			$('#botaoSalvar').attr('href','javaScript:liberarCamposAlteracao();');
			$('#botaoSalvar').removeClass('btn-success').addClass('btn-primary');
			$('input[class|="input"][id!="codigoAgendamento"]').attr('disabled','true');

			location.reload();
		}
	}

	function irParaBrowser(){
		
		$('#cad011').attr("action","Cad011Action!browser.action");
		$('#cad011').validate().cancelSubmit = true;
		$('#cad011').submit();
		
	}

	function mostrarCampoBusca(idCampo){
		
		var idDiferente = "[id!='"+idCampo+"']";
		
		$('#'+idCampo).toggle();
		$('.busca'+idDiferente).hide();
		
	}
	

	function alterarTipoInclusao(){
		
		var codigoTipoInclusao = $('#codigoTipoInclusao').val();
		
		$('.tipoInclusao').toggle('slow',function(){
			if(codigoTipoInclusao == "1"){
				$('#botaoTipoInclusao').html('<fmt:message key="label.padrao.inclusao.rapida" />');
				$('#placa').mask('aaa-9999');
				$('#documento').mask('99.999.999/9999-99');
				$('#codigoTipoInclusao').val("2");
				
			}else{
			    $('#botaoTipoInclusao').html('<fmt:message key="label.padrao.cliente.cadastrado" />');
				$('#codigoTipoInclusao').val("1");
			}
		});
	}
	
	
	function buscaVeiculosPorCliente(codigoCliente){
		
		if(codigoCliente == 0){
			 $('#divAviso').fadeOut('fast');
             $('#mensagemAviso').html('');
             $('#selecaoVeiculo').show();
             $('#inclusaoPorPlaca').hide();
             
             return;
		}
		
		$.ajax({
            url: "Cad005Action!carregaVeiculosPorCliente.action",
            type: "POST",
            dataType: "json",  
            data: {
            	codigoEmpresaSelecionada: codigoCliente
                
            },
            success: function(json){   

            	if(json != null && json.length > 0){
            		
	                var options = "<option value=''></option>";
	                
	                $.each(json, function(json){
	                    options += "<option value="+this.codigoVeiculo+">"+this.placa+"</option>";
	                });
	
	                $('#listaVeiculos').html(options);
	                $('#divAviso').fadeOut('slow');
	                $('#selecaoVeiculo').show();
	                $('#inclusaoPorPlaca').hide();
	                
	                
            	}else{
	                $('#mensagemAviso').html('Não existe veículo cadastrado para o cliente selecionado. Informe uma placa para a inclusão rápida deste registro');
	                $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
	                $('#selecaoVeiculo').hide();
	                $('#inclusaoPorPlaca').show();
            	}

                
            },
            error: function(){  
                alert('Error');
            }
        });
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
    
    function fechar(idDiv){
    	$('#'+idDiv).hide();
    }
    
    function mostrarAgendamentos(){
    	
    	var dataAgendamento = $('#dataAgendamento').val(); 
    	
    	if(dataAgendamento == null || dataAgendamento == ''){
    		$('#horariosAgendados').slideUp();
    		return;
    	} 
    	
    	
    	$.ajax({
            url: "Cad011Action!buscarAgendamentos.action",
            type: "POST",
            dataType: "html",  
            data: {
            	dataBuscaAgendamento : dataAgendamento
            },
            success: function(html){   

            	if(html != ''){
            		
	            	$('#regitros').html(html);
			    	$('#horariosAgendados').slideUp();
			        $('#spanData').html($('#dataAgendamento').val());
			        $('#horariosAgendados').slideDown();
            	}else{
            		$('#horariosAgendados').slideUp();
            	}
		        
            },
            error: function(){  
                alert('Error');
            }
        });
    	
    	
    	
    	
    }
    
    $('#consultar').click(function(){
        
        var numeroGru = $('#numeroGru').val();
        var imagemCarregando = '<img id="imgCarregando" alt="teste" src="${imagens}/ajax-loader.gif">';
        var imagemOk = '<img id="imgOk" alt="teste" src="${icones}/ok.png">';
        var imagemCancela = '<img id="imgCancela" alt="teste" src="${icones}/cancel.png">';
        
        $('#imgOk').remove();
        $('#imgCancela').remove();
        $('#divConsultar').append(imagemCarregando);
        
        $.ajax({
            url: "ConsultaGruAction!buscar.action",
            type: "POST",
            dataType: "json",   
            data: {
                codigoGru:numeroGru
            },
            success: function(json){   
            	
            	if(json.mensagemErro){
            		 $('#mensagemAviso').html(json.mensagemErro);
                     $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
                     $('#numeroGru').focus();
                     $('#imgCarregando').remove();
            	
            	}else{
            		
            		if(json.situacao == 'ativo'){
		            	 $('#divConsultar').append(imagemOk);
            		}else if(json.situacao == 'inativo'){
		            	 $('#divConsultar').append(imagemCancela);
            		}
            		 $('#mensagemAviso').html(json.situacao);
                     $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
                     $('#numeroGru').focus();
                     $('#imgCarregando').remove();
            	}
            	
                
            },
            error: function(){  
            	 $('#mensagemAviso').html('Erro ao consultar GRU');
                 $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
		        $('#imgCarregando').remove();
            }
        });
        
    });
    
    function isExisteGruCadastradoMesmoCodigo(){
    	
    	var numeroGru = $('#numeroGru').val();
    	
    	$.ajax({
            url: "ConsultaGruAction!isExisteGruCadastradoMesmoCodigo.action",
            type: "POST",
            dataType: "json",   
            data: {
                codigoGru:numeroGru
            },
            success: function(json){ 
            	
                if(json == true){
                	 $('#mensagemAviso').html('Já existe um agendamento cadastrado com este número de GRU');
                     $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
                     $('#imgCarregando').remove();
                }else{
                	salvarCadastro();
                }
                
                
            },
            error: function(){  
                $('#mensagemAviso').html('Erro ao consultar GRU');
                $('#divAviso').fadeIn(1000).delay(1000).fadeOut('slow');
                $('#imgCarregando').remove();
            }
        });
    	
    	
    	
    }    
	
</script>
</body>
</html>