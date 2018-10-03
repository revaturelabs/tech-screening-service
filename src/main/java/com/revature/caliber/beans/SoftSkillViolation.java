package com.revature.caliber.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Soft Skills Violation", description = "Any violations that happen during the scourse of a screening")
@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {

	@ApiModelProperty(value = "Id of the violation")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SOFT_SKILL_VIOLATION_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SOFT_SKILL_VIOLATION_SEQUENCE",sequenceName="SOFT_SKILL_VIOLATION_SEQUENCE")
	@Column(name = "SOFT_SKILL_VIOLATION_ID")
	private int softViolationId;

	@ApiModelProperty(value = "Id of the Screening the violation occurred in")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private int screening;

	@ApiModelProperty(value = "Id of the ViolationType that occurred in the screening")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VIOLATION_TYPE_ID")
	private int violation;

	@ApiModelProperty(value = "Any comments regarding the violation")
	@Column(name="COMMENT")
	private String comment;

	@ApiModelProperty(value = "Time of the violation")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;

	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(int softViolationId, int screening, int violation, String comment, Date time) {
		super();
		this.softViolationId = softViolationId;
		this.screening = screening;
		this.violation = violation;
		this.comment = comment;
		this.time = time;
	}

	public SoftSkillViolation(int screening, int violation, String comment, Date time) {
		super();
		this.screening = screening;
		this.violation = violation;
		this.comment = comment;
		this.time = time;
	}

	public int getSoftViolationId() {
		return softViolationId;
	}

	public void setSoftViolationId(int softViolationId) {
		this.softViolationId = softViolationId;
	}

	public int getScreening() {
		return screening;
	}

	public void setScreening(int screening) {
		this.screening = screening;
	}

	public int getViolation() {
		return violation;
	}

	public void setViolation(int violation) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SoftSkillViolation that = (SoftSkillViolation) o;
		return getSoftViolationId() == that.getSoftViolationId() &&
				getScreening() == that.getScreening() &&
				getViolation() == that.getViolation() &&
				Objects.equals(getComment(), that.getComment()) &&
				Objects.equals(getTime(), that.getTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSoftViolationId(), getScreening(), getViolation(), getComment(), getTime());
	}

	@Override
	public String toString() {
		return "SoftSkillViolation{" +
				"softViolationId=" + softViolationId +
				", screening=" + screening +
				", violation=" + violation +
				", comment='" + comment + '\'' +
				", time=" + time +
				'}';
	}
}
