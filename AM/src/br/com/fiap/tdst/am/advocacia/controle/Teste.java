package br.com.fiap.tdst.am.advocacia.controle;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaDespesasDAO;

class Teste{
	
	
	
	
	
	
	public static void main(String [] args) throws SQLException, ClassNotFoundException {
		
	
	
	
		LancaDespesa lanca =new OracleLancaDespesasDAO().getDespesa(-286);
		
		
		
		System.out.println(lanca.getDescricao());
		
		
		
		
	}
	
	


}