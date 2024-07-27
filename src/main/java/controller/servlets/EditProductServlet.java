package controller.servlets;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.ProductController;
import model.ProductModel;



@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productSlug = request.getParameter("productSlug");

        ProductController productController = new ProductController();
        ProductModel product = productController.getProductBySlug(productSlug);

        request.setAttribute("product", product);
        request.getRequestDispatcher("./backend/products/edit.jsp").forward(request, response);
        
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

}
