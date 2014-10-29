package br.com.fiap.tdst.am.advocacia.beans;

import java.io.Serializable;

import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaDespesasDAO;

public final class Cliente extends Pessoa implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String razaoSocial;
	private long  cnpj;
	private double numeroInsEstadual;
	
	
	
	public Cliente(){};
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public double getNumeroInsEstadual() {
		return numeroInsEstadual;
	}
	public void setNumeroInsEstadual(double numeroInsEstadual) {
		this.numeroInsEstadual = numeroInsEstadual;
	}
	
	@Override
	public String toString() {
		
		return "Nome: "+this.razaoSocial+" cnpj: "+this.cnpj;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Cliente cliente =(Cliente)obj;
		
		if(this.id > cliente.getId()){
			return false;
		}if(this.id == cliente.getId()){
			return true;
		}
		return false;
	}

	
	
	
	
	
}
