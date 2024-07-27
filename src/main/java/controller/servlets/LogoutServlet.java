package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try(PrintWriter out = response.getWriter()){
			Cookie[] cookies = request.getCookies();
			if(cookies != null ) {
			
				for(Cookie cookie :cookies) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			
			HttpSession session = request.getSession(false);
			if(session !=null) {
				session.invalidate();
			}
			if(request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				   response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
			}
			else {
				   response.sendRedirect(request.getContextPath() + "/frontend/home.jsp");
			}
		}
	}


}
