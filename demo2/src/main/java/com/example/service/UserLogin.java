package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Display login page. 
 * @author CSY
 *
 */
@RestController
public class UserLogin {

	/**
	 * User login with their name and pwd.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView register() {
		return new ModelAndView("Login"); // Login.html
	}

}
