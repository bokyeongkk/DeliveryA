package store.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.vo.Order;
import store.model.dao.StoreDao;
import store.model.vo.Menu;
import store.model.vo.Review;
import store.model.vo.Store;
import store.model.vo.StoreReviewData;

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

	public StoreReviewData seleceRevView(int storeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//이건 리뷰 리스트 가져오는 DAO
		ArrayList<Review> listRev = new StoreDao().selectRevView(conn, storeNo);
		
		//이건 해당 가게 리뷰 갯수 가져오는 DAO
		int cntRev = new StoreDao().selectRevCnt(conn, storeNo);
		
		//이건 해당 가게 리뷰 평균 점수 가져오는 DAO
		int avgRev = new StoreDao().selectRevAvg(conn, storeNo);
		
		JDBCTemplate.close(conn);
		
		StoreReviewData srd = new StoreReviewData(listRev, cntRev, avgRev);
		
		return srd;
	}

	public Order selectOrder(String cliId, int storeNo, String now) {
		Connection conn = JDBCTemplate.getConnection();
		Order order = new StoreDao().selectOrder(conn, cliId, storeNo, now);
		JDBCTemplate.close(conn);

		return order;
	}


}
