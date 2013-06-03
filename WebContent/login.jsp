<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>CET - LOGIN</title>
	    
		<style type="text/css">
	
			body {
				padding-top: 40px;
				padding-bottom: 40px;
				background-color: #f5f5f5;
			}
	
	    </style>
	</head>
	
<body>
		
	<s:form id="loginAction" action="LoginAction!autenticacao.action" theme="simple" cssClass="form-signin">
	
		<h3 class="form-signin-heading">Ensaio de Tacógrafos</h3>
        <s:textfield name="usuarioVo.nick" id="nick" cssClass="input-block-level required" placeholder="Login"/>
        <s:password name="usuarioVo.senha" id="senha" cssClass="input-block-level required" placeholder="Senha" />
        
        <div class="control-group pull-right" >
			<div class="controls">
				<a id="botaoLogar" class="btn btn-large btn-primary" href="javaScript:autenticar();">
					<i class="icon-ok icon-white"></i>
					<span id="textoBtnLogin">Login</span>
				</a>
			</div>
		</div>
		
		<p class="text-info"> Usuário e senha Padrão (Login = adm, senha = a) </p>        

      </s:form>
      
      <es:mensagemErro />
			
  </body>

<script type="text/javascript">


$(document).ready(function(){

	$('#divErros').hide();
	
	$('#loginAction').validate({
	
		errorLabelContainer: "#listaErros",
		errorElement: "li",
		
        rules:{
        	"usuarioVo.nick":{
                required: true
            },
            "usuarioVo.senha":{
                required: true
            }
        },
        messages:{
        	"usuarioVo.nick":{
                required: "O campo Login é obrigatório."
            },
        	"usuarioVo.senha":{
                required: "O campo Senha é obrigatório."
            }
        }
    });
});

function autenticar(){
	
	var senha = $('#senha').val();
	if(senha != ''){
		senha = $.md5(senha);
	}
	
	$('#senha').val(senha);
	
	
	if(buscaProximoCampo() == true){
		
		$('#textoBtnLogin').html('Logando...');
	}else{
		
		$('#divErros').fadeIn(2000).fadeOut('slow');
		
	}
	
	$('#loginAction').delay(1000).submit();
	
}

</script>

</html>

