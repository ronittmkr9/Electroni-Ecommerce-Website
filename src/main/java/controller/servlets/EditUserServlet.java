package controller.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import controller.DatabaseController;


@WebServlet(asyncSupported = true, urlPatterns = { "/edit-user" })
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getRequestDispatcher("/frontend/edit-profile.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String userIdParam = request.getParameter("id");
		 	System.out.println(userIdParam+"userse");
		    if (userIdParam != null && !userIdParam.isEmpty()) {
		        int userId = Integer.parseInt(userIdParam);
		        String fullName = request.getParameter("fullName");
		        String user_name = request.getParameter("user_name");
		        String user_email = request.getParameter("user_email");
		        String user_password = request.getParameter("user_password");
		        String user_address = request.getParameter("user_address");
		        String user_contact = request.getParameter("user_contact");
	
		        String is_admin = request.getParameter("is_admin");

		        // Update category in the database
		        UserController userController = new UserController();
		        userController.updateUserProfile(userId, fullName, user_name, user_email, user_password, user_address,user_contact, is_admin );

			       request.getSession().setAttribute("userSuccessMessage", "User updated successfully");
		        response.sendRedirect(request.getContextPath() + "/frontend/user-profile.jsp");
		    } else {

		        response.sendRedirect(request.getContextPath() + "/error.jsp");
		    }
  	
		
    }


}
