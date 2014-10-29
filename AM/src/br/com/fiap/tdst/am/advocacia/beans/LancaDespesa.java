package br.com.fiap.tdst.am.advocacia.beans;

import java.io.Serializable;
import java.sql.Date;

public final class LancaDespesa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private TipoDespesa tipoDespesa;
	private Processo processo;
	private Date dataDespesa;
	private double valorDespesa;
	private String descricao;
	
	public LancaDespesa() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public Date getDataDespesa() {
		return dataDespesa;
	}
	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}
	public double getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
