package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.Advogado;
import br.com.fiap.tdst.am.advocacia.beans.Cliente;
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public final class  OracleProcessoDAO {

	private Connection conn = null;
	
	
	public OracleProcessoDAO() throws ClassNotFoundException{
			this.conn=ConnectionManager.getInstance().getConnection();
	}

	public boolean verificaProcesso(long id) throws SQLException, ClassNotFoundException{
		
		
		Processo processo = getProcessoId(id);
		if(processo.getNumeroProcesso()==0){
			return false;
		}else if(processo !=null){
			return true;
		}
		return false;
	}
	
	
	
	public List<Processo> getList(Date dataInicial,Date dataFinal) throws SQLException, ClassNotFoundException{
		
		String select ="SELECT PR.NR_PROCESSO,PR.DS_PROCESSO,CLI.DS_RAZAO_SOCIAL "+"FROM T_AM_PROCESSO PR "+
								"INNER JOIN T_AM_CLIENTE CLI ON PR.CD_PESSOA1 = CLI.CD_PESSOA "+
				" WHERE PR.DT_ABERTURA >= ? AND PR.DT_ABERTURA <= ? "+ "AND PR.DT_FECHAMENTO is null";
		
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setDate(1, dataInicial);
		stmt.setDate(2,	dataFinal);
		ResultSet rs = stmt.executeQuery();
		
		List<Processo> processos = new ArrayList<>();
		
		while(rs.next()){
			
			
			Processo processo =getProcessoId(rs.getInt("NR_PROCESSO"));
			processos.add(processo);
		}
		
		return processos;
	}
	
	
	
	
	public List<Processo> getLista(Cliente cliente) throws SQLException, ClassNotFoundException {
		
		String select = "SELECT P.NR_PROCESSO "+"FROM T_AM_PROCESSO P, T_AM_CLIENTE CL "+
				"WHERE P.CD_PESSOA1 = CL.CD_PESSOA "+
				"AND CL.DS_RAZAO_SOCIAL = ? "+
				"AND P.DT_FECHAMENTO IS NULL";
		
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setString(1, cliente.getRazaoSocial());
		ResultSet rs =stmt.executeQuery();
		
		List<Processo> lista =new ArrayList<>();
		
		while(rs.next()){
			
			Processo processo = new Processo();
			
			
			processo =getProcessoId(rs.getInt("NR_PROCESSO"));
			processo.setCliente(cliente);
			
			lista.add(processo);
			
		}
		
		return lista;
	}
	
	
	
	public Processo getProcessoId(long id) throws SQLException, ClassNotFoundException{
		
		String select = "select * from T_AM_PROCESSO where NR_PROCESSO=?";
		PreparedStatement stmt  = conn.prepareStatement(select);
		stmt.setLong(1, id);
		ResultSet  rs =stmt.executeQuery();
		
		
	
		Processo processo = new Processo();
		
		while(rs.next()){
			
			OracleClienteDAO clienteDAO = new OracleClienteDAO();
			OracleAdvogadoDAO advogadoDAO = new OracleAdvogadoDAO();
					
			processo.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
			Advogado advogado = advogadoDAO.getAdvogadoId(rs.getLong("CD_PESSOA"));
			processo.setAdvogado(advogado);
			Cliente cliente = clienteDAO.getClienteId(rs.getLong("CD_PESSOA1"));
			processo.setCliente(cliente);
			processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
			processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
			processo.setDataDiaVencimento(rs.getInt("DT_DIA_VENCIMENTO"));
			processo.setDescricaoProcesso(rs.getString("DS_PROCESSO"));
			processo.setResultado(rs.getInt("NR_RESULTADO"));
			processo.setSituacao(rs.getInt("NR_SITUACAO"));
			processo.setObservacao(rs.getString("DS_OBSERVACAO"));
		}
		
		return processo;
	}


	
	
	
}
