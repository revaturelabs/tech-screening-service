package com.revature.caliber.screening.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.data.ScreeningRepository;

@RestController
@CrossOrigin
public class ScreeningController {
	
	ScreeningRepository screeningRepository;
	
	@Transactional
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(Screening screening){

		screening.setStatus("Pending");
		Screening i = screeningRepository.save(screening);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}
}
