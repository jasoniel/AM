package br.com.fiap.tdst.am.advocacia.beans;

import java.util.Calendar;

public final  class LancaHonorario {
	
	private long id;
	private TipoTarefa tipoTarefa;
	private Processo processo;
	private Calendar dataHonorario;
	private double qtdHora;
	private String observacao;
	  
	public LancaHonorario(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Calendar getDataHonorario() {
		return dataHonorario;
	}

	public void setDataHonorario(Calendar dataHonorario) {
		this.dataHonorario = dataHonorario;
	}

	public double getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(double qtdHora) {
		this.qtdHora = qtdHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	  
	  
	  
	  
	  
	
	
	  
	
}
