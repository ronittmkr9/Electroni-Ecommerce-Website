
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoryModel" %>
<%@ page import="controller.DatabaseController" %>
<%@ page import="controller.CategoryController" %>

<%@ page import="utils.StringUtlis" %>



<%
    DatabaseController dbController = new DatabaseController();
    List<CategoryModel> categories = dbController.getCategories();
    ProductController productController = new ProductController();
    List<ProductModel> products = productController.getAllProducts();

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
  <link rel="stylesheet" type="text/css" href="../SFS_Enterprises/assets/admin/css/styles.css">
</head>
<body>
  
    <div class="dashboard-container">
   <div class="dashboard-sidebar">
            <h2 class="sidebar-header">Admin Panel</h2>
            <ul class="sidebar-menu">
                <li class="menu-item"><a href="../dashboard.jsp" class="menu-link">Dashboard</a></li>
                <li class="menu-item"><a href="../users/index.jsp" class="menu-link">Users</a></li>
                     <li class="menu-item"><a href="../category/index.jsp" class="menu-link">Categories</a></li>
                <li class="menu-item"><a href="index.jsp" class="menu-link">Products</a></li>
                <li class="menu-item"><a href="../orders/index.jsp" class="menu-link">Orders</a></li>
           
            </ul>
        </div>
        <div class="dashboard-content">
           <div class="dashboard-header">
                <h4>Products</h4>
                    <a href="create.jsp" class="add-btn">Add New Products</a>
            
              </div>
<% 
String successMessage = (String) request.getSession().getAttribute("producetSuccessMessage");
if (successMessage != null) { %>
    <div id="successMessage" class="success-message">
        <%= successMessage %>
    </div>
<% } %> 
<div id="successMessage" class="success-message" >
      Product was deleted successfully
    </div>

              <table class="category-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Cost Price</th>
                        <th>Retail Price</th>
                               <th>Product Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
              
                    <% 
            if (products != null && !products.isEmpty()) {
                for (ProductModel product : products) {
            %>
                   <%
                          CategoryController categoryController = new CategoryController();
                          String categoryName = categoryController.getCategoryNameById(product.getFk_categoryID());
                          %>
                    <tr>
                    <td> <%= product.getId() %></td>
                        <td><%= product.getProductName() %></td>
                   
                                       <td><%= categoryName %></td>
                        <td><%= product.getProductCostPrice() %></td>
                        <td><%= product.getProductRetailPrice() %></td>
                             <td><%= product.getProductDescription() %></td>
                          <td class="action-links">
                        
         <a href="../../edit-product?productSlug=<%= product.getProductSlug() %>">Edit</a>
                       <a href="#" class="delete" data-product-id="<%= product.getId() %>">Delete</a>
                        </td>
                    </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="3">No products found</td>
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
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    // Event handler for the delete link
    $(".delete").click(function(e) {
        e.preventDefault(); 
        
        var productId = $(this).data("product-id"); 
        var confirmation = confirm("Are you sure you want to delete this product?");
        
        if (confirmation) {
        
            $.ajax({
                url: "../../deleteproduct",
                method: "POST",
                data: { action: "delete", productId: productId },
                success: function(response) {
                   window.location.reload();
                 
                },
                error: function(xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
    });
});
</script>
    <script>

    document.addEventListener("DOMContentLoaded", function() {

        var successMessage = document.getElementById("successMessage");
        
        if (successMessage) {
       
            setTimeout(function() {
                successMessage.style.display = "none";
            }, 5000); 
        }
    });
</script>
    
</body>
</html>

 