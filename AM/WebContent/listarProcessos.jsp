<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Listar Processos</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/listarProcessos.css" %></style>
<script ><%@include file="js/listarProcessos.js" %></script>
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
					
					<!--fun��o para mudar mensagem do required oninvalid="this.setCustomValidity('Messagem')" 
					
					pattern="^[a-zA-Z]{1,}$ \s  {1,} $"
					-->
					
						<form name ="form_listar_processos" id="idFormListar" method="get" action="listaProcessos" >
							<fieldset>
								N�mero do Processo: <input type="text" name="nrProcesso" required  id="idNrProcesso" /><br/>
								Nome do Cliente: <input type="text" name="nomeCliente" required  id="idNomeCliente"  ><br/>
								Per�odo: <input type="date" name="dtIncialPeriodo" id="idDtInicial" required="required">
								at� <input type="date" name="dtFinallPeriodo" id="idDtFinal" required="required"><br/>
								<button type="submit" class="btn btn-inverse" id="idBtnBuscar"><i class="icon-search"></i> Buscar</button>
								<button type="reset" class="btn btn-inverse" id="btnLimpar">Limpar</button>
							</fieldset>
						</form>
					
					</div>
					
					
					<div id="conteudo_bottom" >
					
						<table class="table">
							<tr>
								<th>N�mero</th>
								<th>Descri��o</th>
								<th>Cliente</th>
								<th>A��o</th>
							</tr>
						</table>

					</div>
					
					
				</div>
		
		</div>
		
		<div id="rodape"></div>
		
		
		
		
		
	</div>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
  </body>
</html>