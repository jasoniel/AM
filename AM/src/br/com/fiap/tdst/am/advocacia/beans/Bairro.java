package br.com.fiap.tdst.am.advocacia.beans;

public final class Bairro {
	
	private long id;
	private Cidade cidade;
	private String nome;
	
	public Bairro() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
