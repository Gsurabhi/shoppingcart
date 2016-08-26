<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>Product List</h1>

 Cart  : : ${ size }

${ productList }


<center>
<br>

<a class="btn green" href="/OnlineShoppingcartSpring/app/viewcart">View Cart</a>
<br><br><a href=/OnlineShoppingcartSpring/app/logout>Logout</a>
<br>

</center>
