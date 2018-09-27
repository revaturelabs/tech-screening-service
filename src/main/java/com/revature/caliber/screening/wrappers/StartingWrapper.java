package com.revature.caliber.screening.wrappers;

import java.util.Date;

public class StartingWrapper {
	private int scheduledScreeningId;
	private Date beginTime;
	private int trainerId;
	private int skillTypeId;
	
	public int getScheduledScreeningId() {
		return scheduledScreeningId;
	}
	public void setScheduledScreeningId(int scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public int getSkillTypeId() {
		return skillTypeId;
	}
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	} 

}
