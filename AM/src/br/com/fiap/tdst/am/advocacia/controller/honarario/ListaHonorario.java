package br.com.fiap.tdst.am.advocacia.controller.honarario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaHonorario;
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaHonorarioDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;

@WebServlet("/listaHonorario")
public class ListaHonorario extends HttpServlet{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		OracleLancaHonorarioDAO lancaHonorarioDAO=null;
		OracleProcessoDAO processoDAO =null;
		try {
			processoDAO= OracleDAOFactory.getOracleProcessoDAO();
			lancaHonorarioDAO =OracleDAOFactory.getOracleLancaHonorarioDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Processo processo = null;
		try {
			processo = processoDAO.getProcessoId(Integer.parseInt(request.getParameter("idProcesso")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(processo.getNumeroProcesso());
		
		
		List<LancaHonorario>lista = null;
		try {
			lista = lancaHonorarioDAO.getList(processo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listaHonorarios", lista);
		System.out.println(lista.size());
		request.getRequestDispatcher("listarHonorarios.jsp").forward(request, response);
		
		
		
	}
	

}
