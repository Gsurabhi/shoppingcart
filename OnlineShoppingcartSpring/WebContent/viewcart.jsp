<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="viewcart" uri="/WEB-INF/CustomTags/cart.tld" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
</head>
<body>
<%-- <c:if test="${place==true}"> --%>
<viewcart:printCart/><br>
<%-- </c:if> --%>
<%-- <c:if test="${place==false}"> --%>

<%-- <h3>No products in your cart !!</h3></c:if> --%>
<!-- <a href=/OnlineShoppingcartSpring/app/list>View Products </a> -->
<br><br><a href=/OnlineShoppingcartSpring/app/logout>Logout</a>
</body>
</html>