package client.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import client.model.service.ClientService;
import client.model.vo.Client;

/**
 * Servlet implementation class AjaxLoginServlet
 */
@WebServlet(name = "AjaxLogin", urlPatterns = { "/ajaxLogin" })
public class AjaxLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		Client client = new Client();
		client.setCliId(request.getParameter("cliId"));
		client.setCliPw(request.getParameter("cliPw"));
		
		Client loginClient = new ClientService().selectOneClient(client);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		if(loginClient!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("client", loginClient);
			new Gson().toJson(1, response.getWriter());
		} else {
			new Gson().toJson(0, response.getWriter());
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
