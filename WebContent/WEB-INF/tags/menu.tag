<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="mostrarNomePrograma" required="true" %>

		<div class="barra">
			<div class="c_clogo" style="min-width: 170px; display: table; margin-right: 10px; cursor: pointer;" title="Principal">
				<div style="display: table-row;">
					<div style="display: table-cell; vertical-align: middle; text-align: center;">
						<i class="icon-home icon-white"></i>
						<s:a action="Cad001Action!principal.action">CET</s:a>
					</div>
				</div>
			</div>
			
			<div>
				<div class="nav-collapse collapse navbar-responsive-collapse">
					<ul class="nav">
						<li class="dropdown">
                        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        		Cadastros <b class="caret"></b>
                        	</a>
                        	
                        	<ul class="dropdown-menu">
							<li>
								<a href="#">
									<s:a action="Cad001Action!browser.action">Empresa</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad006Action!browser.action">Pessoa</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad008Action!browser.action">Usu�rio</s:a>
								</a>
							</li>
							
							<li class="divider"></li>
	                   		
							<li>
								<a href="#">
									<s:a action="Cad002Action!browser.action">Marca</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad003Action!browser.action">Modelo</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad007Action!browser.action">Tac�grafo</s:a>
								</a>
							</li>								
							<li>
								<a href="#">
									<s:a action="Cad005Action!browser.action">Ve�culo</s:a>
								</a>
							</li>
							
							<li class="divider" />
							
							<li>
								<a href="#">
									<s:a action="Cad004Action!browser.action">Ensaio</s:a>
								</a>
							</li>

							<li>
								<a href="#">
									<s:a action="Cad009Action!browser.action">Programa</s:a>
								</a>
							</li>

							<li>
								<a href="#">
									<s:a action="Cad010Action!browser.action">Upload</s:a>
								</a>
							</li>
						</ul>
					</li>
				</ul>
				<ul class="nav">
					<li class="dropdown">
                       	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                       		Relat�rios <b class="caret"></b>
                       	</a>
                     	
                       	<ul class="dropdown-menu">
							<li>
								<a href="#">
									<s:a action="Rel001Action!crud.action">Ensaios</s:a>
								</a>
							</li>
						</ul>
                       	<ul class="dropdown-menu">
							<li>
								<a href="#">
									<s:a action="Rel001Action!crud.action" target="_blank">Ensaios</s:a>
								</a>
							</li>
							
							<li>
								<a href="#">
									<s:a action="Rel002Action!browser.action">Log A��es</s:a>
								</a>
							</li>
						</ul>
					</li>
				</ul>
                
                <c:if test="${mostrarNomePrograma == false}">
					<ul class="nav">
						<li class="dropdown">
	                       	<a href="#" class="dropdown-toggle" data-toggle="dropdown" onclick="javacript:atalhos()">
	                       	    Atalhos
	                       	</a>
						</li>
					</ul>
					<ul class="nav">
						<li class="dropdown">
	                       	<a href="#" class="dropdown-toggle" data-toggle="dropdown" onclick="javacript:grafico()">
	                       	    Gr�fico
	                       	</a>
						</li>
					</ul>
				</c:if>
				<ul class="nav">
					<li class="dropdown">
                       	<a href="#" class="dropdown-toggle" data-toggle="dropdown" onclick="javacript:sair()">
                       	    Sair
                       	</a>
					</li>
				</ul>
			</div>
			
			<c:if test="${mostrarNomePrograma == true}">
				<div class="c_clogo" style="min-width: 300px; display: table; float: right;">
					<div style="display: table-row;">
						<div style="display: table-cell; vertical-align: middle; text-align: center;">
							<c:out value="${nomePrograma}" />
						</div>
					</div>
				</div>
			
			</c:if>
        </div>
    </div>
	    
	    
<script type="text/javascript">
    
    function sair(){
    	$('<form/>').attr('action','LogoutAction!logout.action').submit();
    }

    function atalhos(){
    	$('#atalhos').toggle('slow');
    }
    function grafico(){
    	
    	var visivel = $('#grafico').is(':visible');
    	
    	
	    	$('#grafico').toggle('slow');
    	if(visivel){
	    	$('#ordemServico').addClass('maximizarOrdemServicoPendente');
    	}else{
	    	$('#ordemServico').removeClass('maximizarOrdemServicoPendente');
    	}
    	
    }
</script>