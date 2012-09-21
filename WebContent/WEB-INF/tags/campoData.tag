<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-tags" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="name" required="true" %>
<%@ attribute name="id" required="true" %>



<label for="data" class="label"><fmt:message key="label.padrao.data"/></label>
<s:textfield name="#name" id="#id" cssClass="input-small" />

<script type="text/javascript">
	$("#dataEnsaio").datepicker({dateFormat: 'dd/mm/yy'});
</script>