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
@Table(name = "scheduled_screening")
public class ScheduledScreening {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCHEDULED_SCREENING_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SCHEDULED_SCREENING_SEQUENCE",sequenceName="SCHEDULED_SCREENING_SEQUENCE")
	@Column(name = "ID")
	private int scheduledScreeningId;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name = "trainer_id")
	private int trainer;
	
	@Column(name = "STATUS")
	private String scheduledStatus;
	
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;
	
	@Column(name = "SCHEDULED_DATE")
	private Date scheduledDate;
	
	public ScheduledScreening() {
		super();
	}

	public ScheduledScreening(int scheduledScreeningId, Candidate candidate, int trainer, String scheduledStatus,
			int skillTypeId, Date scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.candidate = candidate;
		this.trainer = trainer;
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

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public String getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(String scheduledStatus) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result + scheduledScreeningId;
		result = prime * result + ((scheduledStatus == null) ? 0 : scheduledStatus.hashCode());
		result = prime * result + skillTypeId;
		result = prime * result + trainer;
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
		ScheduledScreening other = (ScheduledScreening) obj;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (scheduledScreeningId != other.scheduledScreeningId)
			return false;
		if (scheduledStatus == null) {
			if (other.scheduledStatus != null)
				return false;
		} else if (!scheduledStatus.equals(other.scheduledStatus))
			return false;
		if (skillTypeId != other.skillTypeId)
			return false;
		if (trainer != other.trainer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScheduledScreening [scheduledScreeningId=" + scheduledScreeningId + ", candidate=" + candidate
				+ ", trainer=" + trainer + ", scheduledStatus=" + scheduledStatus + ", skillTypeId=" + skillTypeId
				+ ", scheduledDate=" + scheduledDate + "]";
	}


}
