<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>
 <%@include file="../includes/cookie.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %> <!-- Import HttpSession -->
 <% 
    Integer userId = (Integer) session.getAttribute("user_id"); // Use Integer to allow null value
    if (userId == null) {
        userId = null; // Set userId to null if user is not logged in
    }
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Home</title>
   <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
    <style>
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
    </style>
</head>
<body>
    <%@include file="../includes/header.jsp" %>


 <div class="product-container" style="border: 1px solid #EEEDED; margin-top: 42px;">
        <!-- Product Detail -->
        <div class="product-detail">
            <div class="product-image">
           
     		 <img src="uploads/${product.productImage}" alt="Product Image" width="300px">

            </div>
            <div class="product-info">
                <h2>${product.productName }</h2>
                <p class="price">Rs ${product.productRetailPrice }</p>
                <p>${product.productDescription }</p>
        
                
                 <form action="cart" method="POST">
                   <input type="hidden" class="" value="${product.id}" name="productId">
                     <input type="hidden" class="" value=" <%= userId %>" name="userId">
                    <input type="hidden" class="" value=" ${product.productName}" name="productName">
                     <input type="hidden" class="" value="${product.productImage}" name="productImage">
          
             
                <input type="number" class="quantity-input" value="1" min="1" name="quantity">
          
                      <input type="hidden" class="" value="${product.productRetailPrice}" name="price"> 
               
                  	 <button type="submit" class="add-to-cart-btn">Add to Cart</button>
            </form>
            </div>
        </div>

        <!-- Additional Information -->
       <!--  <div class="additional-info">
            <h3>Additional Information</h3>
            <ul>
                <li>Category: Electronics</li>
                <li>Brand: XYZ</li>
                <li>Availability: In stock</li>
            </ul>
        </div>
 -->
        
    </div>

    
        <%@include file="../includes/footer.jsp" %>
    
</body>
</html>




