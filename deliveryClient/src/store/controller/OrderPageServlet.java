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
import order.model.vo.Order;
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
		
		HttpSession session = request.getSession();
		
		//로그인 세션이 존재하는지 확인
		Client loginClient = (Client)session.getAttribute("loginClient");
		
		if(loginClient == null) { //로그인 한 세션이 존재하지 않으면 주문하기 사용 불가
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			//여기 나중에 로그인 창 서블릿으로 바꾸기
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		} else {
			
			//장바구니에 담긴 메뉴 리스트 세션이 존재하는지 확인
			ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
			
			//2. view에서 넘어온 값 저장
			Order order = new Order();
			order.setOrdTPrice(Integer.parseInt(request.getParameter("orderTotalPrice")));
			order.setOrdCliId(loginClient.getCliId());
			order.setOrdStoreNo(Integer.parseInt(request.getParameter("storeNo")));
			order.setOrdAddr(loginClient.getCliAddr());

			//여기 나중에 주문하기 페이지(jsp)로 변경
			RequestDispatcher rd = request.getRequestDispatcher("/.jsp");
			request.setAttribute("order", order);
			
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
