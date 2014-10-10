<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inicio</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/index.css" %></style>
<link href="js/index.js" rel="stylesheet" media="screen">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<!-- test -->
	<div id="todo" >

	
		
		
			<div id="conteudo_meio">
			
				<form name="form_login" action="autentica" method="post" id="idFormLogin">
					<fieldset><legend>Indentifique-se</legend>
					login: <input type="text" name="login" id="idLogin" /><br/>
					senha: <input type="password" name="passoword" id="id_passoword" /><br/>
					<button type="submit" class="btn btn-success" id="idEnviar">Entrar</button>
					<button type="reset" class="btn btn-danger">Limpar</button>
					</fieldset>
				</form>
			
			
			
			
			</div>
		
		
		
	</div>
	
	
	
	 <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
	
  </body>
</html>