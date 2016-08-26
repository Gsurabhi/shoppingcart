<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="viewplaced" uri="/WEB-INF/CustomTags/placedOrder.tld" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Placed Order</title>

</head>
<body>
	<viewplaced:placed/><br>
	<h3>Grand Total</h3>
	
		<table>
			<tr>
				<td><h1><b>${grandTotal}</b></h1></td>
			</tr>
		</table>
		
	<br><br><a href=/OnlineShoppingcartSpring/app/viewcart1>View Cart</a>
	<br><br><a href=/OnlineShoppingcartSpring/app/logout>Logout</a>
	
</body>
</html>