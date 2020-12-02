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
import store.model.vo.Menu;
import store.model.vo.Review;
import store.model.vo.Store;
import store.model.vo.ReviewData;

/**
 * Servlet implementation class StoreDetailViewServlet
 */
@WebServlet(name = "StoreDetailView", urlPatterns = { "/storeDetailView" })
public class StoreDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreDetailViewServlet() {
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
		Store s = new StoreService().selectStoreView(storeNo);
		ArrayList<Menu> listMenu = new StoreService().selectMenuView(storeNo);
		ReviewData srd = new StoreService().selectRevView(storeNo);
		
		//4. 결과처리
		if(s == null || listMenu.isEmpty()) { //가게 정보가 없거나 메뉴가 없을 때
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "상세 페이지 준비중");
			request.setAttribute("loc", "/searchCategory?categoryNo="+s.getStoreCateId());
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/store/storeDetail.jsp");
			request.setAttribute("s", s);
			request.setAttribute("listMenu", listMenu);
			request.setAttribute("srd", srd);
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
