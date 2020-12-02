package order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import order.model.vo.Order;

public class OrderDao {

	public int insertOrder(Connection conn, Order order) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into ord_db values (ord_seq.nextval, ?, ?, ?, ?, ?, ?, to_char(sysdate,'yyyy-mm-dd'))";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, order.getOrdTPrice());
			pstmt.setString(2, order.getOrdCliId());
			pstmt.setInt(3, order.getOrdStoreNo());
			pstmt.setString(4, order.getOrdAddr());
			pstmt.setString(5, order.getOrdSub());
			pstmt.setInt(6, order.getOrdCpId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

}
