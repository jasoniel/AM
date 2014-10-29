package br.com.fiap.tdst.am.advocacia.controle.despesa;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.dao.OracleLancaDespesasDAO;

@WebServlet("/deletaDespesa")
public class DeletaDespesaControle extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OracleLancaDespesasDAO lancaDespesaDAO = null;
		try {
			lancaDespesaDAO = new OracleLancaDespesasDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LancaDespesa lancaDespesa=null;
		try {
			lancaDespesa=lancaDespesaDAO.getDespesa(Long.parseLong(request.getParameter("idLancaDespesa")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lancaDespesaDAO.excluirDespesa(lancaDespesa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("listaDespesa?idProcesso="+lancaDespesa.getProcesso().getNumeroProcesso());
		
	}

}
