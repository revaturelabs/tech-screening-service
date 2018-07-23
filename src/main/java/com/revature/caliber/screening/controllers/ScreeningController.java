package com.revature.caliber.screening.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.beans.SimpleScreening;
import com.revature.caliber.repositories.ScreeningRepository;
import com.revature.caliber.screening.services.ScreeningService;

@RestController
@CrossOrigin
public class ScreeningController {
	
	ScreeningService screeningService;
	
	ScreeningRepository screeningRepository;
	
	@Transactional
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(@RequestBody Screening simpleScreening){

		Screening screening = simpleScreening;
		screening.setStatus("Pending");
		Screening i = screeningRepository.save(screening);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}

}
