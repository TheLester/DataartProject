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
public class ArrangementService {

	@Autowired
	protected ArrangementRepository repository;
	@Autowired
	protected SectorService sectorService;

	/* get list of all arrangements */
	public List<Arrangement> getArrangements() {
		return repository.getArrangements();
	}

	/* create an arrangement */
	public void createArrangement(Arrangement arrangement) {
		repository.createArrangement(arrangement);		
	}

	/* delete an arrangement */
	public void deleteArrangement(Arrangement arrangement) {
		for(Sector sector: arrangement.getSectors()) {
			sectorService.deleteSector(sector);
		}
		repository.deleteArrangement(arrangement);
	}

	/* edit an arrangement */
	public void updateArrangement(Arrangement arrangement, String name, Date date) {
		repository.updateArrangement(arrangement, name, date);
	}
}
