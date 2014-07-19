package com.dataart.project.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.dataart.project.repositories.Arrangement;
import com.dataart.project.services.ArrangementService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-servlet.xml" }, loader = ContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArrangementRepositoryTest {

	@Autowired
	ArrangementService repository;

	@Test
	public void testcreateArrangement() {
		repository.createArrangement(new Arrangement("Match", new
		Date()));
		List<Arrangement> real=repository.getArrangements();
		List<Arrangement> list = new ArrayList<Arrangement>() {{
		    add(new Arrangement("Match", new
		    		Date()));
		}};
		System.out.println(real.get(0).getId()+" "+real.get(0).getName().toString());
		assertEquals(list.toString(),real.toString());

	}
	
	/* Returns date from its string representation */
	private Date getDate(String year, String month, String day) {
		 GregorianCalendar newGregCal = new GregorianCalendar(
		     Integer.parseInt(year),
		     Integer.parseInt(month) - 1,
		     Integer.parseInt(day)
		 );
		return newGregCal.getTime();
	}
}
