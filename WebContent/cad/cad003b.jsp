<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>[cad003b.jsp] Cadastro de Modelo</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
		
		 <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
   		 <!--[if lt IE 9]>
	      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
		
		<style>
		 body {
        	padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      	 }
      	 </style>
      	 
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="row">
				<div class="span4">
					<a class="btn btn-info" href="javaScript:irParaPrincipal('cad003');">
						<i class="icon-home icon-white">
						</i>
						<fmt:message key="label.padrao.principal"/>
					</a>
				</div>
				
				<div class="span4" align="center">
					<a class="btn btn-success" onclick="javaScript:irParaCrud('cad003');">
						<i class="icon-plus icon-white icon">
						</i><fmt:message key="label.padrao.incluir"/>
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

            <s:form id="cad003" action="Cad003Action!browser.action" theme="simple" cssClass="well form-inline">
                <s:hidden name="filtrar" id="filtrar" />
                
				<p>
                	<label for="descricao" class="label"><fmt:message key="label.padrao.filtro"/></label>
	                <s:textfield name="campoBusca" id="campoBusca" required="required" cssClass="input-300 search-query" />
					<a class="btn btn" href="javaScript:filtrar();">
						<i class="icon-search icon">
						</i><fmt:message key="label.padrao.buscar"/>
					</a>
                </p>
                
            </s:form>
        </div>
    </div>

	<div class="container">
		
		<s:if test="%{listaModelo.isEmpty()}">
		    <div class="alert">
		  		<strong>Sem Resultado!</strong> Não existe nenhum registro para a busca atual.
			</div>
		
		</s:if>
		<s:else>
		
			<table width="100%" class="table table-bordered table-striped ">
				<thead>
					<tr>
						<th width="20%"><fmt:message key="label.padrao.codigo"/></th>
						<th width="*"><fmt:message key="label.padrao.descricao"/></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator  value="listaModelo" status="status">
						<tr onclick="javaScript:detalhes('<s:property value="codigoModelo" />')">
							<td>
								<a>
									<fmt:formatNumber value="${codigoModelo}" type="number"  minIntegerDigits="6" />
								</a>
							</td>
							<td>
								<a><s:property value="descricao" /></a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:else>
	
	</div>
	
	<ensaio:rodape descricao="${usuarioLogado}"/>
	
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
			$('#cad003').submit();
			
		}
		
		function detalhes(codigo){
			$('#ac').val(' ');
			$('#cad003').attr("action","Cad003Action!crud.action?ac=consultar&codigoModeloSelecionado="+codigo);
			$('#cad003').submit();
			
		}
		
			
	</script>
</html>
