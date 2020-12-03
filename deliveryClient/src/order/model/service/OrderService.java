package order.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.dao.OrderDao;
import order.model.vo.Order;
import store.model.vo.Cart;

public class OrderService {

	public int insertOrder(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new OrderDao().insertOrder(conn, order);

		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int useCoupon(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new OrderDao().useCoupon(conn, order);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertOrderDet(ArrayList<Cart> listCart) {
		Connection conn = JDBCTemplate.getConnection();
		int total = 0;
		for(Cart c : listCart) {
			int result = new OrderDao().insertOrderDet(conn, c);

			if(result>0) {
				total++;
			}

		}
		if(total==listCart.size()) {
			JDBCTemplate.commit(conn);
			JDBCTemplate.close(conn);
			return 1;
		}
		else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return 0;
		}
	}


}
