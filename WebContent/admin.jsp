<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
<link rel="stylesheet" type="text/css" href="css/topbar.css" />
<link rel="stylesheet" type="text/css" href="css/searchbar.css" /> 
<jsp:include page="menu.jsp"/>
 <jsp:include page="footer.jsp"/>
</head>
<body>
<%
if(session.getAttribute("userId")!=null)
{%>
<form action="SigninController" method="get">
<h1 align="right" style="color:black;">Hi ${userName}
<input type ="submit"  value="Logout" name="signin" class="button">
</h1></form>
<%}
else {%>
<button onclick="document.getElementById('id01').style.display='block'" class="button" ><span>Login / Register</span></button>
<%}%>
<!-- <div id="id01" class="modal"/>
 --><form >
<table border="1px"  style = "color:black" cellspacing="0" width="75%" top="10%">
                                            
                                                <tr>
                                                    <th>User Id</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Email Id</th>
                                                    <th>Gender</th>
                                                    <th>Action</th>
                                                </tr>

                                            <c:forEach var="i" items="${userdata}">
                                                <tr>
                                                    <td><c:out value="${i.userId}"/></td>
                                                    <td><c:out value="${i.fname}" /></td>
                                                    <td><c:out value="${i.lname}" /></td>
                                                    <td><c:out value="${i.emailId}" /></td>
                                                    <td><c:out value="${i.gender}" /></td>
                                                    
                                          			<td><a href="<%=request.getContextPath() %>/SigninController?signin=Delete&id=${i.userId}">Delete</a></td>
                                           </tr>
                                                </c:forEach>
                                        </table>
                                        </form>
</body>
</html>