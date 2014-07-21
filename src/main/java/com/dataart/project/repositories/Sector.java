package com.dataart.project.repositories;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Represents sector at stadium
 * 
 * @author lester
 *
 */
@Entity
@Table(name = "Sectors")
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sector_id")
	private int id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;
	@ManyToOne
 	@JoinColumn(name = "arrangement_id")
 	private Arrangement arrangement;
	@OneToMany(mappedBy = "sector")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public Sector() {
	}

	public Sector(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Sector(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Arrangement getArrangement() {
		return arrangement;
	}

	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		if (!(obj instanceof Sector))
			return false;
		if (obj == this)
			return true;
		return  this.name.equals(((Sector) obj).name)
				&& (Double.compare(this.price,((Sector) obj).price)==0);
	}

	public int hashCode() {
		int result = 0;
		result = (int) (name.length()+100+price);
		return result;
	}
}
