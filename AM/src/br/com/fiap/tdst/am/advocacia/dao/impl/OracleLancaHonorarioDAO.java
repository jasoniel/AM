package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.LancaHonorario;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;
import br.com.fiap.tdst.am.advocacia.dao.interfaces.OracleLancaHonorarioDAOInterface;

public class OracleLancaHonorarioDAO implements OracleLancaHonorarioDAOInterface {

	
	private Connection conn = null;
	
			
	public OracleLancaHonorarioDAO() throws ClassNotFoundException{
		
		this.conn=ConnectionManager.getInstance().getConnection();
	}
			
			
	
	@Override
	public Object getObjeto(long id) {
		
		return null;
	}

	@Override
	public void incluir(Object objeto) throws SQLException {
		
		LancaHonorario lancaHonorario = (LancaHonorario)objeto;
		
		String insert = " insert into T_AM_LANCA_HONORARIO " + " values(SQ_T_AM_LANCA_HONORARIO.NEXTVAL, ?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insert);
		
		stmt.setLong(1, lancaHonorario.getTipoTarefa().getId());
		stmt.setInt(2, lancaHonorario.getProcesso().getNumeroProcesso());
		stmt.setDate(3, lancaHonorario.getDataHonorario());
		stmt.setDouble(4, lancaHonorario.getQtdHora());
		stmt.setString(5, lancaHonorario.getObservacao());
		
		stmt.executeUpdate();
		
		
	}

	@Override
	public void excluir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object objeto) {
		// TODO Auto-generated method stub
		
	}
	
	

}
