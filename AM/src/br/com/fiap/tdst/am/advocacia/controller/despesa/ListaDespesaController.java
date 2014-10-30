package br.com.fiap.tdst.am.advocacia.controller.despesa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.bo.LancaDespesaBO;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoNaoExistenteException;

@WebServlet("/listaDespesa")
public class ListaDespesaController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		OracleProcessoDAO processoDAO = null;
		LancaDespesaBO lancaDespesaBO=null;
		try {
			lancaDespesaBO = new LancaDespesaBO();
			processoDAO= OracleDAOFactory.getOracleProcessoDAO();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		List<LancaDespesa>listaDespesas=null;
		try {
			listaDespesas=lancaDespesaBO.getListaLancaDespesa(processoDAO.getProcessoId(Long.parseLong(request.getParameter("idProcesso"))));
		} catch (ClassNotFoundException | SQLException | NumberFormatException 
				| ProcessoInvalidoException | ProcessoNaoExistenteException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(listaDespesas.size());
		request.setAttribute("listaDespesas", listaDespesas);
		//response.sendRedirect("listarDespesas.jsp");
		
		request.getRequestDispatcher("listarDespesas.jsp").forward(request, response);
		
		
	}
}
