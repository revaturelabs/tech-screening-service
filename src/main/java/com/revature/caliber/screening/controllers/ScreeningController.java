package com.revature.caliber.screening.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Screening;
import com.revature.caliber.screening.services.ScreeningServiceImpl;


/**
 * The controller for incoming REST requests to the Screening service.
 * 
 * @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
 */
@RestController
@CrossOrigin
public class ScreeningController {
	
	@Autowired
	private ScreeningServiceImpl screeningService;
	
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(@RequestBody StartingWrapper screeningInfo){
		Screening i = screeningService.setPending(screeningInfo);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}
}
