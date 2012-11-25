<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="descricao" required="true" %>


<div class="navbar navbar-fixed-bottom">
   	<div class="rodape">
	   	<div class="c_clogo" style="min-width: 300px; float: right; display: table;">
			<div style="display: table-row;">
				<div style="display: table-cell; vertical-align: middle; text-align: center;">
					<c:out value="${descricao}" />
				</div>
			</div>
		</div>
   	</div>
</div>