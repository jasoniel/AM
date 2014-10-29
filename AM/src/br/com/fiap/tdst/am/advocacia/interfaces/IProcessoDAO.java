package br.com.fiap.tdst.am.advocacia.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.Cliente;
import br.com.fiap.tdst.am.advocacia.beans.Processo;

public interface IProcessoDAO {

	List<Processo> getLista(Cliente cliente)throws SQLException ;
	
}
