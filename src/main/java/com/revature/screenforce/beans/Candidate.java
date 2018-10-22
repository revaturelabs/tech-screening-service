package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/*
 * Missing Data in data.sql for
 * Recruiter
 * College
 * Degree
 * Major
 * TechScreenerName
 */

@ApiModel(value = "Candidate", description = "A candidate that is being screened")
@Entity
@Table(name = "CANDIDATE")
public class Candidate {

	@ApiModelProperty(value = "Id of the candidate")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CANDIDATE_ID")
	private int candidateId;

	@ApiModelProperty(value = "Id from Salesforce which identifies the candidate")
	@Column(name = "RESOURCE_ID")
	private String resourceId;

	@ApiModelProperty(value = "Name of the candidate")
	@Column(name = "NAME")
	private String name;

	@ApiModelProperty(value = "Email of the candidate")
	@Column(name = "EMAIL")
	private String email;

	@ApiModelProperty(value = "Phone number of the candidate")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@ApiModelProperty(value = "Skype username of the candidate")
	@Column(name = "SKYPE_ID")
	private String skypeId;

	@ApiModelProperty(value = "Link to the candidates portfolio")
	@Column(name = "PROFILE_URL")
	private String profileUrl;

	@ApiModelProperty(value = "Name of the recruiter for the candidate")
	@Column(name = "RECRUITER_NAME")
	private String recruiterName;

	@ApiModelProperty(value = "College the candidate attended")
	@Column(name = "COLLEGE")
	private String college;

	@ApiModelProperty(value = "Degree the candidate attained")
	@Column(name = "DEGREE")
	private String degree;

	@ApiModelProperty(value = "Field the candidate majored in")
	@Column(name = "MAJOR")
	private String major;

	@ApiModelProperty(value = "Name of the screener for the candidate")
	@Column(name = "TECH_SCREENER_NAME")
	private String techScreenerName;

	public Candidate() {
		super();
	}

	public Candidate(int candidateId, String resourceId, String name, String email, String phoneNumber, String skypeId,
					 String profileUrl, String recruiterName, String college, String degree, String major,
					 String techScreenerName) {
		super();
		this.candidateId = candidateId;
		this.resourceId = resourceId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.skypeId = skypeId;
		this.profileUrl = profileUrl;
		this.recruiterName = recruiterName;
		this.college = college;
		this.degree = degree;
		this.major = major;
		this.techScreenerName = techScreenerName;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechScreenerName() {
		return techScreenerName;
	}

	public void setTechScreenerName(String techScreenerName) {
		this.techScreenerName = techScreenerName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Candidate candidate = (Candidate) o;
		return getCandidateId() == candidate.getCandidateId() &&
				Objects.equals(getResourceId(), candidate.getResourceId()) &&
				Objects.equals(getName(), candidate.getName()) &&
				Objects.equals(getEmail(), candidate.getEmail()) &&
				Objects.equals(getPhoneNumber(), candidate.getPhoneNumber()) &&
				Objects.equals(getSkypeId(), candidate.getSkypeId()) &&
				Objects.equals(getProfileUrl(), candidate.getProfileUrl()) &&
				Objects.equals(getRecruiterName(), candidate.getRecruiterName()) &&
				Objects.equals(getCollege(), candidate.getCollege()) &&
				Objects.equals(getDegree(), candidate.getDegree()) &&
				Objects.equals(getMajor(), candidate.getMajor()) &&
				Objects.equals(getTechScreenerName(), candidate.getTechScreenerName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCandidateId(), getResourceId(), getName(), getEmail(), getPhoneNumber(), getSkypeId(), getProfileUrl(), getRecruiterName(), getCollege(), getDegree(), getMajor(), getTechScreenerName());
	}

	@Override
	public String toString() {
		return "Candidate{" +
				"candidateId=" + candidateId +
				", resourceId='" + resourceId + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", skypeId='" + skypeId + '\'' +
				", profileUrl='" + profileUrl + '\'' +
				", recruiterName='" + recruiterName + '\'' +
				", college='" + college + '\'' +
				", degree='" + degree + '\'' +
				", major='" + major + '\'' +
				", techScreenerName='" + techScreenerName + '\'' +
				'}';
	}
}
