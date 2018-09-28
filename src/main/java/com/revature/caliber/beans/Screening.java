package com.revature.caliber.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Screening", description = "An object to represent the screening object")
@Entity
@Table(name = "SCREENING")
public class Screening {
	@ApiModelProperty(value = "Id of the screening")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREENING_SEQUENCE")
	@SequenceGenerator(allocationSize = 1, name = "SCREENING_SEQUENCE", sequenceName = "SCREENING_SEQUENCE")
	@Column(name = "id")
	private int screeningId;

	@ApiModelProperty(value = "The Scheduled Screening connected to the screening")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "SCHEDULED_SCREENING_ID")
	private ScheduledScreening scheduledScreening;

	@ApiModelProperty(value = "Id of the trainer from Salesforce")
	@Column(name = "TRAINER_ID")
	private int trainerId;

	@ApiModelProperty(value = "Id of the job path from the admin-screening-service")
	@Column(name = "SKILL_TYPE_ID")
	private int skillType;

	@ApiModelProperty(value = "The total score the candidate recieved")
	@Column(name = "COMPOSITE_SCORE")
	private Double compositeScore;

	@ApiModelProperty(value = "Comments regarding candidates introduction")
	@Column(name = "ABOUT_COMMENT")
	private String aboutMeCommentary;

	@ApiModelProperty(value = "General commentary regarding the candidates screening")
	@Column(name = "GENERAL_COMMENT")
	private String generalCommentary;

	@ApiModelProperty(value = "Commentary regarding candidates soft skills")
	@Column(name = "SOFT_SKILL_COMMENT")
	private String softSkillCommentary;

	@ApiModelProperty(value = "Starting date and time of the screening")
	@Column(name = "START_DATE")
	private Date startDateTime;

	@ApiModelProperty(value = "Ending date and time of the screening")
	@Column(name = "END_DATE")
	private Date endDateTime;

	@ApiModelProperty(value = "Final verdict on the candidates Soft Skills")
	@Column(name = "SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	@ApiModelProperty(value = "Enum denoting the current status of the screening")
	@Column(name = "STATUS")
	private String status;

	public Screening() {
	}

	public Screening(ScheduledScreening scheduledScreening, int trainerId, int skillType, Double compositeScore, String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime, Date endDateTime, Boolean softSkillsVerdict, String status) {
		this.scheduledScreening = scheduledScreening;
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
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public ScheduledScreening getScheduledScreening() {
		return scheduledScreening;
	}

	public void setScheduledScreening(ScheduledScreening scheduledScreening) {
		this.scheduledScreening = scheduledScreening;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Screening screening = (Screening) o;
		return getScreeningId() == screening.getScreeningId() &&
				getTrainerId() == screening.getTrainerId() &&
				getSkillType() == screening.getSkillType() &&
				Objects.equals(getScheduledScreening(), screening.getScheduledScreening()) &&
				Objects.equals(getCompositeScore(), screening.getCompositeScore()) &&
				Objects.equals(getAboutMeCommentary(), screening.getAboutMeCommentary()) &&
				Objects.equals(getGeneralCommentary(), screening.getGeneralCommentary()) &&
				Objects.equals(getSoftSkillCommentary(), screening.getSoftSkillCommentary()) &&
				Objects.equals(getStartDateTime(), screening.getStartDateTime()) &&
				Objects.equals(getEndDateTime(), screening.getEndDateTime()) &&
				Objects.equals(getSoftSkillsVerdict(), screening.getSoftSkillsVerdict()) &&
				getStatus() == screening.getStatus();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getScreeningId(), getScheduledScreening(), getTrainerId(), getSkillType(), getCompositeScore(), getAboutMeCommentary(), getGeneralCommentary(), getSoftSkillCommentary(), getStartDateTime(), getEndDateTime(), getSoftSkillsVerdict(), getStatus());
	}

	@Override
	public String toString() {
		return "Screening{" +
				"screeningId=" + screeningId +
				", scheduledScreening=" + scheduledScreening +
				", trainerId=" + trainerId +
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
