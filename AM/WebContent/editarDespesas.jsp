<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Despesas</title>
<style><%@include file="css/style.css" %></style>
<style><%@include file="css/elementos/editarDespesas.css" %></style>

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
				
					<div id="idDivFormEditarDespesa">
						
						<form action="editaDespesa?idLancaEditaDespesa=${editaLancaDespesa.id}" name="formEditarDespesa"
						 id="idFormEditarDespesa" method="post"> 
					
							<div id="idDivNrProEdDesp"> Número do processo:<input type="text" 
							name="nrProEdDesp" id="idNrProEdDesp" readonly value="${editaLancaDespesa.processo.numeroProcesso}"><br/></div>
						
							<div id="idDivNmClienteEdDesp">Nome do cliente: 
							<input  type="text" name="nmClienteEdDesp" id="idNmClienteEdDesp" readonly
							value="${editaLancaDespesa.processo.cliente.razaoSocial}"><br/></div>
						
							<div id="idDivEdDespDivDtDesp">Data da despesa: 
							<input type="date" name="dtDespEdDesp" id="idEdDespDtDesp" 
							value="${editaLancaDespesa.dataDespesa}"><br/></div>
						
							<div id="idDivVrDespEdDesp">Valor da despesa:
							<input type="text" name="valorDespEdDesp" id="idValorDespEdDesp"
							value="${editaLancaDespesa.valorDespesa}"><br/></div> 
						
							<div id="idDivTpDespEdDesp"> Despesas:
							
							<input type="text" name="tpDespEdDesp" id="idTpDespEdDesp" readonly
							value="${editaLancaDespesa.tipoDespesa.descricao}">
							</div>
							
							<div id="idDivObsEdDesp">
								Observações: <textarea name="obsEdDesp" id="idObsEdDesp"
								 rows="" cols="">${editaLancaDespesa.descricao}</textarea>
							</div>
						
							<button type="submit" class="btn btn-inverse" id="idBtnEnviarEdDesp">Editar</button>
							<button type="reset" class="btn btn-inverse" id="idBtnLimparEdDesp"><i class=icon-remove-sign></i> Limpar</button>
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