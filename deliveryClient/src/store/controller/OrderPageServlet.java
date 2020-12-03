package store.controller;

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
import coupon.model.vo.Coupon;
import order.model.vo.Order;
import order.model.vo.OrderClient;
import order.model.vo.OrderDet;
import store.model.service.StoreService;
import store.model.vo.Cart;

/**
 * Servlet implementation class OrderPageServlet
 */
@WebServlet(name = "OrderPage", urlPatterns = { "/orderPage" })
public class OrderPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 (필터로 생략)
		
		//2. view에서 넘어온 값 저장
		int storeNo = Integer.parseInt(request.getParameter("orderStoreNo"));
		
		//세션 받아오기
		HttpSession session = request.getSession();
		
		Client loginClient = (Client)session.getAttribute("client");
		ArrayList<Cart> listCart = (ArrayList<Cart>)session.getAttribute("listCart");
	

		if(listCart == null){ //cart에 아무것도 담겨있지 않으면 주문하기 사용 불가
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "장바구니가 비어있습니다.");
			request.setAttribute("loc", "/storeDetailView?storeNo="+storeNo);
			rd.forward(request, response);
		} else if(loginClient == null){ //로그인 한 세션이 존재하지 않으면 주문하기 사용 불가
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			request.setAttribute("loc", "/storeDetailView?storeNo="+storeNo);
			rd.forward(request, response);
		} else {	
			Order order = new Order();
			
			order.setOrdTPrice(Integer.parseInt(request.getParameter("orderTotalPrice")));
			order.setOrdCliId(loginClient.getCliId());
			order.setOrdStoreNo(Integer.parseInt(request.getParameter("orderStoreNo")));
			order.setOrdAddr(loginClient.getCliAddr());
			order.setOrdSub(loginClient.getCliAddrDet());			
			
			ArrayList<OrderDet> orderDet = new ArrayList<OrderDet>();
			
			for(Cart c : listCart) {
				OrderDet det = new OrderDet();
				det.setOrdDetMenuNo(c.getMenuNo());
				det.setOrdDetCnt(c.getMenuCount());
				orderDet.add(det);
			}

			//수경 수정////////////////////////////////////////////
			OrderClient oc = new OrderClient();
			oc.setOrder(order);
			oc.setOrderDet(orderDet);
			oc.setClient(loginClient);
			ArrayList<Coupon> cpList = new StoreService().selectOneClientCp(loginClient.getCliId());
			for(Coupon cp : cpList) {
				System.out.println("쿠폰명>"+cp.getCpName());
			}
			oc.setCpList(cpList);
			///////////////////////////////////////////////////
			
			
			//주문하는 jsp페이지로 이동
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/order/orderFrm.jsp");
//			request.setAttribute("order", order);
//			request.setAttribute("orderDet", orderDet);
			request.setAttribute("orderClient", oc);
			rd.forward(request, response);
			
//			//"listCart" 세션 삭제
//			session.removeAttribute("listCart");
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
