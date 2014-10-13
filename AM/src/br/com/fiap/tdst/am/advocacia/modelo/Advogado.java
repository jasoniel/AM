package br.com.fiap.tdst.am.advocacia.modelo;

public class Advogado extends Pessoa{
	

	private int nrOab;
	private int nrCpf;
	private String nrRg;
	private HoraAdvogado vlHoraAdvogado ;
	

	
	public Advogado() {
	}
	
	public HoraAdvogado getHoraAdvogado() {
		return vlHoraAdvogado;
	}
	public void setHoraAdvogado(HoraAdvogado horaAdvogado) {
		this.vlHoraAdvogado = horaAdvogado;
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
