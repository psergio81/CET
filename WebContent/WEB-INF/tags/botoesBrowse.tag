<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="codigoPrograma" required="true" %>

	<div class="navbar-inner2">
		<div style="display: table-cell; vertical-align: middle;">
			<a class="btn btn-success" onclick="javaScript:irParaCrud('<c:out value="${codigoPrograma}" />');">
					<i class="icon-plus icon-white icon">
					</i><fmt:message key="label.padrao.incluir"/>
			</a>
		</div>
	</div>