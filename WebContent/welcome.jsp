<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
if(session == null || session.getAttribute("userId") == null){
	session.setAttribute("UserLogInErr", "User Not Logged In");
	response.sendRedirect("index.jsp");
} %>
<div style="color:blue; background-color:pink;">${UserRegisteredErr}</div>

<form action="Signin" method="get">
<h1 align="left">Welcome - ${userName}
<input type ="submit"  value="Logout" name="signin" style="position:absolute ; right: 0; ">
</h1></form>

</body>
</html>