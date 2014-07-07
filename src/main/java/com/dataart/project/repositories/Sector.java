package com.dataart.project.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;

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

}
