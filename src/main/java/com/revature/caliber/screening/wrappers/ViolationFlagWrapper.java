package com.revature.caliber.screening.wrappers;

import java.util.Date;

/**
 * Wrapper class
 */
public class ViolationFlagWrapper {
	private Integer violationTypeId;
	private String softSkillComment;
	private Date violationTime;
	private Integer screeningId;
	
	public Integer getViolationTypeId() {
		return violationTypeId;
	}
	public void setViolationTypeId(Integer violationTypeId) {
		this.violationTypeId = violationTypeId;
	}
	public String getSoftSkillComment() {
		return softSkillComment;
	}
	public void setSoftSkillComment(String softSkillComment) {
		this.softSkillComment = softSkillComment;
	}
	public Date getViolationTime() {
		return violationTime;
	}
	public void setViolationTime(Date violationTime) {
		this.violationTime = violationTime;
	}
	public Integer getScreeningId() {
		return screeningId;
	}
	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}
	
}
