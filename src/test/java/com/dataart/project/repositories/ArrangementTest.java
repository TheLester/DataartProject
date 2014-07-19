package com.dataart.project.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-servlet.xml" }, loader = ContextLoader.class)
public class ArrangementTest {
	@Test
	public void testHashCodeEquals() {
		 Map<Arrangement, String> m = new HashMap<Arrangement, String>();
		    m.put(new Arrangement("Name",getDate("1992", "05", "01")),"Jeff Smith");
		    assertEquals("Jeff Smith", m.get(new Arrangement("Name",getDate("1992", "05", "01"))));
	}
	
	@Test
	public void testHashCodeNotequals() {
		 Map<Arrangement, String> m = new HashMap<Arrangement, String>();
		    m.put(new Arrangement("Name",getDate("1992", "05", "01")),"Jeff Smith");
		    assertEquals(null, m.get(new Arrangement("Name",getDate("1992", "05", "10"))));
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
