package com.dataart.project.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArrangementRepositoryHibernateImpl implements
		ArrangementRepository {

	@Autowired
	protected SessionFactory sessionFactory;

	/* change to sessionFactory if using HSQL in memory DB */
	@Override
	@SuppressWarnings("unchecked")
	public List<Arrangement> getArrangements() {
		return currentSession().createQuery("FROM Arrangement a").list();
	}

	@Override
	public void createArrangement(Arrangement arrangement) {
		currentSession().save(arrangement);
	}

	@Override
	public void deleteArrangement(int id) {
		Arrangement arrangement = (Arrangement) sessionFactory
				.getCurrentSession().get(Arrangement.class, id);
		currentSession().delete(arrangement);
	}

	@Override
	public void updateArrangement(int id, String name, Date date) {
		Arrangement a = (Arrangement) currentSession().get(Arrangement.class,
				id);
		a.setName(name);
		a.setDate(date);
		currentSession().update(a);	
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
