<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="mostrarNomePrograma" required="true" %>

		<div class="barra">
			<div class="c_clogo" style="min-width: 170px; display: table; margin-right: 10px;" title="Principal">
				<div style="display: table-row;">
					<div style="display: table-cell; vertical-align: middle; text-align: center;">
						CET
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
									<s:a action="Cad008Action!browser.action">Usuário</s:a>
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
									<s:a action="Cad007Action!browser.action">Tacógrafo</s:a>
								</a>
							</li>								
							<li>
								<a href="#">
									<s:a action="Cad005Action!browser.action">Veículo</s:a>
								</a>
							</li>
							
							<li class="divider" />
							
							<li>
								<a href="#">
									<s:a action="Cad004Action!browser.action">Ensaio</s:a>
								</a>
							</li>
						</ul>
					</li>
				</ul>
				<ul class="nav">
					<li class="dropdown">
                       	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                       		Relatórios <b class="caret"></b>
                       	</a>
                     	
                       	<ul class="dropdown-menu">
							<li>
								<a href="#">
									<s:a action="Cad001Action!browser.action">Ensaios</s:a>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			
			<c:if test="${mostrarNomePrograma == true}">
			
				<div class="c_clogo" style="min-width: 300px; float: right; display: table;">
					<div style="display: table-row;">
						<div style="display: table-cell; vertical-align: middle; text-align: center;">
							<c:out value="${nomePrograma}" />
						</div>
					</div>
				</div>
			
			</c:if>
                </div>
	    </div>