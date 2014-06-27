package com.dataart.project.repositories;

import java.util.List;

public interface ArrangementService {
	/* get list of all arrangements */
	List<Book> getArrangements();

	/* create an arrangement */
	void createArrangement(Arrangement arrangement);

	/* delete an arrangement */
	void deleteArrangement(int id);
	
	/* change an arrangement */
	void amendArrangement(int id, String name);

}
