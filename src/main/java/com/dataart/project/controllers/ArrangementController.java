package com.dataart.project.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.services.ArrangementService;

@Controller
public class ArrangementController {
	@Autowired
	protected ArrangementService service;

	@RequestMapping(value = { "/arrangements" })
	public String getArrangements(Model model) {
		List<Arrangement> arrangements = service.getArrangements();
		model.addAttribute("arrangements", arrangements);
		return "arrangements";
	}

	@RequestMapping(value = "create-book")
	public String createBookGet(Model model) {
		model.addAttribute("arrangement", new Arrangement());
		return "create-book";
	}

	@RequestMapping(value = "create-book", method = RequestMethod.POST)
	public String createBookPost(
			@ModelAttribute("arrangement") Arrangement arrangement) {
		service.createArrangement(arrangement);
		return "redirect:arrangements";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView getdata() {
		ModelAndView model = new ModelAndView("ticket");
		return model;
	}
}