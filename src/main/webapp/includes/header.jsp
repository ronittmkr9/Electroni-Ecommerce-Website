
<%
    Integer auth = (Integer) request.getSession().getAttribute("auth");

%>


  <header>
        <nav class="navbar">
            <div class="container">
                <div class="navbar-left">
                 
                    <ul>
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="product-index.jsp">Product</a></li>
                        <li><a href="about.jsp">About</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                    </ul>
                </div>
                <div class="navbar-right">
                    <ul>
                  <li>
    <form id="searchForm" action="../search" method="GET">
    <div class="search-container">
        <input type="text" id="searchInput" name="query" placeholder="Search products..." style="align-text:center">
        <button type="submit" class="search-btn"><i class="fas fa-search"></i></button>
    </div>
</form>
                        </li>
                    
                      <% if(auth != null && auth == 1) { %>
                               <li><a href="cart.jsp">Cart</a></li>
                         <li><a href="orders.jsp">Order History</a></li>
                  <li><a href="user-profile.jsp">User Profile</a></li>
                        <li><a href="../logout">Logout</a></li>
            <% } else { %>
                   <li><a href="../auth/login.jsp">Login</a></li>
            <% } %>
                       
                    </ul>
                </div>
            </div>
        </nav>
    </header>