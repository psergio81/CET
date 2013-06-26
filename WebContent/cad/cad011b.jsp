<%@ include file="/include/principal.jsp" %>
<!DOCTYPE html P UBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

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
                	<label for="razaoSocial" class="control-label" ><fmt:message key="label.padrao.cliente"/></label>
   					<div class="controls">
		                <s:textfield name="campoBusca" id="campoBusca" required="required" cssClass="span3" />
						<a class="btn btn" href="javaScript:filtrar();">
							<i class="icon-search icon">
							</i><fmt:message key="label.padrao.buscar"/>
						</a>
   					</div></div>
				 
               <div class="control-group">
                   <label for="data" class="control-label"><fmt:message key="label.padrao.data"/></label>
                   <div class="controls input-append">
                       <s:textfield id="dataAgendamento" name="agendamentoVo.dataAgendamento" cssClass="span2 data "/>
                       <span class="add-on btn" id="dataAtual"><i class="icon-calendar"></i></span>
                   </div>
               </div>

               <div class="control-group">
                   <label for="data" class="control-label"><fmt:message key="label.padrao.status.gru"/></label>
                   <div class="controls input-append">
                       <s:select name="agendamentoVo.codigoVeiculo"  id="listaVeiculos" list="#{'0':'Não Consultada', '1':'Ativa', '2':'Inativa' }" cssClass="span4" emptyOption="true"/>
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
						<th width="*"><fmt:message key="label.padrao.status.gru"/></th>
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
							<td>
								<a><s:property value="statusGru" /></a>
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
			setDataAtual('dataAgendamento');
			
			$('#dataAtual').click(function(){
		            
			    setDataAtual('dataAgendamento');
		            
	         });
			
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
