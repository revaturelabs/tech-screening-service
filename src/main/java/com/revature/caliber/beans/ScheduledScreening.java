package com.revature.caliber.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@ApiModel(value = "Scheduled Screening", description = "A Scheduled Screening with information on the skills and timing.")
@Entity
@Table(name = "scheduled_screening")
public class ScheduledScreening {

	@ApiModelProperty(value = "Id of the screening")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHEDULED_SCREENING_ID")
	private int scheduledScreeningId;

	@ApiModelProperty(value = "Candidate that is being screened")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@ApiModelProperty(value = "Status of the screening")
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private ScheduledStatus scheduledStatus;

	@ApiModelProperty(value = "The skill type from admin service that the candidate is training in")
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;

	@ApiModelProperty(value = "The date of the screening")
	@Column(name = "SCHEDULED_DATE")
	private Date scheduledDate;

	public ScheduledScreening() {
		super();
	}

	public ScheduledScreening(int scheduledScreeningId, Candidate candidate, ScheduledStatus scheduledStatus,
							  int skillTypeId, Date scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.candidate = candidate;
		this.scheduledStatus = scheduledStatus;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}

	public int getScheduledScreeningId() {
		return scheduledScreeningId;
	}

	public void setScheduledScreeningId(int scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public ScheduledStatus getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(ScheduledStatus scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ScheduledScreening that = (ScheduledScreening) o;
		return getScheduledScreeningId() == that.getScheduledScreeningId() &&
				getSkillTypeId() == that.getSkillTypeId() &&
				Objects.equals(getCandidate(), that.getCandidate()) &&
				Objects.equals(getScheduledStatus(), that.getScheduledStatus()) &&
				Objects.equals(getScheduledDate(), that.getScheduledDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getScheduledScreeningId(), getCandidate(), getScheduledStatus(), getSkillTypeId(), getScheduledDate());
	}

	@Override
	public String toString() {
		return "ScheduledScreening{" +
				"scheduledScreeningId=" + scheduledScreeningId +
				", candidate=" + candidate +
				", scheduledStatus='" + scheduledStatus + '\'' +
				", skillTypeId=" + skillTypeId +
				", scheduledDate=" + scheduledDate +
				'}';
	}
}
