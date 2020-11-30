package store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.model.vo.Cart;

/**
 * Servlet implementation class DeleteCartAllServlet
 */
@WebServlet(name = "DeleteCartAll", urlPatterns = { "/deleteCartAll" })
public class DeleteCartAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 (필터로 생략)
		
		//2. view에서 넘어온 데이터 저장
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		
		//3. 비지니스 로직
		HttpSession session = request.getSession(false);
		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listCart");
		
		
		if(listCart != null) {
			//ArrayList<Cart> 데이터 삭제
			listCart.clear();
			
			//"listCart" 세션 삭제
			session.removeAttribute("listCart");
		}
			
		//4. 결과처리
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
