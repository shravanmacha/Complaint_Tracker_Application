<%@page import="com.application.model.Complaint"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 table, th, td {
      border: 1px solid black;
    }
    table {
      border-collapse: collapse; /* Collapses borders between cells */
    }
    th, td {
      padding: 8px;
      text-align: left;
    }
      th {
      background-color: #4CAF50;
      color: white;
    }
     tr:nth-child(even) {
      background-color: #f2f2f2;
    }	
     table {
      width: 100%; /* Makes the table span the full width of its container */
      table-layout: fixed; /* Ensures fixed column widths if specified */
    }
    a {
 color: #020b69;
 text-decoration : none;
 font-size: 20px;
 font-family: serif;
 font-weight: bold;
}
a:hover {
color: red;
text-decoration: underline;
}
</style>
<meta charset="UTF-8">
<title>update/delete</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<h1 style="text-align: center; color: #020b69;">Update / Delete Complaints</h1>
<table border="1">
<tr>
<th>ComplaintId</th>
<th>Complaint Name</th>
<th>Flat-No</th>
<th>Complaint Date</th>
<th>Phone Number</th>
<th>Status</th>
<th>Update</th>
<th>Delete</th>
</tr>
<% List<Complaint> complaintList = (List<Complaint>)request.getAttribute("complaints");
	for(Complaint list : complaintList) {
	%>
	<tr>
	<td><%= list.getComplaintId() %></td>
	<td><%= list.getName() %></td>
	<td><%= list.getFlatNo() %>
	<td><%= list.getDate() %></td>
	<td><%= list.getPhoneNumber() %></td>
	<td><%= list.getStatus() %></td>
	<td><a href="updateComplaint.jsp?id=<%= list.getComplaintId()%>">Update</a></td>
	<td><a href="DeleteComplaintServlet?id=<%= list.getComplaintId()%>">Delete</a></td>
	</tr>
	<% } %>
</table><hr>
<a href="complaints.jsp">Go to Home Page</a>
</body>
</html>