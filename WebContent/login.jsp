<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	    <title>CET - LOGIN</title>
	    
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	    <!--[if lt IE 9]>
	    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
	
		<style type="text/css">
	      body {
	        padding-top: 60px;
	        padding-bottom: 40px;
	      }
	    </style>
	</head>
	
<body>
	

    <div class="container">
      
      <div class="container-fluid">
      
        <div class="container">

            <s:form id="loginAction" action="LoginAction!autenticacao.action" theme="simple" cssClass="well form-horizontal">
                
                <div class="control-group">
					<label for="nick" class="control-label">Login</label>
					<div class="controls">
						<s:textfield name="usuarioVo.nick" id="nick" cssClass="input-xxlarge required"/>
					</div>
				</div>

                <div class="control-group">
                	<label for="razaoSocial" class="control-label">Senha</label>
					<div class="controls">
		                <s:password name="usuarioVo.senha" id="senha" cssClass="input-xxlarge required" />
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
			<!-- mensagem de alerta para o validate -->
			<div id="divErros" onchange="javaScript:carregaLista()" class="well alert alert-error" style="overflow; position:absolute; display: block; width: 300px;" >
				<button type="button" class="close" data-dismiss="modal">×</button>
				<ul id="listaErros" > </ul>  
			</div>
			<!-- fim da mensagem de alerta -->
			
		</div>
		
	  </div>
	  
	</div>

  </body>
</html>

<script>

$(document).ready(function(){

	$('#divErros').css('display','none');
	
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
                required: "O campo Loginn é obrigatório."
            },
        	"usuarioVo.senha":{
                required: "O campo Senha é obrigatório."
            }
        }
    });
});

function autenticar(){
	
	var senha = $('#senha').val();
	senha = $.md5(senha);
	
	$('#senha').val(senha);
	
	
	if(buscaProximoCampo() == true){
		
		$('#textoBtnLogin').html('Logando...');
	}else{
		
		$('#divErros').fadeIn(2000).fadeOut('slow');
		
	}
	
	$('#loginAction').delay(1000).submit();
	
}

</script>