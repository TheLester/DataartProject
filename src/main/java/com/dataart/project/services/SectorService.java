package com.dataart.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	public void createSector(Sector sector) {
		repository.createSector(sector);
		
	}

	
	public void deleteSector(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateSector(int id, String name, double price) {
		// TODO Auto-generated method stub
		
	}

}
