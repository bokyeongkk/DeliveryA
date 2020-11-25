package store.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import store.model.dao.StoreDao;
import store.model.vo.Menu;
import store.model.vo.Review;
import store.model.vo.Store;

public class StoreService {

	public ArrayList<Store> selcetStoreList(int storeCateId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Store> listStore = new StoreDao().selectStoreList(conn, storeCateId);
		JDBCTemplate.close(conn);

		return listStore;
	}

	public Store selectStoreView(int storeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Store s = new StoreDao().selectStoreView(conn, storeNo);
		JDBCTemplate.close(conn);
		
		return s;
	}

	public ArrayList<Menu> selectMenuView(int storeNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Menu> listMenu = new StoreDao().selectMenuView(conn, storeNo);
		JDBCTemplate.close(conn);
		
		return listMenu;
	}

	public ArrayList<Review> seleceRevView(int storeNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Review> listRev = new StoreDao().selectRevView(conn, storeNo);
		JDBCTemplate.close(conn);
		
		return listRev;
	}


}
