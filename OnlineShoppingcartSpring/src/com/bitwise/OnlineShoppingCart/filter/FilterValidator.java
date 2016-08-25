package com.bitwise.OnlineShoppingCart.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterValidator
 */
@WebFilter("/FilterValidator")
public class FilterValidator implements Filter {

    /**
     * Default constructor. 
     */
    public FilterValidator() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpServletRequest reuest=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		if (reuest.getSession(false) != null && reuest.getSession(false).getAttribute("name") != null) {
			chain.doFilter(request, response);
		}
		else {
			//System.out.println("<font color = red> Login first !!!</font>");
			out.write("Login first !!!");
			resp.sendRedirect("/OnlineShoppingcartSpring/login");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
