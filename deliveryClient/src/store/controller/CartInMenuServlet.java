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
 * Servlet implementation class CartInMenuServlet
 */
@WebServlet(name = "CartInMenu", urlPatterns = { "/cartInMenu" })
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
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		String menuName = request.getParameter("menuName");
		
		Cart cart = new Cart();
		cart.setMenuName(menuName);
		cart.setMenuCount(1);
		cart.setMenuPrice(Integer.parseInt(request.getParameter("menuPrice")));
		
		//3. 비지니스로직
		//장바구니 세션이 존재하는지 검사
		HttpSession session = request.getSession(false);		
		ArrayList<Cart> listCart = (ArrayList<Cart>)session.getAttribute("listCart");
		
		if(listCart == null) { //장바구니가 비어있을 때
			listCart = new ArrayList<Cart>();
			listCart.add(cart);
			session.setAttribute("listCart", listCart); //세션에 담는 것 까지 세팅
		} else {
			listCart.add(cart);
			//int index = new StoreService().searchIndex(menuName);
		}
		
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("msg", "장바구니에 담겼습니다.");
		request.setAttribute("loc", "/storeDetailView?store="+storeNo);
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
