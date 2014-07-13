package com.dataart.project.repositories;

import java.util.Date;
import java.util.List;

public interface ArrangementRepository {
	List<Arrangement> getArrangements();

	void createArrangement(Arrangement arrangement);

	void deleteArrangement(int id);

	public void updateArrangement(int id, String name, Date date);
}
