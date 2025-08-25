<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">/* Styling the form container */
form {
background: #EEAECA;
background: radial-gradient(circle, rgba(238, 174, 202, 1) 0%, rgba(148, 187, 233, 1) 100%);
  border: 1px solid ;
  padding: 20px;
  border-radius: 5px;
  max-width: 500px;
  margin: 20px auto;
}

/* Styling text input fields */
input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ddd;
  border-radius: 3px;
  box-sizing: border-box; /* Ensures padding and border are included in the element's total width and height */
}
label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}
 input[type="submit"] {
        background-color: #4CAF50; /* Green background */
        color: white; /* White text */
        padding: 12px 18px; /* Padding inside the button */
        border: none; /* No border */
        border-radius: 4px; /* Rounded corners */
        cursor: pointer; /* Change cursor to pointer on hover */
        font-size: 16px; /* Font size */
    }

    /* Optional: Add hover effect */
    input[type="submit"]:hover {
        background-color: #45a049; /* Darker green on hover */
    }
    a {
 color: #020b69;
 text-decoration: none
}
a:hover {
color: red;
text-decoration: underline;
}
</style>
<meta charset="UTF-8">
<title>User SignUp</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<form method="post" action="UserSignUpServlet">
<h1 style="text-align: center;">User Registration Form</h1><hr><br>
<label>Name : </label>
<input type="text" name="name" placeholder="Name"><br>
<label>Email : </label>
<input type="email" name="email" placeholder="Email"><br>
<label>Password : </label>
<input type="text" name="password" placeholder="password"><br>
<label>Confirm Password : </label>
<input type="password" name="confirm-password" placeholder="confirm password"><br>
<input type="submit" value="Submit"><br>
<p>Are you an existing User? <a href="userLogin.jsp">Login</a></p>
</form>
</body>
</html>