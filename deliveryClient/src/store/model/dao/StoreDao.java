package store.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.vo.Order;
import store.model.vo.Menu;
import store.model.vo.Review;
import store.model.vo.Store;

public class StoreDao {

	public ArrayList<Store> selectStoreList(Connection conn, int storeCateId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Store> listStore = new ArrayList<Store>();
		
		String query = "select * from store_db where store_cate_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeCateId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Store s = new Store();
				
				s.setStoreNo(rset.getInt("store_no"));
				s.setStoreCeo(rset.getString("store_ceo"));
				s.setStoreAddr(rset.getString("store_addr"));
				s.setStoreTel(rset.getString("store_tel"));
				s.setStoreDet(rset.getString("store_det"));
				s.setStoreName(rset.getString("store_name"));
				s.setStoreCateId(rset.getInt("store_cate_id"));
				s.setStoreStartT(rset.getString("store_start_t"));
				s.setStoreEndT(rset.getString("store_end_t"));
				s.setStoreFilepath(rset.getString("store_filepath"));
				s.setStoreFilename(rset.getString("store_filename"));
				s.setStoreRest(rset.getString("store_rest"));
				
				listStore.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listStore;
	}

	public Store selectStoreView(Connection conn, int storeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Store s = null;
		
		String query = "select * from store_db where store_no =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Store();
				s.setStoreNo(rset.getInt("store_no"));
				s.setStoreCeo(rset.getString("store_ceo"));
				s.setStoreAddr(rset.getString("store_addr"));
				s.setStoreTel(rset.getString("store_tel"));
				s.setStoreDet(rset.getString("store_det"));
				s.setStoreName(rset.getString("store_name"));
				s.setStoreCateId(rset.getInt("store_cate_id"));
				s.setStoreStartT(rset.getString("store_start_t"));
				s.setStoreEndT(rset.getString("store_end_t"));
				s.setStoreFilepath(rset.getString("store_filepath"));
				s.setStoreFilename(rset.getString("store_filename"));
				s.setStoreRest(rset.getString("store_rest"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return s;
	}

	public ArrayList<Menu> selectMenuView(Connection conn, int storeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Menu> listMenu = new ArrayList<Menu>();
		
		String query = "select * from menu_db where menu_store_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Menu m = new Menu();
				
				m.setMenuNo(rset.getInt("menu_no"));
				m.setMenuPrice(rset.getInt("menu_price"));
				m.setMenuStoreNo(rset.getInt("menu_store_no"));
				m.setMenuDet(rset.getString("menu_det"));
				m.setMenuName(rset.getString("menu_name"));
				m.setMenuFilepath(rset.getString("menu_filepath"));
				m.setMenuFilname(rset.getString("menu_filename"));
				
				listMenu.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listMenu;
		
	}

	public ArrayList<Review> selectRevView(Connection conn, int storeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> listRev = new ArrayList<Review>();
		
		String query = "select * from rev_db where rev_store = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setRevNo(rset.getInt("rev_no"));
				r.setRevOrdNo(rset.getInt("rev_ord_no"));
				r.setRevScore(rset.getInt("rev_score"));
				r.setRevContent(rset.getString("rev_content"));
				r.setRevCliId(rset.getString("rev_cli_id"));
				r.setRevStore(rset.getInt("rev_store"));
				r.setRevEnrollDate(rset.getString("rev_enroll_date"));

				listRev.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listRev;
	}

	public Order selectOrder(Connection conn, String cliId, int storeNo, String now) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Order order = null;
		
		String query = "select * from ord_db where ord_cli_id=? and ord_store_no=? and ord_date=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cliId);
			pstmt.setInt(2, storeNo);
			pstmt.setString(3, now);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				order = new Order();
				order.setOrdNo(rset.getInt("ord_no"));
				order.setOrdCliId(rset.getString("ord_cli_id"));
				order.setOrdTPrice(rset.getInt("ord_total_t"));
				order.setOrdStoreNo(rset.getInt("ord_store_no"));
				order.setOrdAddr(rset.getString("ord_addr"));
				order.setOrdSub(rset.getString("ord_sub"));
				order.setOrdCpId(rset.getInt("ord_cp_id"));
				order.setOrdDate(rset.getString("ord_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return order;
	}
	
	

}
