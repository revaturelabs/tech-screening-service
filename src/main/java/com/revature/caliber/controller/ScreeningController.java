package com.revature.caliber.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.repositories.PathVariable;
import com.revature.caliber.repositories.RequestMapping;

@RestController
@CrossOrigin
public class ScreeningController {
	
	@RequestMapping(value = "/screening/pending/{simpleScheduledScreeningId}")
	public SimpleScreening pendingScreeningsByScreeningId(@PathVariable (value="simpleScheduledScreeningId") Integer simpleScheduledScreeningId){
		//return dataAccess.getSimpleSceeningById(Integer simpleScheduledSCreeningId);
		return null;
	}
}
