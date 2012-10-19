<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="mostrarNomePrograma" required="true" %>

		<div class="navbar-inner">
			<c:if test="${mostrarNomePrograma == true}">
				<div class="pull-right">
					<input type="text" class="span2 search-query" value="${nomePrograma}" style="width: 300px; text-align: center; margin-top: 1px; margin-right: 5px;">
				</div>
			</c:if>
	    </div>

	     <div class="dropdown clearfix navbar-fixed-top menu">
			<a class="dropdown-toggle" data-toggle="dropdownMenu" href="#menu">
				<img src="icones/menu3.png" alt="" class="icone">
			</a>

			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li class="dropdown-submenu">
					<a tabindex="-1" href="#">Cadastro</a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">
								<s:a action="Cad001Action!browser.action">Empresa</s:a>
							</a>
						</li>
						<li>
							<a href="#">
								<s:a action="Cad008Action!browser.action">Usuário</s:a>
							</a>
						</li>
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
								<s:a action="Cad004Action!browser.action">Ensaio</s:a>
							</a>
						</li>
						<li>
							<a href="#">
								<s:a action="Cad005Action!browser.action">Veículo</s:a>
							</a>
						</li>
						<li>
							<a href="#">
								<s:a action="Cad006Action!browser.action">Pessoa</s:a>
							</a>
						</li>
						<li>
							<a href="#">
								<s:a action="Cad007Action!browser.action">Tacógrafo</s:a>
							</a>
						</li>
					</ul>
				</li>
				<li class="dropdown-submenu">
					<a tabindex="-1" href="#">Relatórios</a>
					
					<ul class="dropdown-menu">
						<li>
							<a href="#">
								<s:a action="Cad007Action!browser.action">Ensaio</s:a>
							</a>
						</li>
						<li class="dropdown-submenu">
							<a tabindex="-1" href="#">More options</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
					</ul>
				</li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
						<li><a tabindex="-1" href="#">Second level link</a></li>
					</ul>
				</li>
			</ul>
		</div>
