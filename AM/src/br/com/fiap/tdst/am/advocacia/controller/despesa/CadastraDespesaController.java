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
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.beans.TipoDespesa;
import br.com.fiap.tdst.am.advocacia.bo.LancaDespesaBO;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleTipoDespesaDAO;
import br.com.fiap.tdst.am.advocacia.exceptions.DataInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.DataMaiorException;
import br.com.fiap.tdst.am.advocacia.exceptions.DespesaInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoNaoExistenteException;
import br.com.fiap.tdst.am.advocacia.exceptions.TipoDespesaInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.ValorInvalidoException;
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;

@WebServlet({"/lancaDespesa","/cadastraDespesa"})
public class CadastraDespesaController extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TipoDespesa tipoDespesa = null;
		LancaDespesaBO lancaDespesaBO = null;
		OracleTipoDespesaDAO tipoDespesaDAO=null;
		
		long id = Long.parseLong(request.getParameter("selectTipoDespesa"));
		
		try {
			lancaDespesaBO = new LancaDespesaBO();
			 tipoDespesaDAO =OracleDAOFactory.getOracleTipoDespesaDAO();
			 tipoDespesa = tipoDespesaDAO.getTipoDespesaId(id);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		LancaDespesa lancaDespesa = new LancaDespesa();
		
		try {
			lancaDespesa.setProcesso(new OracleProcessoDAO().getProcessoId(Long.parseLong(request.getParameter("nrProcessoDespesa"))));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	
		lancaDespesa.setDataDespesa(DateUtilidades.getData(request.getParameter("dataDespesa")));
		
		if(request.getParameter("valorDespesa").isEmpty() || request.getParameter("valorDespesa")==null){
			lancaDespesa.setValorDespesa(0);
		}else{
			lancaDespesa.setValorDespesa(Double.parseDouble(request.getParameter("valorDespesa")));
		}
		lancaDespesa.setTipoDespesa(tipoDespesa);
		lancaDespesa.setDescricao(request.getParameter("obs"));
		
			try {
				lancaDespesaBO.incluirDespesa(lancaDespesa);
			} catch (SQLException | DespesaInvalidaException
					| ProcessoInvalidoException | DataInvalidaException
					| ValorInvalidoException | ClassNotFoundException |
					ProcessoNaoExistenteException | TipoDespesaInvalidaException | DataMaiorException e) {
				
				
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
	
		
		
		
		request.getRequestDispatcher("lancDespesas.jsp").forward(request, response);
	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OracleProcessoDAO processoDAO =null;
		try {
			 processoDAO = OracleDAOFactory.getOracleProcessoDAO();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Processo processo = null;
		List<TipoDespesa> listaTipoDespesa =null;
		 
		try {
			 processo =processoDAO.getProcessoId(Integer.parseInt(request.getParameter("idProcesso")));
			 listaTipoDespesa =OracleDAOFactory.getOracleTipoDespesaDAO().getListaTipoDespesa();
			 System.out.println(request.getParameter("idProcesso"));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		request.getSession().setAttribute("listaTipoDespesa", listaTipoDespesa);
		request.getSession().setAttribute("processoDespesas", processo);
		response.sendRedirect("lancDespesas.jsp");
		
	}
	
	
	
	
	
	
	
	
	
	
}
