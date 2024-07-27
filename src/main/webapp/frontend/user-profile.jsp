
<%@ page import="controller.UserController" %>
<%@ page import="java.util.Date" %>
 <%@include file="../includes/cookie.jsp" %>

<%@ page import="model.UsersModel" %>

<%

    UserController userController = new UserController();
    UsersModel user = userController.getUserById(session);
    

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | User Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
    <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
<style>

.profile-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

.heading-title {
    text-align: center;
    margin-bottom: 30px;
}

.user-info {
    display: flex;
    align-items: center;
}

.profile-picture {
    flex: 1;
    margin-right: 20px;
}

.profile-picture img {
    width: 100%;
    height: auto;
    max-width: 200px;
    max-height: 200px;
}


.profile-details {
    flex: 2;
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
   
  <div class="profile-container">
        <h1 class="heading-title">User Profile</h1>
        <%
        String successMessage = (String) request.getAttribute("userSuccessMessage");
        if(successMessage != null && !successMessage.isEmpty()){
        	%>
        	<p><%=successMessage %></p>
      <%  }
        %>
  
        
        
        <div class="user-info" style="padding:32px; border:1px solid #e7e7e7">
            <div class="profile-picture">
                <img src="../assets/images/person.jpg" alt="Profile Picture">
            </div>
           
            <div class="profile-details">
                <h2><%= user.getUsername() %></h2>
                <p>Email: <%= user.getUserEmail() %></p>
                <p>Phone: <%= user.getUserContact() %></p>
                <p>Address: <%= user.getUserAddress() %></p>
               	<a href="../edit-user" class="edit-profile-btn">Edit Profile</a>
            </div>
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
