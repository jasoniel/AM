package br.com.fiap.tdst.am.advocacia.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.exceptions.DataInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.DataMaiorException;
import br.com.fiap.tdst.am.advocacia.exceptions.DespesaInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.IdInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoNaoExistenteException;
import br.com.fiap.tdst.am.advocacia.exceptions.TipoDespesaInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.ValorInvalidoException;
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;



public class LancaDespesaBO  {
	
	OracleLancaDespesasDAO dao = null;
	
	public LancaDespesaBO() throws ClassNotFoundException{
		
		this.dao= OracleDAOFactory.getOracleLancaDespesasDAO();
	}

	
	
	
	
	/*
	CD_LANCAMENTO   NOT NULL NUMBER(10)    
	CD_TIPO_DESPESA NOT NULL NUMBER(5)     
	NR_PROCESSO     NOT NULL NUMBER(10)    
	DT_DESPESA      NOT NULL DATE          
	VL_DESPESA      NOT NULL NUMBER(8,2)  
	
	*/

	////RN22 ,RN17,RN20
	public void incluirDespesa(LancaDespesa lancaDespesa) 
				throws SQLException, DespesaInvalidaException, ProcessoInvalidoException, 
					DataInvalidaException, ValorInvalidoException, ProcessoNaoExistenteException,
					ClassNotFoundException, TipoDespesaInvalidaException, DataMaiorException {
		
		
		if(!(lancaDespesa==null)){
			
			if(lancaDespesa.getTipoDespesa()==null){
				throw new DespesaInvalidaException();
			}else if (lancaDespesa.getTipoDespesa().getId()<=0){
				throw new TipoDespesaInvalidaException();
			}else if(lancaDespesa.getProcesso()==null){
				throw new ProcessoInvalidoException();
			}else if(lancaDespesa.getProcesso().getNumeroProcesso()<=0){
				throw new ProcessoInvalidoException();
			}else if((OracleDAOFactory.getOracleProcessoDAO().verificaProcesso(lancaDespesa.getProcesso().getNumeroProcesso()))==false){
				throw new ProcessoNaoExistenteException();
			}else if(lancaDespesa.getDataDespesa()==null){
				throw new DataInvalidaException();
			}else if(DateUtilidades.isMaior(lancaDespesa.getDataDespesa())==true){
				throw new DataMaiorException();
			}
			
			
			else if(lancaDespesa.getValorDespesa()<=0){
				throw new ValorInvalidoException();
			}else {
				dao.incluirDespesa(lancaDespesa);
			}
			
		} 
					
	}
	
	
	public List<LancaDespesa> getListaLancaDespesa(Processo processo) throws SQLException, ClassNotFoundException, 
	ProcessoInvalidoException, ProcessoNaoExistenteException{
		
		if(processo==null){
			throw new ProcessoInvalidoException();
		}else if((OracleDAOFactory.getOracleProcessoDAO().verificaProcesso(processo.getNumeroProcesso()))==false){
			throw new ProcessoNaoExistenteException();
		}else
	
		return dao.getListaLancaDespesa(processo);
	}
	
	
	public LancaDespesa getDespesa (long id) throws SQLException, ClassNotFoundException, IdInvalidoException{
		
		
		if (id<=0){
			throw new IdInvalidoException();
			
		}else
		
		return dao.getDespesa(id);
	}
	
	
	public void excluirDespesa(LancaDespesa lancaDespesa) throws SQLException, IdInvalidoException{
				
		if (lancaDespesa.getId() <= 0) {
			throw new IdInvalidoException();
		} else

			dao.excluirDespesa(lancaDespesa);
	
	}
	
	public void updateDespesa(LancaDespesa lancaDespesa) throws SQLException{
		
	
		
	}
	
	
	
	
	
	
	

	
	
			

}
