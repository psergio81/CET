<%@ include file="/include/principal.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>

		<title>[rel002b.jsp] Relatório de Log Ações</title>

	</head>
	
<body>

	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="true" />
		
		<es:botoesBrowse codigoPrograma="rel002"/>		
		
	</div>

	<div class="container-fluid">
        <div class="container">
            <s:form id="rel002" action="Rel002Action!browser.action" theme="simple" cssClass="well form-horizontal">
                <s:hidden name="filtrar" id="filtrar" />
        
        		<div class="control-group">
        		
                	<label for="descricaoLog" class="control-label" ><fmt:message key="label.padrao.filtro"/></label>
                	
   					<div class="controls">
   					
		                <s:textfield name="filtroVo.buscaTextoPadrao" id="buscaLog" required="required" cssClass="span3" />
		                
   					</div>
   					
				</div>
				
				<div class="control-group">
                   <label for="tipoServico" class="control-label"><fmt:message key="label.padrao.usuario"/></label>
                   <div class="controls input-append">
                       <s:select name="filtroVo.codigoUsuario" list="listaUsuario" listKey="codigoUsuario" listValue="nomeUsuario" emptyOption="true" cssClass="span4"/>
                   </div>
               </div>
               
                <div class="control-group">
                   <label for="dataInicial" class="control-label"><fmt:message key="label.padrao.data"/> <fmt:message key="label.padrao.inicial"/></label>
                   <div class="controls input-append">
                       <s:textfield id="dataInicial" name="filtroVo.dataInicial" cssClass="span2 data "/>
                       <span class="add-on btn" id="dataAtual"><i class="icon-calendar"></i></span>
                   </div>
               </div>
				
				
			  <div class="control-group">
                   <label for="dataInicial" class="control-label"><fmt:message key="label.padrao.data"/> <fmt:message key="label.padrao.final"/></label>
                   <div class="controls input-append">
                       <s:textfield id="dataFinal" name="filtroVo.dataFinal" cssClass="span2 data "/>
                       <span class="add-on btn" id="dataFinal"><i class="icon-calendar"></i></span>
                   </div>
               </div>
               
               <div class="control-group">
                   <label for="tipoServico" class="control-label"><fmt:message key="label.padrao.programa"/></label>
                   <div class="controls input-append">
                       <s:select name="filtroVo.codigoPrograma" list="listaPrograma" listKey="chave" listValue="valor" emptyOption="true" cssClass="span4"/>
                   </div>
               </div>
               
            </s:form>
        </div>
    </div>

	<div class="container">
		<s:if test="%{listaLog.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
		
			<table width="100%" class="table table-bordered table-striped ">
	
				<thead>
					<tr>
						<th width="20%"><fmt:message key="label.padrao.codigo"/></th>
						<th width="*"><fmt:message key="label.padrao.nome"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaEmpresa" status="status">
						<tr onclick="javaScript:detalhes('<s:property value="codigoEmpresa" />')">
							<td>
								<a>
									<fmt:formatNumber value="${codigoEmpresa}" type="number"  minIntegerDigits="6" />
								</a>
							</td>
							<td>
								<a><s:property value="razaoSocial" /></a>
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
		

		function filtrar(){
			
			$('#filtrar').val(true);
			$('#cad001').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad001').attr("action","Cad001Action!crud.action?ac=consultar&codigoEmpresaSelecionado="+codigo);
			$('#cad001').submit();
			
		}
		
			
	</script>
</html>
