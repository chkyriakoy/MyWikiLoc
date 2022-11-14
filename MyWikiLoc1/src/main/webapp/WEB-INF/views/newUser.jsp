<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyWikiLoc</title>

</head>
<body>
<H1> My WikiLoc App</H1>
<h2>New User</h2>

<form action="/register" method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="name" name="name" value="John" required><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" value="Doe" required><br><br>
  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" value="jDoe@myemail.com" required><br><br>
  <label for="passwd">Password:</label><br>
  <input type="password" id="passwd" name="passwd" required minlength="6" maxlength="10"><br><br>
  <input type="submit" value="Submit">
</form> 



</body>
</html>