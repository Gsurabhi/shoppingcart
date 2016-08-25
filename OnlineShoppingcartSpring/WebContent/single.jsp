<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add </title>
<div class="row">
		<div class="col m2"></div>
		<div class="col m8">
			<div class="product-container">
				<div class="product-container__header">
				${ prodName }
				</div>
				<div class="product-container__body">
				<label>Product Price: </label>${ prodPrice }<br/>
				<label>Product Size: </label>${ prodSize }<br/>
				<label>Product Stock: </label>${ prodStock }<br/>
				<label>Product Color: </label>${ prodColor }<br/>
				<a class="btn green" href="/OnlineShoppingcartSpring/app/list">Back</a>
				</div>
			</div>
		</div>
		<div class="col m2"></div>
	</div>
