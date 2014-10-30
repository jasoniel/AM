package br.com.fiap.tdst.am.advocacia.controller.despesa;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.bo.LancaDespesaBO;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.exceptions.IdInvalidoException;

@WebServlet("/deletaDespesa")
public class DeletaDespesaController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		LancaDespesaBO lancaDespesaBO = null;
		try {
			lancaDespesaBO = new LancaDespesaBO();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LancaDespesa lancaDespesa=null;
		try {
			lancaDespesa= lancaDespesaBO.getDespesa(Long.parseLong(request.getParameter("idLancaDespesa")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IdInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			lancaDespesaBO.excluirDespesa(lancaDespesa);
		} catch (SQLException | IdInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("listaDespesa?idProcesso="+lancaDespesa.getProcesso().getNumeroProcesso());
		
	}

}
