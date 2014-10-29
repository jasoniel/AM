package br.com.fiap.tdst.am.advocacia.exceptions;

public class DespesaInvalidaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DespesaInvalidaException(){
		super("Despesa não pode ser nula");
	}
}
