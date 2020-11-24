package store.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import store.model.dao.StoreDao;
import store.model.vo.Store;

public class StoreService {

	public ArrayList<Store> selcetStoreList(int storeCateId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Store> list = new StoreDao().selectStoreList(conn, storeCateId);
		JDBCTemplate.close(conn);

		return list;
	}


}
