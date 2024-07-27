package controller.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.ProductController;
import model.ProductModel;

import utils.StringUtlis;


@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1 MB
    maxFileSize = 10 * 1024 * 1024,   // 10 MB
    maxRequestSize = 50 * 1024 * 1024 // 50 MB
)


/**
 * Servlet implementation class UpdateProductServlet
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/update-product" })
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve parameters from the request
	    String productIdParam = request.getParameter("id");
	    
	    if (productIdParam != null && !productIdParam.isEmpty()) {
	        int productId = Integer.parseInt(productIdParam);
	        int categoryId = Integer.parseInt(request.getParameter("fk_categoryID")); // Assuming you have categoryId as a hidden field in the form
	        String productName = request.getParameter("productName");
	        String productSlug = request.getParameter("productSlug");

	        double productCostPrice = Double.parseDouble(request.getParameter("productCostPrice"));
	        double productRetailPrice = Double.parseDouble(request.getParameter("productRetailPrice"));
	        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
	        String productDescription = request.getParameter("productDescription");
	        boolean productStatus = request.getParameter("productStatus") != null; 

		    Part filePart = request.getPart("productImage");
		    String fileName = null;

		    if (filePart != null) {
		        fileName = filePart.getSubmittedFileName();
		        String uploadPath = "C:\\Users\\Sanish\\eclipse-workspace\\SFS_Enterprises\\src\\main\\webapp\\uploads\\" + fileName;
		        
		        try (InputStream is = filePart.getInputStream();
		             FileOutputStream fos = new FileOutputStream(uploadPath)) {
		            byte[] buffer = new byte[1024];
		            int bytesRead;
		            while ((bytesRead = is.read(buffer)) != -1) {
		                fos.write(buffer, 0, bytesRead);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		    
		        }
		    }

	        
	        
	        
	        ProductController productController = new ProductController();
	        productController.updateProduct(productId, categoryId, productName, productSlug, fileName, productCostPrice, productRetailPrice, productQuantity, productDescription, productStatus);

	        // Set success message
	        request.getSession().setAttribute("successMessage", "Product updated successfully");

	        // Redirect to product list page
	        response.sendRedirect(request.getContextPath() + "/backend/products/index.jsp");
	

	    } else {
	     
	        response.sendRedirect(request.getContextPath() + "/error.jsp");
	    }
	}



}
