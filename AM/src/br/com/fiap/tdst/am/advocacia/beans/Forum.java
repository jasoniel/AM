package br.com.fiap.tdst.am.advocacia.beans;

public final class Forum {

	private long id ;
	private String descricao;
	
	public Forum(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "ID: "+this.id;
	}
	
}
