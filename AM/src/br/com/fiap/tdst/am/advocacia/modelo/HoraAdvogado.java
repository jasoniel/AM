package br.com.fiap.tdst.am.advocacia.modelo;

import java.util.Calendar;

public class HoraAdvogado {

	private  int cdPessoa;
	private  int cdHistPessoa;
	private Calendar dtVigencia;
	private int vlHora;
	
	
	public HoraAdvogado(){}
	
	public HoraAdvogado(int cdPessoa,int cdHistPessoa,Calendar dtVigencia,int vlHora){
		
		this.cdPessoa = cdPessoa;
		this.cdHistPessoa = cdHistPessoa;
		this.dtVigencia = dtVigencia;
		this.vlHora = vlHora;
		
	}
	
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	public int getCdHistPessoa() {
		return cdHistPessoa;
	}
	public void setCdHistPessoa(int cdHistPessoa) {
		this.cdHistPessoa = cdHistPessoa;
	}
	public Calendar getDtVigencia() {
		return dtVigencia;
	}
	public void setDtVigencia(Calendar dtVigencia) {
		this.dtVigencia = dtVigencia;
	}
	public int getVlHora() {
		return vlHora;
	}
	public void setVlHora(int vlHora) {
		this.vlHora = vlHora;
	}
	
	
	

}
