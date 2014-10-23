package br.com.fiap.tdst.am.advocacia.modelo;

public class Processo {
	
	
	private long nrProcesso;
	private long cdPessoa;
	
	
	
	
	
	public long getCdPessoa(){
		
		return this.cdPessoa;
	}
	
	public void setCdPessoa(Advogado advogado){
		
		this.cdPessoa=advogado.getCdPessoa();
	}
}
