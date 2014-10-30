package br.com.fiap.tdst.am.advocacia.dao.interfaces;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;

public interface OracleLancaHonorarioDAOInterface {
	
	Object getObjeto (long id);
	
	void incluir(Object objeto) throws SQLException;

	void excluir(Object objeto);

	void update(Object objeto);	
	
	

}
