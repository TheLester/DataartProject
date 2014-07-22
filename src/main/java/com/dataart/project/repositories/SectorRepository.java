package com.dataart.project.repositories;

import java.util.List;

public interface SectorRepository {
	public List<Sector> getSectors();

	public void createSector(Sector sector);

	public void deleteSector(int id);

	public void updateSector(Sector sector, String name, double price);
}
