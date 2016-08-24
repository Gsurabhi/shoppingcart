package com.bitwise.OnlineShoppingCart.operations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.bitwise.OnlineShoppingCart.model.ProductDetails;
import com.bitwise.OnlineShoppingCart.model.ProductList;

public class PrintProducts extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse res = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.getAttribute("productList");
		System.out.println("productList.getProductDetails() : " + request.getAttribute("productList"));
		ProductList productList = (ProductList) request.getAttribute("productList");
		for (ProductDetails tmpProductDetails : ((ProductList) request.getAttribute("productList"))
				.getProductDetails()) {
			System.out.println(tmpProductDetails);
		}
		PrintWriter out = res.getWriter();
		System.out.println("productList.getProductDetails() : " + productList.getProductDetails());
		for (ProductDetails tmpProductDetails : productList.getProductDetails()) {
			System.out.println(tmpProductDetails);
		}
		System.out.println("in print product   " + productList);
		System.out.println(productList);
		out.println("<center>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td colspan=6 style='text-allign=center'><h3>Products</h3></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Name</td>");
		out.println("<td>Price</td>");
		out.println("<td>Size</td>");
		out.println("<td>Color</td>");
		out.println("<td>Quantity</td>");

		out.println("</tr>");

		for (ProductDetails product : ((ProductList) request.getAttribute("productList")).getProductDetails()) {

			out.println("<tr>");
			out.println("<td>");
			out.println(product.getName());
			out.println("<td>");
			out.println("Rs " + product.getPrice());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getSize());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getColor());
			out.println("</td>");
			out.println("<td>");
			out.println(product.getStock());
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='/OnlineShoppingcartSpring/app/add?pname=" + product.getName() + "'>Add to Cart</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href=/OnlineShoppingcartSpring/app/viewcart>View Cart</a>");
		out.println("<center>");

	}

}