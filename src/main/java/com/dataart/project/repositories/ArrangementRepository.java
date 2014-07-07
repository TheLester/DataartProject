package com.dataart.project.repositories;

import java.util.List;

public interface ArrangementRepository {
	List<Arrangement> getArrangements();

	void createArrangement(Arrangement arrangement);

	void deleteArrangement(int id);

	void amendArrangement(Arrangement arrangement);
}
