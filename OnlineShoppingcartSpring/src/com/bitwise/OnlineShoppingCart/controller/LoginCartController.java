package com.bitwise.OnlineShoppingCart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.OnlineShoppingCart.model.Login;
import com.bitwise.OnlineShoppingCart.validator.LoginValidator;

@Controller
// @RequestMapping(value = "/login")
public class LoginCartController {
	@Autowired
	Login login;
	@Autowired
	LoginValidator loginValidator;

	@RequestMapping(value = {"/", "/login" }, method = RequestMethod.GET)
	public String init(Model model, @ModelAttribute("login") Login login, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Controller");

		if (request.getSession(false) != null && request.getSession(false).getAttribute("name") != null) {
			System.out.println("session is valid");
			if (request.getRequestURI().equals(request.getContextPath() + "/login")) {
				System.out.println("Inside inner block");
				model.addAttribute("alreadyloggedin","Already Logged in");
				return "index";
			}
			
		}
		model.addAttribute("alreadyloggedin","Successfully Logged in");
		return "/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("login") Login login, BindingResult result, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String name = login.getName();
		String password = login.getPassword();
		String url = "";

		loginValidator.validate(login, result);

		if (!result.hasErrors()) {
			if (request.getSession(false) != null && request.getRequestURI().equals("login"))
				url = "index";
			if (name.equals("surabhi") && password.equals("Asdf@123")) {
				model.addAttribute("login", login);
				url = "redirect:/app/list";
				session = request.getSession(true);

				session.setAttribute("name", name);
				session.setAttribute("sessID", session.getId());
				session.setMaxInactiveInterval(1000);
			} else {
				model.addAttribute("error", "Invalid User !!!! Please Enter Correct Username Or Password");
				url = "login";
			}
		} else
			url = "login";
		return url;
	}
}
