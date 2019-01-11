package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserRegister {

	/**
	 * User create an account with their id, name and pwd. 
	 * @return
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView register() {
		return new ModelAndView("Register"); // Register.html
	}

}
