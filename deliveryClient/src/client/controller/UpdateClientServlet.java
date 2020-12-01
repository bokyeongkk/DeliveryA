package client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.model.service.ClientService;
import client.model.vo.Client;

/**
 * Servlet implementation class UpdateClientServlet
 */
@WebServlet(name = "UpdateClient", urlPatterns = { "/updateClient" })
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		
		Client client = new Client();
		String cliId = request.getParameter("cliId");
		client.setCliId(cliId);
		client.setCliNickname(request.getParameter("cliNick"));
		client.setCliTel(request.getParameter("cliTel"));
		client.setCliAddr(request.getParameter("cliAddr"));
		client.setCliAddrDet(request.getParameter("cliAddrDet"));

		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("cliPw");
		
		System.out.println("oldPw>"+oldPw);
		System.out.println("newPw>"+newPw);
		if(newPw.isEmpty()) {
			client.setCliPw(oldPw);
		} else {
			client.setCliPw(newPw);
		}
		
		
		int result = new ClientService().updateClient(client);
		
		RequestDispatcher rd  = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "정보 수정 성공");
		} else {
			request.setAttribute("msg", "정보 수정 실패");
		}
		request.setAttribute("loc", "/mypage?cliId="+cliId);
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
