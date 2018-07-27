package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.ScheduledScreening;

public interface ScheduledScreeningService {

	List<ScheduledScreening> findByStatus(String status);

	void updateStatus(int scheduledScreeningId) throws IllegalArgumentException;

}
