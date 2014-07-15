package com.dataart.project.repositories;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Represents person who reserves a ticket
 * 
 * @author lester
 *
 */
@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;
	@Column(nullable = false, length = 255)
	private String firstName;
	@Column(nullable = false, length = 255)
	private String lastName;
	@Column
	private Date reservationTime;
	@OneToMany(mappedBy = "customer")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public Customer() {
	}

	public Customer(String firstName, String lastName, Date reservationTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.reservationTime = reservationTime;
	}

	public Customer(int id, String firstName, String lastName,
			Date reservationTime) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reservationTime = reservationTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
