package com.revature.caliber.wrappers;

import java.util.Date;

/**
 * Wrapper class
 */
public class EndingWrapper {
	private String status;
	private boolean softSkillVerdict;
	private String softSkillCommentary;
	private Date endDateTime;
	private int screeningId;
	private int scheduledScreeningId;
	private double compositeScore;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSoftSkillVerdict() {
		return softSkillVerdict;
	}
	public void setSoftSkillVerdict(boolean softSkillVerdict) {
		this.softSkillVerdict = softSkillVerdict;
	}
	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}
	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public int getScreeningId() {
		return screeningId;
	}
	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}
	public int getScheduledScreeningId() {
		return scheduledScreeningId;
	}
	public void setScheduledScreeningId(int scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}
	public double getCompositeScore() {
		return compositeScore;
	}
	public void setCompositeScore(double compositeScore) {
		this.compositeScore = compositeScore;
	}
	
	
}
