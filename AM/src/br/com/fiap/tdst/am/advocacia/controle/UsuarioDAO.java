package br.com.fiap.tdst.am.advocacia.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;

public class UsuarioDAO {

	
	Connection conn = null;
	
	UsuarioDAO(){
		try {
			this.conn =new ConnectionManager().getInstance().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	boolean verifica(Usuario usuario) throws SQLException{
		
		String teste = "select * from usuarios where usuario=?";
				
		PreparedStatement stmt = conn.prepareStatement(teste);
		
		stmt.setString(1, usuario.getLogin());
		ResultSet rs = stmt.executeQuery();
		
		String t=null;
		
		while(rs.next()){
			
	
			t= rs.getString("senha");
			
		}
		
		if(t == null){
			return false;
		}
		
		if(t.contains(usuario.getSenha())){
			return true;
		}else
			
		return false;
	}
	
}
