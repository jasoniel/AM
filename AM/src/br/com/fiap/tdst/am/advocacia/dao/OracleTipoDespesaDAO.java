package br.com.fiap.tdst.am.advocacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.TipoDespesa;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public class OracleTipoDespesaDAO {

	
	private Connection conn = null;
	
	
	
	public OracleTipoDespesaDAO() throws ClassNotFoundException{
		this.conn = ConnectionManager.getInstance().getConnection();
	}
	
	
	public TipoDespesa getTipoDespesaId(long id) throws SQLException{
		
		String select ="select * from T_AM_TIPO_DESPESA where CD_TIPO_DESPESA = ?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setLong(1, id);
		
		TipoDespesa tipoDespesa= new TipoDespesa();
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			
			tipoDespesa.setId(rs.getLong("CD_TIPO_DESPESA"));
			tipoDespesa.setDescricao(rs.getString("DS_TIPO_DESPESA"));
		}
		
		
		return tipoDespesa;
	}
	
}
