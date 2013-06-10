<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<%@ include file="/include/principal.jsp" %>

	<head>
		
		<title>[cad010b.jsp] Cadastro de Programa</title>
      	 
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true" />
		<es:botoesBrowse codigoPrograma="cad010" id_botao="botao_incluir"/>		
		
	</div>

    <input type="hidden" name="quantidadeEnsaiosRelatorio" id="quantidadeEnsaiosRelatorio">
    
    <div class="container-fluid">
        <div class="container">
            <s:form action="Cad010Action!upload.action" method="POST" enctype="multipart/form-data" cssClass="well form-horizontal" theme="simple">
                <s:hidden name="filtrar" id="filtrar" />
        
                <div class="control-group">
                    <div class="controls">
                        <input type="file" name="upload" class="input-xlarge" id="nomeArquivo">
                        <s:submit cssClass="btn" id="btnSubmit"/>  
                    </div>
                </div>
                
                <div class="control-group span4 resultado">
                    <label for="descricao" class="control-label"  style="padding-top: 0px;">
                        <fmt:message key="label.padrao.periodo"/>
                    </label>
                    <div class="controls">
			            <s:property value="periodo" />
                    </div>
                </div>
                <div class="control-group span4 resultado">
                    <label for="descricao" class="control-label"  style="padding-top: 0px;">
                        <fmt:message key="label.padrao.quantidade"/>
                    </label>
                    <div class="controls">
			            <s:property value="quantidadeEnsaiosRelatorio" />
                    </div>
                </div>
                
            </s:form>
        </div>
    </div>
    
	<div class="container">
		<s:if test="%{listaEnsaioVo.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
		    <table width="100%" class="table table-bordered table-striped" style="font-size: 8pt;">

				<thead>
					<tr>
						<th></th>
						<th><fmt:message key="label.padrao.proprietario"/></th>
						<th><fmt:message key="label.padrao.renavam"/></th>
						<th><fmt:message key="label.padrao.placa"/></th>
						<th><fmt:message key="label.padrao.marca"/></th>
						<th><fmt:message key="label.padrao.modelo"/></th>
						<th><fmt:message key="label.padrao.numero.serie"/></th>
						<th><fmt:message key="label.padrao.gru"/></th>
						<th><fmt:message key="label.padrao.data"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaEnsaioVo" status="status">
						<tr class="${classeCss}">
							<td>
								<s:property value="codigoEnsaio" />
							</td>
							<td>
								<s:property value="nomeProprietario" />
							</td>
							<td>
								<s:property value="renavam" />
							</td>
							<td>
								<s:property value="placa" />
							</td>
							<td>
								<s:property value="marca" />
							</td>
							<td>
								<s:property value="modelo" />
							</td>
							<td>
								<s:property value="serie" />
							</td>
							<td>
								<s:property value="gru" />
							</td>
							<td>
								<s:property value="data" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
		
	</div>
	
	<es:rodape descricao="${usuarioLogadoVo.nomeUsuario}"/>
	
	</body>

	<script type="text/javascript">
	
	
		$(document).ready(function($) {
			
			$(":file").filestyle({ 
			      icon: true,
			      buttonText:"Selecionar Arquivo"
			});

			$('#btnSubmit').attr("value", "Ler Arquivo");
			$('#btnSubmit').hide();
			
			var quantidadeEnsaiosRelatorio = $('#quantidadeEnsaiosRelatorio').val();
			
			$('.resultado').hide();
			
			if(quantidadeEnsaiosRelatorio != '0' && quantidadeEnsaiosRelatorio != ''){
				$('.resultado').show();
			    $('#botao_incluir').show();
			}else{
			    $('#botao_incluir').hide();
			}
			
			
			$('#nomeArquivo').change(function(){
			    
				var nomeArquivo = $(this).val();
				var extensao = nomeArquivo.substring(nomeArquivo.lastIndexOf("."));
				
			    if(extensao == ".pdf"){
					$('#btnSubmit').attr("value", "Ler Arquivo");
					$('#btnSubmit').removeClass('btn-warning');
			    	$('#btnSubmit').addClass('btn-info');
			    	$('#btnSubmit').removeAttr("disabled");
					$('#btnSubmit').show();
			    }else{
			    	$('#btnSubmit').attr("value", "Selecione um arquivo PDF!");
			    	$('#btnSubmit').attr("disabled", "disabled");
			    	$('#btnSubmit').removeClass('btn-info');
			    	$('#btnSubmit').addClass('btn-warning');
					$('#btnSubmit').show();
			    }
			});
			
			
			$('#campoBusca').val('');
			$('#filtrar').val(false);
			
		});
		
		$('.dropdown-toggle').dropdown();
		
			function selBrowser(codigo){
			
		}
			
		function filtrar(){
			
			$('#filtrar').val(true);
			$('#cad010').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad010').attr("action","Cad010Action!crud.action?ac=consultar&codigoProgramaSelecionado="+codigo);
			$('#cad010').submit();
			
		}
		
			
	</script>
</html>
