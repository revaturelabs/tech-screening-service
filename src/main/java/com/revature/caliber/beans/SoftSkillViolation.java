package com.revature.caliber.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SOFT_SKILL_VIOLATION_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SOFT_SKILL_VIOLATION_SEQUENCE",sequenceName="SOFT_SKILL_VIOLATION_SEQUENCE")
	@Column(name="SOFT_SKILL_VIOLATION_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Screening screeningId;
	
	@Column(name="VIOLATION_TYPE_ID")
	private int violationId;
	
	@Column(name="SOFT_SKILL_VIOLATION_COMMENT")
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date Time;
	
	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(int id, Screening screeningId, int violationId, String comment, Date time) {
		super();
		this.id = id;
		this.screeningId = screeningId;
		this.violationId = violationId;
		this.comment = comment;
		Time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Time == null) ? 0 : Time.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
		result = prime * result + violationId;
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
		SoftSkillViolation other = (SoftSkillViolation) obj;
		if (Time == null) {
			if (other.Time != null)
				return false;
		} else if (!Time.equals(other.Time))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (violationId != other.violationId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SoftSkillViolation [id=" + id + ", screeningId=" + screeningId + ", violationId=" + violationId
				+ ", comment=" + comment + ", Time=" + Time + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Screening getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Screening screeningId) {
		this.screeningId = screeningId;
	}

	public int getViolationId() {
		return violationId;
	}

	public void setViolationId(int violationId) {
		this.violationId = violationId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}
	
	
	
}
