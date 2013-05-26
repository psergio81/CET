<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>

		<title>[cad004b.jsp] Cadastro de OS</title>
		
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true" />
		
		<es:botoesBrowse codigoPrograma="cad004"/>		
		
	</div>

	<div class="container-fluid">
        <div class="container">
            <s:form id="cad004" action="Cad004Action!browser.action" theme="simple" cssClass="well form-horizontal">
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
		<s:if test="%{listaEnsaio.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
			<table width="100%" class="table table-bordered table-striped ">
	
				<thead>
					<tr>
						<th width="20%"><fmt:message key="label.padrao.codigo"/></th>
						<th width="*"><fmt:message key="label.padrao.data"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaEnsaio" status="status">
						<tr onclick="javaScript:detalhes('<s:property value="codigoEnsaio" />')">
							<td>
								<a>
									<fmt:formatNumber value="${codigoEnsaio}" type="number"  minIntegerDigits="6" />
								</a>
							</td>
							<td>
								<a><s:property value="data" /></a>
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
			$('#cad004').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad004').attr("action","Cad004Action!crud.action?ac=consultar&codigoEnsaioSelecionado="+codigo);
			$('#cad004').submit();
			
		}
		
			
	</script>
</html>
