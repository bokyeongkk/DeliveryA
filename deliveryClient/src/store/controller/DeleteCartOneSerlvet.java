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

import store.model.service.StoreService;
import store.model.vo.Cart;

/**
 * Servlet implementation class DeleteCartOneSerlvet
 */
@WebServlet(name = "DeleteCartOne", urlPatterns = { "/deleteCartOne" })
public class DeleteCartOneSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartOneSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 (필터로 생략)

		// 2. view에서 넘어온 데이터 저장
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		String menuName = request.getParameter("menuName");

		// 3. 비지니스 로직
		HttpSession session = request.getSession(false);
		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
		
		
		if(listCart != null) {
			// 메뉴 이름으로 index 추출
			int index = new StoreService().searchIndex(listCart, menuName);
			if (index != -1) {
				//해당 데이터 삭제
				listCart.remove(index);
			}
			
			//메뉴가 삭제되었을 때 장바구니에 아무것도 없으면 세션도 null로 세팅
			if(listCart.isEmpty()) {
				session.removeAttribute("listCart");
			}
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("/storeDetailView?storeNo="+storeNo);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
