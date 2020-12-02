package store.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import coupon.model.vo.Coupon;
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
		
		String query = "SELECT REV_NO, REV_ORD_NO, MENU_NAME, REV_SCORE, REV_CONTENT, REV_CLI_ID, REV_STORE, REV_ENROLL_DATE "
				+ "FROM REV_DB "
				+ "JOIN ORD_DET_DB ON (REV_ORD_NO = ORD_DET_NO) "
				+ "JOIN MENU_DB ON (ORD_DET_MENU_NO = MENU_NO) "
				+ "WHERE REV_STORE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setRevNo(rset.getInt("rev_no"));
				r.setRevOrdNo(rset.getInt("rev_ord_no"));
				r.setMenuName(rset.getString("menu_name"));
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
				order.setOrdTPrice(rset.getInt("ord_t_price"));
				order.setOrdCliId(rset.getString("ord_cli_id"));
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

	public int selectRevCnt(Connection conn, int storeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int cntRev = 0;
		String query = "select count(*) as cnt from rev_db where rev_store = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cntRev = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cntRev;
	}

	public double selectRevAvg(Connection conn, int storeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		double avgRev = 0;
		String query = "select round(avg(rev_score),1) as avg from rev_db where rev_store = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				avgRev = rset.getDouble("avg");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return avgRev;
	}

	public int insertReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into rev_db values (rev_db_seq.nextval, ?,?,?,?,?, to_char(sysdate, 'yyyy-mm-dd'))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, review.getRevOrdNo());
			pstmt.setInt(2, review.getRevScore());
			pstmt.setString(3, review.getRevContent());
			pstmt.setString(4, review.getRevCliId());
			pstmt.setInt(5, review.getRevStore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Coupon> selectOneClientCp(Connection conn, String cliId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Coupon> list = new ArrayList<Coupon>();
		String query = "select * from cp_db join cp_list_db on cp_no = cp_list_no where cp_list_cli_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cliId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Coupon c = new Coupon();
				c.setCpListPk(rset.getInt("cp_list_pk"));
				c.setCpListNo(rset.getInt("cp_list_no"));
				c.setCpListCliId(rset.getString("cp_list_cli_id"));
				c.setCpListDate(rset.getString("cp_list_date"));
				c.setCpListAdminId(rset.getString("cp_list_admin_id"));
				c.setCpListUse(rset.getString("cp_list_use"));
				c.setCpName(rset.getString("cp_name"));
				c.setCpPrice(rset.getInt("cp_price"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}


}
