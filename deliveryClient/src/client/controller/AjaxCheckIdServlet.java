package client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.model.service.ClientService;
import client.model.vo.Client;

/**
 * Servlet implementation class AjaxCheckIdServlet
 */
@WebServlet(name = "AjaxCheckId", urlPatterns = { "/ajaxCheckId" })
public class AjaxCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxCheckIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");

		//2. view에서 넘어온 값 저장
		String cliId = request.getParameter("cliId");
		
		//3. 비지니스 로직
		Client client = new ClientService().selectOneClient(cliId);

		//4. 결과 처리
		PrintWriter out = response.getWriter();
		if(client!=null) {	//회원 존재 -> 사용 불가능
			out.print(0);
		} else {
			out.print(1);
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
