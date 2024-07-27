package controller.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.DatabaseController;
import controller.ProductController;
import model.ProductModel;
import utils.StringUtlis;

import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1 MB
    maxFileSize = 10 * 1024 * 1024,   // 10 MB
    maxRequestSize = 50 * 1024 * 1024 // 50 MB
)

@WebServlet(asyncSupported = true, urlPatterns = { "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ProductController pdController = new ProductController();
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		String idString = request.getParameter("id");
		int id = -1; // Default value or placeholder for the id

		// Check if idString is not null before parsing
		if (idString != null && !idString.isEmpty()) {
		    id = Integer.parseInt(idString);
		}
	    String fk_categoryID = request.getParameter("fk_categoryID");
	    String productName = request.getParameter("productName");
	    String productSlug = request.getParameter("productSlug");
	    String productCostPrice = request.getParameter("productCostPrice");
	    String productRetailPrice = request.getParameter("productRetailPrice");
	    String productQuantity = request.getParameter("productQuantity");
	    String productDescription = request.getParameter("productDescription");
	    String productStat = request.getParameter("productStatus");
	    boolean productStatus = Boolean.parseBoolean(productStat);

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
	            // Handle file upload error
	        }
	    }

	    // Create ProductModel object
	    ProductModel productModel = new ProductModel(id, fk_categoryID, productName, productSlug, 
	                                                  fileName, productCostPrice, 
	                                                  productRetailPrice, productQuantity, 
	                                                  productDescription, productStatus);

	    // Add product to database
	    int result = pdController.addProducts(productModel);

	    if (result > 0) {

	        request.getSession().setAttribute("producetSuccessMessage", "Product added successfully");

	        // Redirect to product list page
	        response.sendRedirect(request.getContextPath() + "/backend/products/index.jsp");
		
	    } else {
	    	request.setAttribute(StringUtlis.ERROR_MESSAGE, StringUtlis.PRODUCT_ERROR_MESSAGE);	
	    	  response.sendRedirect(request.getContextPath() + "/backend/products/create.jsp");
	    }
	}


}
