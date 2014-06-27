package com.dataart.project.controllers;

import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.dataart.project.repositories.Arrangement;
import com.dataart.project.repositories.ArrangementRepository;

public class ArrangementRepositoryTest {

	@Autowired
	ArrangementRepository repository;
	
	@Test
	public void testcreateArrangement() {
        repository.createArrangement(new Arrangement(3, "match", new Date()));
       
    }
}
