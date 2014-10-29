package br.com.fiap.tdst.am.advocacia.beans;

import java.util.List;

public final class TipoCausa {

	private long id;
	private String dsCausa;
	
	
	public TipoCausa() {
	}
	
	public long getCdCausa() {
		return id;
	}
	public void setCdCausa(long id) {
		this.id = id;
	}
	public String getDsCausa() {
		return dsCausa;
	}
	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+this.id+" Causa"+this.dsCausa;
	}
	
}
