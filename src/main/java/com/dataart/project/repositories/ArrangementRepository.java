package com.dataart.project.repositories;

import java.util.Date;
import java.util.List;

public interface ArrangementRepository {
	public List<Arrangement> getArrangements();

	public void createArrangement(Arrangement arrangement);

	public void deleteArrangement(Arrangement arrangement);

	public void updateArrangement(Arrangement arrangement, String name, Date date);
}
