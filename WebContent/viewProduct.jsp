<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
<title>HomePage</title>
</head>

<body>
<!-- pritee's code -->


<div class="main_page">
<%-- 
<% out.print("<div>"+session.getAttribute("productList")+"</div>");
%> --%>

<jsp:include page="LoginRegisterDisplay.jsp"/>
 <% 

if(session.getAttribute("userId")!=null)
{%>
<c:forEach items="${viewProduct}" var="a" varStatus="status" >
<form action="ProductPageController" method="post">
<a href="ProductPageController?id=${a.id}">
<div class="product_preview_container">
<ul style="color:black">
<li><img class="product_image" src="imageViewer.jsp?imgID=${a.id}" height=75px width=75px/>
<li><c:out value="${a.name}(${a.size})"/></li>
<li style="font-weight:bold"><c:out value="$${a.price}"/></li>
</ul>
</div>
  

<input type="hidden" name="productId" value="${a.id}" /> 
 <input type ="submit" value="Add to cart" name="submit" />
</form>
 </c:forEach>
<%}
else {%>
<%}%>
</div>

<!-- End here -->

</body>
</html>


