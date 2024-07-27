package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import controller.CategoryController;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet("/edit-category")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the category ID from the request parameter
        String categoryIdString = request.getParameter("id");
        if (categoryIdString != null && !categoryIdString.isEmpty()) {
            try {
                int categoryId = Integer.parseInt(categoryIdString);

 
                CategoryController categoryController = new CategoryController();
                CategoryModel category = categoryController.getCategoryById(categoryId);

                request.setAttribute("category", category);
                request.getRequestDispatcher("/backend/category/edit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
 
                response.sendRedirect(request.getContextPath() + "/categories.jsp");
            }
        } else {

            response.sendRedirect(request.getContextPath() + "/categories.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
