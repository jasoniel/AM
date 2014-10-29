package br.com.fiap.tdst.am.advocacia.beans;

public final class Estado {
	
	private long id;
	private String nome;
	private String siglaUf;
	
	public Estado(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}
	
	

}
