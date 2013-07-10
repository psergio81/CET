<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


    <s:iterator  value="listaAgendamentos" status="status">
        <tr>
            <td>
                <s:property value="horaAgendamento" />
            </td>
            <td>
                <s:property value="nomeTipoServico" />
            </td>
        </tr>
    </s:iterator>