package store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.model.service.StoreService;
import store.model.vo.Cart;

/**
 * Servlet implementation class CountPlagServlet
 */
@WebServlet(name = "CountPlag", urlPatterns = { "/countPlag" })
public class CountPlagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountPlagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 (필터로 생략)

		// 2. view에서 넘어온 데이터 저장
		String menuName = request.getParameter("menuName");		
		//이미 변경된 수량으로 값을 넘겨주고 있음
		int count = Integer.parseInt(request.getParameter("count"));
			
		// 3. 비지니스 로직
		HttpSession session = request.getSession();
		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
				
		//메뉴 이름으로 index 추출
		int index = new StoreService().searchIndex(listCart, menuName);
		if (index != -1) { //동일한 메뉴 이름이 존재할 때		
			//해당 메뉴 수량 변경
			listCart.get(index).setMenuCount(count);
		}
			
		//4. 결과처리
		PrintWriter out = response.getWriter();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
