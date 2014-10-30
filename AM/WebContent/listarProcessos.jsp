 <%@page import="br.com.fiap.tdst.am.advocacia.beans.Processo"%>
<%@page import="br.com.fiap.tdst.am.advocacia.beans.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<style>

</style>
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
					
					<!--função para mudar mensagem do required :)   oninvalid="this.setCustomValidity('Messagem')" 
					onMouseOver="this.style.background='red'"
															onMouseOut="this.style.background='white'"
					pattern="^[a-zA-Z]{1,}$ \s  {1,} $"
					-->
					
			
				
						<form name ="form_listar_processos" id="idFormListar" method="post" action="listaProcessos" >
							<fieldset>
							
									<div id="idDivNrProcesso">									
										<div id="campoNrProcesso">Número do Processo:<input type="number" name="nrProcesso" id="idNrProcesso" /> </div>
										<!-- se processo não existir e gerado uma div com msg de erro --> 								 		
								 		<c:if test="${vProcesso eq false}">								 		
											<div class="alert alert-error" id="msgNrProcesso">											
												<button type="button" class="close" data-dismiss="alert">×</button>
	  											Processo invalido!
											</div>
										</c:if>								 
								  </div><br/>									
						
									<div id="idDivNomeCliente">
											
										<div id="campoNomeCliente">Nome do Cliente: <input type="text" name="nomeCliente"   id="idNomeCliente"  ></div>
										<!-- se cliente não existir e gerado uma div com msg de erro --> 
										<c:if test="${verificaCliente eq false}">								 		
											<div class="alert alert-error" id="msgNomeCliente">											
												<button type="button" class="close" data-dismiss="alert">×</button>
	  											Cliente invalido!
											</div>
										</c:if>	
									</div><br/>
							
								Período: <input type="date" name="dtIncialPeriodo" id="idDtInicial" >
								até <input type="date" name="dtFinalPeriodo" id="idDtFinal"><br/>
								<button type="submit" class="btn btn-inverse" id="idBtnBuscar"><i class="icon-search"></i> Buscar</button>
								<button type="reset" class="btn btn-inverse" id="btnLimpar">Limpar</button>
							</fieldset>
						</form>
					
					</div>
					
				<c:if test="${not empty clienteLista  }" >
					<div id="conteudo_bottom" >
					
						<div id="idDivTitulo">
						<table class="table"  >
							
							<tr>
								<th style="width:10px">Número</th>
								<th style="width:1px">Descrição</th>
								<th style="width: 134px; text-align: center;">Cliente</th>
								<th style="text-align: center;">Ação</th>
							</tr>
							
							
							
							</table>
							</div>
							
						<div id="tabela">
							<table class="table table-hover" id="idTable">
							
							
								<c:forEach var="processo" items="${clienteLista}">
									<tr>
									<td style="width: 45px;">${processo.numeroProcesso}</td>
									<td>${processo.descricaoProcesso}</td>
									<td>${processo.cliente.razaoSocial }</td>
									<td style="width: 257px;">



											<div class="btn-group">
												<button class="btn">Despesa</button>
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a  href="lancaDespesa?idProcesso=${processo.numeroProcesso}" 	>Lançar Depesas</a></li>
													<li><a href="listaDespesa?idProcesso=${processo.numeroProcesso}" >Consultar Depesas</a></li>
												</ul>
											</div> 
											<div class="btn-group">
												<button class="btn">Honorario</button>
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a  href="#">Lançar Honorario</a></li>
													<li><a href="#" >Consultar Honorario</a></li>
												</ul>
											</div> 
							
											
													<!-- <a class="btn" id="btnLista" href="lancaDespesa?idProcesso=${processo.numeroProcesso}">Lançar Depesas</a>
												<a class="btn" id="btnCons" href="listaDespesa?idProcesso=${processo.numeroProcesso}" >Consultar Depesas</a>								
													 -->
									 </td>
									</tr>
								</c:forEach>
							
							
						</table>
						</div>
					</div>
				</c:if>
					
				</div>
		
		</div>
		
	
		
		
		
		
		
	</div>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
  </body>
</html>