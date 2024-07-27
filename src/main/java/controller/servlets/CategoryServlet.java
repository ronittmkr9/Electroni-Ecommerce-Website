package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.CategoryModel;
/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/category" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController dbController = new DatabaseController();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     request.getRequestDispatcher("/WEB-INF/backend/category/index.jsp").forward(request, response);


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
	String categoryName = request.getParameter("categoryName");
		
		String categoryAlias = request.getParameter("categorySlug");
		String is_active_param = request.getParameter("status");
		boolean status = Boolean.parseBoolean(is_active_param);
		
		
	CategoryModel categoryModel= new CategoryModel(id, categoryName, categoryAlias,   status);
		
		int result = dbController.addCategory(categoryModel);
		
		if(result  > 0) {
		       request.getSession().setAttribute("successMessage", "Category added successfully");

		        
	        response.sendRedirect(request.getContextPath() + "/backend/category/index.jsp");
		}
	
		
	}

}
