package order.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import order.model.dao.OrderDao;
import order.model.vo.Order;

public class OrderService {

	public int insertOrder(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		OrderDao orderDao = new OrderDao(); 
		int result1 = orderDao.insertOrder(conn, order);
		int result2 = 0;
		if(result1>0) {
			JDBCTemplate.commit(conn);
			result2 = orderDao.useCoupon(conn, order);
			if(result2>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result1+result2;
	}

}
