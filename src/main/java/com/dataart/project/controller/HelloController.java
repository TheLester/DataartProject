package com.dataart.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// http://javabeginnerstutorial.com/spring-framework-tutorial/developing-a-spring-3-framework-mvc-application-step-by-step-tutorial/
	/* Bodybuilding food shopping */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {

		ModelAndView model = new ModelAndView("ticket");
	
		return model;

	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getdata1() {

		ModelAndView model = new ModelAndView("default");
	
		return model;

	}
}