<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyWikiLoc</title>

</head>
<body>
<H1> My WikiLoc App</H1>
<h2>Edit User</h2>

 <form:form action="/save" method="post" modelAttribute="user">
            <form:label path="name">Full name:</form:label>
            <form:input path="name"/><br/>
             <form:label path="lname">Last name:</form:label>
            <form:input path="lname"/><br/>
             <form:label path="email">Email:</form:label>
            <form:input path="email"/><br/>
             <form:label path="passwd">Password:</form:label>
            <form:input path="passwd"/><br/>
            
 <form:button>Submit</form:button>
        </form:form>



</body>
</html>