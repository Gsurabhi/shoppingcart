
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page session="false"%>

<title>Login Page</title>
<h1>Login Form</h1>
<form:form method="post" action="login" commandName="login">
<br><font color=red>${error}</font><br>
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
			<td><font color="red"><form:errors path="name" /></font></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:input path="password" type="password" /></td>
			<td><font color="red"><form:errors path="password" /></font></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Login" /></td>
		</tr>
	</table>
		
</form:form>
