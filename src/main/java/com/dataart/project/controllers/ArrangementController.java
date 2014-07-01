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
	public String createArrangementGet(Model model) {
		model.addAttribute("partial", "create-arrangement.jsp");
		model.addAttribute("title", "Template");
		return "template";
	}

	@RequestMapping(value = "create-arrangement", method = RequestMethod.POST)
	public String createArrangementPost(HttpServletRequest request) {
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String check = request.getParameter("NotNull");
		System.out.println("=============================================================================");
		System.out.println(name);
		System.out.println(date);
		System.out.println(time);
		System.out.println(check);
		System.out.println("=============================================================================");
		if (check.equals("true")) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		try {
			Date dateDate = format.parse(date + " " + time);
			Arrangement a = new Arrangement(name, dateDate);			
			service.createArrangement(a);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:arrangements";		
		}
		else
			return "redirect:create-arrangement";
	}

	@RequestMapping(value = { "/delete-arrangement" })
	public String deleteArrangementGet(Model model) {
		List<Arrangement> arrangements = service.getArrangements();
		model.addAttribute("partial", "delete-arrangement.jsp");
		model.addAttribute("title", "Template");
		model.addAttribute("arrangements", arrangements);
		return "template";
	}

	@RequestMapping(value = "/delete-arrangement", method = RequestMethod.POST)
	public String deleteArrangementPost(HttpServletRequest request) {
		String id = request.getParameter("selector");		
		service.deleteArrangement(Integer.parseInt(id));
		return "redirect:arrangements";
	}
}