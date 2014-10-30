
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<title>Lancar Honarario</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/lancarHonarario.css" %></style>
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
						
								<form method="post" action="lancaHonarario" id ="idFormLancaHonarario">
								
									<fieldset><legend>Lançar Honorario</legend>
									
											<div id ="idDivNrProcesso">
												Número do processo:
												<input id="idNrProcesso" type="text" name="nrProcessoHonorario"  
												 value="${processoDespesas.numeroProcesso}" readonly>
											</div>
											<div id ="idDivNomeClienteHonorario">
												Nome do Cliente:
												<input id="idNomeCliente" type="text" name="nomeClienteHonarario"  value="${processoDespesas.cliente.razaoSocial }" readonly>
											</div>
											<div id ="idDivDataHonorario" >
												Data do Honorario:
												<input id="idDataHonorario" type="date" name="dataHonorario" required>
											</div>
											<div id="idDivValorHonorario">
												Quantidade de Horas: 
												<input id="idQtdHoras" type="text" name="qtdHoras" required >
											</div>
											
												<div id ="idDivSelectHonorario">			
																		
												Tarefa:<select name="selectHonorario" id="idSelectTipoTarefa" required>
														<option value="" >selecione</option>
														
																<c:forEach items="${listaTipoTarefa}" var="tarefa">
																
																		<option value="${tarefa.id }">${tarefa.descricao}</option>
																		
																</c:forEach>
												
														</select>
										
												</div>
											
											<div id ="idDivObs" >
												Observação:
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