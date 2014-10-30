package br.com.fiap.tdst.am.advocacia.exceptions;

public class DataMaiorException extends Exception {

	
	public DataMaiorException(){
		
		super("Data não pode ser maior que a atual!!");
		
	}
}
