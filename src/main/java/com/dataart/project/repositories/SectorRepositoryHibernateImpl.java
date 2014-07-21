package com.dataart.project.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SectorRepositoryHibernateImpl implements SectorRepository {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Sector> getSectors() {
		return currentSession().createQuery("FROM Sector a").list();
	}

	@Override
	public void createSector(Sector sector) {
		currentSession().save(sector);
	}

	@Override
	public void deleteSector(int id) {
		Sector sector = (Sector) sessionFactory
				.getCurrentSession().get(Sector.class, id);
		currentSession().delete(sector);
	}

	@Override
	public void updateSector(Sector sector) {
		currentSession().update(sector);
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

}
