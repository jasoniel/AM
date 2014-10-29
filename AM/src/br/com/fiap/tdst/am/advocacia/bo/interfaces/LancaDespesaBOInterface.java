package br.com.fiap.tdst.am.advocacia.bo.interfaces;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.exceptions.DataInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.DespesaInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoNaoExistenteException;
import br.com.fiap.tdst.am.advocacia.exceptions.ValorInvalidoException;

public interface LancaDespesaBOInterface {

	
	
	public void incluirDespesa(LancaDespesa lancaDespesa) 
			throws SQLException,DespesaInvalidaException,ProcessoInvalidoException,DataInvalidaException
			,ValorInvalidoException,ProcessoNaoExistenteException,ClassNotFoundException;
}
