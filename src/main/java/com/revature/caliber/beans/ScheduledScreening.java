package com.revature.caliber.beans;

import java.util.Date;

public class ScheduledScreening {
	private Candidate Candidate;
	private Integer trainer;
	private ScheduledStatus status;
	private Integer scheduledScreeningId;
	private Integer skillTypeId;
	private Date scheduledDate;
	public ScheduledScreening() {
		super();
	}

	public ScheduledScreening(Candidate Candidate, Integer trainer, ScheduledStatus status, Integer skillTypeId,
			Date scheduledDate) {
		super();
		this.Candidate = Candidate;
		this.trainer = trainer;
		this.status = status;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}


	public ScheduledScreening(Candidate Candidate, Integer trainer, ScheduledStatus status, Integer scheduledScreeningId,
			Integer skillTypeId, Date scheduledDate) {
		super();
		this.Candidate = Candidate;
		this.trainer = trainer;
		this.status = status;
		this.scheduledScreeningId = scheduledScreeningId;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}

	public Candidate getCandidate() {
		return Candidate;
	}

	public void setCandidate(Candidate Candidate) {
		this.Candidate = Candidate;
	}

	public Integer getTrainer() {
		return trainer;
	}

	public void setTrainer(Integer trainer) {
		this.trainer = trainer;
	}

	public ScheduledStatus getStatus() {
		return status;
	}

	public void setStatus(ScheduledStatus status) {
		this.status = status;
	}

	public Integer getScheduledScreeningId() {
		return scheduledScreeningId;
	}

	public void setScheduledScreeningId(Integer scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}

	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	@Override
	public String toString() {
		return "ScheduledScreening [Candidate=" + Candidate + ", trainer=" + trainer + ", status=" + status
				+ ", scheduledScreeningId=" + scheduledScreeningId + ", skillTypeId=" + skillTypeId + ", scheduledDate="
				+ scheduledDate + ", getCandidate()=" + getCandidate() + ", getTrainer()=" + getTrainer() + ", getStatus()="
				+ getStatus() + ", getScheduledScreeningId()=" + getScheduledScreeningId() + ", getSkillTypeId()="
				+ getSkillTypeId() + ", getScheduledDate()=" + getScheduledDate() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result + ((scheduledScreeningId == null) ? 0 : scheduledScreeningId.hashCode());
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((Candidate == null) ? 0 : Candidate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (scheduledScreeningId == null) {
			if (other.scheduledScreeningId != null)
				return false;
		} else if (!scheduledScreeningId.equals(other.scheduledScreeningId))
			return false;
		if (skillTypeId == null) {
			if (other.skillTypeId != null)
				return false;
		} else if (!skillTypeId.equals(other.skillTypeId))
			return false;
		if (status != other.status)
			return false;
		if (Candidate == null) {
			if (other.Candidate != null)
				return false;
		} else if (!Candidate.equals(other.Candidate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

}
