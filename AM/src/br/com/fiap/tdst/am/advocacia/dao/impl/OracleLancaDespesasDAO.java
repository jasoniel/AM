package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.LancaDespesa;
import br.com.fiap.tdst.am.advocacia.beans.Processo;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;
import br.com.fiap.tdst.am.advocacia.dao.interfaces.LancaDespesaDAOInterface;

public  class  OracleLancaDespesasDAO implements LancaDespesaDAOInterface {
	
	private  Connection conn = null;
	
	
	public OracleLancaDespesasDAO() throws ClassNotFoundException{
		
		this.conn=ConnectionManager.getInstance().getConnection();
	}
	
	@Override
	public void incluirDespesa(LancaDespesa lancaDespesa) throws SQLException{
		
		String insert =" insert into T_AM_LANCA_DESPESA"+" VALUES(SQ_AM_LANCA_DESPESA.NEXTVAL,?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(insert);
		
		stmt.setLong(1,lancaDespesa.getTipoDespesa().getId());
		stmt.setInt(2,lancaDespesa.getProcesso().getNumeroProcesso());
		stmt.setDate(3, lancaDespesa.getDataDespesa());
		stmt.setDouble(4,lancaDespesa.getValorDespesa());
		stmt.setString(5, lancaDespesa.getDescricao());
		stmt.executeUpdate();
	}
	

	@Override
	public List<LancaDespesa> getListaLancaDespesa(Processo processo) throws SQLException, ClassNotFoundException{
		
		String select = "select * from T_AM_LANCA_DESPESA where NR_PROCESSO=?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setInt(1, processo.getNumeroProcesso());
		ResultSet rs = stmt.executeQuery();
		
		List<LancaDespesa> lista = new ArrayList<>();
		
		while(rs.next()){
			LancaDespesa lancaDespesa = new LancaDespesa();
			lancaDespesa.setId(rs.getLong("CD_LANCAMENTO"));
			lancaDespesa.setTipoDespesa(new OracleTipoDespesaDAO().getTipoDespesaId(rs.getLong("CD_TIPO_DESPESA")));
			lancaDespesa.setProcesso(new OracleProcessoDAO().getProcessoId(rs.getLong("NR_PROCESSO")));
			lancaDespesa.setDataDespesa(rs.getDate("DT_DESPESA"));
			lancaDespesa.setValorDespesa(rs.getDouble("VL_DESPESA"));
			lancaDespesa.setDescricao(rs.getString("DS_OBSERVACAO"));
			
			lista.add(lancaDespesa);
		}
	
		return lista;
	}
	
	
	public LancaDespesa getDespesa (long id) throws SQLException, ClassNotFoundException{
		
		String select =" select * from T_AM_LANCA_DESPESA where CD_LANCAMENTO=?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		LancaDespesa lancaDespesa = new LancaDespesa();
		while(rs.next()){
			
			lancaDespesa.setId(rs.getLong("CD_LANCAMENTO"));
			lancaDespesa.setTipoDespesa(new OracleTipoDespesaDAO().getTipoDespesaId(rs.getLong("CD_TIPO_DESPESA")));
			lancaDespesa.setProcesso(new OracleProcessoDAO().getProcessoId(rs.getLong("NR_PROCESSO")));
			lancaDespesa.setDataDespesa(rs.getDate("DT_DESPESA"));
			lancaDespesa.setValorDespesa(rs.getDouble("VL_DESPESA"));
			lancaDespesa.setDescricao(rs.getString("DS_OBSERVACAO"));
		}
		
		
		return lancaDespesa;
	}
	
	
	public void excluirDespesa(LancaDespesa lancaDespesa) throws SQLException{
		
		String delete =" delete from T_AM_LANCA_DESPESA where CD_LANCAMENTO=?";
		PreparedStatement stmt = conn.prepareStatement(delete);
		stmt.setLong(1, lancaDespesa.getId());
		stmt.executeUpdate();
		
	}
	
	public void updateDespesa(LancaDespesa lancaDespesa) throws SQLException{
		
		String update =" update T_AM_LANCA_DESPESA " +" set DT_DESPESA=?,VL_DESPESA=?,DS_OBSERVACAO=? "+
						"where CD_LANCAMENTO=?";
		PreparedStatement stmt = conn.prepareStatement(update);
		stmt.setDate(1, lancaDespesa.getDataDespesa());
		stmt.setDouble(2, lancaDespesa.getValorDespesa());
		stmt.setString(3, lancaDespesa.getDescricao());
		stmt.setLong(4, lancaDespesa.getId());
		stmt.executeUpdate();
		
	}
	
	
	
	
	
	
	
	

}
