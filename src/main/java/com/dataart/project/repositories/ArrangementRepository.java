package com.dataart.project.repositories;

import java.util.Date;
import java.util.List;

public interface ArrangementRepository {
	public List<Arrangement> getArrangements();

	public void createArrangement(Arrangement arrangement);

	public void deleteArrangement(int id);

	public void updateArrangement(int id, String name, Date date);
}
