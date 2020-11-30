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
 * Servlet implementation class InsertCartServlet
 */
@WebServlet(name = "InsertCart", urlPatterns = { "/insertCart" })
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 필터로 생략

		// 2. view에서 넘어온 데이터 저장
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		String menuName = request.getParameter("menuName");

		Cart cart = new Cart();
		cart.setMenuNo(Integer.parseInt(request.getParameter("menuNo")));
		cart.setMenuName(menuName);
		cart.setMenuCount(1);
		cart.setMenuPrice(Integer.parseInt(request.getParameter("menuPrice")));
		cart.setCountPrice(1*Integer.parseInt(request.getParameter("menuPrice")));

		// 3. 비지니스로직
		// 장바구니 세션이 존재하는지 검사
		HttpSession session = request.getSession();
		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");

		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (listCart == null) { // 장바구니가 비어있을 때
			listCart = new ArrayList<Cart>();
			listCart.add(cart);
			request.setAttribute("msg", "장바구니에 담겼습니다.");

			session.setAttribute("listCart", listCart); // 세션에 담는 것 까지 세팅

		} else {

			// 동일한 메뉴는 장바구니에 담지 않도록 하는 조건
			int index = new StoreService().searchIndex(listCart, menuName);
			if (index < 0) { // 동일한 메뉴명이 존재하지 않음
				listCart.add(cart); // listCart에 담기
				request.setAttribute("msg", "장바구니에 담겼습니다.");
			} else { // 동일한 메뉴명이 존재함
				request.setAttribute("msg", "동일한 메뉴가 장바구니 안에 존재합니다.");
			}

		}

		request.setAttribute("loc", "/storeDetailView?storeNo=" + storeNo);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
