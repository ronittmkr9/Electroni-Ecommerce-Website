package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CategoryController;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/updateCategory" })
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryController categoryController = new CategoryController();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String categoryIdParam = request.getParameter("id");
		 
		    if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
		        int categoryId = Integer.parseInt(categoryIdParam);
		        String categoryName = request.getParameter("categoryName");
		        String categorySlug = request.getParameter("categorySlug");
	
		        boolean status = request.getParameter("status") != null; // Convert checkbox value to boolean

		        // Update category in the database
		        CategoryController categoryController = new CategoryController();
		        categoryController.updateCategory(categoryId, categoryName, categorySlug, status);

			       request.getSession().setAttribute("successMessage", "Category updated successfully");
		        response.sendRedirect(request.getContextPath() + "/backend/category/index.jsp");
		    } else {
		        // Handle missing or invalid category ID parameter
		        response.sendRedirect(request.getContextPath() + "/error.jsp");
		    }
        
	}

}
