package com.dataart.project.repositories;

import java.util.Date;

import javax.persistence.*;

/**
 * Defines a name and date of any arrangement (like match, concert etc)
 * 
 * @author dgoncharenko
 * 
 */

@Entity
@Table(name = "Arrangements")
public class Arrangement {	

	public Arrangement(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public Arrangement() {
		// TODO Auto-generated constructor stub
	}

	public Arrangement(String name2, Date date2) {
		this.date=date2;
		this.name=name2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 255)
	private String name;

	@Column
	private Date date;

	public void setId(int id) {
        this.id = id;
    }
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		System.out.println("-------------------------");
		System.out.println(date);
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
