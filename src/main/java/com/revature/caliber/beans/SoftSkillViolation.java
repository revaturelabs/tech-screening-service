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
	@Column(name="ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Screening screening;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VIOLATION_TYPE_ID")
	private ViolationType violation;
	
	@Column(name="COMMENT")
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;
	
	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(int id, Screening screening, ViolationType violation, String comment, Date time) {
		super();
		this.id = id;
		this.screening = screening;
		this.violation = violation;
		this.comment = comment;
		this.time = time;
	}

	public SoftSkillViolation(Screening screening, ViolationType violation, String comment, Date time) {
		super();
		this.screening = screening;
		this.violation = violation;
		this.comment = comment;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public ViolationType getViolation() {
		return violation;
	}

	public void setViolation(ViolationType violation) {
		this.violation = violation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((screening == null) ? 0 : screening.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((violation == null) ? 0 : violation.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (screening == null) {
			if (other.screening != null)
				return false;
		} else if (!screening.equals(other.screening))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (violation == null) {
			if (other.violation != null)
				return false;
		} else if (!violation.equals(other.violation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SoftSkillViolation [id=" + id + ", screening=" + screening + ", violation=" + violation + ", comment="
				+ comment + ", time=" + time + "]";
	}
}
