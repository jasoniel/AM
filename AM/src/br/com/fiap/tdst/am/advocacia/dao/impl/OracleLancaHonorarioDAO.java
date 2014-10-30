package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaHonorario;
import br.com.fiap.tdst.am.advocacia.beans.TipoTarefa;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;
import br.com.fiap.tdst.am.advocacia.dao.interfaces.OracleDAOInterface;

public class OracleLancaHonorarioDAO implements OracleDAOInterface {

	
	private Connection conn = null;
	
			
	public OracleLancaHonorarioDAO() throws ClassNotFoundException{
		
		this.conn=ConnectionManager.getInstance().getConnection();
	}
			
			
	
	@Override
	public Object getObjeto(long id) throws SQLException, ClassNotFoundException {
		
		String select =" select * from T_AM_LANCA_HONORARIO where CD_LANCAMENTO=?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setLong(1, id);
		ResultSet rs =stmt.executeQuery();
		
		LancaHonorario lancaHonorario = new LancaHonorario();
		
		while(rs.next()){
			
			lancaHonorario.setId(rs.getLong("CD_LANCAMENTO"));
			lancaHonorario.setDataHonorario(rs.getDate("DT_HONORARIO"));
			lancaHonorario.setProcesso(new OracleProcessoDAO().getProcessoId(rs.getLong("NR_PROCESSO")));
			lancaHonorario.setQtdHora(rs.getDouble("QT_HORA"));
			lancaHonorario.setObservacao(rs.getString("DS_OBSERVACAO"));
			lancaHonorario.setTipoTarefa((TipoTarefa) new OracleTipoTarefaDAO().getObjeto(rs.getLong("CD_TIPO_TAREFA")));
		}
		
		return lancaHonorario;
	}

	@Override
	public void incluir(Object objeto) throws SQLException {
		
		LancaHonorario lancaHonorario = (LancaHonorario)objeto;
		
		String insert = " insert into T_AM_LANCA_HONORARIO " + " values(SQ_AM_LANCA_HONORARIO.NEXTVAL, ?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insert);
		
		stmt.setLong(1, lancaHonorario.getTipoTarefa().getId());
		stmt.setInt(2, lancaHonorario.getProcesso().getNumeroProcesso());
		stmt.setDate(3, lancaHonorario.getDataHonorario());
		stmt.setDouble(4, lancaHonorario.getQtdHora());
		stmt.setString(5, lancaHonorario.getObservacao());
		
		stmt.executeUpdate();
		
		
	}

	@Override
	public void excluir(Object objeto) throws SQLException {
		

		String delete = "delete from T_AM_LANCA_HONORARIO where CD_LANCAMENTO = ?";
		
		PreparedStatement stmt = conn.prepareStatement(delete);
		
		stmt.setLong(1, ((LancaHonorario)objeto).getId());
		
		
		
		
	}

	@Override
	public void update(Object objeto) {
		// TODO Auto-generated method stub
		
	}
	
	

}
