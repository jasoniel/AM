package br.com.fiap.tdst.am.advocacia.dao;

import br.com.fiap.tdst.am.advocacia.dao.impl.OracleAdvogadoDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleClienteDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleTipoDespesaDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleUsuarioDAO;

public final class OracleDAOFactory {
	
	public static OracleAdvogadoDAO getOracleAdvogadoDAO () throws ClassNotFoundException{
		
		return new OracleAdvogadoDAO();
	}
	
	public static OracleClienteDAO getOracleClienteDAO() throws ClassNotFoundException{
		
		return new OracleClienteDAO();
	}
	
	public static OracleLancaDespesasDAO getOracleLancaDespesasDAO() throws ClassNotFoundException{
		
		return new OracleLancaDespesasDAO();
	}
	
	public static OracleProcessoDAO getOracleProcessoDAO() throws ClassNotFoundException{
		
		return new OracleProcessoDAO ();
	}
	
	
	public static OracleTipoDespesaDAO getOracleTipoDespesaDAO() throws ClassNotFoundException{
		
		return new OracleTipoDespesaDAO();
	}
	
	public static OracleUsuarioDAO getOracleUsuarioDAO(){
		
		return new OracleUsuarioDAO();
	}
	
	
	
	
}
