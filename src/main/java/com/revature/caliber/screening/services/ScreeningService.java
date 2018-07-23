package com.revature.caliber.screening.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;

@Service
public interface ScreeningService {
	Integer tempName(ScheduledScreening scheduledScreening);
}
