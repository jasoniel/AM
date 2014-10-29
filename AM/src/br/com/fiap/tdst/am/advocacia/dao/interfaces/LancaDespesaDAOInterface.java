package br.com.fiap.tdst.am.advocacia.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.beans.Processo;

public interface LancaDespesaDAOInterface{
	
	void incluirDespesa(LancaDespesa lancaDespesa) throws SQLException;
	List<LancaDespesa> getListaLancaDespesa(Processo processo) throws SQLException,ClassNotFoundException;
	
	
}
