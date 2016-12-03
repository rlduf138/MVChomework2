package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller		// @Component +
public class HomeController {
	
	// http://localhost:8080/MVChomework2/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		
		return "home";	// view's logical name
	}
	
}
