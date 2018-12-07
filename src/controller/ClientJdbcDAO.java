package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientJdbcDAO {
	
	private Connection conn;
	
	public ClientJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public static List<Client> select () throws SQLException, ClassNotFoundException{
		List<Client> clients = new ArrayList<Client>();

		String sql="select * from Client";
		System.out.println(sql);
		PreparedStatement prepareStatement = JdbcUtil.getConnection().prepareStatement(sql);
		ResultSet q = prepareStatement.executeQuery();
		while(q.next()) {
			Client c = new Client();
			c.setId(q.getInt(1));
			c.setNome(q.getString(2));
			c.setEndereco(q.getString(3));
			c.setComplemento(q.getString(4));
			c.setUf(q.getString(5));
			c.setTelefone(q.getString(6));
			clients.add(c);
		}
		prepareStatement.close();
		JdbcUtil.close();
		
		return clients;
	}
}
