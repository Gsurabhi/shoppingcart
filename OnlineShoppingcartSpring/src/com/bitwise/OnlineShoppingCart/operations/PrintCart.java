package com.bitwise.OnlineShoppingCart.operations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.bitwise.OnlineShoppingCart.model.Cart;
import com.bitwise.OnlineShoppingCart.model.ProductDetails;

public class PrintCart extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse res = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.getAttribute("cart");
		System.out.println("cart.getProductDetails() : " + request.getAttribute("cart"));
		Cart cart = (Cart) request.getAttribute("cart");
		PrintWriter out = res.getWriter();
		System.out.println(cart);
		out.println("<center>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td colspan=6 style='text-allign=center'><h3>Cart</h3></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Name</td>");
		out.println("<td>Price</td>");
		out.println("<td>Size</td>");
		out.println("<td>Color</td>");
		out.println("<td>Purchased Quantity </td>");

		out.println("</tr>");

		for (ProductDetails product : ((Cart) request.getAttribute("cart")).getCartItems()) {

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
			out.println(product.getQuantity());
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='/OnlineShoppingcartSpring/app/remove?pname=" + product.getName() + "'>Remove From Cart</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href=/OnlineShoppingcartSpring/app/product1>Add More</a>");
		out.println("<a href=/OnlineShoppingcartSpring/app/place>Place Order</a>");
		out.println("<center>");
		
	}
}
