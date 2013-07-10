
<%@ include file="/include/principal.jsp" %>

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
	
	   <s:hidden name="mensagemErro" id="mensagemErro" value="%{mensagemErro}"/>
	
		<h3 class="form-signin-heading">Ensaio de Tac�grafos</h3>
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
                required: "O campo Login � obrigat�rio."
            },
        	"usuarioVo.senha":{
                required: "O campo Senha � obrigat�rio."
            }
        }
    });
	
	$('#loginAction input').keydown(function(e) {
	    if (e.keyCode == 13) {
	    	autenticar();
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
		    var percent = $bar.width()/4;
		    if(percent > 1){
		        $bar.text(percent + "%");
		    }
		}, 800);
	}
}

</script>

</html>

