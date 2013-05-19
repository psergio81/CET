<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="codigoPrograma" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="funcao" required="true" %>
<%@ attribute name="nomeIcone" required="false" %>


<c:if test="${nomeIcone == ''  || nomeIcone == null}">
    <c:set var="nomeIcone" value="icon-list-alt"/>
</c:if>


<a href="javascript: <c:out value="${funcao}" />('<c:out value="${codigoPrograma}" />');" class="shortcut">
    <i class="shortcut-icon  <c:out value="${nomeIcone}" />"></i> 
    <span class="shortcut-label">
       <c:out value="${label}" />
    </span>
</a> 
