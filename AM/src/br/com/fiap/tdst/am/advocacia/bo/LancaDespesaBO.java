package br.com.fiap.tdst.am.advocacia.bo;

import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.bo.interfaces.LancaDespesaBOInterface;
import br.com.fiap.tdst.am.advocacia.dao.OracleLancaDespesasDAO;
import br.com.fiap.tdst.am.advocacia.exceptions.DataInvalidaException;
import br.com.fiap.tdst.am.advocacia.exceptions.DespesaVaziaException;
import br.com.fiap.tdst.am.advocacia.exceptions.ProcessoInvalidoException;
import br.com.fiap.tdst.am.advocacia.exceptions.ValorInvalidoException;



public class LancaDespesaBO implements LancaDespesaBOInterface {
	
	OracleLancaDespesasDAO dao = null;
	
	public LancaDespesaBO() throws ClassNotFoundException{
		
		this.dao= new OracleLancaDespesasDAO();
	}

	@Override
	////RN22 ,RN17
	public void incluirDespesa(LancaDespesa lancaDespesa) 
				throws SQLException, DespesaVaziaException, ProcessoInvalidoException, 
					DataInvalidaException, ValorInvalidoException {
		

		if(lancaDespesa.getTipoDespesa()==null){
			throw new DespesaVaziaException();
		}else if(lancaDespesa.getProcesso()==null){
			throw new ProcessoInvalidoException();
		}else if(lancaDespesa.getDataDespesa()==null){
			throw new DataInvalidaException();
		}else if(lancaDespesa.getValorDespesa()<=0){
			throw new ValorInvalidoException();
		}else{
			
			dao.incluirDespesa(lancaDespesa);
		}
			
					
	}
	
	

	
	
			

}
