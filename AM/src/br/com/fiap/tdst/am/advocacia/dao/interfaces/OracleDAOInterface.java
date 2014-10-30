package br.com.fiap.tdst.am.advocacia.dao.interfaces;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;

public interface OracleDAOInterface {
	
	Object getObjeto (long id) throws SQLException, ClassNotFoundException;
	
	void incluir(Object objeto) throws SQLException;

	void excluir(Object objeto) throws SQLException;

	void update(Object objeto) throws SQLException;
	
	

}
