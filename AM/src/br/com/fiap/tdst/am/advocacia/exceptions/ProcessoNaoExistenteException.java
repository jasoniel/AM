package br.com.fiap.tdst.am.advocacia.exceptions;

public class ProcessoNaoExistenteException extends Exception{
	
	public ProcessoNaoExistenteException(){
		
		super("Processo não existente!");
	}

}
