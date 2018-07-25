package com.revature.caliber.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "SCREENING")

public class Screening {
	@Id
	@Column(name = "id")
	private Integer screeningId;

	@OneToOne
	@JoinColumn(name="id")
	private Candidate candidate;

	@Column(name = "TRAINER_ID")
	private Integer trainerId;

	@Column(name = "SKILL_TYPE_ID")
	private Integer skillType;

	@Column(name = "COMPOSITE_SCORE")
	private Double compositeScore;

	@Column(name = "ABOUT_COMMENT")
	private String aboutMeCommentary;

	@Column(name = "GENERAL_COMMENT")
	private String generalCommentary;
	
	@Column(name = "SOFT_SKILL_COMMENT")
	private String softSkillCommentary;

	@Column(name = "START_DATE")
	private Date startDateTime;
	
	@Column(name = "END_DATE")
	private Date endDateTime;
	
	@Column(name = "SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "SCHEDULED_SCREENING_ID")
	private Integer scheduledScreeningId;
	
	public Screening() {
		super();
	}

	public Screening(Candidate candidate,Integer trainerId, Integer skillType, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.candidate = candidate;
		this.skillType = skillType;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	public Integer getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getSkillType() {
		return skillType;
	}

	public void setSkillType(Integer skillType) {
		this.skillType = skillType;
	}

	public Double getCompositeScore() {
		return compositeScore;
	}

	public void setCompositeScore(Double compositeScore) {
		this.compositeScore = compositeScore;
	}

	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	public String getGeneralCommentary() {
		return generalCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getSoftSkillsVerdict() {
		return softSkillsVerdict;
	}

	public void setSoftSkillsVerdict(Boolean softSkillsVerdict) {
		this.softSkillsVerdict = softSkillsVerdict;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
