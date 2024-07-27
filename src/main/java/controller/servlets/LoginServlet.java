package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import utils.StringUtlis;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
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
        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");

        try {
            int user_id = dbController.getUserLoginInfo(user_name, user_password); 
            System.out.println(user_id);
            if (user_id > 0 && user_id != 999) { 
            	
            	HttpSession userSession = request.getSession();
            	userSession.setAttribute("username", user_name);
            	userSession.setMaxInactiveInterval(30*30);
            	
            	
            	Cookie userCookie = new Cookie("user", user_name);
            	userCookie.setMaxAge(30*60);
            	response.addCookie(userCookie);
            	
            	
                request.getSession().setAttribute("auth", 1); 
                request.getSession().setAttribute("user_id", user_id); 
                response.sendRedirect("home");
            } else if (user_id == 0) {
    			request.setAttribute(StringUtlis.ERROR_MESSAGE, StringUtlis.LOGIN_ERROR_MESSAGE);	
    			request.getRequestDispatcher(StringUtlis.LOGIN_PAGE).forward(request, response);
          
            } else if (user_id == 999) {
            	HttpSession userSession = request.getSession();
            	userSession.setAttribute("username", user_name);
            	userSession.setMaxInactiveInterval(30*30);
            	
            	
            	Cookie userCookie = new Cookie("user", user_name);
            	userCookie.setMaxAge(30*60);
            	response.addCookie(userCookie);
            	
            	
                request.getSession().setAttribute("admin", 1); 
                request.getSession().setAttribute("user_id", user_id); 
                response.sendRedirect("admin/dashboard");
            } else {
    			request.setAttribute(StringUtlis.ERROR_MESSAGE, StringUtlis.LOGIN_ERROR_MESSAGE);	
    			request.getRequestDispatcher(StringUtlis.LOGIN_PAGE).forward(request, response);
            }
        } catch (Exception e) {
      
            e.printStackTrace();
        
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
