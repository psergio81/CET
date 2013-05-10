<%@ include file="/include/principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<title>CET</title>


<style type="text/css">
    
    body {
        padding-top: 50px;
    }
    
    .widget-content {
        margin-bottom: 5px;
    }

</style>


</head>

<body>

	<div class="navbar navbar-fixed-top">

		<es:menu mostrarNomePrograma="false" />

	</div>
	
	<div class="container">
		<div class="row-fluid">

			<div class="span7">
				<div class="widget-content">
					<p>
						<b>Usuário:</b> <c:out value="${usuarioVo.nomeUsuario}" /><br>
						<b>Empresa:</b> <c:out value="${empresaVo.codigoEmpresa}"/> - <c:out value="${empresaVo.razaoSocial}"/>
					</p>
				</div>
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>Ensaios</td>
								<td class="text-center">
								    <c:out value="${quantidadeEnsaios}" />
                                </td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Veículos</td>
								<td><c:out value="${quantidadeVeiculos}" /></td>
							</tr>
							<tr>
								<td>Tacógrafos</td>
								    <td><c:out value="${quantidadeTacografos}" /></td>
							</tr>
							<tr>
								<td>Pessoas</td>
								<td><c:out value="${quantidadePessoas}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			<div class="span5 widget-content">
                <cet:grafico tituloDaSerie="Ensaios" tituloDoGrafico="Ensaios por Mês" /> 
            </div>

		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="span12" style="margin-left: 0px; width: 980px;">
				<div class="widget">
					<div class="container-fluid">
						<div class="widget-content">
							<div class="shortcuts">
								<a href="javascript:irParaPrograma('Cad004');" class="shortcut">
									<i class="shortcut-icon icon-list-alt"></i> <span
									class="shortcut-label">Ensaio</span>
								</a> <a href="javascript:irParaPrograma('Cad001');" class="shortcut">
									<i class="shortcut-icon icon-bookmark"></i> <span
									class="shortcut-label">Empresa</span>
								</a> <a href="javascript:irParaPrograma('Cad005');" class="shortcut">
									<i class="shortcut-icon icon-signal"></i> <span
									class="shortcut-label">Veículo</span>
								</a> <a href="javascript:irParaPrograma('Cad002');" class="shortcut">
									<i class="shortcut-icon icon-signal"></i> <span
									class="shortcut-label">Marca</span>
								</a> <a href="javascript:irParaPrograma('Cad003');" class="shortcut">
									<i class="shortcut-icon icon-signal"></i> <span
									class="shortcut-label">Modelo</span>
								</a> <a href="javascript:irParaPrograma('Cad007');" class="shortcut">
									<i class="shortcut-icon icon-comment"></i> <span
									class="shortcut-label">Tacógrafo</span>
								</a> <a href="javascript:irParaPrograma('Cad006');" class="shortcut">
									<i class="shortcut-icon icon-user"></i> <span
									class="shortcut-label">Pessoa</span>
								</a> <a href="javascript:irParaRelatorio('Rel001');" class="shortcut">
									<i class="shortcut-icon icon-file"></i> <span
									class="shortcut-label">Relatório</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<footer>
	<p>&copy; Stdio.H - Company 2012</p>
	</footer>

</body>

<script type="text/javascript">

    function irParaPrograma(action){
    	
    	$('<form/>').attr('action',action+'Action!browser.action').submit();

    }
    function irParaRelatorio(action){
    	
    	$('<form/>').attr('action',action+'Action!crud.action').attr('target','_blank').submit();

    }
    
</script>

</html>
