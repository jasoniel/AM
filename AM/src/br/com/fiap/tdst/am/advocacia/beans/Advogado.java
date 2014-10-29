package br.com.fiap.tdst.am.advocacia.beans;


import java.io.Serializable;
import java.util.List;

public final class Advogado extends Pessoa implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroOab;
	private double cpf;
	private String rg;

	public Advogado() {
	}
	
	public int getNumeroOab() {
		return numeroOab;
	}

	public void setNumeroOab(int numeroOab) {
		this.numeroOab = numeroOab;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(double cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	
	@Override
	public String toString() {
		
		return "nome: "+this.email+" OAB: "+this.numeroOab;
	}
	
	
}
