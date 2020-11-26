package store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.vo.Order;
import store.model.service.StoreService;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet(name = "SearchOrder", urlPatterns = { "/searchOrder" })
public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 (필터로 생략)

		// 2. view에서 넘어온 데이터 저장
		String cliId = request.getParameter("cliId");
		int storeNo = Integer.parseInt(request.getParameter("storeNo"));
		
		Date date = new Date();
		//MM대문자 : 월 //mm소문자 : 시간  //dd소문자 : 일
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String now = sdf.format(date);
		System.out.println(now);
		
		//3. 비지니스 로직
		Order order = new StoreService().selectOrder(cliId, storeNo, now);
		
		//4. 결과처리
		PrintWriter out = response.getWriter();
		if(order == null) { //주문한 이력이 없을 때 
			out.print("0");
		} else { //주문한 이력이 있을 때 
			out.print("1");
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
