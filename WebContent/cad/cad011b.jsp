<!DOCTYPE html P UBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<%@ include file="/include/principal.jsp" %>

	<head>
		
		<title>[cad011b.jsp] Cadastro de Agendamento</title>
      	 
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true" />
		
		<es:botoesBrowse codigoPrograma="cad011"/>		
		
	</div>
	
	<div class="container-fluid">
        <div class="container">
            <s:form id="cad011" action="Cad011Action!browser.action" theme="simple" cssClass="well form-horizontal">
                <s:hidden name="filtrar" id="filtrar" />
        
        		<div class="control-group">
                	<label for="razaoSocial" class="control-label" ><fmt:message key="label.padrao.filtro"/></label>
   					<div class="controls">
		                <s:textfield name="campoBusca" id="campoBusca" required="required" cssClass="span3" />
						<a class="btn btn" href="javaScript:filtrar();">
							<i class="icon-search icon">
							</i><fmt:message key="label.padrao.buscar"/>
						</a>
   					</div>
				</div>
            </s:form>
        </div>
    </div>
    
	<div class="container">
		<s:if test="%{listaAgendamento.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
		    <table width="100%" class="table table-bordered table-striped ">

				<thead>
					<tr>
						<th width="20%"><fmt:message key="label.padrao.codigo"/></th>
						<th width="*"><fmt:message key="label.padrao.proprietario"/></th>
						<th width="*"><fmt:message key="label.padrao.tipo.servico"/></th>
						<th width="*"><fmt:message key="label.padrao.data"/></th>
						<th width="*"><fmt:message key="label.padrao.hora"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaAgendamento" status="status">
						<tr onclick="javaScript:detalhes('<s:property value="codigoAgendamento" />')">
							<td>
								<a><fmt:formatNumber value="${codigoAgendamento}" type="number"  minIntegerDigits="6" /></a>
							</td>
							<td>
								<a><s:property value="nomeProprietario" /></a>
							</td>
							<td>
								<a><s:property value="nomeTipoServico" /></a>
							</td>
							<td>
								<a><s:property value="dataAgendamento" /></a>
							</td>
							<td>
								<a><s:property value="horaAgendamento" /></a>
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
			
			$('#campoBusca').val('');
			$('#filtrar').val(false);
			
		});
		
		$('.dropdown-toggle').dropdown();
		
			function selBrowser(codigo){
			
		}
			
		function filtrar(){
			
			$('#filtrar').val(true);
			$('#cad011').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad011').attr("action","Cad011Action!crud.action?ac=consultar&codigoAgendamentoSelecionado="+codigo);
			$('#cad011').submit();
			
		}
		
			
	</script>
</html>
