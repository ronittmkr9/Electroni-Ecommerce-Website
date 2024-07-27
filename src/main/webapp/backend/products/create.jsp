
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.CategoryModel" %>
<%@ page import="controller.CategoryController" %>
     <%
    Integer auth = (Integer) request.getSession().getAttribute("admin");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Products Index</title>
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
          
            <div class="center-container">
            <div class="form-container">
                <h2 class="form-title">Add New Product</h2>
<form action="../../product" method="post" enctype="multipart/form-data">
                    <div class="input-container">
                        <input type="text" class="form-input" placeholder="Product Name" name="productName">
                        <input type="text" class="form-input" placeholder="Product Slug"name="productSlug" >
                    </div>
                    <div class="input-container">
                        <input type="number" class="form-input" placeholder="Quantity" name="productQuantity" >
                        <input type="number" class="form-input" placeholder="Cost Price"  name="productCostPrice">
                        <input type="number" class="form-input" placeholder="Retail Price" name="productRetailPrice" >
                    </div>
                    <textarea class="form-input" placeholder="Description" rows="4" name="productDescription"></textarea>
                    <input type="file" class="form-input" placeholder="Product Image" name="productImage" >
                 <select class="form-input" name="fk_categoryID">
    <option value="" disabled selected>Select Category</option>
    <% 
    CategoryController categoryController = new CategoryController();
    
    
    List<CategoryModel> categories = categoryController.getAllCategories(); // Fetch categories from database
    for (CategoryModel category : categories) { 
    %>
    <option value="<%= category.getId() %>"><%= category.getCategoryName() %></option>
    <% } %>
</select>
                 
                
                    <label for="status">Status:</label>
                      <input  class="" type="checkbox" id="status" name="productStatus" ${product.productStatus ? 'checked' : ''}>
                    <button type="submit" class="form-submit">Add Product</button>
    
                          <a   href ="index.jsp" class="cancel-btn">Cancel</a>
                </form>
            </div>
        </div>
    
          
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

