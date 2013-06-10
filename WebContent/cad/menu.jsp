<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="/struts-tags" prefix="s"%>

<body>
	
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav nav-pills">
					<li class="dropdown" id="menu1">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
							Cadastros<b class="caret"></b>
						</a>
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
				</ul>

				<ul class="nav nav-pills">
					<li class="dropdown" id="menu2">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#menu2">
							Relatórios<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">
									Ensaios
								</a>
							</li>
    					</ul>
  					</li>
				</ul>
			</div>
		</div>
	</div>
