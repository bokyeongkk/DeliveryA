package client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.model.dao.ClientDao;
import client.model.service.ClientService;
import client.model.vo.Client;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet(name = "Join", urlPatterns = { "/join" })
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘긴 값 받기
		Client client = new Client();
		client.setCliId(request.getParameter("cliId"));
		client.setCliPw(request.getParameter("cliPw"));
		client.setCliName(request.getParameter("cliName"));
		client.setCliNickname(request.getParameter("cliNickname"));
		client.setCliEmail(request.getParameter("cliEmail"));
		client.setCliTel(request.getParameter("cliTel"));
		client.setCliBirth(request.getParameter("cliBirth"));
		client.setCliGender(request.getParameter("cliGender"));
		//test용 주소
		client.setCliAddr("주소");
		client.setCliAddrDet("상세주소");
		
		//3. 비지니스 로직
		int result = new ClientService().insertClient(client);
		
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "회원가입 성공");
		} else {
			request.setAttribute("msg", "회원가입 실패");
		}
		request.setAttribute("loc", "/");
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
