package com.bitwise.OnlineShoppingCart.controller;

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
	public String init(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws RuntimeException {
		System.out.println("Controller");
		return "list";
	}

	@RequestMapping(value = "/app/product1")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		return new ModelAndView("products", "productList", productList);
	}

	@RequestMapping(value = "/app/add")
	public ModelAndView addItem(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String pname, HttpSession session) {
		cart.addItem(productList.getProductByProductName(pname));
		return new ModelAndView("products", "productList", productList);
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
