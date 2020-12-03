package client.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.model.service.ClientService;
import client.model.vo.Client;
import coupon.model.vo.Coupon;
import order.model.service.OrderService;
import order.model.vo.Order;
import order.model.vo.OrderDet;
import store.model.service.StoreService;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = { "/mypage" })
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
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
		String cliId = request.getParameter("cliId");
		Client client = new ClientService().selectOneClient(cliId);
		System.out.println("servlet cliId>"+cliId);
		
		//3. 비지니스 로직
		ArrayList<Coupon> cpList = new StoreService().selectOneClientCp(cliId);
		ArrayList<Order> ordList = new OrderService().selectOrd(cliId);
		
		for(Coupon c : cpList) {
			System.out.println("사용자ID>"+c.getCpListCliId());
			System.out.println("쿠폰명>"+c.getCpName());
		}
		
		for(Order o : ordList) {
			System.out.println("ORD사용자ID>"+o.getOrdCliId());
			System.out.println("주문번호>"+o.getOrdNo());
		}
		
		//4. 결과 처리
		if(cliId.equals("")) {	//에러처리
			RequestDispatcher rd  = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "잘못된 접근");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd  = request.getRequestDispatcher("/WEB-INF/views/client/mypage.jsp");
			request.setAttribute("client", client);
			HttpSession session = request.getSession();
			session.setAttribute("cpList", cpList);
			session.setAttribute("ordList", ordList);
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
