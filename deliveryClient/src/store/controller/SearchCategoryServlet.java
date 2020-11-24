package store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.model.service.StoreService;
import store.model.vo.Store;

/**
 * Servlet implementation class SearchCategoryServlet
 */
@WebServlet(name = "SearchCategory", urlPatterns = { "/searchCategory" })
public class SearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 (필터로 생략)
		
		//2. view에서 넘어온 데이터 저장
		int storeCateId = Integer.parseInt(request.getParameter("categoryNo"));
		
		//3. 비지니스 로직
		ArrayList<Store> list = new StoreService().selcetStoreList(storeCateId);
		System.out.println(list);
		
		//4. 결과처리
		if(list.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "입점 준비 중");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/store/storeList.jsp");
			request.setAttribute("list", list);
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
