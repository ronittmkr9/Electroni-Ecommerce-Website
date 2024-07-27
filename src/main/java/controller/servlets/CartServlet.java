package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import controller.CartController;

import model.CartModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
	
	CartController cartController = new CartController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String idString = request.getParameter("id");
		int id = -1; 
		if (idString != null && !idString.isEmpty()) {
		    id = Integer.parseInt(idString);
		}
		
		
		   String productIdString = request.getParameter("productId");
		    String userIdString = request.getParameter("userId");
		    String priceString = request.getParameter("price");
		    String quantityString = request.getParameter("quantity");
		    String productName = request.getParameter("productName");
		    String productImage = request.getParameter("productImage");
		    String cart_status = "C";
		    
		    
			CartModel cartmodel= new CartModel(id, userIdString, productIdString, quantityString,   priceString, productName, productImage,cart_status);
			
			int result = cartController.addCart(cartmodel);
			
			if(result  > 0) {
		        response.sendRedirect(request.getContextPath() + "/frontend/cart.jsp");
			}
		
	
	}

}
