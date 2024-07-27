 <%
    Integer auth = (Integer) request.getSession().getAttribute("auth");

%>
 
 
 <div class="dashboard-sidebar">
            <h2 class="sidebar-header">Admin Panel</h2>
            <ul class="sidebar-menu">
                <li class="menu-item"><a href="dashboard.jsp" class="menu-link">Dashboard</a></li>
                <li class="menu-item"><a href="users/index.jsp" class="menu-link">Users</a></li>
                     <li class="menu-item"><a href="category/index.jsp" class="menu-link">Categories</a></li>
                <li class="menu-item"><a href="products/index.jsp" class="menu-link">Products</a></li>
                <li class="menu-item"><a href="orders/index.jsp" class="menu-link">Orders</a></li>
                 <li class="menu-item"><a href="orders/index.jsp" class="menu-link">Logout</a></li>
                    
          <%--   <% if(auth != null && auth == 1) { %>
                       <li class="menu-item"><a href="../logout" class="menu-link">Logout</a></li>
              
            <% } %> --%>
            </ul>
        </div>