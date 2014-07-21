package com.dataart.project.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.TestUtilities;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-servlet.xml" }, loader = ContextLoader.class)
public class ArrangementTest {
	TestUtilities utilities=TestUtilities.getInstance();
	
	@Test
	public void testHashCodeEquals() {
		 Map<Arrangement, String> m = new HashMap<Arrangement, String>();
		 m.put(new Arrangement("Name",utilities.getDate("1992", "05", "01")),"Jeff Smith");
		 assertEquals("Jeff Smith", m.get(new Arrangement("Name",utilities.getDate("1992", "05", "01"))));
	}
	
	@Test
	public void testHashCodeNotequals() {
		 Map<Arrangement, String> m = new HashMap<Arrangement, String>();
		 m.put(new Arrangement("Name",utilities.getDate("1992", "05", "01")),"Jeff Smith");
		 assertEquals(null, m.get(new Arrangement("Name",utilities.getDate("1992", "05", "10"))));
	}
	
	@Test
	public void testEventsEqual() {
		Arrangement a=new Arrangement("A", "2014-05-12","03:45");
		a.setId(10);
		Arrangement b=new Arrangement("A", "2014-05-12","03:45");
		b.setId(2);
		assertEquals(a, b);
	}
	
	@Test
	public void testEventsNotEqual_1() {
		Arrangement a=new Arrangement("A", "2014-05-12","03:45");
		Arrangement b=new Arrangement("B", "2014-05-12","03:45");
		assertEquals(false, b.equals(a));
	}
	
	@Test
	public void testEventsNotEqual_2() {
		Arrangement a=new Arrangement("A", "2014-05-12","03:45");
		Arrangement b=new Arrangement("A", "2009-05-11","03:45");
		assertEquals(false, b.equals(a));
	}
	
	@Test
	public void testEventsNotEqual_3() {
		Arrangement a=new Arrangement("A", "2014-05-12","03:45");
		Arrangement b=new Arrangement("A", "2014-05-12","10:45");
		assertEquals(false, b.equals(a));
	}
}
