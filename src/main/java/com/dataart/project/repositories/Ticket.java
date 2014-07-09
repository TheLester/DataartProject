package com.dataart.project.repositories;

import java.util.Set;

import javax.persistence.*;

enum TicketStatus {
	FREE, SOLD, RESERVED
};

/**
 * Represents ticket for one seat
 * 
 * @author lester
 *
 */
@Entity
@Table(name = "Tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int id;
	@Column(nullable = false)
	private int row;
	@Column(nullable = false)
	private int seat;
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	@ManyToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Ticket() {
	}

	public Ticket(int row, int seat, TicketStatus status) {
		super();
		this.row = row;
		this.seat = seat;
		this.status = status;
	}

	public Ticket(int id, int row, int seat, TicketStatus status) {
		super();
		this.id = id;
		this.row = row;
		this.seat = seat;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
