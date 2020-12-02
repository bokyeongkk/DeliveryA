package store.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.model.service.StoreService;
import store.model.vo.Review;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet(name = "InsertReview", urlPatterns = { "/insertReview" })
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
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
		
		Review review = new Review();
		review.setRevScore(Integer.parseInt(request.getParameter("reviewScore")));
		review.setRevContent(request.getParameter("reviewContent"));
		review.setRevStore(storeNo);
		review.setRevCliId(request.getParameter("cliId"));
		
		Date date = new Date();
		//MM대문자 : 월 //mm소문자 : 시간  //dd소문자 : 일
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String now = sdf.format(date);
		
		review.setRevEnrollDate(now);
		
		//3. 비지니스 로직
		int result = new StoreService().insertReview(review);
		
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) { //등록이 성공 한 경우
			request.setAttribute("msg", "리뷰가 등록되었습니다.");
			request.setAttribute("loc", "/storeDetailView?storeNo="+storeNo);
		} else { //등록이 실패한 경우
			request.setAttribute("msg", "리뷰가 등록되지 않았습니다. 관리자에게 문의해주세요.");
			request.setAttribute("loc", "/storeDetailView?storeNo="+storeNo);
		}
		
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
