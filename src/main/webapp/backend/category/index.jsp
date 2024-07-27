
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="controller.ProductController" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoryModel" %>
<%@ page import="controller.DatabaseController" %>
<%
    DatabaseController dbController = new DatabaseController();
    List<CategoryModel> categories = dbController.getCategories();
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
                <li class="menu-item"><a href="../users/index.jsp" class="menu-link">Users</a></li>
                     <li class="menu-item"><a href="index.jsp" class="menu-link">Categories</a></li>
                <li class="menu-item"><a href="../products/index.jsp" class="menu-link">Products</a></li>
                <li class="menu-item"><a href="../orders/index.jsp" class="menu-link">Orders</a></li>
                               <% if(auth != null && auth == 1) { %>
                      <li class="menu-item"><a href="../logout" class="menu-link">Logout</a></li>

            <% }  %>
           
           
            </ul>
        </div>
        <div class="dashboard-content">
           <div class="dashboard-header">
                <h4>Category</h4>
                    <a href="create.jsp" class="add-btn">Add New Category</a>
            
              </div>
              <% 
String successMessage = (String) request.getSession().getAttribute("successMessage");
if (successMessage != null) { %>
    <div id="successMessage" class="success-message">
        <%= successMessage %>
    </div>
<% } %>



              <table class="category-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Slug</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
            if (categories != null && !categories.isEmpty()) {
                for (CategoryModel category : categories) {
            %>
                    <tr>
                    <td> <%= category.getId() %></td>
                        <td><%= category.getCategoryName() %></td>
                        <td><%= category.getCategorySlug() %></td>
                  
                         <td><% if (category.getStatus()) { %>
					  active
					<% } else { %>
					  inactive
					<% } %></td>
                        
                          <td class="action-links">
             <a href="../../edit-category?id=<%= category.getId() %>" class="edit">Edit</a>
                       <a href="#" class="delete" data-category-id="<%= category.getId() %>">Delete</a>
                        </td>
                    </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="3">No records of the users are there</td>
                </tr>
            <% 
            } 
            %>
                </tbody>
            </table>
        </div>

    </div>

    <script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    // Event handler for the delete link
    $(".delete").click(function(e) {
        e.preventDefault(); 
        
        var categoryId = $(this).data("category-id"); 
        var confirmation = confirm("Are you sure you want to delete this category?");
        
        if (confirmation) {
        
            $.ajax({
                url: "../../deletecategory",
                method: "POST",
                data: { action: "delete", categoryId: categoryId },
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

 