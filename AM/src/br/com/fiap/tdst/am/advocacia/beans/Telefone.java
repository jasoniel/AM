package br.com.fiap.tdst.am.advocacia.beans;

public class Telefone {

	private long id;
	private TipoFone tipofone;
	private int numeroDdd;
	private int numeroFone;
	
	public Telefone() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoFone getTipofone() {
		return tipofone;
	}

	public void setTipofone(TipoFone tipofone) {
		this.tipofone = tipofone;
	}

	public int getNumeroDdd() {
		return numeroDdd;
	}

	public void setNumeroDdd(int numeroDdd) {
		this.numeroDdd = numeroDdd;
	}

	public int getNumeroFone() {
		return numeroFone;
	}

	public void setNumeroFone(int numeroFone) {
		this.numeroFone = numeroFone;
	}
	
	
}
