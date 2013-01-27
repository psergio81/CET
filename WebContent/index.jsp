<%@ include file="/include/principal.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>

		<title>CET</title>
		
	</head>
	
<body>
	
	<div class="navbar navbar-fixed-top">
		
		<es:menu mostrarNomePrograma="false" />

	</div>	

    <div class="container">
        <div class="row-fluid">
            
    <div class="span12">
      <!--Body content-->
      <div class="hero-unit" align="center">
        <h1>Olá, seja bem vindo!</h1>
        <p>Este é um sistema de controle de conotacógrafos</p>
      </div>
      
    </div>
  </div>
</div>

	
    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      

      <!-- Example row of columns -->
      <div class="row">
        <div class="span12">
                <div class="widget">
                    <div class="container-fluid">                        
                        <div class="widget-content">
                            <div class="shortcuts">
                                <a href="javascript:irParaPrograma('Cad004');" class="shortcut">
                                    <i class="shortcut-icon icon-list-alt"></i>
                                    <span class="shortcut-label">Ensaio</span>
                                </a>
                            
                                <a href="javascript:irParaPrograma('Cad001');" class="shortcut">
                                    <i class="shortcut-icon icon-bookmark"></i>
                                    <span class="shortcut-label">Empresa</span>                               
                                </a>
                                
                                <a href="javascript:irParaPrograma('Cad005');" class="shortcut">
                                    <i class="shortcut-icon icon-signal"></i>
                                    <span class="shortcut-label">Veículo</span> 
                                </a>

                                <a href="javascript:irParaPrograma('Cad002');" class="shortcut">
                                    <i class="shortcut-icon icon-signal"></i>
                                    <span class="shortcut-label">Marca</span> 
                                </a>
                                
                                <a href="javascript:irParaPrograma('Cad003');" class="shortcut">
                                    <i class="shortcut-icon icon-signal"></i>
                                    <span class="shortcut-label">Modelo</span> 
                                </a>
                                
                                <a href="javascript:irParaPrograma('Cad007');" class="shortcut">
                                    <i class="shortcut-icon icon-comment"></i>
                                    <span class="shortcut-label">Tacógrafo</span>                                
                                </a>
                                
                                <a href="javascript:irParaPrograma('Cad006');" class="shortcut">
                                    <i class="shortcut-icon icon-user"></i>
                                    <span class="shortcut-label">Pessoa</span>
                                </a>
                                
                                <a href="javascript:irParaPrograma('Cad001');" class="shortcut">
                                    <i class="shortcut-icon icon-file"></i>
                                    <span class="shortcut-label">Relatório</span>   
                                </a>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
       </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Stdio.H - Company 2012</p>
      </footer>

  </body>

<script type="text/javascript">

    function irParaPrograma(action){
    	
    	$('<form/>').attr('action',action+'Action!browser.action').submit();

    }

</script>

</html>
