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
input[type="date"],
input[type="number"] {
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
 text-decoration : none;
 font-family: serif;
 font-weight: bold;
}
a:hover {
color: red;
text-decoration: underline;
}
</style>
<meta charset="UTF-8">
<title>Add Complaint</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<form method="post" action="NewComplaintServlet">
<h1 style="text-align: center;">Add New Complaint</h1><hr><br>
<label>Complaint Name : </label>
<input type="text" name="complaint-name" placeholder="Enter your Complaint"><br>
<label>Flat-No : </label>
<input type="text" name="flatNo" placeholder="Enter FlatNo"><br>
<label>Complaint Date : </label>
<input type="date" name="complaint-date" ><br>
<label>Phone Number : </label>
<input type="number" name="phone-number" placeholder="Enter your Phone Number"><br>

<input type="submit" value="Submit"><br><br>
<a href="complaints.jsp">Go to HomePage</a><br>
</form>
</body>
</html>