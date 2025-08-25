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
form {
    display: flex;
    align-items: center;
    gap: 10px;
    margin: 10px 0;
    font-family: Arial, sans-serif;
}

select {
    padding: 6px 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    background-color: #f9f9f9;
    font-size: 14px;
    cursor: pointer;
    transition: border 0.3s;
}

select:focus {
    border-color: #007bff;
    outline: none;
}

input[type="submit"] {
    padding: 6px 14px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 6px;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.2s;
}

input[type="submit"]:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}
input[type="submit"]:active {
    transform: scale(0.98);
}

</style>
<meta charset="UTF-8">
<title>All Complaints</title>
</head>
<body style="background: #eb88b1;
background: radial-gradient(circle,rgba(235, 166, 177, 1) 0%, rgba(148, 147, 233, 1) 100%);">
<marquee style="font-size: 40px; font-weight: bold;">Welcome Admin <%= session.getAttribute("email") %></marquee><hr>
<h1 style="text-align: center;">All Complaints</h1>
<table border="1">
<tr>
<th>ComplaintId</th>
<th>Complaint Name</th>
<th>Flat-No</th>
<th>Complaint Date</th>
<th>Phone Number</th>
<th>Status</th>
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
	<td>
                    <form method="post" action="UpdateComplaintStatusServlet">
                        <input type="hidden" name="complaintId" value="<%= list.getComplaintId()%>">
                        <select name="status">
                             <option value="PENDING" <%= "PENDING".equals(list.getStatus()) ? "selected" : "" %>>Pending</option>
        <option value="SOLVED" <%= "SOLVED".equals(list.getStatus()) ? "selected" : "" %>>Solved</option>
                        </select>
                        <input type="submit" value="Update">
                    </form>
                </td>
	</tr>
	<% } %>
</table><hr>
<a href="adminLogin.jsp">Go To Home Page</a>
</body>
</html>