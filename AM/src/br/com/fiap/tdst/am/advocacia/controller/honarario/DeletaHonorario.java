package br.com.fiap.tdst.am.advocacia.controller.honarario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tdst.am.advocacia.beans.LancaHonorario;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaHonorarioDAO;
@WebServlet("/deletaHonorario")
public class DeletaHonorario extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		long id = Long.parseLong(request.getParameter("idHonorario"));
		
		OracleLancaHonorarioDAO lancaHonorarioDAO =null;
		
		try {
			lancaHonorarioDAO= OracleDAOFactory.getOracleLancaHonorarioDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LancaHonorario lancaHonorario=null;
		try {
			lancaHonorario = (LancaHonorario) lancaHonorarioDAO.getObjeto(id);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			lancaHonorarioDAO.excluir(lancaHonorario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.getRequestDispatcher("principal.jsp").forward(request, response);;
		
		
		
		
	}

}
