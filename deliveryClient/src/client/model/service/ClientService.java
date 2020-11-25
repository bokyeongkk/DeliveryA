package client.model.service;

import java.sql.Connection;

import client.model.dao.ClientDao;
import client.model.vo.Client;
import common.JDBCTemplate;

public class ClientService {

	public Client selectOneClient(String cliId) {
		Connection conn = JDBCTemplate.getConnection();
		Client client = new ClientDao().selectOneClient(conn, cliId);
		JDBCTemplate.close(conn);
		return client;
	}

	public int insertClient(Client client) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ClientDao().insertClient(conn, client);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
