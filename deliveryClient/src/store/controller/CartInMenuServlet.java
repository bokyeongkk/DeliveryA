package store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.model.vo.Client;

/**
 * Servlet implementation class CartInMenuServlet
 */
@WebServlet("/CartInMenuServlet")
public class CartInMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartInMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 필터로 생략
		
		//2. view에서 넘어온 데이터 저장
		String menuName = request.getParameter("menuName");
		String menuPrice = request.getParameter("menuPrice");
		int menuCounter = 1;

		//1) 로그인 세션이 존재하는지 검사
		//session.setAttribute("client", loginClient); 
		HttpSession session = request.getSession(false);
		Client loginClient = (Client)session.getAttribute("loginClient");
		
		//2) 존재하지 않으면 장바구니 담기 사용 불가
		if(loginClient == null) { //로그인 한 세션이 존재하지 않을 때
			
		} else {
			
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
