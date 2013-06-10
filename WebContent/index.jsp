<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<%@ include file="/include/principal.jsp"%>

<title>CET</title>


<style type="text/css">
    
    body {
        padding-top: 50px;
    }
    
    .widget-content {
        margin-bottom: 5px;
    }
    
    .maximizarInformacoes{
        
        width: 30%;
    
    }

    .maximizarOrdemServicoPendente{
        
        width: 65.96% !important;
    
    }
    .maximizarOrdemServicoPendente tbody{
        
        font-size: medium;
    
    }

</style>


</head>

<body>

	<div class="navbar navbar-fixed-top">

		<es:menu mostrarNomePrograma="false" />

	</div>
	
	<input type="hidden" id="mostraAtalho" value="${usuarioVo.mostraAtalhosTelaInicial}"> 
	<input type="hidden" id="mostraGrafico" value="${usuarioVo.mostraGraficoTelaInicial}"> 
	
    <div class="container-fluid" id="atalhos">
        <div class="widget">
            <div class="widget-content" style="padding: 5px 5px 5px">
                <div class="shortcuts">
                    
                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad004" label="Ensaio" nomeIcone="icon-list-alt"/>
                    
                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad011" label="Agendamento" nomeIcone="icon-calendar"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad001" label="Empresa" nomeIcone="icon-briefcase"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad005" label="Veículo" nomeIcone="icon-veiculo"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad002" label="Marca" nomeIcone="icon-tasks"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad003" label="Modelo" nomeIcone="icon-tasks"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad007" label="Tacógrafo" nomeIcone="icon-time"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad006" label="Pessoa" nomeIcone="icon-user"/>

                    <cet:botao_atalho funcao="irParaRelatorio" codigoPrograma="Rel001" label="Relatório" nomeIcone="icon-file"/>

                    <cet:botao_atalho funcao="irParaPrograma" codigoPrograma="Cad010" label="Upload" nomeIcone="icon-upload"/>
                    
                </div>
            </div>
        </div>
    </div>
	
	
	
	<div class="container-fluid">
		<div class="row-fluid">

			<div class="span4 maximizarInformacoes" id="informacoes">
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
			
			<div class="span4 widget-content" id="grafico">
                <cet:grafico tituloDaSerie="Ensaios" tituloDoGrafico="Ensaios por Mês" /> 
            </div>
            
			<div class="span4 widget-content maximizarOrdemServicoPendente" style="height: 297px; overflow-y: scroll; font-size: 8px !important;" id="ordemServico">
			     <table class="table table-condensed">
			         <thead>
                           <tr>
                                <th colspan="3" style="text-align: center;">
                                    Ordem de Serviço Pendente
                                </th>
                           </tr>			         
			         </thead>
                     <s:if test="%{listaEnsaio.isEmpty()}">
                        <tbody>
                            <tr>
                                <td>
			                         <div class="alert">
			                             <strong>Sem Resultado!</strong><br> Não existe Ordem de Serviço Pendente.
			                         </div>
                                </td>
                            </tr>
                        
                        </tbody>
     
                     </s:if>
                     <s:else>
				         <tbody>
				                <tr>
				                    <th>
                                        Código				                    
				                    </th>
				                    <th>
                                        Data				                    
				                    </th>
				                    <th>
                                        Hora Inicio				                    
				                    </th>
				                </tr>
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
		                                <td>
		                                    <a><s:property value="horaInicio" /></a>
		                                </td>
		                            </tr>
		                        </s:iterator>
				         </tbody>
                    </s:else>
			     </table>
            </div>

		</div>
	</div>


	<hr>

	<footer>
	<p>&copy; Stdio.H - Company 2012</p>
	</footer>

</body>

<script type="text/javascript">


    $(document).ready(function(){
    	
    	var $mostraGrafico = $('#mostraGrafico').val();
    	var $mostraAtalho = $('#mostraAtalho').val();
    	
    	
    	if($mostraAtalho == 'true'){
    		$('#atalhos').show();
    	}else{
    		$('#atalhos').hide();
    	}
    	if($mostraGrafico == 'true'){
    		$('#grafico').show();
    		$('#ordemServico').removeClass('maximizarOrdemServicoPendente');
    	}else{
    		$('#grafico').hide();
    		$('#ordemServico').addClass('maximizarOrdemServicoPendente');
    	}
    	
    });


    function irParaPrograma(action){

    	var newForm = $('<form>', {
            'action': action+'Action!browser.action',
            'name': 'irParaProgrma',
            'id': 'irParaProgrma',
            'method':'Post'
        });

    	newForm.submit();
    }
    function irParaRelatorio(action){
    	
    	$('<form/>').attr('action',action+'Action!crud.action').attr('target','_blank').submit();

    }
    
    function detalhes(codigo){
    	
    	var newForm = $('<form>', {
            'action': 'Cad004Action!crud.action?ac=consultar&codigoEnsaioSelecionado='+codigo,
            'method':'Post'
        });
    	
    	newForm.submit();
        
    }
    
</script>

</html>
