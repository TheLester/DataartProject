package com.dataart.project.repositories;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "arrangement_id")
	private int id;

	@Column(nullable = false, length = 255)
	private String name;

	@Column
	private Date date;
	@OneToMany(mappedBy = "arrangement")
	private Set<Sector> sectors = new HashSet<Sector>();

	public Arrangement(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public Arrangement() {
	}

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

	public Set<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}

	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		if (!(obj instanceof Arrangement))
			return false;
		if (obj == this)
			return true;
		return this.id == ((Arrangement) obj).id
				&& this.name.equals(((Arrangement) obj).name)
				&& this.date.equals(((Arrangement) obj).date);
	}

	public int hashCode() {
		int result = 0;
		result = (int) (name.length()+100+date.getDay()+date.getDate());
		return result;
	}

}
