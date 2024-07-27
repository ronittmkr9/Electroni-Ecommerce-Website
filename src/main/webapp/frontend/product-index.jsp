<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">

<link rel="stylesheet" type="text/css" href="../assets/css/styles.css">

<style>
footer {
     footer {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    background-color: #333;
    color: #fff;
    padding: 20px 0;
    text-align: center;
}
}</style>
</head>
<body>
  
  <%@include file="../includes/header.jsp" %>

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

<%@include file="../includes/footer.jsp" %>
    <script>
        document.querySelector('.hamburger-icon').addEventListener('click', function() {
            document.querySelector('.nav-menu').classList.toggle('show');
        });
    </script>
</body>
</html>


