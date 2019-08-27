package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Objects;

/** 
 * The Screening class, meant to represent the technical Screening of a Candidate.  It must be associated with a 
 * ScheduledScreening
 * 
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Screening", description = "An object to record the result of screening a candidate")
@Entity
@Table(name = "SCREENING")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Screening {
	
	/** The screening id. */
	@ApiModelProperty(value = "Id of the screening")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int screeningId;

	/** The Screening Scheduled to take place on @see startDateTime; these are either PENDING if it has not been completed or SCREENED if it has. */
	@ApiModelProperty(value = "The Screening Scheduled to take place; these are either PENDING if it has not been completed or SCREENED if it has.")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCHEDULED_SCREENING_ID")
	private ScheduledScreening scheduledScreening;

	/** Id of the person screening the candidate. */
	@ApiModelProperty(value = "Id of the person screening the candidate")
	@Column(name = "SCREENER_ID")
	private int screenerId;

	/** Id referencing a training track in the screening-admin-service. */
	@ApiModelProperty(value = "Id referencing a training track in the screening-admin-service")
	@Column(name = "SKILL_TYPE_ID")
	private int skillType;

	/** The total score the candidate recieved. */
	@ApiModelProperty(value = "The total score the candidate recieved")
	@Column(name = "COMPOSITE_SCORE")
	private Double compositeScore;

	/** Comments regarding candidate's introduction. */
	@ApiModelProperty(value = "Comments regarding candidate's introduction")
	@Column(name = "ABOUT_COMMENT")
	private String aboutMeCommentary;

	/** eneral commentary regarding the candidate's screening. */
	@ApiModelProperty(value = "General commentary regarding the candidate's screening")
	@Column(name = "GENERAL_COMMENT")
	private String generalCommentary;

	/** Commentary regarding candidate's soft skills. */
	@ApiModelProperty(value = "Commentary regarding candidate's soft skills")
	@Column(name = "SOFT_SKILL_COMMENT")
	private String softSkillCommentary;

	/** Starting date and time of the screening. */
	@ApiModelProperty(value = "Starting date and time of the screening")
	@Column(name = "START_DATE")
	private Date startDateTime;

	/** Ending date and time of the screening. */
	@ApiModelProperty(value = "Ending date and time of the screening")
	@Column(name = "END_DATE")
	private Date endDateTime;

	/** Final verdict on the candidate's soft skills. */
	@ApiModelProperty(value = "Final verdict on the candidate's soft skills")
	@Column(name = "SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	/** Enum denoting the current status of the screening. @see ScheduledStatus*/
	@ApiModelProperty(value = "Enum denoting the current status of the screening")
	@Column(name = "STATUS")
	private String status;

	/**
	 * Instantiates a new screening.
	 */
	public Screening() {
		super();
	}

	/**
	 * Instantiates a new screening.
	 *
	 * @param screeningId the screening id
	 * @param scheduledScreening the scheduled screening
	 * @param screenerId the screener id
	 * @param skillType the skill type
	 * @param compositeScore the composite score
	 * @param aboutMeCommentary the about me commentary
	 * @param generalCommentary the general commentary
	 * @param softSkillCommentary the soft skill commentary
	 * @param startDateTime the start date time
	 * @param endDateTime the end date time
	 * @param softSkillsVerdict the soft skills verdict
	 * @param status the status
	 */
	public Screening(int screeningId, ScheduledScreening scheduledScreening, int screenerId, int skillType,
			Double compositeScore, String aboutMeCommentary, String generalCommentary, String softSkillCommentary,
			Date startDateTime, Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.screeningId = screeningId;
		this.scheduledScreening = scheduledScreening;
		this.screenerId = screenerId;
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

	/**
	 * Gets the screening id.
	 *
	 * @return the screening id
	 */
	public int getScreeningId() {
		return screeningId;
	}

	/**
	 * Sets the screening id.
	 *
	 * @param screeningId the new screening id
	 */
	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	/**
	 * Gets the scheduled screening.
	 *
	 * @return the scheduled screening
	 */
	public ScheduledScreening getScheduledScreening() {
		return scheduledScreening;
	}

	/**
	 * Sets the scheduled screening.
	 *
	 * @param scheduledScreening the new scheduled screening
	 */
	public void setScheduledScreening(ScheduledScreening scheduledScreening) {
		this.scheduledScreening = scheduledScreening;
	}

	/**
	 * Gets the screener id.
	 *
	 * @return the screener id
	 */
	public int getScreenerId() {
		return screenerId;
	}

	/**
	 * Sets the screener id.
	 *
	 * @param screenerId the new screener id
	 */
	public void setScreenerId(int screenerId) {
		this.screenerId = screenerId;
	}

	/**
	 * Gets the skill type.
	 *
	 * @return the skill type
	 */
	public int getSkillType() {
		return skillType;
	}

	/**
	 * Sets the skill type.
	 *
	 * @param skillType the new skill type
	 */
	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}

	/**
	 * Gets the composite score.
	 *
	 * @return the composite score
	 */
	public Double getCompositeScore() {
		return compositeScore;
	}

	/**
	 * Sets the composite score.
	 *
	 * @param compositeScore the new composite score
	 */
	public void setCompositeScore(Double compositeScore) {
		this.compositeScore = compositeScore;
	}

	/**
	 * Gets the about me commentary.
	 *
	 * @return the about me commentary
	 */
	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	/**
	 * Sets the about me commentary.
	 *
	 * @param aboutMeCommentary the new about me commentary
	 */
	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	/**
	 * Gets the general commentary.
	 *
	 * @return the general commentary
	 */
	public String getGeneralCommentary() {
		return generalCommentary;
	}

	/**
	 * Sets the general commentary.
	 *
	 * @param generalCommentary the new general commentary
	 */
	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	/**
	 * Gets the soft skill commentary.
	 *
	 * @return the soft skill commentary
	 */
	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	/**
	 * Sets the soft skill commentary.
	 *
	 * @param softSkillCommentary the new soft skill commentary
	 */
	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	/**
	 * Gets the start date time.
	 *
	 * @return the start date time
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * Sets the start date time.
	 *
	 * @param startDateTime the new start date time
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * Gets the end date time.
	 *
	 * @return the end date time
	 */
	public Date getEndDateTime() {
		return endDateTime;
	}

	/**
	 * Sets the end date time.
	 *
	 * @param endDateTime the new end date time
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Gets the soft skills verdict.
	 *
	 * @return the soft skills verdict
	 */
	public Boolean getSoftSkillsVerdict() {
		return softSkillsVerdict;
	}

	/**
	 * Sets the soft skills verdict.
	 *
	 * @param softSkillsVerdict the new soft skills verdict
	 */
	public void setSoftSkillsVerdict(Boolean softSkillsVerdict) {
		this.softSkillsVerdict = softSkillsVerdict;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Screening screening = (Screening) o;
		return getScreeningId() == screening.getScreeningId() &&
				getScreenerId() == screening.getScreenerId() &&
				getSkillType() == screening.getSkillType() &&
				Objects.equals(getScheduledScreening(), screening.getScheduledScreening()) &&
				Objects.equals(getCompositeScore(), screening.getCompositeScore()) &&
				Objects.equals(getAboutMeCommentary(), screening.getAboutMeCommentary()) &&
				Objects.equals(getGeneralCommentary(), screening.getGeneralCommentary()) &&
				Objects.equals(getSoftSkillCommentary(), screening.getSoftSkillCommentary()) &&
				Objects.equals(getStartDateTime(), screening.getStartDateTime()) &&
				Objects.equals(getEndDateTime(), screening.getEndDateTime()) &&
				Objects.equals(getSoftSkillsVerdict(), screening.getSoftSkillsVerdict()) &&
				Objects.equals(getStatus(), screening.getStatus());
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getScreeningId(), getScheduledScreening(), getScreenerId(), getSkillType(), getCompositeScore(), getAboutMeCommentary(), getGeneralCommentary(), getSoftSkillCommentary(), getStartDateTime(), getEndDateTime(), getSoftSkillsVerdict(), getStatus());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Screening{" +
				"screeningId=" + screeningId +
				", scheduledScreening=" + scheduledScreening +
				", screenerId=" + screenerId +
				", skillType=" + skillType +
				", compositeScore=" + compositeScore +
				", aboutMeCommentary='" + aboutMeCommentary + '\'' +
				", generalCommentary='" + generalCommentary + '\'' +
				", softSkillCommentary='" + softSkillCommentary + '\'' +
				", startDateTime=" + startDateTime +
				", endDateTime=" + endDateTime +
				", softSkillsVerdict=" + softSkillsVerdict +
				", status=" + status +
				'}';
	}
}
