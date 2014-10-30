package br.com.fiap.tdst.am.advocacia.dao.interfaces;

import java.sql.SQLException;

public interface ObjetoInterface {

	
	Object getObjeto (long id) throws SQLException;
}
