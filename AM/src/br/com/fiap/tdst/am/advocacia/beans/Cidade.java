package br.com.fiap.tdst.am.advocacia.beans;

public final class Cidade {
	
	private long id;
	private Estado estado;
	private String nome;
	
	public Cidade() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
