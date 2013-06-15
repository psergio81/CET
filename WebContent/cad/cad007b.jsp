<%@ include file="/include/principal.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>
	
		<title>[cad007b.jsp] Cadastro de Tacógrafo</title>
		
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true" />
		
		<es:botoesBrowse codigoPrograma="cad007"/>		
		
	</div>

	<div class="container-fluid">
        <div class="container">
            <s:form id="cad007" action="Cad007Action!browser.action" theme="simple" cssClass="well form-horizontal">
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
		<s:if test="%{listaTacografo.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
			<table width="100%" class="table table-bordered table-striped ">
	
				<thead>
					<tr>
						<th width="25%"><fmt:message key="label.padrao.codigo"/></th>
						<th width="25%"><fmt:message key="label.padrao.marca"/></th>
						<th width="25%"><fmt:message key="label.padrao.modelo"/></th>
						<th width="25%"><fmt:message key="label.padrao.numero.serie"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaTacografo" status="status">
						<tr onclick="javaScript:detalhes('<s:property value="codigoTacografo" />')">
							<td>
								<a>
									<fmt:formatNumber value="${codigoTacografo}" type="number"  minIntegerDigits="6" />
								</a>
							</td>
							<td>
								<a><s:property value="nomeMarca" /></a>
							</td>
							<td>
								<a><s:property value="nomeModelo" /></a>
							</td>
							<td>
								<a><s:property value="codigoSerie" /></a>
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
			$('#cad007').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad007').attr("action","Cad007Action!crud.action?ac=consultar&codigoTacografoSelecionado="+codigo);
			$('#cad007').submit();
			
		}
		
			
	</script>
</html>
