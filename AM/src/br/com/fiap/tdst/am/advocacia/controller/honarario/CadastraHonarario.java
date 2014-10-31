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
import br.com.fiap.tdst.am.advocacia.beans.TipoTarefa;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaHonorarioDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleTipoTarefaDAO;
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;

@WebServlet({"/lancaHonario","/cadastraHonarario"})
public class CadastraHonarario extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Processo processo=null;
		OracleLancaHonorarioDAO  lancaHonararioDAO =null;
		try {
			lancaHonararioDAO = OracleDAOFactory.getOracleLancaHonorarioDAO();
			processo =new OracleProcessoDAO().getProcessoId(Long.parseLong(request.getParameter("idProcesso")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<TipoTarefa> lista = null ;
		try {
			lista= new OracleTipoTarefaDAO().getLista();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaTipoTarefa", lista);
		request.setAttribute("processoHonarario", processo);
		request.getRequestDispatcher("lancarHonorario.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		OracleLancaHonorarioDAO lancaHonorarioDAO=null;
		OracleProcessoDAO processoDAO = null;
		OracleTipoTarefaDAO tipoTarefaDAO = null;
		try {
			 lancaHonorarioDAO = OracleDAOFactory.getOracleLancaHonorarioDAO();
			 processoDAO = OracleDAOFactory.getOracleProcessoDAO();
			 tipoTarefaDAO = OracleDAOFactory.getOracleTipoTarefaDAO();
		} catch (ClassNotFoundException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}		
		
		TipoTarefa tipoTarefa = null;
		try {
			tipoTarefa = (TipoTarefa) tipoTarefaDAO.getObjeto(Long.parseLong(request.getParameter("selectHonorario")));
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		System.out.println(request.getParameter("nomeClienteHonarario"));
		System.out.println(request.getParameter("selectHonorario"));
		System.out.println(request.getParameter("qtdHoras"));
		System.out.println(request.getParameter("obs"));
		System.out.println();*/
		
		
		Processo processo = null;
		
		try {
			processo =processoDAO.getProcessoId(Integer.parseInt(request.getParameter("nrProcessoHonorario")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(processo);
		
		LancaHonorario lancaHonorario = new LancaHonorario();
		
		lancaHonorario.setTipoTarefa(tipoTarefa);
		lancaHonorario.setQtdHora(Double.parseDouble(request.getParameter("qtdHoras")));	
		lancaHonorario.setProcesso(processo);	
		lancaHonorario.setObservacao(request.getParameter("obs")+" obssss");
		lancaHonorario.setDataHonorario(DateUtilidades.getData(request.getParameter("dataHonorario")));
		
		
		try {
			lancaHonorarioDAO.incluir(lancaHonorario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("lancarHonorario.jsp");
		
	}
}
