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
public class Screening {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCREENING_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SCREENING_SEQUENCE",sequenceName="SCREENING_SEQUENCE")
	@Column(name = "id")
	private int screeningId;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

	@Column(name = "TRAINER_ID")
	private int trainerId;

	@Column(name = "SKILL_TYPE_ID")
	private int skillType;

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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="scheduled_screening_id")
	private ScheduledScreening scheduledScreening;
	
	public Screening() {
		super();
	}

	public Screening(int screeningId, Candidate candidate, int trainerId, int skillType, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status, ScheduledScreening scheduledScreening) {
		super();
		this.screeningId = screeningId;
		this.candidate = candidate;
		this.trainerId = trainerId;
		this.skillType = skillType;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
		this.scheduledScreening = scheduledScreening;
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getSkillType() {
		return skillType;
	}

	public void setSkillType(int skillType) {
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

	public ScheduledScreening getScheduledScreening() {
		return scheduledScreening;
	}

	public void setScheduledScreening(ScheduledScreening scheduledScreening) {
		this.scheduledScreening = scheduledScreening;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutMeCommentary == null) ? 0 : aboutMeCommentary.hashCode());
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + ((compositeScore == null) ? 0 : compositeScore.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((generalCommentary == null) ? 0 : generalCommentary.hashCode());
		result = prime * result + ((scheduledScreening == null) ? 0 : scheduledScreening.hashCode());
		result = prime * result + screeningId;
		result = prime * result + skillType;
		result = prime * result + ((softSkillCommentary == null) ? 0 : softSkillCommentary.hashCode());
		result = prime * result + ((softSkillsVerdict == null) ? 0 : softSkillsVerdict.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + trainerId;
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
		Screening other = (Screening) obj;
		if (aboutMeCommentary == null) {
			if (other.aboutMeCommentary != null)
				return false;
		} else if (!aboutMeCommentary.equals(other.aboutMeCommentary))
			return false;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
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
		if (scheduledScreening == null) {
			if (other.scheduledScreening != null)
				return false;
		} else if (!scheduledScreening.equals(other.scheduledScreening))
			return false;
		if (screeningId != other.screeningId)
			return false;
		if (skillType != other.skillType)
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
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Screening [screeningId=" + screeningId + ", candidate=" + candidate + ", trainerId=" + trainerId
				+ ", skillType=" + skillType + ", compositeScore=" + compositeScore + ", aboutMeCommentary="
				+ aboutMeCommentary + ", generalCommentary=" + generalCommentary + ", softSkillCommentary="
				+ softSkillCommentary + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", softSkillsVerdict=" + softSkillsVerdict + ", status=" + status + ", scheduledScreening="
				+ scheduledScreening + "]";
	}

}
