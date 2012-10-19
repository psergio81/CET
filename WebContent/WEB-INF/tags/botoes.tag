<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="codigoPrograma" required="true" %>

<div class="navbar-inner2">
	<div style="display: table-cell; vertical-align: middle; width: 20%;">
		<a class="btn btn-info" href="javaScript:irParaBrowser('<c:out value="${codigoPrograma}" />');">
			<i class="icon-search icon-white">
			</i>
			<fmt:message key="label.padrao.busca"/>
		</a>
	</div>
	
	<div style="display: table-cell; vertical-align: middle;">
	
	
		<a id="botaoCancelar" class="btn btn-danger" href="javaScript:cancelarCadastro();">
			<i class="icon-remove icon-white"></i>
			<span id="textoBtnCancelarExcluir"><fmt:message key="label.padrao.cancelar"/></span>
		</a>
		<a id="botaoSalvar" class="btn btn-success" href="javaScript:salvarCadastro();">
			<i class="icon-ok icon-white"></i>
			<span id="textoBtnSalvarAlterar"><fmt:message key="label.padrao.salvar"/></span>
		</a>
		
	</div>
	<div style="display: table-cell; vertical-align: middle;width: 20%;"></div>
</div>
