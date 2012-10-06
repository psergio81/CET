<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%@ attribute name="param1" required="false" %>
<%@ attribute name="param2" required="false" %>

<label for="data" class="label"><fmt:message key="label.padrao.data"/></label>
<input type="text" name="${param1}" id="${param2}">



<script type="text/javascript">
	$("#dataEnsaio").datepicker({dateFormat: 'dd/mm/yy'});
</script>