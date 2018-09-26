package com.revature.caliber.services;

import com.revature.caliber.beans.ScheduledScreening;
import com.revature.caliber.beans.Screening;
import com.revature.caliber.data.ScheduledScreeningRepository;
import com.revature.caliber.data.ScreeningRepository;
import com.revature.caliber.wrappers.EndingWrapper;
import com.revature.caliber.wrappers.StartingWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {
	@Autowired
	ScreeningRepository screeningRepository;

	@Autowired
	ScheduledScreeningRepository scheduledScreeningRepository;

	@Override
	public Screening setPending(StartingWrapper screeningInfo) {
		Screening screening = new Screening();
		ScheduledScreening scheduledScreening = scheduledScreeningRepository.findById(screeningInfo.getScheduledScreeningId()).orElse(null);
		screening.setScreeningId(0);
		screening.setScheduledScreening(scheduledScreening);
		screening.setStartDateTime(screeningInfo.getBeginTime());
		screening.setTrainerId(screeningInfo.getTrainerId());
		screening.setCandidate(scheduledScreening.getCandidate());
		screening.setSkillType(screeningInfo.getSkillTypeId());
		screening.setStatus("PENDING");
		return screeningRepository.save(screening);
	}

	@Override
	public Screening getScreening(int id) {
		return screeningRepository.findById(id).orElse(new Screening());
	}

	@Override
	public void updateAboutMeComment(String aboutMeComment, int screeningId) {
		Screening s = screeningRepository.findById(screeningId).orElse(null);
		if (s != null) {
			s.setAboutMeCommentary(aboutMeComment);
			screeningRepository.save(s);
		}
	}

	@Override
	public void updateGeneralComment(String generalComment, int screeningId) {
		Screening s = screeningRepository.findById(screeningId).orElse(null);
		if (s != null) {
			s.setGeneralCommentary(generalComment);
			screeningRepository.save(s);
		}
	}

	@Override
	public void endScreening(EndingWrapper screeningInfo) {
		Screening s = screeningRepository.findById(screeningInfo.getScreeningId()).orElse(null);
		if (s != null) {
			s.setStatus(screeningInfo.getStatus());
			s.setSoftSkillsVerdict(screeningInfo.isSoftSkillVerdict());
			s.setSoftSkillCommentary(screeningInfo.getSoftSkillCommentary());
			s.setEndDateTime(screeningInfo.getEndDateTime());
			screeningRepository.save(s);
		}
	}
}
