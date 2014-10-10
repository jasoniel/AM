package br.com.fiap.tdst.am.advocacia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	
	
	public static ConnectionManager instance;
	
	
	
	public static ConnectionManager getInstance(){
		
		if (instance == null){
			instance = new ConnectionManager();
		}
		
		return instance;
	}
	
	
	public Connection getConnection(){
		
		String login = "OPS$RM71357";
		String senha = "271294";
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		
		try {
			return DriverManager.getConnection(jdbcUrl, login, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
