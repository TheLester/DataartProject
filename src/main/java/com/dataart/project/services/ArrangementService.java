package com.dataart.project.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.ArrangementRepository;
import com.dataart.project.repositories.Sector;

@Service
public class ArrangementService{

	@Autowired
	protected ArrangementRepository repository;
	
	@Autowired
	protected SectorService sector_service;

	/* get list of all arrangements */
	public List<Arrangement> getArrangements() {
		return repository.getArrangements();
	}

	/* create an arrangement */
	public void createArrangement(Arrangement arrangement) {		
		repository.createArrangement(arrangement);
		arrangement.setSectors(setSectors(arrangement));
	}

	public void deleteArrangement(int id) {
		repository.deleteArrangement(id);
	}

	public void updateArrangement(int id, String name, Date date) {
		repository.updateArrangement(id, name, date);
	}

	/* sets sectors for an event */
private Set<Sector> setSectors(Arrangement arrangement) {
		Set<Sector> sectors = new HashSet<Sector>();
		for (int i=0;i<25;i++) {
			Sector s=new Sector(String.valueOf(i),100.0);
			s.setArrangement(arrangement);
			sectors.add(s);
			sector_service.createSector(s);
		}
		return sectors;
	}
}
