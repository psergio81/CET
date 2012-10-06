<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:select name="tacografosDisponiveis" id="tacografosDisponiveis" list="listaTacografo" listKey="codigoTacografo" listValue="codigoSerie" emptyOption="true" template="false" ></s:select>