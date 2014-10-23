package br.com.fiap.tdst.am.advocacia.dao;

import java.sql.Connection;

import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public class ProcessoDAO {

	private Connection conn = null;
	
	
	public ProcessoDAO() throws ClassNotFoundException{
		
			conn=ConnectionManager.getInstance().getConnection();
			
			}
	
}
