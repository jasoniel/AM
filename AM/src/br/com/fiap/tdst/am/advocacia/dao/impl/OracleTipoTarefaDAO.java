package br.com.fiap.tdst.am.advocacia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tdst.am.advocacia.beans.TipoTarefa;
import br.com.fiap.tdst.am.advocacia.connection.ConnectionManager;
import br.com.fiap.tdst.am.advocacia.dao.interfaces.ObjetoInterface;

public class OracleTipoTarefaDAO implements ObjetoInterface{
	
	private Connection conn = null;
	
	public OracleTipoTarefaDAO() throws ClassNotFoundException{
		
		this.conn = ConnectionManager.getInstance().getConnection();
	}
	
	

	@Override
	public Object getObjeto(long id) throws SQLException {
		
		String select = "select * from T_AM_TIPO_TAREFA where CD_TIPO_TAREFA = ? ";
		
		PreparedStatement stmt = conn.prepareStatement(select);
		
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		TipoTarefa tipoTarefa = new TipoTarefa();
		
		while(rs.next()){
			tipoTarefa.setId(rs.getLong("CD_TIPO_TAREFA"));
			tipoTarefa.setDescricao(rs.getString("DS_TIPO_TAREFA"));
			}
				
		return tipoTarefa;
	}
	
	
	public List<TipoTarefa> getLista () throws SQLException{
		
		
		String select = "select * from T_AM_TIPO_TAREFA ";
		
		List<TipoTarefa> lista=new ArrayList<>();
		
		PreparedStatement stmt = conn.prepareStatement(select);
		
		ResultSet rs =stmt.executeQuery();
		
		while (rs.next()){
			
			TipoTarefa tipoTarefa = (TipoTarefa)getObjeto(rs.getLong("CD_TIPO_TAREFA"));
			
			lista.add(tipoTarefa);
		}
		
		return lista;
	}
	
			
			

}
