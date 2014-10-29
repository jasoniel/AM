package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.Advogado;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public class OracleAdvogadoDAO {
	
	private  Connection conn = null;
	
	public OracleAdvogadoDAO() throws ClassNotFoundException{
	
		this.conn=ConnectionManager.getInstance().getConnection();
	
	}
	
	public  Advogado getAdvogadoId(long id) throws SQLException{
		
		String select = "select * from T_AM_ADVOGADO where CD_PESSOA=?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setLong(1, id);
		
		ResultSet  rs = stmt.executeQuery();
		
		Advogado advogado = populaAdvogado(rs);
		
		return advogado;
				
		
	}
	
	private  Advogado populaAdvogado(ResultSet rs) throws SQLException{
		
		Advogado advogado = new Advogado();
		
		while(rs.next()){
			
			
			advogado.setId(rs.getLong("CD_PESSOA"));
			advogado.setNumeroOab(rs.getInt("NR_OAB"));
			advogado.setCpf(rs.getDouble("NR_CPF"));
			advogado.setRg(rs.getString("NR_RG"));
			advogado.setEmail(rs.getString("DS_EMAIL"));
			advogado.setPassword(rs.getString("DS_PASSWORD"));
		}
		
		return advogado;
	}
}
