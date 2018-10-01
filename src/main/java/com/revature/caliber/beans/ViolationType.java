package com.revature.caliber.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Violation Type", description = "All of the possible types of violations")
@Entity
@Table(name = "VIOLATION_TYPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ViolationType {

	@ApiModelProperty(value = "Id of the violation")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int violationId;

	@ApiModelProperty(value = "Name of the violation type")
	@Column(name = "VIOLATION_TYPE")
	private String violationTypeText;

	@ApiModelProperty(value = "Description of the violation")
	@Column(name = "DESCRIPTION")
	private String description;

	public ViolationType() {
		super();
	}

	public ViolationType(int violationId, String violationTypeText, String description) {
		super();
		this.violationId = violationId;
		this.violationTypeText = violationTypeText;
		this.description = description;
	}


	public int getViolationId() {
		return violationId;
	}

	public void setViolationId(int violationId) {
		this.violationId = violationId;
	}

	public String getViolationTypeText() {
		return violationTypeText;
	}

	public void setViolationTypeText(String violationTypeText) {
		this.violationTypeText = violationTypeText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ViolationType that = (ViolationType) o;
		return getViolationId() == that.getViolationId() &&
				Objects.equals(getViolationTypeText(), that.getViolationTypeText()) &&
				Objects.equals(getDescription(), that.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getViolationId(), getViolationTypeText(), getDescription());
	}

	@Override
	public String toString() {
		return "ViolationType{" +
				"violationId=" + violationId +
				", violationTypeText='" + violationTypeText + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
