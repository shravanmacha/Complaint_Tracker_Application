<%@page import="com.application.model.Complaint"%>
<%@page import="com.application.dao.ComplaintDao"%>
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
<title>Update Complaint</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<% int complaintId = (Integer.parseInt(request.getParameter("id")));
ComplaintDao complaintDao = new ComplaintDao();
Complaint complaint = complaintDao.updateComplaintbyId(complaintId);%>
<h1 style="text-align: center;">Update Complaint</h1>
<form method="post" action="UpdateComplaintServlet">
<input type="hidden" name="id" value="<%= complaint.getComplaintId() %>">
<label>Complaint Name : </label>
<input type="text" name="complaint-name" value="<%= complaint.getName() %>"><br>
<label>Flat-No : </label>
<input type="text" name="flatNo" value="<%= complaint.getFlatNo() %>"><br>
<label>Complaint Date : </label>
<input type="date" name="complaint-date" value="<%= complaint.getDate() %>"><br>
<label>Phone Number : </label>
<input type="number" name="phone-number" value="<%= complaint.getPhoneNumber() %>"><br>

<input type="submit" value="Update">
</form>
</body>
</html>