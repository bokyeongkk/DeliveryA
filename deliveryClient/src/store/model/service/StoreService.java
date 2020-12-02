package store.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import coupon.model.vo.Coupon;
import order.model.vo.Order;
import store.model.dao.StoreDao;
import store.model.vo.Cart;
import store.model.vo.Menu;
import store.model.vo.Review;
import store.model.vo.ReviewData;
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

	public ReviewData seleceRevView(int storeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		//리뷰 리스트 가져오는 DAO
		ArrayList<Review> listRev = new StoreDao().selectRevView(conn, storeNo);
		
		//해당 가게 리뷰 갯수 가져오는 DAO
		int cntRev = new StoreDao().selectRevCnt(conn, storeNo);
		
		//해당 가게 리뷰 평균 점수 가져오는 DAO
		double avgRev = new StoreDao().selectRevAvg(conn, storeNo);
		
		JDBCTemplate.close(conn);
		
		ReviewData srd = new ReviewData(listRev, cntRev, avgRev);
		
		return srd;
	}

	public Order selectOrder(String cliId, int storeNo, String now) {
		Connection conn = JDBCTemplate.getConnection();
		Order order = new StoreDao().selectOrder(conn, cliId, storeNo, now);
		JDBCTemplate.close(conn);

		return order;
	}

	public int insertReview(Review review) {
		Connection conn = JDBCTemplate.getConnection();
		String cliId = review.getRevCliId();
		int storeNo = review.getRevStore();
		String now = review.getRevEnrollDate();
				
		Order order = new StoreDao().selectOrder(conn, cliId, storeNo, now);
		
		int orderNo = order.getOrdNo();
		review.setRevOrdNo(orderNo);
		
		int result = new StoreDao().insertReview(conn, review);

		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int searchIndex(ArrayList<Cart> listCart, String menuName) {
		
		for(int i=0; i<listCart.size(); i++) {
			if(listCart.get(i).getMenuName().equals(menuName)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Coupon> selectOneClientCp(String cliId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Coupon> list = new StoreDao().selectOneClientCp(conn, cliId);
		JDBCTemplate.close(conn);

		return list;
	}	





}
