<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
    Integer auth = (Integer) request.getSession().getAttribute("admin");

%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
  <link rel="stylesheet" type="text/css" href="../assets/admin/css/styles.css">
</head>
<body>
    <div class="dashboard-container">
   <div class="dashboard-sidebar">
            <h2 class="sidebar-header">Admin Panel</h2>
            <ul class="sidebar-menu">
                <li class="menu-item"><a href="dashboard.jsp" class="menu-link">Dashboard</a></li>
                <li class="menu-item"><a href="users/index.jsp" class="menu-link">Users</a></li>
                     <li class="menu-item"><a href="category/index.jsp" class="menu-link">Categories</a></li>
                <li class="menu-item"><a href="products/index.jsp" class="menu-link">Products</a></li>
                <li class="menu-item"><a href="orders/index.jsp" class="menu-link">Orders</a></li>
                    <% if(auth != null && auth == 1) { %>
                      <li class="menu-item"><a href="../logout" class="menu-link">Logout</a></li>

            <% }  %>
           
            </ul>
        </div>
        <div class="dashboard-content">
            <h1 class="dashboard-header">Dashboard</h1>
            <div class="placeholder-content">
                Welcome to the Admin Dashboard. Select an option from the menu to get started.
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
