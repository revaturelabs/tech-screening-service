package com.revature.caliber.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCREENING")
public class SimpleScreening {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREENING_SEQUENCE")
	@SequenceGenerator(name = "SCREENING_SEQUENCE", sequenceName = "SCREENING_SEQUENCE")
	@Column(name = "SCREENING_ID")
	private Integer screeningId;

	@Column(name = "TRAINER_ID")
	private Integer trainerId;

	@Column(name = "TRAINEE_ID")
	private Integer traineeId;

	@Column(name = "SKILL_TYPE_ID")
	private Integer skillTypeId;

	@Column(name = "COMPOSITE_SCORE")
	private Double compositeScore;

	@Column(name = "ABOUT_ME_COMMENTARY")
	private String aboutMeCommentary;

	@Column(name = "GENERAL_COMMENTARY")
	private String generalCommentary;

	@Column(name = "SOFT_SKILL_COMMENTARY")
	private String softSkillCommentary;

	@Column(name = "START_DATE_TIME")
	private Date startDateTime;

	@Column(name = "END_DATE_TIME")
	private Date endDateTime;

	@Column(name = "SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	@Column(name = "STATUS")
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SCHEDULED_SCREENING_ID")
	private SimpleScheduledScreening simpleScheduledScreening;

	public SimpleScreening() {
		super();
	}

	public SimpleScreening(Integer screeningId) {
		super();
		this.screeningId = screeningId;
	}

	public SimpleScreening(Integer trainerId, Integer traineeId, Integer skillTypeId, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.trainerId = trainerId;
		this.traineeId = traineeId;
		this.skillTypeId = skillTypeId;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}
	
	public SimpleScreening(Integer trainerId, Integer traineeId, Integer skillTypeId, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status, SimpleScheduledScreening simpleScheduledScreening) {
		super();
		this.trainerId = trainerId;
		this.traineeId = traineeId;
		this.skillTypeId = skillTypeId;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
		this.simpleScheduledScreening = simpleScheduledScreening;
	}

	public SimpleScreening(Integer screeningId, String aboutMeCommentary) {
		super();
		this.screeningId = screeningId;
		this.aboutMeCommentary = aboutMeCommentary;
	}

	// /screening/start
	public SimpleScreening(Integer trainerId, Integer traineeId, Integer skillTypeId, Date startDateTime) {
		super();
		this.trainerId = trainerId;
		this.traineeId = traineeId;
		this.skillTypeId = skillTypeId;
		this.startDateTime = startDateTime;
	}

	// /screening/end
	public SimpleScreening(Integer screeningId, Double compositeScore, String softSkillCommentary, Date endDateTime,
			Boolean softSkillsVerdict, String status) {
		super();
		this.screeningId = screeningId;
		this.compositeScore = compositeScore;
		this.softSkillCommentary = softSkillCommentary;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	public SimpleScheduledScreening getSimpleScheduledScreening() {
		return simpleScheduledScreening;
	}

	public void setSimpleScheduledScreening(SimpleScheduledScreening simpleScheduledScreening) {
		this.simpleScheduledScreening = simpleScheduledScreening;
	}
	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
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

	public Integer getScreeningId() {
		return screeningId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutMeCommentary == null) ? 0 : aboutMeCommentary.hashCode());
		result = prime * result + ((compositeScore == null) ? 0 : compositeScore.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((generalCommentary == null) ? 0 : generalCommentary.hashCode());
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
		result = prime * result + ((softSkillCommentary == null) ? 0 : softSkillCommentary.hashCode());
		result = prime * result + ((softSkillsVerdict == null) ? 0 : softSkillsVerdict.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((traineeId == null) ? 0 : traineeId.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleScreening other = (SimpleScreening) obj;
		if (aboutMeCommentary == null) {
			if (other.aboutMeCommentary != null)
				return false;
		} else if (!aboutMeCommentary.equals(other.aboutMeCommentary))
			return false;
		if (compositeScore == null) {
			if (other.compositeScore != null)
				return false;
		} else if (!compositeScore.equals(other.compositeScore))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (generalCommentary == null) {
			if (other.generalCommentary != null)
				return false;
		} else if (!generalCommentary.equals(other.generalCommentary))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (skillTypeId == null) {
			if (other.skillTypeId != null)
				return false;
		} else if (!skillTypeId.equals(other.skillTypeId))
			return false;
		if (softSkillCommentary == null) {
			if (other.softSkillCommentary != null)
				return false;
		} else if (!softSkillCommentary.equals(other.softSkillCommentary))
			return false;
		if (softSkillsVerdict == null) {
			if (other.softSkillsVerdict != null)
				return false;
		} else if (!softSkillsVerdict.equals(other.softSkillsVerdict))
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (traineeId == null) {
			if (other.traineeId != null)
				return false;
		} else if (!traineeId.equals(other.traineeId))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleScreening [screeningId=" + screeningId + ", trainerId=" + trainerId + ", traineeId=" + traineeId
				+ ", skillTypeId=" + skillTypeId + ", compositeScore=" + compositeScore + ", aboutMeCommentary="
				+ aboutMeCommentary + ", generalCommentary=" + generalCommentary + ", softSkillCommentary="
				+ softSkillCommentary + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", softSkillsVerdict=" + softSkillsVerdict + ", status=" + status + "]";
	}
	
	
}