package com.revature.caliber.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="VIOLATION_TYPE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ViolationType {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIOLATION_SEQUENCE")
	@SequenceGenerator(name="VIOLATION_SEQUENCE",sequenceName="VIOLATION_SEQUENCE")
	@Column(name="VIOLATION_ID")
	private int violationTypeId;
	
	@Column(name="VIOLATION")
	private String violationTypeText;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public ViolationType() {
		super();
	}

	public ViolationType(int violationTypeId, String violationTypeText, String description) {
		super();
		this.violationTypeId = violationTypeId;
		this.violationTypeText = violationTypeText;
		this.description = description;
	}

	public int getViolationTypeId() {
		return violationTypeId;
	}

	public void setViolationTypeId(int violationTypeId) {
		this.violationTypeId = violationTypeId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + violationTypeId;
		result = prime * result + ((violationTypeText == null) ? 0 : violationTypeText.hashCode());
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
		ViolationType other = (ViolationType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (violationTypeId != other.violationTypeId)
			return false;
		if (violationTypeText == null) {
			if (other.violationTypeText != null)
				return false;
		} else if (!violationTypeText.equals(other.violationTypeText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViolationType [violationTypeId=" + violationTypeId + ", violationTypeText=" + violationTypeText
				+ ", description=" + description + "]";
	}
}
