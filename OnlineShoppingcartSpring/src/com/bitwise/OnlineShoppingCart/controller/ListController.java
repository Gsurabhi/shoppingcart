package com.bitwise.OnlineShoppingCart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.OnlineShoppingCart.exceptions.OutOfStockException;
import com.bitwise.OnlineShoppingCart.model.Cart;
import com.bitwise.OnlineShoppingCart.model.Login;
import com.bitwise.OnlineShoppingCart.model.ProductDetails;
import com.bitwise.OnlineShoppingCart.model.ProductList;

@Controller
public class ListController {
	@Autowired
	ProductList productList;
	@Autowired
	Cart cart;
	@Autowired
	ProductDetails pd;
	@Autowired
	Login login;

	@RequestMapping(value = "/app/list")
	public ModelAndView displayProducts (ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("title", "Products");
		model.addAttribute("homeActive", "active");
		StringBuilder sb = productsList(request);
		model.addAttribute("productList", sb.toString());
		return new ModelAndView("list", model);
	}
	
	private StringBuilder productsList(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder(100);
		String contextPath = request.getContextPath();
		for (ProductDetails prod: productList.getList()) {
			sb.append("<div class='col m4'>")
			.append("<div class='item-container'>")
			.append("<div class='item-header' >")
			.append("<a href='"+contextPath+"/app/single?pname="+ prod.getName() + "'> ")
			.append("<br/>" + prod.getName())
			.append("</a>")
			.append("</div>")
			.append("<div class='item-content' >")
//			.append("Product Color : " + prod.getColor() + "<br/>")
//			.append("Price: " + prod.getPrice() + "<br/>")
//			.append("Product Size: " + prod.getSize()+ "<br/>")
			.append("Available Stock: " + prod.getStock() + "<br/>")
			.append("<a href='"+contextPath+"/app/add?pname="+prod.getName()+"' >Add to Cart</a>")
			.append("</div>")
			.append("</div>")
			.append("</div>");
		}
		return sb;
	}

	@RequestMapping(value = "/app/product1")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		return new ModelAndView("products", "productList", productList);
	}
	
	
	@RequestMapping (value = "/app/single", method = RequestMethod.GET)
	public ModelAndView singleProduct (ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("pname") String pname) {
		//List<ProductDetails> products = this.productList.getList();
		ProductDetails product = this.productList.getProductByProductName(pname);
		
		model.addAttribute("prodName", product.getName());
		model.addAttribute("prodPrice", product.getPrice());
		model.addAttribute("prodSize", product.getSize());
		model.addAttribute("prodStock", product.getStock());
		model.addAttribute("prodColor", product.getColor());
		
		return new ModelAndView("single", model);
	}

	@RequestMapping(value = "/app/add" , method= RequestMethod.GET)
	public @ResponseBody String addItem(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String pname, HttpSession session) {
		int cartSize = cart.addItem(productList.getProductByProductName(pname));
		String res = ""+cartSize;
		return res;
		//return new ModelAndView("products", "productList", productList);
	}
	
	
	
		

		
		
	

	@RequestMapping(value = "/app/viewcart", method = RequestMethod.GET)
	public ModelAndView displayCart(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("in viewcart");
		for (ProductDetails tmpCart : cart.getCartItems()) {
			System.out.println(tmpCart);
		}
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/app/remove")
	public ModelAndView removeItem(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String pname, HttpSession session) {
		cart.removeItem(cart.getProductByProductName(pname));
		return new ModelAndView("viewcart", "cart", cart);
	}

	@RequestMapping(value = "/app/place")
	public ModelAndView placeOrder(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		model.addAttribute("grandTotal", cart.getCartValue());
		return new ModelAndView("vieworder", "cart", cart);
	}

	@RequestMapping(value = "/app/logout")
	public String logoutCart(ModelMap model, HttpServletRequest request, HttpServletResponse res, HttpSession session) {
		session.invalidate();

		return "redirect:/login";
	}

	@ExceptionHandler(OutOfStockException.class)
	public ModelAndView handleCustomException(OutOfStockException o) {

		return new ModelAndView("exception", "exceptionMsg", o.getMessage());

	}

}
