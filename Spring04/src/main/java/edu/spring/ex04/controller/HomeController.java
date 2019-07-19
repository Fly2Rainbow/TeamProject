package edu.spring.ex04.controller;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("home() 호출");
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test1(Model model) {
		logger.info("test1() 호출");
		model.addAttribute("page", 1);
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Locale locale, Model model) {
		logger.info("test2() 호출");
		model.addAttribute("locale", locale.toString());
		model.addAttribute("page", 2);
		
		return "test";
	}
	
} // end class HomeController
