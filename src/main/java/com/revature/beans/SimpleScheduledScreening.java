package com.revature.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "SCHEDULED_SCREENING")
@Entity
public class SimpleScheduledScreening {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULED_SCREENING_SEQUENCE")
	@SequenceGenerator(name = "SCHEDULED_SCREENING_SEQUENCE", sequenceName = "SCHEDULED_SCREENING_SEQUENCE")
	@Column(name = "SCHEDULED_SCREENING_ID")
	private Integer scheduledScreeningId;
	@Column(name = "TRAINEE")
	private Integer trainee;
	@Column(name = "TRAINER")
	private Integer trainer;
	@Column(name = "STATUS")
	private String status;
	@Column(name="SKILL_TYPE")
	private Integer skillTypeId;
	@Column(name = "SCHEDULED_DATE")
	private Date scheduledDate;
	

	public SimpleScheduledScreening() {
		super();
	}

	public SimpleScheduledScreening(Integer trainee, Integer trainer, String status, Integer skillTypeId,
			Date scheduledDate) {
		super();
		this.trainee = trainee;
		this.trainer = trainer;
		this.status = status;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}

	public SimpleScheduledScreening(Integer scheduledScreeningId, Integer trainee, Integer trainer, String status,
			Integer skillTypeId, Date scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.trainee = trainee;
		this.trainer = trainer;
		this.status = status;
		this.skillTypeId = skillTypeId;
		this.scheduledDate = scheduledDate;
	}

	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public Integer getTrainee() {
		return trainee;
	}

	public void setTrainee(Integer trainee) {
		this.trainee = trainee;
	}

	public Integer getTrainer() {
		return trainer;
	}

	public void setTrainer(Integer trainer) {
		this.trainer = trainer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getScheduledScreeningId() {
		return scheduledScreeningId;
	}

	public void setScheduledScreeningId(Integer scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
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
		result = prime * result + ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result + ((scheduledScreeningId == null) ? 0 : scheduledScreeningId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((trainee == null) ? 0 : trainee.hashCode());
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
		SimpleScheduledScreening other = (SimpleScheduledScreening) obj;
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
		if (status != other.status)
			return false;
		if (trainee == null) {
			if (other.trainee != null)
				return false;
		} else if (!trainee.equals(other.trainee))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleScheduledScreening [trainee=" + trainee + ", trainer=" + trainer + ", status=" + status
				+ ", scheduledScreeningId=" + scheduledScreeningId + ", scheduledDate=" + scheduledDate + "]";
	}

}
