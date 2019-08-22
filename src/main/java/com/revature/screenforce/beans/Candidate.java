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

/**
 * The Class Candidate, meant to represent a Candidate that is being screened.
 */
@ApiModel(value = "Candidate", description = "A candidate that is being screened")
@Entity
@Table(name = "CANDIDATE")
public class Candidate {

	/** The candidate's id. */
	@ApiModelProperty(value = "Id of the candidate")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CANDIDATE_ID")
	private int candidateId;

	/** ID from Salesforse which identifies the candidate */
	@ApiModelProperty(value = "Id from Salesforce which identifies the candidate")
	@Column(name = "RESOURCE_ID")
	private String resourceId;

	/** Name of the candidate */
	@ApiModelProperty(value = "Name of the candidate")
	@Column(name = "NAME")
	private String name;

	/** Email of the candidate */
	@ApiModelProperty(value = "Email of the candidate")
	@Column(name = "EMAIL")
	private String email;

	/** The Candidate's phone number. */
	@ApiModelProperty(value = "Phone number of the candidate")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	/** Skype username of the candidate. */
	@ApiModelProperty(value = "Skype username of the candidate")
	@Column(name = "SKYPE_ID")
	private String skypeId;

	/** Link to the candidates portfolio. */
	@ApiModelProperty(value = "Link to the candidates portfolio")
	@Column(name = "PROFILE_URL")
	private String profileUrl;

	/** Name of the recruiter for the candidate. */
	@ApiModelProperty(value = "Name of the recruiter for the candidate")
	@Column(name = "RECRUITER_NAME")
	private String recruiterName;

	/** College the candidate attended. */
	@ApiModelProperty(value = "College the candidate attended")
	@Column(name = "COLLEGE")
	private String college;

	/** Degree the candidate attained. */
	@ApiModelProperty(value = "Degree the candidate attained")
	@Column(name = "DEGREE")
	private String degree;

	/** Field the candidate majored in. */
	@ApiModelProperty(value = "Field the candidate majored in")
	@Column(name = "MAJOR")
	private String major;

	/** Name of the screener for the candidate. */
	@ApiModelProperty(value = "Name of the screener for the candidate")
	@Column(name = "TECH_SCREENER_NAME")
	private String techScreenerName;

	/**
	 * Instantiates a new candidate.
	 */
	public Candidate() {
		super();
	}

	/**
	 * Instantiates a new candidate.
	 *
	 * @param candidateId      the candidate id
	 * @param resourceId       the resource id
	 * @param name             the name
	 * @param email            the email
	 * @param phoneNumber      the phone number
	 * @param skypeId          the skype id
	 * @param profileUrl       the profile url
	 * @param recruiterName    the recruiter name
	 * @param college          the college
	 * @param degree           the degree
	 * @param major            the major
	 * @param techScreenerName the tech screener name
	 */
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

	/**
	 * Gets the candidate id.
	 *
	 * @return the candidate id
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * Sets the candidate id.
	 *
	 * @param candidateId the new candidate id
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * Gets the resource id.
	 *
	 * @return the resource id
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * Sets the resource id.
	 *
	 * @param resourceId the new resource id
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the skype id.
	 *
	 * @return the skype id
	 */
	public String getSkypeId() {
		return skypeId;
	}

	/**
	 * Sets the skype id.
	 *
	 * @param skypeId the new skype id
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/**
	 * Gets the profile url.
	 *
	 * @return the profile url
	 */
	public String getProfileUrl() {
		return profileUrl;
	}

	/**
	 * Sets the profile url.
	 *
	 * @param profileUrl the new profile url
	 */
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	/**
	 * Gets the recruiter name.
	 *
	 * @return the recruiter name
	 */
	public String getRecruiterName() {
		return recruiterName;
	}

	/**
	 * Sets the recruiter name.
	 *
	 * @param recruiterName the new recruiter name
	 */
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	/**
	 * Gets the college.
	 *
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * Sets the college.
	 *
	 * @param college the new college
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * Gets the degree.
	 *
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * Sets the degree.
	 *
	 * @param degree the new degree
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * Gets the major.
	 *
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Sets the major.
	 *
	 * @param major the new major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * Gets the tech screener name.
	 *
	 * @return the tech screener name
	 */
	public String getTechScreenerName() {
		return techScreenerName;
	}

	/**
	 * Sets the tech screener name.
	 *
	 * @param techScreenerName the new tech screener name
	 */
	public void setTechScreenerName(String techScreenerName) {
		this.techScreenerName = techScreenerName;
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getCandidateId(), getResourceId(), getName(), getEmail(), getPhoneNumber(), getSkypeId(), getProfileUrl(), getRecruiterName(), getCollege(), getDegree(), getMajor(), getTechScreenerName());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
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
