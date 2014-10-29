package br.com.fiap.tdst.am.advocacia.beans;

public abstract class Pessoa {

	protected long id;
	protected String nome;
	protected String email;
	protected String password;
	protected Telefone telefone;
	protected Endereco endereco;
	
	
	public Pessoa() {
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Telefone getFonePessoa() {
		return telefone;
	}
	public void setFonePessoa(Telefone telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
	

}
