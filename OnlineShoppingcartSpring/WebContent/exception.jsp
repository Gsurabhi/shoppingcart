<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Exception/Error</title>
</head>
<body>
	<h2><b><font color=red>Product Not Available</font></b></h2>
	<br><c:out value="${exceptionMsg}"></c:out><br><br>
	<a href="<c:url value="/app/product1"/>">ViewProduct</a>
</body>
</html>