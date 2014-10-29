package br.com.fiap.tdst.am.advocacia.beans;

import java.util.Date;

public final class HistoricoTaxa {
	
	private long id;
	private Date dataVigencia;
	private double valorTaxaAdm;
	private double valorTaxaJuros;
	private double valorMoraDiaria;
	
	public HistoricoTaxa() {}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
	public double getValorTaxaAdm() {
		return valorTaxaAdm;
	}
	public void setValorTaxaAdm(double valorTaxaAdm) {
		this.valorTaxaAdm = valorTaxaAdm;
	}
	public double getValorTaxaJuros() {
		return valorTaxaJuros;
	}
	public void setValorTaxaJuros(double valorTaxaJuros) {
		this.valorTaxaJuros = valorTaxaJuros;
	}
	public double getValorMoraDiaria() {
		return valorMoraDiaria;
	}
	public void setValorMoraDiaria(double valorMoraDiaria) {
		this.valorMoraDiaria = valorMoraDiaria;
	}
	
	
}
