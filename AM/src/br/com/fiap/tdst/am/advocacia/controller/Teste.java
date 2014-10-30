package br.com.fiap.tdst.am.advocacia.controller;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;

public class Teste{

	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
	  
	  Processo processo = new OracleProcessoDAO().getProcessoId(7);
	  
	  
	  System.out.println(processo);
	 }
}