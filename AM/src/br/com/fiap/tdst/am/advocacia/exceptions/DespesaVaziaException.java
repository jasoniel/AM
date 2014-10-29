package br.com.fiap.tdst.am.advocacia.exceptions;

public class DespesaVaziaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DespesaVaziaException(){
		super("Despesa não pode ser nula");
	}
}
