package com.revature.screenforce.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Class ViolationType, meant to represent all types of possible violations.
 *
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Violation Type", description = "All of the possible types of violations")
@Entity
@Table(name = "VIOLATION_TYPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ViolationType {

	/** The violation type id. */
	@ApiModelProperty(value = "Id of the violation")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VIOLATION_TYPE_ID")
	private int violationTypeId;

	/** Name of the violation type. */
	@ApiModelProperty(value = "Name of the violation type")
	@Column(name = "VIOLATION_TYPE")
	private String violationTypeText;

	/** A description of the violation. */
	@ApiModelProperty(value = "Description of the violation")
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * Instantiates a new violation type.
	 */
	public ViolationType() {
		super();
	}

	/**
	 * Instantiates a new violation type.
	 *
	 * @param violationTypeId the violation type id
	 * @param violationTypeText the violation type text
	 * @param description the description
	 */
	public ViolationType(int violationTypeId, String violationTypeText, String description) {
		super();
		this.violationTypeId = violationTypeId;
		this.violationTypeText = violationTypeText;
		this.description = description;
	}


	/**
	 * Gets the violation type id.
	 *
	 * @return the violation type id
	 */
	public int getViolationTypeId() {
		return violationTypeId;
	}

	/**
	 * Sets the violation type id.
	 *
	 * @param violationTypeId the new violation type id
	 */
	public void setViolationTypeId(int violationTypeId) {
		this.violationTypeId = violationTypeId;
	}

	/**
	 * Gets the violation type text.
	 *
	 * @return the violation type text
	 */
	public String getViolationTypeText() {
		return violationTypeText;
	}

	/**
	 * Sets the violation type text.
	 *
	 * @param violationTypeText the new violation type text
	 */
	public void setViolationTypeText(String violationTypeText) {
		this.violationTypeText = violationTypeText;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
		ViolationType that = (ViolationType) o;
		return getViolationTypeId() == that.getViolationTypeId() &&
				Objects.equals(getViolationTypeText(), that.getViolationTypeText()) &&
				Objects.equals(getDescription(), that.getDescription());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getViolationTypeId(), getViolationTypeText(), getDescription());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ViolationType{" +
				"violationTypeId=" + violationTypeId +
				", violationTypeText='" + violationTypeText + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
