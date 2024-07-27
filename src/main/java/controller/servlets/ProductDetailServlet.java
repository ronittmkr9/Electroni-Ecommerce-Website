package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ProductController;
import model.ProductModel;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String productSlug = request.getParameter("productSlug");
	        
	        // Retrieve product data based on product slug
	        ProductController productController = new ProductController();
	        ProductModel product = productController.getProductBySlug(productSlug);
	        
	       
	        request.setAttribute("product", product);
	    
		    
		    // Forward the request to a JSP page to render the product details
		    request.getRequestDispatcher("./frontend/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
