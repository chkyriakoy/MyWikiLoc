<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyWikiLoc</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
<script src= "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
</head>
<body>
<H1> My WikiLoc App</H1>
<h2>All Users</h2>

<div class="col-sm-5" align = "center">
                 <div class="panel-body" align = "center" >
                 <table class="table">
  <thead class="thead-dark">
    <tr>
       <th>User ID</th>
            <th>User Name</th>
            <th>User Last Name</th>
            <th>Email</th>
             <th>Edit</th>
            <th>Delete</th>
   </tr>
  </thead>
  <tbody>
  						<c:forEach var="user" items="${listUsers}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.lname}" /></td>
							<td><c:out value="${user.email}" /></td>
							
							<td><a href="edit?email=<c:out value='${user.email}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <td><a
								href="delete?email=<c:out value='${user.email}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
  
 </tbody>
</table>
  </div>

</body>
</html>