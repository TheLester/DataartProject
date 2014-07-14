package com.dataart.project.repositories;

import java.util.List;

public interface TicketRepository {
	public List<Ticket> getTickets();

	public void createTicket(Ticket ticket);

	public void deleteTicket(int id);

	public void updateTicket(Ticket ticket);
}
