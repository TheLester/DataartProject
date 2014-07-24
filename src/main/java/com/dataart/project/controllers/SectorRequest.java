package com.dataart.project.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.dataart.project.repositories.Sector;

public class SectorRequest {

	private ArrayList<Sector> allSectors = new ArrayList<Sector>();	
	
	public void setAllSectors(ArrayList<Sector> allSectors){
		this.allSectors=allSectors;
	}
	
	public ArrayList<Sector> getAllSectors() {
		return allSectors;
	}
}
