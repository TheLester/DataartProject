package com.dataart.project.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// http://javabeginnerstutorial.com/spring-framework-tutorial/developing-a-spring-3-framework-mvc-application-step-by-step-tutorial/
	/* Bodybuilding food shopping */

	/* how to pass values to Controller from View */
	private static final Logger logger = Logger
			.getLogger(HelloController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {
		logger.debug("===========================");
		ModelAndView model = new ModelAndView("ticket");

		// log it via log4j
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}

		return model;

	}

	// http://www.commonj.com/blogs/2012/06/01/spring-mvc-3-tutorial-passing-request-parameters-to-controllers/
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getdata1(HttpServletRequest request) {
		logger.debug("===========================");

		ModelAndView model = new ModelAndView("default");
		String now = (new Date()).toString();
		model.addObject("now", now);

		logger.info("************************** "
				+ request.getAttributeNames().nextElement().toString());

		logger.info("Returning hello view with " + now);
		// log it via log4j
		if (logger.isDebugEnabled()) {
			logger.debug(model);
		}

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("ticket");
		return mav;
	}
}