package client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.model.service.ClientService;

/**
 * Servlet implementation class UpdatePwServlet
 */
@WebServlet(name = "updatePw", urlPatterns = { "/updatePw" })
public class UpdatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cliId = request.getParameter("cliId");
		String cliPw = request.getParameter("cliPw");
		
		int result = new ClientService().updatePw(cliId, cliPw);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {	//비밀번호 변경 성공
//			request.setAttribute("msg", "비밀번호 변경성공.");
//			request.setAttribute("loc", "/views/client/completePw.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/views/client/completePw.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "비밀번호 변경 실패\n관리자에게 문의하세요");
			request.setAttribute("loc", "/views/client/search.jsp");
			rd.forward(request, response);
		}
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
