package com.revature.caliber.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.repositories.PathVariable;
import com.revature.caliber.repositories.RequestMapping;
import com.revature.caliber.repositories.ScreeningRepository;
import com.revature.caliber.services.ScreeningService;

@RestController
@CrossOrigin
public class ScreeningController {
	
	ScreeningService screeningService;
	
	@RequestMapping(value = "/screening/pending/{simpleScheduledScreeningId}")
	public SimpleScreening pendingScreeningsByScreeningId(@PathVariable (value="simpleScheduledScreeningId") Integer simpleScheduledScreeningId){
		return screeningService.screeningByScreeningId(simpleScheduledScreeningId);
	}
}
