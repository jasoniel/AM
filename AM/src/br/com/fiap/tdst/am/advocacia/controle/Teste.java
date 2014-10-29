package br.com.fiap.tdst.am.advocacia.controle;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;

class Teste{
	
	
	
	
	
	
	public static void main(String [] args) throws SQLException, ClassNotFoundException {
		
	
	
	
		
		OracleProcessoDAO dao = new OracleProcessoDAO();
		
		Processo processo = dao.getProcessoId(26);
		
		
		
		
		
		
		
		
		/*
		Date data =FormatDate.getData("2014-10-10");
		
		System.out.println(data instanceof java.sql.Date);
		
		
		System.out.println(lancaDespesaDAO.getDespesa(268).getProcesso().getCliente().getEmail());*/
		
		
		
		
		
		
		
		
	}

}