package br.com.fiap.tdst.am.advocacia.beans;

import java.io.Serializable;
import java.sql.Date;

public final class Processo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numeroProcesso;
	private Advogado advogado;//cdPessoa
	private Cliente cliente; //cdPessoa1
	private Forum forum;//cdPessoa2
	private String descricaoProcesso;
	private Date dataAbertura;
	private Date dataFechamento;
	private int dataDiaVencimento;
	private int resultado;
	private int situacao;
	private String observacao;
	
	public Processo() {}
	
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	
	public Advogado getAdvogado() {
		return advogado;
	}
	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public String getDescricaoProcesso() {
		return descricaoProcesso;
	}
	public void setDescricaoProcesso(String descricaoProcesso) {
		this.descricaoProcesso = descricaoProcesso;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public int getDataDiaVencimento() {
		return dataDiaVencimento;
	}
	public void setDataDiaVencimento(int dataDiaVencimento) {
		this.dataDiaVencimento = dataDiaVencimento;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public String toString() {
		return "Numero: "+this.numeroProcesso+" Data Abertura: "+this.dataAbertura;
	}
	
	
	
}
