package com.dataart.project.repositories;

import javax.persistence.*;

import org.hibernate.annotations.Check;

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
	private int id;
	@Column(nullable = false)
	private int row;
	@Column(nullable = false)
	private int seat;
	@Enumerated(EnumType.STRING)
	private TicketStatus status;

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

}
