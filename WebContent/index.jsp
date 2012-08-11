<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
	<head>
    	<meta charset="utf-8">
	    <title>Bootstrap, from Twitter</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
		<script src="/CET/padrao/jquery/jquery.js"></script>
		
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
	
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav nav-pills">
					<li class="dropdown" id="menu1">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
							Cadastros<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">
									<s:a action="Cad001Action!browser.action">Empresa</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									Usuário
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad002Action!browser.action">Marca</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad003Action!browser.action">Modelo</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad004Action!browser.action">Ensaio</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad005Action!browser.action">Veículo</s:a>
								</a>
							</li>
							<li>
								<a href="#">
									<s:a action="Cad006Action!browser.action">Pessoa</s:a>
								</a>
							</li>
    					</ul>
  					</li>
				</ul>

				<ul class="nav nav-pills">
					<li class="dropdown" id="menu2">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#menu2">
							Relatórios<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">
									Ensaios
								</a>
							</li>
    					</ul>
  					</li>
				</ul>
			</div>
		</div>
	</div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h1>Olá, seja bem vindo!</h1>
        <p>Este é um sistema de controle de conotacógrafos</p>
        <p><a class="btn btn-primary btn-large">Leia mais aqui &raquo;</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="span4">
          <h2>Heading</h2>
           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
        <div class="span4">
          <h2>Heading</h2>
           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
       </div>
        <div class="span4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Stdio.H - Company 2012</p>
      </footer>

    </div>

  </body>
</html>