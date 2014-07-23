package com.dataart.project.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.services.ArrangementService;
import com.dataart.project.services.SectorService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;

import service.TestUtilities;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-servlet.xml" }, loader = ContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArrangementServiceTest {

	@Autowired
	ArrangementService arrangementService;
	@Autowired
	SectorService sectorService;
	@Autowired
	SessionFactory sessionFactory;
	TestUtilities utilities = TestUtilities.getInstance();

	@Test
	public void testcreateArrangement() {
		Arrangement a = new Arrangement("Match", utilities.getDate("1992",
				"05", "24"));
		arrangementService.createArrangement(a);
		/* Set sectors */
		for (int i = 0; i < 25; i++) {
			Sector sector = new Sector(String.valueOf(i), 100.0);
			a.addSector(sector);
			sectorService.createSector(sector, a);
		}
		List real = getArrangementsSql();
		List<Arrangement> list = new ArrayList<Arrangement>() {
			{
				add(new Arrangement("Match", utilities.getDate("1992", "05",
						"24")));
			}
		};
		assertEquals(1, real.size());
		assertEquals(list.toString(), real.toString());
	}

	@Test
	public void testDeleteArrangement() {
		Arrangement a = new Arrangement("Match", utilities.getDate("1992",
				"05", "24"));
		arrangementService.createArrangement(a);
		/* Set sectors */
		for (int i = 0; i < 25; i++) {
			Sector sector = new Sector(String.valueOf(i), 100.0);
			a.addSector(sector);
			sectorService.createSector(sector, a);
		}
		List real = getArrangementsSql();
		assertEquals(1, real.size());
		arrangementService.deleteArrangement(a.getId());
		real = getArrangementsSql();
		assertEquals(0, real.size());
	}

	@Test
	public void testEditArrangement() {
		Arrangement input = new Arrangement("Match", utilities.getDate("1992",
				"05", "24"));
		arrangementService.createArrangement(input);
		List real = getArrangementsSql();
		assertEquals(1, real.size());
		arrangementService.updateArrangement(input.getId(), "Mama",
				utilities.getDate("1992", "05", "24"));
		real = getArrangementsSql();
		Arrangement expected = new Arrangement("Mama", utilities.getDate(
				"1992", "05", "24"));
		assertEquals(1, real.size());
		assertEquals(expected, (Arrangement) real.get(0));
	}

	private List getArrangementsSql() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM Arrangements";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Arrangement.class);
			tx.commit();
			return query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
