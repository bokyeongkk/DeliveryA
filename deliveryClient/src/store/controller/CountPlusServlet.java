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

import org.json.simple.JSONObject;

import store.model.service.StoreService;
import store.model.vo.Cart;

/**
 * Servlet implementation class CountPlusServlet
 */
@WebServlet(name = "CountPlus", urlPatterns = { "/countPlus" })
public class CountPlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountPlusServlet() {
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
		
		// 3. 비지니스 로직
		HttpSession session = request.getSession();
		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
		
		// 메뉴 이름으로 index 추출
		int index = new StoreService().searchIndex(listCart, menuName);
		int changeNum = 0;
		if (index != -1) {
			//해당되는 메뉴의 count숫자 +1
			for(Cart c : listCart) {
				for(int i=0; i<listCart.size(); i++) {
					if(i == index) {
						//메뉴 카운트 변경
						c.setMenuCount(c.getMenuCount()+1);
						changeNum = c.getMenuCount();
						//카운트 변경에 따른 가격 변경
						c.setCountPrice(changeNum*c.getMenuPrice());


					}
				}
			}
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
