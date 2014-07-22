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
public class SectorPOJOTest {
	TestUtilities utilities=TestUtilities.getInstance();
	
	@Test
	public void testHashCodeEquals() {
		 Map<Sector, String> m = new HashMap<Sector, String>();
		 m.put(new Sector("Name",10.36),"Jeff Smith");
		 assertEquals("Jeff Smith", m.get(new Sector("Name",10.36)));
	}
	
	@Test
	public void testHashCodeNotequals() {
		 Map<Sector, String> m = new HashMap<Sector, String>();
		 m.put(new Sector("Name",10.36),"Jeff Smith");
		 assertEquals(null, m.get(new Sector("Name1",10.36)));
	}
	
	@Test
	public void testEventsEqual() {
		Sector a=new Sector("A",100.25);
		a.setId(10);
		Sector b=new Sector("A", 100.25);
		b.setId(2);
		assertEquals(a, b);
	}
	
	@Test
	public void testEventsNotEqual_1() {
		Sector a=new Sector("A",100.25);
		Sector b=new Sector("B", 100.25);
		assertEquals(false, b.equals(a));
	}
	
	@Test
	public void testEventsNotEqual_2() {
		Sector a=new Sector("A",100.25);
		Sector b=new Sector("A", 10.20);
		assertEquals(false, b.equals(a));
	}
	
}
