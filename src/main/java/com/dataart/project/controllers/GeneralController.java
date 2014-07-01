package com.dataart.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getdata() {
		ModelAndView model = new ModelAndView("ticket");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView handleRequest1(Model model) {
		model.addAttribute("partial", "home.jsp");
		model.addAttribute("title", "Template");
		return new ModelAndView("template");
	}

}
