package client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.model.service.ClientService;
import client.model.vo.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘어온 값 받기
		Client client = new Client();
		client.setCliId(request.getParameter("cliId"));
		client.setCliPw(request.getParameter("cliPw"));
		
		//3. 비지니스 로직
		Client c = new ClientService().selectOneClient(client);
		
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(c!=null) {	//로그인 성공
			HttpSession session = request.getSession();
			request.setAttribute("msg", "로그인 성공");
			session.setAttribute("client", c);
			request.setAttribute("loc", "/");
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			request.setAttribute("loc", "/views/client/login.jsp");
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
