package com.dataart.project.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.ArrangementRepository;
import com.dataart.project.repositories.Sector;
import com.dataart.project.repositories.SectorRepository;

@Service
public class SectorService {

	@Autowired
	protected SectorRepository repository;

	public List<Sector> getSectors() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createSector(Sector sector, Arrangement arrangement) {
		sector.setArrangement(arrangement);
		repository.createSector(sector);
	}

	public void deleteSector(Sector sector) {
		repository.deleteSector(sector.getId());
	}

	public void updateSector(Sector sector, String name, double price) {
		repository.updateSector(sector, name, price);
	}

	public Set<Sector> getDefaultSectors() {
		Set<Sector> sectors = new HashSet<Sector>();
		for (int i = 0; i < 10; i++) {
			sectors.add(new Sector(String.valueOf(i), 15.3));
		}
		return sectors;
	}
}
