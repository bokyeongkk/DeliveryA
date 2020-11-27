package order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.model.vo.Client;

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
		String orderName = request.getParameter("orderName");
		
		
		
		
		
		//1) 로그인 세션이 존재하는지 검사
		HttpSession session = request.getSession(false);
		Client loginClient = (Client)session.getAttribute("loginClient");
				
		//2) 존재하지 않으면 주문하기 사용 불가
		if(loginClient == null) { //로그인 한 세션이 존재하지 않을 때
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/msg.jsp");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			//여기 나중에 로그인 창 서블릿으로 바꾸기
			request.setAttribute("loc", "/");
		} else {
			//RequestDispatcher rd = request.getRequestDispatcher("/");
			//request.setAttribute("", );
			//rd.forward(request, response);
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
