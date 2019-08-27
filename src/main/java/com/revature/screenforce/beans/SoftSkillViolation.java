package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The Class SoftSkillViolation, meant to represent and record any violations that occurred during a screening.
 *
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Soft Skills Violation", description = "Any violations that happen during the scourse of a screening")
@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {

	/** The violation id. */
	@ApiModelProperty(value = "Id of the violation")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SOFT_SKILL_VIOLATION_ID")
	private int softViolationId;

	/** The ID of the screening during which the violation occurred. */
	@ApiModelProperty(value = "The ID of the screening during which the violation occurred.")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private Screening screening;

	/** The type of violation that occurred. */
	@ApiModelProperty(value = "The type of violation that occurred.")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VIOLATION_TYPE_ID")
	private ViolationType violationType;

	/** Any comments regarding the violation. */
	@ApiModelProperty(value = "Any comments regarding the violation")
	@Column(name="COMMENT")
	private String comment;

	/** Time of the violation. */
	@ApiModelProperty(value = "Time of the violation")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date time;

	/**
	 * Instantiates a new soft skill violation.
	 */
	public SoftSkillViolation() {
		super();
	}

	/**
	 * Instantiates a new soft skill violation.
	 *
	 * @param softViolationId the soft violation id
	 * @param screening the screening
	 * @param violationType the violation type
	 * @param comment the comment
	 * @param time the time
	 */
	public SoftSkillViolation(int softViolationId, Screening screening, ViolationType violationType, String comment, Date time) {
		super();
		this.softViolationId = softViolationId;
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}

	/**
	 * Instantiates a new soft skill violation.
	 *
	 * @param screening the screening
	 * @param violationType the violation type
	 * @param comment the comment
	 * @param time the time
	 */
	public SoftSkillViolation(Screening screening, ViolationType violationType, String comment, Date time) {
		super();
		this.screening = screening;
		this.violationType = violationType;
		this.comment = comment;
		this.time = time;
	}

	/**
	 * Gets the soft violation id.
	 *
	 * @return the soft violation id
	 */
	public int getSoftViolationId() {
		return softViolationId;
	}

	/**
	 * Sets the soft violation id.
	 *
	 * @param softViolationId the new soft violation id
	 */
	public void setSoftViolationId(int softViolationId) {
		this.softViolationId = softViolationId;
	}

	/**
	 * Gets the screening.
	 *
	 * @return the screening
	 */
	public Screening getScreening() {
		return screening;
	}

	/**
	 * Sets the screening.
	 *
	 * @param screening the new screening
	 */
	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	/**
	 * Gets the violation type.
	 *
	 * @return the violation type
	 */
	public ViolationType getViolationType() {
		return violationType;
	}

	/**
	 * Sets the violation type.
	 *
	 * @param violationType the new violation type
	 */
	public void setViolationType(ViolationType violationType) {
		this.violationType = violationType;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(Date time) {
		this.time = time;
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
		SoftSkillViolation violation = (SoftSkillViolation) o;
		return getSoftViolationId() == violation.getSoftViolationId() &&
				Objects.equals(getScreening(), violation.getScreening()) &&
				Objects.equals(getViolationType(), violation.getViolationType()) &&
				Objects.equals(getComment(), violation.getComment()) &&
				Objects.equals(getTime(), violation.getTime());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getSoftViolationId(), getScreening(), getViolationType(), getComment(), getTime());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SoftSkillViolation{" +
				"softViolationId=" + softViolationId +
				", screening=" + screening +
				", violationType=" + violationType +
				", comment='" + comment + '\'' +
				", time=" + time +
				'}';
	}
}
