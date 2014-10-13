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
		
		if (usuario.getLogin()=="" || usuario.getSenha()==""){
			return false;
		}
		
		String teste = "select usuario,senha from usuarios where usuario=?";
				
		PreparedStatement stmt = conn.prepareStatement(teste);
		
		stmt.setString(1, usuario.getLogin());
		ResultSet rs = stmt.executeQuery();
		
		String login=null;
		String senha=null;
		
		
		while(rs.next()){
		
			
			login = rs.getString("usuario");
			senha= rs.getString("senha");
			
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
