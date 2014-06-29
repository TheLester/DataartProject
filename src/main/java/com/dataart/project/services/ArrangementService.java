package com.dataart.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.ArrangementRepository;

@Service
public class ArrangementService {

	@Autowired 
	protected ArrangementRepository repository;
	
	/* get list of all arrangements */
	public List<Arrangement> getArrangements() {
		return repository.getArrangements();
	}

	/* create an arrangement */
	public void createArrangement(Arrangement arrangement) {
		 repository.createArrangement(arrangement);
	}
	
	public void deleteArrangement(int id) {
		 repository.deleteArrangement(id);
	}

}
