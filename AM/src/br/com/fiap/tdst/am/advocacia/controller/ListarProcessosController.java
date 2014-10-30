package br.com.fiap.tdst.am.advocacia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.Cliente;
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleClienteDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;

@WebServlet("/listaProcessos")
public class ListarProcessosController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		
		OracleClienteDAO clienteDAO= null;
		Cliente cliente = null;
		OracleProcessoDAO processoDAO = null;
		List<Processo>	lista = new ArrayList<>();
		
		boolean verificaProcesso = false;
		boolean verificaCliente = false;
		try {
			processoDAO = OracleDAOFactory.getOracleProcessoDAO();
			clienteDAO =  OracleDAOFactory.getOracleClienteDAO();
			
			if(request.getParameter("nrProcesso")!=null && !(request.getParameter("nrProcesso").isEmpty())){
				verificaProcesso =processoDAO.verificaProcesso(Long.parseLong(request.getParameter("nrProcesso")));
			}
			
			
			if( (request.getParameter("nrProcesso")==null  || request.getParameter("nrProcesso").isEmpty()) &&
					(request.getParameter("nomeCliente")!=null && !(request.getParameter("nomeCliente").isEmpty()))
					
					){
			
				verificaCliente= clienteDAO.ClienteExiste(request.getParameter("nomeCliente"));
			}
			

			
			
			
		} catch (ClassNotFoundException |SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		 
		 if(verificaProcesso==true){
		 			//numero do Processo
					if(request.getParameter("nrProcesso")!= null && !request.getParameter("nrProcesso").isEmpty()){
						
						try {
							Processo processo = processoDAO.getProcessoId(Integer.parseInt(request.getParameter("nrProcesso")));
							lista.add(processo);
						} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					 
		 }	
				 if(!request.getParameter("nrProcesso").isEmpty()){
				 request.setAttribute("vProcesso", verificaProcesso);
				 }
		//Nome do Cliente
		 
		 if(verificaCliente==true){
				if(request.getParameter("nrProcesso")==null || request.getParameter("nrProcesso").isEmpty()){
					 
						try {
						
							
					
						cliente =clienteDAO.getClienteNome(request.getParameter("nomeCliente"));
						System.out.println(cliente);
						lista = processoDAO.getLista(cliente);
					} catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
				
				}
		 }
				 if(request.getParameter("nrProcesso")==null || request.getParameter("nrProcesso").isEmpty()){
					 	request.setAttribute("verificaCliente", verificaCliente);
				 }
	
		
		
		
		//Periodo
		if((request.getParameter("nomeCliente")==null || request.getParameter("nomeCliente").isEmpty()) &&
				(request.getParameter("nrProcesso")==null || request.getParameter("nrProcesso").isEmpty())	){
			
				java.sql.Date dataInicial = DateUtilidades.getData(request.getParameter("dtIncialPeriodo"));
				java.sql.Date dataFinal = DateUtilidades.getData(request.getParameter("dtFinalPeriodo"));
		
					try {
							lista = processoDAO.getList(dataInicial, dataFinal);
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(lista.size());
		}
	
		request.setAttribute("clienteLista", lista);
		//response.sendRedirect("listarProcessos.jsp");
		
		request.getRequestDispatcher("listarProcessos.jsp").forward(request, response);

		
	}
	
	
	
}
