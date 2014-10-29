<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>Lancar Despesas</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/lancDespesas.css" %></style>
<script><%@include file="js/lancaDespesa.js" %></script>

<script src="js/lancaDespesa.js"></script>

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
					
					<div id="idDivFormLancDespesas">
						
								<form method="post" action="cadastraDespesa" id ="idFormLancDespesas">
								<fieldset><legend>Lan�ar Despesas</legend>
									<div id ="idDivNrProcesso">
										N�mero do processo:
										<input id="idNrProcesso" type="text" name="nrProcessoDespesa"  
										 value="${processoDespesas.numeroProcesso}" readonly>
									</div>
									<div id ="idDivNomeClienteDespesa">
										Nome do Cliente:
										<input id="idNomeCliente" type="text" name="nomeClienteDespesa"  value="${processoDespesas.cliente.razaoSocial }" readonly>
									</div>
									<div id ="idDivDataDespesa" >
										Data da despesa:
										<input id="idDataDespesa" type="date" name="dataDespesa" required>
									</div>
									<div id="idDivValorDespesa">
										Valor da despesa: 
										<input id="idValorDespesa" type="text" name="valorDespesa" required >
									</div>
									
										<div id ="idDivSelectDespesa">									
										Despesas:<select name="selectTipoDespesa" id="idSelectDespesa" required>
												<option value="" >Selecione</option>
										<c:forEach items="${listaTipoDespesa}" var="tipoDespesa">
										
												<option value="${tipoDespesa.id }">${tipoDespesa.descricao}</option>
												
										</c:forEach>
										
												</select>
								
										</div>
									
									<div id ="idDivObs" >
										Observa��es:
										<textarea id="idObs" name="obs"></textarea>
									</div>
									<div id ="idDivBtns">
									<button type="submit" class="btn btn-inverse" id="idBtnCadastrar">Cadastrar</button>
									<button type="reset" class="btn btn-inverse" id="idBtnLimpar"><i class=icon-remove-sign></i> Limpar</button>
								</div>
								</fieldset>
							</form>
								
						</div>
					
						
		
			</div>
		
		</div>
		<div id="rodape"></div>
		
	
	</div>
	
	 <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
  </body>
</html>