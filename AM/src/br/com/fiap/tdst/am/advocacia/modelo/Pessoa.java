package br.com.fiap.tdst.am.advocacia.modelo;

public abstract class Pessoa {

	private int cdPessoa;
	private String dsEmail;
	private String dsPassword;
	private FonePessoa FonePessoa;
	
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.cdPessoa+" "+this.dsEmail;
	}
}
