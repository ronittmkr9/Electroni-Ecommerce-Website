<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="../includes/cookie.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SFS | Contact Us</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400&display=swap">
    <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
    <style>
    

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
  <div class="contact-container">
        <h1 class="heading-title">Contact Us</h1>
        <div class="contact-info">
            <div class="info-item">
                <div class="icon"><i class="fas fa-map-marker-alt"></i></div>
                <div class="text">
                    <h3>Location</h3>
                    <p>123 Street, City, Country</p>
                </div>
            </div>
            <div class="info-item">
                <div class="icon"><i class="far fa-envelope"></i></div>
                <div class="text">
                    <h3>Email</h3>
                    <p>example@example.com</p>
                </div>
            </div>
            <div class="info-item">
                <div class="icon"><i class="fas fa-phone rotate-icon"></i></div>
                <div class="text">
                    <h3>Phone</h3>
                    <p>+1234567890</p>
                </div>
            </div>
        </div>
        <div class="contact-form" >
            <h2>Send us a Message</h2>
            <form>
                <input type="text" name="name" placeholder="Your Name">
                <input type="email" name="email" placeholder="Your Email">
                <textarea name="message" placeholder="Your Message"></textarea>
                <button type="submit">Send</button>
            </form>
        </div>
    </div>
   <%@include file="../includes/footer.jsp" %> 
   
</body>
</html>
