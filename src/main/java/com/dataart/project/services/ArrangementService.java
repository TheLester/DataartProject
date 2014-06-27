package com.dataart.project.services;

import java.util.List;

import com.dataart.project.repositories.Arrangement;

public interface ArrangementService {
	/* get list of all arrangements */
	List<Arrangement> getArrangements();

	/* create an arrangement */
	void createArrangement(Arrangement arrangement);

	/* delete an arrangement */
	void deleteArrangement(int id);
	
	/* change an arrangement */
	void amendArrangement(int id, String name);

}
