<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>
<%@ page import="javax.servlet.http.HttpSession" %> <!-- Import HttpSession -->
    <% 
        int userId = (int) session.getAttribute("user_id"); 
    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
  <link rel="stylesheet" type="text/css" href="../SFS_Enterprises/assets/css/styles.css">
</head>
<body>
    <div class="navbar" style="padding: 24px;">
        <div class="logo-section">
            <ul class="nav-menu">
                <li class="nav-item"><a href="#" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Products</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About Us</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
            </ul>
        </div>
        <div class="right-section">
            <div class="action-buttons">
                <div class="action-item"><a href="#" class="nav-link"><i class="fas fa-heart"></i></a></div> <!-- Font Awesome icon -->
                <div class="action-item"><a href="#" class="nav-link"><i class="fas fa-shopping-cart"></i></a></div> <!-- Font Awesome icon -->
                <div class="action-item"><a href="#" class="nav-link">Login</a></div>
            </div>
            <div class="hamburger-icon">&#9776;</div>
        </div>
    </div>

    <div class="product-detail">
        <div class="product-image">
            <img src="assets\images\samsung-laptop.jpg" alt="Product Image">
        </div>
        <div class="product-description">
            <h3>${product.productName }</h3>
            
            <p class="product-price">Rs ${product.productRetailPrice }</p>
            <p>${product.productDescription }</p>
            <form action="cart" method="POST">
                   <input type="hidden" class="" value="${product.id}" name="productId">
                     <input type="hidden" class="" value=" <%= userId %>" name="userId">
                   
          
                <input type="button" value="-" class="quantity-control-btn" onclick="decreaseQuantity()">
                <input type="number" class="quantity-input" value="1" min="1" name="quantity">
                <input type="button" value="+" class="quantity-control-btn" onclick="increaseQuantity()">
                      <input type="text" class="" value="${product.productRetailPrice}" name="price"> 
                <div class="add-to-cart-btn-container">
                    <button type="submit" class="add-to-cart-btn">Add to Cart</button>
                </div>
            </form>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </div>

    <script>
        function increaseQuantity() {
            var input = document.querySelector('.quantity-input');
            input.value = parseInt(input.value) + 1;
        }

        function decreaseQuantity() {
            var input = document.querySelector('.quantity-input');
            if (parseInt(input.value) > 1) {
                input.value = parseInt(input.value) - 1;
            }
        }

        document.querySelector('.hamburger-icon').addEventListener('click', function() {
            document.querySelector('.nav-menu').classList.toggle('show');
        });
    </script>
</body>
</html>






<%-- 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SFS | ${product.productName }</title>
</head>
<body>
  <div class="container">
    <h1>Product Detail</h1>
    
    <div class="product-detail">
        <div class="product-image">
            <img src="<%=  %>" alt="<%= ${product.productName} %>">
        </div>
        <div class="product-info">
<img src="C:/Users/Sanish/eclipse-workspace/SFS_Enterprises/src/main/webapp/uploads/${product.productImage}" alt="${product.productName}">
  <img src="../SFS_Enterprises/uploads/${product.getProductImage()}" alt="${product.getProductName()}"> 
            <h2>${product.productName }</h2>
              <p>${product.productDescription }</p>
            <p>Description: <%= request.getAttribute("product").getProductDescription() %></p>
            <p>Price: <%= request.getAttribute("product").getProductRetailPrice() %></p>
            <!-- Add any other product details you want to display -->
        </div>
    </div>
    
    <div class="actions">
        <!-- Add any actions/buttons related to the product (e.g., Add to Cart, Buy Now) -->
        <button>Add to Cart</button>
        <button>Buy Now</button>
    </div>
</div>
</body>
</html> --%>
