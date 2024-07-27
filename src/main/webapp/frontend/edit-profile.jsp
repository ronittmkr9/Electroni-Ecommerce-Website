<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.UsersModel" %>
<%@ page import="controller.UserController" %>
<%@ page import="utils.StringUtlis" %>


<%
UserController userController = new UserController();
UsersModel user = userController.getUserById(session);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Home</title>
   <link rel="stylesheet" type="text/css" href="../SFS_Enterprises/assets/css/styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
 <style>
 .profile-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}
 
 .edit-form {
    text-align: center;
    margin-bottom: 30px;
}

.form-input {
    width: 100%;
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
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

     <div class="profile-container">
     		<div class="edit-form">
     		<h3 style="margin-bottom:30px">Edit User Profile </h3>
     		<form action="../SFS_Enterprises/edit-user" method="POST">
				<input type="hidden" id="id" name="id" value="<%=user.getId()%>" readonly>
				<div class="input-container">
					<input type="text" class="form-input" placeholder="User Name"
						name="user_name" value="<%=user.getUsername()%>">
								<input type="text" class="form-input" placeholder="Full Name"
						name="fullName" value="<%=user.getFullName()%>">
						
							<input type="text" class="form-input" placeholder=""
						name="user_contact" value="<%=user.getUserContact()%>">
							<input type="text" class="form-input" placeholder=""
						name="user_address" value="<%=user.getUserAddress()%>">
							<input type="text" class="form-input" placeholder=""
						name="user_email" value="<%=user.getUserEmail()%>">
					
						    <input type="password" class="form-input" placeholder="Password" name="user_password"  value="<%=user.getUserPassword()%>">
						                 <input type="hidden" class="form-input" placeholder="" name="is_admin" value="0">

				</div>

				<button type="submit" class="form-submit" style="width: 170px">Update Profile</button>
			</form>
     		</div>
     </div>
       
	

        <%@include file="../includes/footer.jsp" %>
    

</body>
</html>
