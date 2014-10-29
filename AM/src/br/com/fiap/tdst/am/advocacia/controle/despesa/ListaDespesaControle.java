package br.com.fiap.tdst.am.advocacia.controle.despesa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.dao.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.dao.OracleProcessoDAO;

@WebServlet("/listaDespesa")
public class ListaDespesaControle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OracleLancaDespesasDAO lancaDespesaDAO= null;
		OracleProcessoDAO processoDAO = null;
		try {
			lancaDespesaDAO = new OracleLancaDespesasDAO();
			processoDAO= new OracleProcessoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<LancaDespesa>listaDespesas=null;
		try {
			listaDespesas=lancaDespesaDAO.getListaLancaDespesa(processoDAO.getProcessoId(Long.parseLong(request.getParameter("idProcesso"))));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listaDespesas.size());
		request.getSession().setAttribute("listaDespesas", listaDespesas);
		response.sendRedirect("listarDespesas.jsp");
		
		
		
		
	}
}
