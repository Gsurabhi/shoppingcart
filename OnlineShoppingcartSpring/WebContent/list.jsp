<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>Product List</h1>
<form:form method="post" action="/OnlineShoppingcartSpring/app/product1">

	<table>
		<tr>
			<td>Apples<br></td>
		</tr>
		<tr>
			<td>Oranges<br></td>
		</tr>
		<tr>
			<td>Plums<br></td>
		<tr>
			<td>Banana<br><br></td>
		</tr>
		 <tr>    
       		<td><input type="submit" value="ShowProductDetails" /></td>    
         </tr>  
	</table>
</form:form>



