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

/**
 * Servlet implementation class ReviewWriteFrmServlet
 */
@WebServlet(name = "ReviewWriteFrm", urlPatterns = { "/reviewWriteFrm" })
public class ReviewWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteFrmServlet() {
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
		String cliId = request.getParameter("cliId");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String now = sdf.format(date)+" ";
		System.out.println(now);
		//3개 를 조건식으로 사용해서 Order객체를 여기로 가지고오죠 그리고 null인지 아닌지 if로 나누는것까지만 먼저작성 결과처리는 지우고
		
		//3. 비지니스 로직
		
		
		
		//4. 결과처리

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
