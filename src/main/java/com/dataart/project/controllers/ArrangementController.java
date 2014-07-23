package com.dataart.project.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.Sector;
import com.dataart.project.services.ArrangementService;
import com.dataart.project.services.SectorService;
import com.dataart.project.services.Utilities;

@Controller
public class ArrangementController {
	@Autowired
	protected ArrangementService arrangementService;
	@Autowired
	protected SectorService sectorService;
	
	@RequestMapping(value = { "/arrangements" })
	public String getArrangements(Model model) {
		List<Arrangement> arrangements = arrangementService.getArrangements();
		model.addAttribute("partial", "arrangements.jsp");
		model.addAttribute("title", "Events");
		model.addAttribute("arrangements", arrangements);
		return "template";
	}

	@RequestMapping(value = "create-arrangement")
	public String createArrangementGet(Model model) {
		model.addAttribute("partial", "create-arrangement.jsp");
		model.addAttribute("title", "Create Event");
		model.addAttribute("sectors", sectorService.getDefaultSectors());
		return "template";
	}

	@RequestMapping(value = "create-arrangement", method = RequestMethod.POST)
	public String createArrangementPost( HttpServletRequest request) {
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String check = request.getParameter("NotNull");
		Set<Sector> sectors=sectorService.getDefaultSectors();
		System.out
				.println("\n=============================================================================");
		System.out.println(name);
		System.out.println(date);
		System.out.println(sectors);
		System.out
				.println("=============================================================================");
		if (check.equals("true")) {
			Arrangement a = new Arrangement(name, Utilities.getDate(date, time));
			arrangementService.createArrangement(a);
			a.setSectors(sectors);
			sectorService.createSectors(sectors, a);
			return "redirect:arrangements";
		}
		return "redirect:create-arrangement";
	}

	@RequestMapping(value = { "/delete-arrangement" })
	public String deleteArrangementGet(Model model) {
		List<Arrangement> arrangements = arrangementService.getArrangements();
		model.addAttribute("partial", "delete-arrangement.jsp");
		model.addAttribute("title", "Delete Event");
		model.addAttribute("arrangements", arrangements);
		return "template";
	}

	@RequestMapping(value = "/delete-arrangement", method = RequestMethod.POST)
	public String deleteArrangementPost(HttpServletRequest request) {
		String check = request.getParameter("NotNull");
		if (check.equals("true")) {
			String id = request.getParameter("selector");
			arrangementService.deleteArrangement(Integer.parseInt(id)); // /!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			return "redirect:arrangements";
		}
		return "redirect:delete-arrangement";
	}

	@RequestMapping(value = { "/edit-arrangement" })
	public String editArrangementGet(Model model) {
		List<Arrangement> arrangements = arrangementService.getArrangements();
		model.addAttribute("partial", "edit-arrangement.jsp");
		model.addAttribute("title", "Edit Event");
		model.addAttribute("arrangements", arrangements);
		return "template";
	}

	@RequestMapping(value = "edit-arrangement", method = RequestMethod.POST)
	public String editArrangementPost(HttpServletRequest request) {
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String arrangement_ID = request.getParameter("arrangement_id");
		System.out
				.println("\n=============================================================================");
		System.out.println(name);
		System.out.println(date);
		System.out.println(time);
		System.out
				.println("=============================================================================");
		if (!arrangement_ID.equals("true")) {
			int arrangement_id = Integer.parseInt(request
					.getParameter("arrangement_id"));
			arrangementService.updateArrangement(arrangement_id, name,
					Utilities.getDate(date, time));
			return "redirect:arrangements";
		} else
			return "redirect:edit-arrangement";
	}

	/*	Example of updating dependencies 
	 * 
	 * Session session = getHibernateSessionFromSomewhere(); Car car = (Car)
	 * session.load(Car.class, "ford"); Tire tire = new Tire();
	 * car.addTire(tire); session.update(car);
	 */
}