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
						
								<form method="get" action="" id ="idFormLancDespesas">
								<fieldset><legend>Lançar Despesas</legend>
									<div id ="idDivNrProcesso">
										Número do processo:
										<input id="idNrProcesso" name="nrProcessoDespesa" type="text" disabled="disabled"readonly>
									</div>
									<div id ="idDivNomeClienteDespesa">
										Nome do Cliente:
										<input id="idNomeCliente" type="text" name="nomeClienteDespesa" disabled="disabled" readonly>
									</div>
									<div id ="idDivDataDespesa">
										Data da despesa:
										<input id="idDataDespesa" type="text" name="dataDespesa" maxlength="10" placeholder="__/__/____" >
									</div>
									<div id="idDivValorDespesa">
										Valor da despesa: 
										<input id="idValorDespesa" type="text" maxlength="9" name="valorDespesa">
									</div>
									<div id ="idDivSelectDespesa">									
										Despesas:<select name="selectDespesa" id="idSelectDespesa">
       											<option value="">Selecione</option>
       											<option value="xerox">Xérox</option>
       											<option value="autenticao">Autenticações</option>
       											<option value="viagens">Viagens</option>
       											<option value="hospedagem">Hospedagens</option>
       											<option value="outros">Outros</option>
										</select>
									</div>
									<div id ="idDivObs">
										Observações:
										<textarea id="idObs" ></textarea>
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