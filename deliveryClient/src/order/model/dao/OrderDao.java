package order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import order.model.vo.Order;
import store.model.vo.Cart;

public class OrderDao {

	public int insertOrder(Connection conn, Order order) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into ord_db values (ord_seq.nextval, ?, ?, ?, ?, ?, ?, to_char(sysdate,'yyyy-mm-dd'))";
		System.out.println("ordCpId >>>"+order.getOrdCpId());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, order.getOrdTPrice());
			pstmt.setString(2, order.getOrdCliId());
			pstmt.setInt(3, order.getOrdStoreNo());
			pstmt.setString(4, order.getOrdAddr());
			pstmt.setString(5, order.getOrdSub());
			if(order.getOrdCpId()==0) {
				pstmt.setString(6, null);
			}else {
				pstmt.setInt(6, order.getOrdCpId());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int searchOrdNo(Connection conn, String cliId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select max(ord_no) as ord_no from ord_db where ORD_CLI_ID=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cliId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("ord_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int useCoupon(Connection conn, Order order) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update cp_list_db set cp_list_use=? where cp_list_cli_id=? and cp_list_pk=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "TRUE");
			pstmt.setString(2, order.getOrdCliId());
			pstmt.setInt(3, order.getOrdCpId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertOrderDet(Connection conn, Cart cart, int ordNo) {
		PreparedStatement pstmt = null;
		int result = 0;		
		String query = "insert into ord_det_db values (ord_det_seq.nextval, ?, ?, ?)";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ordNo);
			pstmt.setInt(2, cart.getMenuNo());
			pstmt.setInt(3, cart.getMenuCount());			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Order searchOrdNoDate(Connection conn, String cliId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select max(ord_no) as ord_no, ord_date from ord_db where ORD_CLI_ID=?";
		Order order = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cliId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				order = new Order();
				order.setOrdNo(rset.getInt("ord_no"));
				order.setOrdDate(rset.getString("ord_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return order;
	}
}
