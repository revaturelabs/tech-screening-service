package com.revature.caliber.screening.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.ScheduledStatus;
import com.revature.caliber.beans.SimpleScheduledScreening;
import com.revature.caliber.beans.SimpleTrainee;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.screening.data.ScheduledScreeningRepository;

@Service
public class ScheduledScreeningServiceImpl implements ScheduledScreeningService {

	@Autowired 
	private ScheduledScreeningRepository ssr;
	
	@Autowired
	private TrainingService ts;
	
	@Override
	public List<ScheduledScreening> findByStatus(String string) {
		List<SimpleScheduledScreening> simpleScheduledScreenings = ssr.findByStatus("PENDING");
		List<SimpleTrainee> simpleTrainees = ts.getAllTrainees();

		List<ScheduledScreening> scheduledScreenings=new ArrayList<>();
		
		for(SimpleScheduledScreening screening : simpleScheduledScreenings) {
			Integer traineeId = screening.getTrainee();
			for (SimpleTrainee trainee : simpleTrainees) {
				if (traineeId == trainee.getTraineeId()) {
					scheduledScreenings.add(new ScheduledScreening(
						new Trainee(trainee),
						0,
						ScheduledStatus.PENDING, 
						screening.getScheduledScreeningId(),
						screening.getSkillTypeId(),
						screening.getScheduledDate())
						);
				}
				
			}
		}
		
		return scheduledScreenings;
	}

	@Override
	public void updateStatus(String screened, Integer scheduledScreeningId) {
		ssr.updateStatus(screened, scheduledScreeningId);
	}

}
