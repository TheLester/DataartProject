package com.dataart.project.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArrangementRepository {

	@Autowired
	protected SessionFactory sessionFactory;

	/* change to sessionFactory if using HSQL in memory DB */

	@SuppressWarnings("unchecked")
	public List<Arrangement> getArrangements() {
		return currentSession().createQuery("FROM Arrangement a").list();
	}

	public void createArrangement(Arrangement arrangement) {
		currentSession().save(arrangement);
	}

	public void deleteArrangement(int id) {
		Arrangement arrangement = (Arrangement) sessionFactory
				.getCurrentSession().get(Arrangement.class, id);
		currentSession().delete(arrangement);
	}

	public void amendArrangement(int id, String name) {

	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
