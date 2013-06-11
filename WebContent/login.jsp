<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
	<head>

<%@ include file="/include/principal.jsp" %>

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
	
	   <s:hidden name="mensagemErro" id="mensagemErro" value="%{mensagemErro}"/>
	
		<h3 class="form-signin-heading">Ensaio de Tacógrafos</h3>
        <s:textfield name="usuarioVo.nick" id="nick" cssClass="input-block-level required"/>
        <s:password name="usuarioVo.senha" id="senha" cssClass="input-block-level required"/>
		
		<div id="progressbar" class="progress progress-striped active" style="display: none;">
            <div id="progresso" class="bar" style="width: 0%;"></div>
        </div>
        
        <div class="control-group pull-right" >
			<div class="controls">
				<a id="botaoLogar" class="btn btn-large btn-primary" href="javaScript:autenticar();">
					<i class="icon-ok icon-white"></i>
					<span id="textoBtnLogin">Login</span>
				</a>
			</div>
		</div>
		
		
      </s:form>
      
      <es:mensagemErro />
			
  </body>

<script type="text/javascript">


$(document).ready(function(){

	$('#divErros').hide();
	
	var mensagem = $('#mensagemErro').val();
    

    if(mensagem != null && mensagem != ''){
        $('#listaErros').html(mensagem);
        $('#divErros').fadeIn(2000).fadeOut('slow',function(){
	        $('#listaErros').html('');
        });
    }
	
	
	
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
	
	
	if(buscaProximoCampo() == false){
		
		$('#divErros').fadeIn(2000).fadeOut('slow');
		$('#loginAction').delay(1000).submit();
		
	}else{

		$('#textoBtnLogin').html('Logando...');
		$('#progressbar').show('slow');
		var progress = setInterval(function() {
		    var $bar = $('.bar');
	
		    if ($bar.width()==400) {
		        clearInterval(progress);
		        $('.progress').removeClass('active');
				$('#loginAction').delay(1000).submit();
				
		    } else {
		        $bar.width($bar.width()+100);
		    }
		    $bar.text($bar.width()/4 + "%");
		}, 800);
	}
}

</script>

</html>

