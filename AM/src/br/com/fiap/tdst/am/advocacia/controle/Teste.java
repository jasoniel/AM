package br.com.fiap.tdst.am.advocacia.controle;

import java.sql.Date;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.dao.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.utils.FormatDate;

class Teste{
	

	public static void main(String [] args) throws SQLException, ClassNotFoundException {
		
		
	
		
		
		OracleProcessoDAO dao = new OracleProcessoDAO();
		
		Processo processo = dao.getProcessoId(7);
		OracleLancaDespesasDAO lancaDespesaDAO = new OracleLancaDespesasDAO();
		
		
		
		Date data =FormatDate.getData("2014-10-10");
		
		System.out.println(data instanceof java.sql.Date);
		
		
		System.out.println(lancaDespesaDAO.getDespesa(268).getProcesso().getCliente().getEmail());
		
		
		
		
		
		
		
		
	}

}