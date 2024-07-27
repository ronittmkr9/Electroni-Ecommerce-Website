<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.CartModel" %>
<%@ page import="controller.CartController" %>

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>
 <%@include file="../includes/cookie.jsp" %>
<%
    int userId = (int) session.getAttribute("user_id"); 
    CartController cartController = new CartController();
    List<CartModel> cartItems = cartController.getCartItemsByUserId(userId);
    
    
    List<CartModel> orderHistory = cartController.getOrderHistoryByUserId(userId);

    // Calculate total
    BigDecimal total = BigDecimal.ZERO;
    for (CartModel cart : cartItems) {
        BigDecimal unitPrice = new BigDecimal(cart.getUnit_price());
        BigDecimal quantity = new BigDecimal(cart.getQuantity());
        BigDecimal itemTotal = unitPrice.multiply(quantity);
        total = total.add(itemTotal);
    }

    // Format total to display with two decimal places
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    String grandTotal = decimalFormat.format(total);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Order History</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
    <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
    
    <style>
    
/* General Styling */
.cart-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

.heading-title {
    text-align: center;
    margin-bottom: 30px;
}

.cart-items {
    margin-bottom: 30px;
}

.cart-item {
    display: flex;
    align-items: center;
    border-bottom: 1px solid #ccc;
    padding-bottom: 20px;
    margin-bottom: 20px;
}

.item-image {
    flex: 1;
    margin-right: 20px;
}

.item-image img {
    width: 100%;
    border-radius: 5px;
}

.item-details {
    flex: 2;
}

h2 {
    margin-bottom: 10px;
}

p {
    margin-bottom: 5px;
}

button {
    background-color: #333;
    color: #fff;
    padding: 8px 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #555;
}

.cart-summary {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.cart-summary h2 {
    margin-bottom: 15px;
}

.checkout-btn {
    background-color: #333;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    display: block;
    margin-top: 15px;
    width: 100%;
}

.checkout-btn:hover {
    background-color: #555;
}


footer {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    background-color: #333;
    color: #fff;
    padding: 20px 0;
    text-align: center;
}</style>
</head>
<body>
  
<%@include file="../includes/header.jsp" %>

 
    <div class="cart-container">
        <h1 class="heading-title">Order History</h1>
        <div class="cart-items">
              <% 
        // Iterate over the cart items
        for (CartModel cart : orderHistory) {
        %>
            <div class="cart-item">
                <div class="item-image">
                    <img src="<%= "../uploads/" + cart.getproductImage() %>" alt="Product Image" style="width:150px; height:150px">
                </div>
                <div class="item-details">
                    <h2><%= cart.getproductName() %></h2>
                    <p>Price: Rs <%= cart.getQuantity() %></p>
                    <p>Quantity:  <%= cart.getUnit_price() %></p>
    
                </div>
            </div>
           <% 
        }
        %>
            <!-- Add more cart items here -->
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
