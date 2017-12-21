<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<%
if(session != null && session.getAttribute("userId") != null){
	session.setAttribute("UserRegisteredErr", "User Already Registered");
	response.sendRedirect("welcome.jsp");
} %>
    <script>
    function check_pass(){
    if (document.getElementById('password').value==document.getElementById('confirmPassword').value){
        document.getElementById('message').innerHTML = " &#x2714;";
}
else {
    document.getElementById('message').innerHTML = " &#x274C";
}
    }
    </script>

<div style="color:red">${userExistErr}</div>
<form action="RegistrationPage" method="post">
<table>
<tr>
<th align="left">First Name
</th></tr>
<tr>
<td><input type ="text" name="fname"><div style="color:red">${firstNameErr}</div>
</td>
</tr>
<tr>
<th align="left">Last Name
</th></tr>
<tr>
<td><input type ="text" name="lname"><div style="color:red">${lastNameErr}</div>
</td>
</tr>
<tr>
<th align="left">EmailId
</th></tr>
<tr>
<td><input type ="text" name="emailId">
</td>
</tr>
<tr>
<th align="left">UserId
</th></tr>
<tr>
<td><input type ="text" name="userId"><div style="color:red">${userIdErr}</div>
</tr>
<tr>
<th align="left">Password
</th></tr>
<tr>
<td><input type ="password" id="password" name="password"><div style="color:red">${passErr}</div>
<br>
</td>
</tr>
<tr>
<th align="left">Confirm Password
</th></tr>
<tr>
<td><input type ="password" id ="confirmPassword" name="confirmPassword" onkeyup='check_pass();'><span id='message'></span><div style="color:red">${cnpassErr}</div>
<br>
</td>
</tr>
<tr><input type ="hidden" name="role" value="customer"></tr>
<tr>
<td align="right"><input type ="submit" value="Register">
</td>
</tr>
</table>
</form>
</body>
</html>