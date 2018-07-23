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
	private Integer violationTypeId;
	
	@Column(name="VIOLATION")
	private String violationTypeText;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public ViolationType() {
		super();
	}
	
	public ViolationType(String violationTypeText, String description) {
		super();
		this.violationTypeText = violationTypeText;
		this.description = description;
	}

	public ViolationType(Integer violationTypeId, String violationTypeText, String description) {
		super();
		this.violationTypeId = violationTypeId;
		this.violationTypeText = violationTypeText;
		this.description = description;
	}

	public Integer getViolationTypeId() {
		return violationTypeId;
	}

	public void setViolationTypeId(Integer violationTypeId) {
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
		result = prime * result + ((violationTypeId == null) ? 0 : violationTypeId.hashCode());
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
		if (violationTypeId == null) {
			if (other.violationTypeId != null)
				return false;
		} else if (!violationTypeId.equals(other.violationTypeId))
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
		return "ViolationType [violationTypeId=" + violationTypeId + ", violationTypeText=" + violationTypeText + "]";
	}

}
