package com.dataart.project.services;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataart.project.repositories.Sector;
import com.dataart.project.repositories.Ticket;
import com.dataart.project.repositories.TicketRepository;
import com.dataart.project.repositories.TicketStatus;

public class TicketService {
	
	@Autowired
	protected TicketRepository repository;

	public void createTicket(Ticket ticket, Sector sector) {
		
	}
	
	public void deleteTicket(Ticket ticket) {
		
	}
	
	public void changeStatus(Ticket ticket, TicketStatus status) {
		ticket.setStatus(status);
		repository.
	}
}
