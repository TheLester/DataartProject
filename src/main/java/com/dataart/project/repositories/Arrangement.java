package com.dataart.project.repositories;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines a name and date of any arrangement (like match, concert etc)
 * 
 * @author dgoncharenko
 * 
 */

@Entity
@Table(name = "Arrangments")
public class Arrangement {
	
	public Arrangement() {
		// TODO Auto-generated constructor stub
	}

	public Arrangement(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 255)
	private String name;

	@Column
	private Date date;

	public void setArrangementName(String name) {
		this.name = name;
	}

	public void setArrangementDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

}
