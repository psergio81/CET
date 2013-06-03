<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<%@ taglib tagdir="/WEB-INF/tags" prefix="es" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cet" %>

<script src="${pageContext.request.contextPath}/padrao/jquery/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/padrao/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
<script src="${pageContext.request.contextPath}/padrao/jquery/jquery-ui-1.7.3.custom.min.js" type="text/javascript"></script>	

<script src="${pageContext.request.contextPath}/padrao/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/padrao/bootstrap/js/bootstrap-filestyle.js"></script>
<script src="${pageContext.request.contextPath}/padrao/bootstrap/js/bootstrap-dropdown.js"></script>
<script src="${pageContext.request.contextPath}/padrao/bootstrap/js/bootstrap-modal.js"></script>

<script src="${pageContext.request.contextPath}/padrao/scripts/script.js"></script>
<script src="${pageContext.request.contextPath}/padrao/scripts/md5.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/bootstrap_new_icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/jquery-ui-1.7.3.custom.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/estilo.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/padrao/bootstrap/css/dashboard.css">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<input type="hidden" id="mensagemErro" name="mensagemErro" value="${mensagemErro}">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
 <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->