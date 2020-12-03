package order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.model.vo.Client;
import order.model.dao.OrderDao;
import order.model.service.OrderService;
import order.model.vo.Order;
import store.model.vo.Cart;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "Order", urlPatterns = { "/order" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. view에서 넘어온 값 받기
		HttpSession session = request.getSession();
		//주문자
		Client loginClient = (Client)session.getAttribute("client");
		//총금액
		int ordTPrice = Integer.parseInt(request.getParameter("ordTPrice"));
		
		//주문 배달지역
		String ordAddr = request.getParameter("ordAddr");
		ordAddr += " "+request.getParameter("ordAddrDet");
		//요구사항
		String ordSub = request.getParameter("ordSub");
		//주문 쿠폰아이디
		String cpId1 =request.getParameter("coupon");
		String[] cpId2 = cpId1.split("/");
		
		//주문 가게아이디
		int ordStoreNo = Integer.parseInt(request.getParameter("ordStoreNo"));
		
		Order order = new Order();
		order.setOrdCliId(loginClient.getCliId());
		order.setOrdAddr(ordAddr);
		if(!cpId2[0].equals("no")) {
			int ordCpId = Integer.parseInt(cpId2[0]);
			order.setOrdCpId(ordCpId);
		}
		order.setOrdSub(ordSub);
		order.setOrdTPrice(ordTPrice);
		order.setOrdStoreNo(ordStoreNo);
		
		ArrayList<Cart> listCart = (ArrayList<Cart>)session.getAttribute("listCart");
		int result = new OrderService().order(order,listCart);
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/order/resultOrder.jsp");
			session.removeAttribute("listCart");
			Order order2 = new OrderService().searchOrdNoDate(loginClient.getCliId());
			String ordDate = order2.getOrdDate();
			String[] array = ordDate.split("-");
			ordDate = array[0]+array[1]+array[2];
			order2.setOrdDate(ordDate);
			request.setAttribute("order",order2);
			rd.forward(request, response);
		} else {			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "주문이 되지 않았습니다. 관리자에게 문의해주세요.");
			request.setAttribute("loc", "/storeDetailView?storeNo="+order.getOrdStoreNo());	
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
