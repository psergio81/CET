<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<table class="table table-bordered table-striped ">

	<thead>
		<tr>
			<th colspan="6" style="text-align: center;"><fmt:message key="label.padrao.tacografos.associados"/></th>
		</tr>
		<tr>
			<th width="20%"><fmt:message key="label.padrao.codigo"/></th>
			<th width="40%"><fmt:message key="label.padrao.numero.serie"/></th>
			<th width="10%"><fmt:message key="label.padrao.data.inicio"/></th>
			<th width="10%"><fmt:message key="label.padrao.data.fim"/></th>
			<th width="10%"><fmt:message key="label.padrao.hora.inicio"/></th>
			<th width="10%"><fmt:message key="label.padrao.hora.fim"/></th>
		</tr>
	</thead>
	
	<tbody>
		<s:iterator  value="listaTacografosAssociados" status="status">
			<tr onclick="javaScript:detalhes('<s:property value="codigoTacografo" />')">
				<td>
					<a>
						<fmt:formatNumber value="${codigoTacografo}" type="number"  minIntegerDigits="6" />
					</a>
				</td>
				<td>
					<a><s:property value="serie" /></a>
				</td>
				<td>
					<a><s:property value="dataInicio" /></a>
				</td>
				<td>
					<a><s:property value="dataFim" /></a>
				</td>
				<td>
					<a><s:property value="horaInicio" /></a>
				</td>
				<td>
					<a><s:property value="horaFim" /></a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
