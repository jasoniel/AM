package br.com.fiap.tdst.am.advocacia.beans;

import java.util.Date;

public final class HistoricoProcesso {
	
	private int numeroProcesso;
	private double codigoTaxa;
	private Date dataValidade;
	
	public HistoricoProcesso() {}
	
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public double getCodigoTaxa() {
		return codigoTaxa;
	}
	public void setCodigoTaxa(double codigoTaxa) {
		this.codigoTaxa = codigoTaxa;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
