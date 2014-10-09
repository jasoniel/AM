<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Processos</title>

<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/cProcessos.css" %></style>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

	<div id="todo">

		<div id="topo">

			<c:import url="estrutura/topo.jsp"></c:import>

		</div>
		
		<div id="meio"> 
			
			<div id="conteudo_esquerdo">
				
				<c:import url="estrutura/conteudo-esquerdo.jsp"></c:import>
				
			</div>
			<div id="conteudo_direito"> 
			
				<form name="formCProcessos" id="idFormCProcessos" method="post" action="cadastraProcessos">
					
					Cliente: <input type="text"  name="cliente" id="idCliente">
					Tipo de Causa: <select name="selectTpCausa" id="idSelectCausa" >
						<option value=""></option>
						<option value="comercial">Comercial</option>
						<option value="trabalhista">Trabalhista</option>
						<option value="tributaria">Tributária</option>
						</select><br>
					Descrição: <input type="text"  name="descricao" id="idDescricao">
					Situação: <select name="selectSituacao" id="idSelectSituacao">
						<option value=""></option>
						<option value="liberado">Liberado</option>
						<option value="bloqueado">Bloqueado</option>
						</select><br/>
					Advogado: <select name="selectAdvogado" id="idSelectAdvogado">
						<option value="0">Advogados Disponiveis</option>
						<option value="1">Leandro</option>
						<option value="2">Leonardo</option>
						</select>
					Resultado de Causa:<select name="selectResultCausa" id="idResultCausa">
						<option value=""></option>
						<option value="ganha">Ganha</option>
						<option value="perdida">Perdida</option>
						</select><br/>
			
					Dia de Vencimento: <input type="text" name="dVencimento" id="idDVencimento"><br/>
			
					Observação:<textarea></textarea><br/>
			
					<button type="submit" class="btn btn-success">Cadastrar</button> 
					<button type="reset" class="btn btn-danger">Limpar</button>
					
				</form>
				
			</div>
		</div>
		
		<div id="rodape"></div>
		
		
		
		
		
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>