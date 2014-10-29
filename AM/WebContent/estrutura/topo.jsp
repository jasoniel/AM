<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/css/style.css" %></style>
<style><%@include file="/css/elementos/topo.css" %></style>
<script><%@include file="topo.js" %></script>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

	<div id="logo"><img src="img/libra.png" id="img-logo"></div>
	
		<div id="conteudo_topo_direito">


		
		<div id="data_topo_direito"><div id="horah5"></div><div id="datah5"></div></div>
		
		<div id="menu_conteudo_topo_direito">
		
		
			<div class="btn-group">
				<button class="btn btn-inverse" disabled href="#"><i class="icon-user icon-white"></i> Olá, ${usuarioLogado.login}</button>
				 <a class="btn btn-inverse dropdown-toggle" data-toggle="dropdown"href="#"><span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li ><a href="logout"><i class="icon-ban-circle"></i> Sair</a></li>
					
				</ul>
			</div>
			
		</div>
	</div>
		
			
			
			
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>