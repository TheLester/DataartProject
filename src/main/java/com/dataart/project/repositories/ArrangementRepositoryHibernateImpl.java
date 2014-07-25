package com.dataart.project.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dataart.project.services.SectorService;

@Repository
@Transactional
public class ArrangementRepositoryHibernateImpl implements
		ArrangementRepository {

	@Autowired
	protected SessionFactory sessionFactory;
	@Autowired
	protected SectorRepository sectorRepository;
	
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
		for(Sector sector: arrangement.getSectors()) {
			sectorRepository.deleteSector(sector.getId());
		}
		currentSession().delete(arrangement);
	}

	@Override
	public void updateArrangement(int id, String name, Date date) {
		Arrangement arrangement = (Arrangement) sessionFactory
				.getCurrentSession().get(Arrangement.class, id);
		arrangement.setName(name);
		arrangement.setDate(date);
		currentSession().createSQLQuery("SET FOREIGN_KEY_CHECKS=0;");
		currentSession().update(arrangement);	
		currentSession().createSQLQuery("SET FOREIGN_KEY_CHECKS=1;");
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
