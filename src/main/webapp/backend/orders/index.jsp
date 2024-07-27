<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CartModel" %>
<%@ page import="controller.OrderController" %>

<%
    OrderController orderController = new OrderController();
    List<CartModel> cartItems = orderController.getAllOrders();
    
    
%>

     <%
    Integer auth = (Integer) request.getSession().getAttribute("admin");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Category Index</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
  <link rel="stylesheet" type="text/css" href="../../assets/admin/css/styles.css">
</head>
<body>
  
    <div class="dashboard-container">
   <div class="dashboard-sidebar">
            <h2 class="sidebar-header">Admin Panel</h2>
            <ul class="sidebar-menu">
                <li class="menu-item"><a href="../dashboard.jsp" class="menu-link">Dashboard</a></li>
                <li class="menu-item"><a href="index.jsp" class="menu-link">Users</a></li>
                     <li class="menu-item"><a href="../category/index.jsp" class="menu-link">Categories</a></li>
                <li class="menu-item"><a href="../products/index.jsp" class="menu-link">Products</a></li>
                <li class="menu-item"><a href="../orders/index.jsp" class="menu-link">Orders</a></li>
                               <% if(auth != null && auth == 1) { %>
                      <li class="menu-item"><a href="../logout" class="menu-link">Logout</a></li>

            <% }  %>
           
           
            </ul>
        </div>
        <div class="dashboard-content">
            <div class="dashboard-header">
                <h4>Orders</h4>
               
              </div>
           <table class="order-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                        <th>Total Price</th>
                        <th>Status</th>
         
                    </tr>
                </thead>
                <tbody>
            
                    <% 
                  if (cartItems != null && !cartItems.isEmpty()) {
                for (CartModel cart : cartItems) {
                	
                	String userIdString = cart.getFk_user_id(); // Example user ID as a String
                	int userId = Integer.parseInt(userIdString);
                    String fullName = orderController.getUserFullName(userId);
            %>
                    <tr>
                    <td> <%= cart.getId() %></td>
                        <td><%= fullName %></td>
                        <td><%= cart.getproductName() %></td>
                       <td><%= cart.getQuantity() %></td>
<td>RS<%= cart.getUnit_price() %></td>
<%
  String quantityStr = cart.getQuantity();
  String unitPriceStr = cart.getUnit_price();
  
  // Parse strings to numeric types
  int quantity = Integer.parseInt(quantityStr);
  double unitPrice = Double.parseDouble(unitPriceStr);
  
  // Calculate total price
  double totalPrice = quantity * unitPrice;
%>

<td>RS <%= totalPrice %></td>

                         <td><%= cart.getCartStatus() %></td>
                        
                       
                    </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="3">No orders have yet processed</td>
                </tr>
            <% 
            } 
            %>
                
                
                
                </tbody>
            </table>
        </div>
        <div class="hamburger-icon">&#9776;</div>
    </div>

    <script>
        document.querySelector('.hamburger-icon').addEventListener('click', function() {
            document.querySelector('.dashboard-container').classList.toggle('show-sidebar');
        });
    </script>
</body>
</html>

