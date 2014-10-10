package br.com.fiap.tdst.am.advocacia.modelo;

public class Advogado extends Pessoa{
	

	private int nrOab;
	private int nrCpf;
	private String nrRg;
	private HoraAdvogado horaAdvogado ;
	

	
	public Advogado() {
	}
	
	public HoraAdvogado getHoraAdvogado() {
		return horaAdvogado;
	}
	public void setHoraAdvogado(HoraAdvogado horaAdvogado) {
		this.horaAdvogado = horaAdvogado;
	}
	
	public int getNrOab() {
		return nrOab;
	}
	public void setNrOab(int nrOab) {
		this.nrOab = nrOab;
	}
	public int getNrCpf() {
		return nrCpf;
	}
	public void setNrCpf(int nrCpf) {
		this.nrCpf = nrCpf;
	}
	public String getNrRg() {
		return nrRg;
	}
	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}
	
	
	
}
