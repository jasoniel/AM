package br.com.fiap.tdst.am.advocacia.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.LancaHonorario;
import br.com.fiap.tdst.am.advocacia.beans.TipoTarefa;
import br.com.fiap.tdst.am.advocacia.dao.OracleDAOFactory;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleLancaHonorarioDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleProcessoDAO;
import br.com.fiap.tdst.am.advocacia.dao.impl.OracleTipoTarefaDAO;
import br.com.fiap.tdst.am.advocacia.utils.DateUtilidades;

public class Teste{

	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
	  
		 LancaHonorario lancaHonorario = new LancaHonorario();
		 
		 
		 lancaHonorario.setDataHonorario(DateUtilidades.getData("2014-10-15"));
		 lancaHonorario.setObservacao("sadjasjdjasdklasjlkd");
		 lancaHonorario.setProcesso(new OracleProcessoDAO().getProcessoId(7));
		 lancaHonorario.setQtdHora(79);
		 
		 TipoTarefa tipoTarefa = new TipoTarefa();
		 tipoTarefa.setId(2);
		 tipoTarefa.setDescricao("sdsdZZS");
		 
		 lancaHonorario.setTipoTarefa(tipoTarefa);
	
	  
	
		 OracleLancaHonorarioDAO dao =OracleDAOFactory.getOracleLancaHonorarioDAO();
	  
		//dao.incluir(lancaHonorario);
		
		 
		System.out.println(dao.getObjeto(new OracleProcessoDAO().getProcessoId(7)).getDataHonorario());;
		
		
		
		
		
		 
		 
	  
	  
	 }
}