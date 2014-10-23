package br.com.fiap.tdst.am.advocacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;
import br.com.fiap.tdst.am.advocacia.controle.Usuario;

public class UsuarioDAO {

	
	private Connection conn = null;
	
	public UsuarioDAO(){
		try {
			this.conn =new ConnectionManager().getInstance().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean verifica(Usuario usuario) throws SQLException{
		

		String select = "select * from usuarios where usuario=? ";
				
		PreparedStatement stmt = conn.prepareStatement(select);
		
		stmt.setString(1, usuario.getLogin());
		
		ResultSet rs = stmt.executeQuery();
		
		String login=null;
		String senha=null;
		
		while(rs.next()){
			
			login= rs.getString("usuario");
			senha = rs.getString("senha");
		}
		
		
		if(login == null || senha ==null){
			return false;
		}else if((login.contains(usuario.getLogin()))
				&& 
				senha.contains(usuario.getSenha())){
			return true;
		}else
			
		return false;
	}
	
}
