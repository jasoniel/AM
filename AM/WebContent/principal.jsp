<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Listar Processos</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/principal.css" %></style>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

	<div id="todo" >

		<div id="topo">

			<c:import url="estrutura/topo.jsp"></c:import>
			
		
			
			
		</div>
		
		<div id="meio"> 
		
			<div id="conteudo_esquerdo">
			
				<c:import url="estrutura/conteudo-esquerdo.jsp"></c:import>
				
			</div>
			
				<div id="conteudo_direito">
				
				
					<div id="conteudo_top">

					

					</div>
					
					
					<div id="conteudo_bottom" >
					
						

					</div>
					
					
				</div>
		
		</div>
		
	
		
		
		
		
		
	</div>
	
	
	<script src="js/listarProcessos.js" ></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
  </body>
</html>