package br.com.fiap.tdst.am.advocacia.beans;

public final  class Logradouro {
	
	private long id;
	private Bairro bairro;
	private TipoLog tipolog;
	private String descricao;
	
	public Logradouro() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public TipoLog getTipolog() {
		return tipolog;
	}

	public void setTipolog(TipoLog tipolog) {
		this.tipolog = tipolog;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
