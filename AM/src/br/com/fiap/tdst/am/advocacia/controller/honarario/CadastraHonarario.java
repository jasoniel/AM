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

@WebServlet("/lancaHonario")
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	/*
		
		LancaHonorario lancaHonorario = new LancaHonorario();
		
		lancaHonorario.setTipoTarefa(tipoTarefa);
		lancaHonorario.setQtdHora(qtdHora);
		lancaHonorario.setProcesso(processo);
		lancaHonorario.setObservacao(observacao);
		lancaHonorario.setDataHonorario(dataHonorario);
		
		*/
	}
}
