package com.dataart.project.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.dataart.project.repositories.Arrangement;
import com.dataart.project.services.ArrangementService;

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
public class ArrangementRepositoryTest {

	@Autowired
	ArrangementService repository;
	@Autowired
	SessionFactory sessionFactory;
	TestUtilities utilities=TestUtilities.getInstance();

	@Test
	@Transactional
	public void testcreateArrangement() {
		repository.createArrangement(new Arrangement("Match", utilities.getDate("1992", "05", "24")));
		List real = getArrangementsSql();
		List<Arrangement> list = new ArrayList<Arrangement>() {
			{
				add(new Arrangement("Match", utilities.getDate("1992", "05", "24")));
			}
		};
		assertEquals(list.toString(), real.toString());
	}

	@Ignore
	@Transactional
	public void testDeleteArrangement() {
		repository.createArrangement(new Arrangement("Match", new Date()));
		String sql = "SELECT * FROM Arrangements";
		SQLQuery query = currentSession().createSQLQuery(sql);
		query.addEntity(Arrangement.class);
		List results = query.list();
		
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private List getArrangementsSql() {
		String sql = "SELECT * FROM Arrangements";
		SQLQuery query = currentSession().createSQLQuery(sql);
		query.addEntity(Arrangement.class);
		return query.list();
	}
}
