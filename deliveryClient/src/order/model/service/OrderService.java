package order.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.dao.OrderDao;
import order.model.vo.Order;
import store.model.vo.Cart;

public class OrderService {
	
	/*
	public int insertOrder(Order order) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new OrderDao().insertOrder(conn, order);

		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//JDBCTemplate.close(conn);
		return result;
	}
	
	public int useCoupon(Order order) {
		//Connection conn = JDBCTemplate.getConnection();
		int result = new OrderDao().useCoupon(conn, order);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//JDBCTemplate.close(conn);
		return result;
	}

	public int insertOrderDet(ArrayList<Cart> listCart) {
		//Connection conn = JDBCTemplate.getConnection();
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
	 */
	public int order(Order order, ArrayList<Cart> listCart) {
		Connection conn = JDBCTemplate.getConnection();
		OrderDao dao = new OrderDao();
		int result1 = dao.insertOrder(conn, order);
		if(result1>0) {	
			int ordNo = dao.searchOrdNo(conn, order.getOrdCliId());
			boolean bool = true;
			for(Cart c : listCart) {
				int result = dao.insertOrderDet(conn, c, ordNo);
				if(result==0) {
					bool = false;
					break;
				}
			}			
			if(bool) {
				if(order.getOrdCpId()!=0) {
					int result = new OrderDao().useCoupon(conn, order);
					if(result>0) {
						result1 = result;
						JDBCTemplate.commit(conn);
					}else {
						JDBCTemplate.rollback(conn);
					}
				}
			}else {
				result1 = 0;
				JDBCTemplate.rollback(conn);
			}
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		// TODO Auto-generated method stub
		return result1;
	}

	public Order searchOrdNoDate(String cliId) {
		Connection conn = JDBCTemplate.getConnection();
		Order order = new OrderDao().searchOrdNoDate(conn, cliId);
		JDBCTemplate.close(conn);
		return order;
	}

}
