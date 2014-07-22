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
public class SectorServiceTest {

	@Autowired
	SectorService sectorService;
	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void testcreateSector() {
		Sector sector = new Sector("Sector A", 1452.36);
		sectorService.createSector(sector, null);
		List real = getSectorsSql();
		List<Sector> list = new ArrayList<Sector>() {
			{
				add(new Sector("Sector A", 1452.36));
			}
		};
		assertEquals(1, real.size());
		assertEquals(list.toString(), real.toString());
	}

	@Test
	public void testDeleteSector() {
		Sector sector = new Sector("Sector A", 1452.36);
		sectorService.createSector(sector, null);
		List real = getSectorsSql();
		assertEquals(1, real.size());
		sectorService.deleteSector(sector);
		real = getSectorsSql();
		assertEquals(0, real.size());
	}

	@Test
	public void testEditSector() {
		Sector sector = new Sector("Sector A", 1452.36);
		sectorService.createSector(sector, null);
		List real = getSectorsSql();
		assertEquals(1, real.size());
		sectorService.updateSector(sector, "Sector B", 12.35);
		real = getSectorsSql();
		Sector expected = new Sector("Sector B", 12.35);
		assertEquals(1, real.size());
		assertEquals(expected, (Sector) real.get(0));
	}

	private List getSectorsSql() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM Sectors";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Sector.class);
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
