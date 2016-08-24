<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>

<body>
	<h1>Index Page</h1>
	<table>
		<tr>
			<td><font color=red>${alreadyloggedin }</font></td>
		</tr>
		<tr>
			<td><a href="login">Login</a><br></td>
		</tr>
		<tr>
			<td><a href="/OnlineShoppingcartSpring/app/list">Product List</a><br></td>
		</tr>

		<tr>
			<td><a href="/OnlineShoppingcartSpring/app/logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>