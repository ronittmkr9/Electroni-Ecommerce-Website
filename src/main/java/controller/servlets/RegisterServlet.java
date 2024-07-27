package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.UsersModel;

import utils.StringUtlis;

@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })

//@WebServlet(asyncSupported = true, urlPatterns = { StringUtlis.REGISTER_SERVLET })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = -1; 
		if (idString != null && !idString.isEmpty()) {
		    id = Integer.parseInt(idString);
		}
		
		String fullName = request.getParameter("fullName");
		
		String user_name = request.getParameter("user_name");
		
		
		String user_email = request.getParameter("user_email");
		
		String user_password = request.getParameter("user_password");
		
		
		String user_address = request.getParameter("user_address");
		
		String user_contact = request.getParameter("user_contact");
		
		String is_admin_param = request.getParameter("is_admin");
		
		boolean is_admin = Boolean.parseBoolean(is_admin_param);
	
	

		   UsersModel userModel = new UsersModel(id, fullName, user_name, user_email, user_password, user_address, user_contact, is_admin);

		int result = dbController.addUser(userModel);

		if(result == 1) {
			request.setAttribute(StringUtlis.SUCCESS_REGISTER_MESSAGE, StringUtlis.SUCCESS_MESSAGE);
			request.getRequestDispatcher(StringUtlis.LOGIN_PAGE).forward(request, response);		}
		else if( result == 0 ) {
			request.setAttribute(StringUtlis.ERROR_MESSAGE, StringUtlis.REGISTER_ERROR_MESSAGE);	
			request.getRequestDispatcher(StringUtlis.REGISTER_PAGE).forward(request, response);
		}
		else {
			request.setAttribute(StringUtlis.ERROR_MESSAGE, StringUtlis.REGISTER_ERROR_MESSAGE);	
			request.getRequestDispatcher(StringUtlis.REGISTER_PAGE).forward(request, response);
		}
		

	}

}
