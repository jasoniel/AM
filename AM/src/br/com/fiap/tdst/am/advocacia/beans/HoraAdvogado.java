package br.com.fiap.tdst.am.advocacia.beans;

import java.util.Date;

public final class HoraAdvogado {

	private  int idPessoa;
	private  int idHistPessoa;
	private Date dataVigencia;
	private int valorHora;
	
	public HoraAdvogado(){}
	
	public int getidPessoa() {
		return idPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.idPessoa = cdPessoa;
	}
	public int getCdHistPessoa() {
		return idHistPessoa;
	}
	public void setCdHistPessoa(int cdHistPessoa) {
		this.idHistPessoa = cdHistPessoa;
	}
	public Date getDtVigencia() {
		return dataVigencia;
	}
	public void setDtVigencia(Date dtVigencia) {
		this.dataVigencia = dtVigencia;
	}
	public int getVlHora() {
		return valorHora;
	}
	public void setVlHora(int vlHora) {
		this.valorHora = vlHora;
	}
	
	
	

}
