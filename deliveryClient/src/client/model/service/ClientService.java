package client.model.service;

import java.sql.Connection;
import java.util.ArrayList;

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

	public Client selectOneClient(Client client) {
		Connection conn = JDBCTemplate.getConnection();
		Client loginClient = new ClientDao().selectOneClient(conn, client);
		JDBCTemplate.close(conn);
		return loginClient;
	}

	public ArrayList<Client> searchId(String cliName, String cliTel) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Client> list = new ClientDao().searchId(conn, cliName, cliTel);
		JDBCTemplate.close(conn);
		return list;
	}

	public Client searchPw(String cliId, String cliTel) {
		Connection conn = JDBCTemplate.getConnection();
		Client client = new ClientDao().searchPw(conn, cliId, cliTel);
		JDBCTemplate.close(conn);
		return client;
	}

	public int updatePw(String cliId, String cliPw) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ClientDao().updatePw(conn, cliId, cliPw);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateClient(Client client) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ClientDao().updateClient(conn, client);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
