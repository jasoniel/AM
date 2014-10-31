<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Listar Honorario</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/listarDespesas.css" %></style>
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
					
					
						<div id="topo_lista">
							
							<table class="table">
								<tr>
								<th style="width: 10px">Número</th>
								<th>Descrição</th>
								
								<th>Ação</th>
							</tr>
							</table>
						
						</div>
					
						<div id="conteudo_lista">
						
							<table class="table table-hover">					
								<c:forEach items="${listaHonorarios}" var="honorario">
									<tr>
										<td style="width: 48px" >${honorario.processo.numeroProcesso }</td>
										<td>${honorario.processo.descricaoProcesso}</td>
										
										<td>
										<a href="deletaHonorario?idHonorario=${honorario.id}"><i class="icon-remove"></i></a>
											&nbsp;&nbsp;
										<a href="#"><i class="icon-pencil"></i></a>
										
										
										
										
										</td>
									</tr>
									
								</c:forEach>
								
							</table>
						</div>
					</div>
					
					<div id="conteudo_bottom">
				
					</div>
					
				</div>
		
		</div>
		
		<div id="rodape"></div>
		
		
		
		
		
	</div>
	
	 <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
  </body>
</html>
