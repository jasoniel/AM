package br.com.fiap.tdst.am.advocacia.controle.despesa;

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
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;

@WebServlet({"/editaDespesa","/redirectDespesa"})
public class EditaDespesaControle extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LancaDespesaBO lancaDespesaBO =null;
		try {
			lancaDespesaBO= new LancaDespesaBO();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		LancaDespesa lancaDespesa=null;
		try {
			lancaDespesa = lancaDespesaBO.getDespesa(Long.parseLong(request.getParameter("idLancaDespesa")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException | IdInvalidoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		request.getSession().setAttribute("editaLancaDespesa", lancaDespesa);
		response.sendRedirect("editarDespesas.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		OracleLancaDespesasDAO lancaDespesaDAO=null;
		try {
			lancaDespesaDAO =OracleDAOFactory.getOracleLancaDespesasDAO();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		LancaDespesa lancaDespesa = new LancaDespesa();
		lancaDespesa.setId(((LancaDespesa)request.getSession().getAttribute("editaLancaDespesa")).getId());
		lancaDespesa.setDataDespesa(DateUtilidades.getData(request.getParameter("dtDespEdDesp")));
		lancaDespesa.setDescricao(request.getParameter("obsEdDesp"));
		lancaDespesa.setValorDespesa(Double.parseDouble(request.getParameter("valorDespEdDesp")));
		try {
			lancaDespesaDAO.updateDespesa(lancaDespesa);
			System.out.println("atualizou");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("editarDespesas.jsp");
		
	}
	
}
