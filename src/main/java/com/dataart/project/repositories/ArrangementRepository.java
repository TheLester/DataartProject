package com.dataart.project.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.project.services.ArrangementService;

@Repository
@Transactional
public class ArrangementRepository implements ArrangementService {

	@Autowired
	protected SessionFactory sessionFactory;

	/* change to sessionFactory if using HSQL in memory DB */

	@SuppressWarnings("unchecked")
	public List<Arrangement> getArrangements() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Arrangement a").list();
	}

	public void createArrangement(Arrangement arrangement) {
		sessionFactory.getCurrentSession().save(arrangement);
	}

	public void deleteArrangement(int id) {		
		Arrangement arrangement=(Arrangement) sessionFactory.getCurrentSession().get(Arrangement.class, id);
		sessionFactory.getCurrentSession().delete(arrangement);
	}

	public void amendArrangement(int id, String name) {
		// TODO Auto-generated method stub

	}

}
