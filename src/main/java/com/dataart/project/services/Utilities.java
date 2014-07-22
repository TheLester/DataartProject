package com.dataart.project.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	
	public static Date getDate(String date, String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dateDate = null;
		try {
			dateDate = format.parse(date + " " + time);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return dateDate;
	}	
	
}
