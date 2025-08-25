<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
 color: #020b69;
 text-decoration : none;
 font-size: 24px;
 font-family: serif;
 font-weight: bold;
}
a:hover {
color: red;
text-decoration: underline;
}
</style>
<meta charset="UTF-8">
<title>User-HomePage</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<marquee style="font-size: 40px; font-weight: bold;">Welcome <%= session.getAttribute("email") %></marquee><hr><br>
<a href="newComplaint.jsp">Add New Complaint</a><br><br>
<a href="ViewComplaintsServlet">View Complaints</a><br><br>
<a href="UpdateDeleteComplaintServlet">Update/Delete Complaint</a><br><br>
<a href="ViewHistoryServlet">View History</a><br><br>
<a href="LogOutServlet">LogOut</a>
</body>
</html>