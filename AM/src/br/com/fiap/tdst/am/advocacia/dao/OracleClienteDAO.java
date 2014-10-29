package br.com.fiap.tdst.am.advocacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.beans.Cliente;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public class OracleClienteDAO {
	
	
	private Connection conn = null; 
	
	public OracleClienteDAO() throws ClassNotFoundException{
		
		this.conn =ConnectionManager.getInstance().getConnection();
	}
	
	
	public  boolean ClienteExiste(String  nome) throws SQLException{
		String select = "select * from T_AM_CLIENTE WHERE DS_RAZAO_SOCIAL=?";

		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setString(1,nome);
		ResultSet rs =stmt.executeQuery();
		
		String nomeTemp ="";
		
		while(rs.next()){
			nomeTemp = rs.getString("DS_RAZAO_SOCIAL");
		}
		if(nomeTemp.isEmpty() || nomeTemp == null){
			return true;
		}else 
			return false;
	}
	

	
	public  Cliente getClienteNome(String nome) throws SQLException{
		
		String select = "select * from t_am_cliente where ds_razao_social=?";
		PreparedStatement stmt = conn.prepareStatement(select);
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		
		long id = 0;
		
		while(rs.next()){
			
			id=rs.getLong("CD_PESSOA");
		
		}
		
		Cliente cliente =getClienteId(id);
		
		return cliente;
	}
	
	
	public  Cliente getClienteId(long id) throws SQLException{
		
		String select = "select * from T_AM_CLIENTE where CD_PESSOA=?"; 
		
		PreparedStatement stmt = conn.prepareStatement(select);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente cliente = populaCliente(rs);
	
		return cliente;
	}
	
	private Cliente populaCliente(ResultSet rs) throws SQLException{
		
		Cliente cliente = new Cliente();
		while(rs.next()){
			
			cliente.setId(rs.getLong("CD_PESSOA"));
			cliente.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
			cliente.setCnpj(rs.getLong("NR_CNPJ"));
			cliente.setNumeroInsEstadual(rs.getDouble("NR_INSC_ESTADUAL"));
			cliente.setEmail(rs.getString("DS_EMAIL"));
			cliente.setPassword(rs.getString("DS_PASSWORD"));
		}
		
		return cliente;
		
	}
	
}
