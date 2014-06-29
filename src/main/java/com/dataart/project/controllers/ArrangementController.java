package com.dataart.project.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		model.addAttribute("partial", "arrangements.jsp");
		model.addAttribute("title", "Template");
		model.addAttribute("arrangements", arrangements);
		return "template";
	}

	@RequestMapping(value = "create-arrangement")
	public String createBookGet(Model model) {		
		model.addAttribute("partial", "create-arrangement.jsp");
		model.addAttribute("title", "Template");
		return "template";
	}

	@RequestMapping(value = "create-arrangement", method = RequestMethod.POST)
	public String createBookPost(HttpServletRequest request) {
		String time=request.getParameter("time");
		String date=request.getParameter("date");
		String name=request.getParameter("name");
		System.out.println("*****");
		 SimpleDateFormat format = 
		            new SimpleDateFormat("yyyy-mm-dd HH:mm");
		 try {
			Date dateDate = format.parse(date+" "+time);
			Arrangement a=new Arrangement(name, dateDate);
			System.out.println(a.getName());
			System.out.println(a.getDate());
			service.createArrangement(a);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:arrangements";
	}

	/*@RequestMapping(value = "create-arrangement", method = RequestMethod.POST)
	public String createBookPost(
			@ModelAttribute("arrangement") Arrangement arrangement) {
		service.createArrangement(arrangement);
		return "redirect:arrangements";
	}
	*/
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