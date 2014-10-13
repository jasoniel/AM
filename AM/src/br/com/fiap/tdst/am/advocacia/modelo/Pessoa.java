package br.com.fiap.tdst.am.advocacia.modelo;

public abstract class Pessoa {

	private long cdPessoa;
	private String nmPessoa;
	private String dsEmail;
	private String dsPassword;
	private FonePessoa FonePessoa;
	private Endereco endereco;
	
	
	public Pessoa(){}
	
	public long getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(long cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getDsPassword() {
		return dsPassword;
	}
	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}
	public FonePessoa getFonePessoa() {
		return FonePessoa;
	}
	public void setFonePessoa(FonePessoa fonePessoa) {
		FonePessoa = fonePessoa;
	}
	
	
	
	

}
