package com.dataart.project.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketRepositoryHibernateImpl implements TicketRepository {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getTickets() {
		return currentSession().createQuery("FROM Ticket a").list();
	}

	@Override
	public void createTicket(Ticket ticket) {
		currentSession().save(ticket);
	}

	@Override
	public void deleteTicket(int id) {
		Ticket ticket = (Ticket) sessionFactory.getCurrentSession().get(
				Ticket.class, id);
		currentSession().delete(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		currentSession().update(ticket);
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
