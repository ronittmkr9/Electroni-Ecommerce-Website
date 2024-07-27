<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>
<%@ page import="utils.StringUtlis" %>

 <%@include file="../includes/cookie.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Home</title>
   <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
 
</head>
<body>
    <%@include file="../includes/header.jsp" %>

    <div class="content">
        <div class="container">
            <!-- Banner -->
            <div class="banner">
                <img src="../assets/images/banner.jpg" alt="Banner Image">
            </div>
            
            <!-- Featured Product Section -->
           <!-- Featured Product Section -->
<div class="featured-product">
    <h2> Products</h2>
    <div class="product-grid">
           <% 
	        // Retrieve products from the database using ProductController
	        ProductController productController = new ProductController();
	        List<ProductModel> products = productController.getAllProducts();
	
	        // Iterate over the list of products
	        for (ProductModel product : products) {
	    %>
	    
        <div class="product">
            <a href="../product-detail?productSlug=<%= product.getProductSlug() %>"> 
              <img src="<%= "../uploads/"+ product.getProductImage() %>" alt="<%= product.getProductName() %>" style="width:300px; height:200px]">
			</a>
            <h3><%= product.getProductName() %></h3>
            <p>Rs  <%= product.getProductRetailPrice() %></p>
        </div>
          <% }
	    %>
    
    
    </div>
</div>

        </div>
    </div>
    
        <%@include file="../includes/footer.jsp" %>
    

</body>
</html>
