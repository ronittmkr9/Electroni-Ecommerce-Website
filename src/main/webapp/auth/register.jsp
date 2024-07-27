<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="utils.StringUtlis" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SFS | Login</title>
<%-- <%@include file="../includes/header.jsp" %> --%>
 <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
 <link rel="stylesheet" type="text/css" href="../SFS_Enterprises/assets/css/styles.css">
 <style>
 .form-container {
    max-width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}


/* Centering container */
.center-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Form container */
.form-container {
    max-width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/* Form title */
.form-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
}

/* Form input fields */
.form-input {
    width: 100%;
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* Form submit button */
.form-submit {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.form-submit:hover {
    background-color: #0056b3;
}

/* Register link */
.register-link {
    text-align: center;
    margin-top: 20px;
}

.register-link a {
    color: #007bff;
    text-decoration: none;
}

.register-link a:hover {
    text-decoration: underline;
}

</style>
</head>
<body>

    <div class="center-container">
        <div class="form-container">
            <h2 class="form-title">Register</h2>
				       <%
				    String errorMessage = (String) request.getAttribute(StringUtlis.ERROR_MESSAGE);
				    if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
				    <p class="error-message"><%= errorMessage %></p>
				<%
				    }
				%>

          <form action="../RegisterServlet" method="POST">
                <input type="text" class="form-input" placeholder="Full name" name="fullName">
                    <input type="text" class="form-input" placeholder="Email Address" name="user_email">
               
   				 <div class="form-row">
               <input type="text" class="form-input" placeholder="Contact number" name="user_contact">
                  <input type="text" class="form-input" placeholder="User address" name="user_address">
                </div>
                <input type="text" class="form-input" placeholder="Username" name="user_name">
                <div class="form-row">
                    <input type="password" class="form-input" placeholder="Password" name="user_password">
                    <input type="password" class="form-input" placeholder="Confirm Password" name="">
                </div>
                      <input type="hidden" class="form-input" placeholder="" name="is_admin" value="0">
                <button type="submit" class="form-submit">Register</button>
            </form>
               <div class="register-link" style="margin-top: 20px;">
                Already have an account? <a href="login.jsp">Login</a>
            </div>
            
            
        </div>
    </div>

<%-- <%@include file="../includes/footer.jsp" %> --%>
</body>
</html>