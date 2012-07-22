<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  taglib  prefix="c"   uri="/struts-tags" %>    
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html lang="en">
	<head>
    	<meta charset="utf-8">
	    <title>CET - LOGIN</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
		<script src="/CET/padrao/jquery/jquery.js"></script>
		<script src="/CET/padrao/jquery/jquery.validate.js" type="text/javascript"></script>
		<script src="/CET/padrao/jquery/jquery.maskedinput.js" type="text/javascript"></script>	
		<script src="/CET/padrao/bootstrap/js/bootstrap.js"></script>
		
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">
		<style type="text/css">
	      body {
	        padding-top: 60px;
	        padding-bottom: 40px;
	      }
	    </style>
		<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap-responsive.css">

	</head>
	
<body>
	

    <div class="container">
      
      <div class="container-fluid">
      
        <div class="container">

            <s:form id="loginAction" action="LoginAction!autenticacao.action" theme="simple" cssClass="well form-horizontal">
                
                <div class="control-group">
					<label for="nick" class="control-label">Login</label>
					<div class="controls">
						<s:textfield name="usuarioVo.nick" id="nick" required="true" cssClass="input-xxlarge"/>
					</div>
				</div>

                <div class="control-group">
                	<label for="razaoSocial" class="control-label">Senha</label>
					<div class="controls">
		                <s:textfield name="usuarioVo.senha" required="true" id="senha" cssClass="input-xxlarge " />
					</div>
				</div>
				
				<div class="control-group">
					<div class="controls">
						<a id="botaoLogar" class="btn btn-success" href="javaScript:autenticar();">
							<i class="icon-ok icon-white"></i>
							<span id="textoBtnLogin">Login</span>
						</a>
					</div>
				</div>
				
				<div class="control-group">
					<div class="controls">
					<p> Usuário e senha Padrão (Login = adm, senha = a) é só rodar o atualiza que cria o usuário. Qualquer erro me avisem abs!</p>
					</div>
				</div>
				
			</s:form>
			
		</div>
		
	  </div>
	  
	</div>

  </body>
</html>

<script>

$(document).ready(function(){
	
	$('#loginAction').validate({
        rules:{
        	senha:{
                required: true
            }
        },
        messages:{
        	senha:{
                required: "O campo Senha é obrigatorio.",
            }
        }
    });
});

function autenticar(){
	
	$('#textoBtnLogin').html('Logando...');
	
	$('#loginAction').submit();
	
}

</script>