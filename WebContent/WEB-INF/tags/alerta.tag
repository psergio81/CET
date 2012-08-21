<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="titulo" required="false" %>
<%@ attribute name="descricao" required="false" %>


<div class="modal hide" id="divAlerta">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>
    <h3>${titulo}</h3>
  </div>
  <div class="modal-body">
    <p>${descricao}</p>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn" data-dismiss="modal"><fmt:message key="label.padrao.cancelar"/></a>
    <a href="javascript:excluirCadastro()" class="btn btn-primary"><fmt:message key="label.padrao.ok"/></a>
  </div>
</div>