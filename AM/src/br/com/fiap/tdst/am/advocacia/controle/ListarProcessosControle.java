package br.com.fiap.tdst.am.advocacia.controle;

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
public class ListarProcessosControle extends HttpServlet{
	
	
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
		
		
		
		
		
		boolean verificaProcesso=false;
		
		System.out.println(request.getParameter("nrProcesso"));
		try {
			processoDAO = OracleDAOFactory.getOracleProcessoDAO();
			clienteDAO =  OracleDAOFactory.getOracleClienteDAO();
			verificaProcesso =processoDAO.verificaProcesso(Long.parseLong(request.getParameter("nrProcesso")));
			
		} catch (ClassNotFoundException |SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 request.getSession().setAttribute("vProcesso", verificaProcesso);
		 
		if(request.getParameter("nrProcesso")!= null && !request.getParameter("nrProcesso").isEmpty()){
			
			try {
				Processo processo = processoDAO.getProcessoId(Integer.parseInt(request.getParameter("nrProcesso")));
				lista.add(processo);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if(request.getParameter("nrProcesso")==null || request.getParameter("nrProcesso").isEmpty()){
				try {
				
					
			
				cliente =clienteDAO.getClienteNome(request.getParameter("nomeCliente"));
				System.out.println(cliente);
				lista = processoDAO.getLista(cliente);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		
		}
	
		System.out.println(request.getParameter("nomeCliente"));
		
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
	
		request.getSession().setAttribute("clienteLista", lista);
		response.sendRedirect("listarProcessos.jsp");

		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
}
