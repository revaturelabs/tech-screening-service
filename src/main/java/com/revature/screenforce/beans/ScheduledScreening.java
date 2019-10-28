package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The Class ScheduledScreening, meant to represent a Scheduled Screening, which is associated with a Candidate and
 *  Track.  They are either PENDING or SCREENING, and have an attached date.
 */
@ApiModel(value = "Scheduled Screening", description = "A Scheduled Screening with the tracks tested and the time of the screening.")
@Entity
@Table(name = "scheduled_screening")
public class ScheduledScreening {

	/** The scheduled screening id. */
	@ApiModelProperty(value = "Id of the screening")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHEDULED_SCREENING_ID")
	private int scheduledScreeningId;

	/** Candidate that is being screened. */
	@ApiModelProperty(value = "Candidate that is being screened")
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	/** The scheduled status. 
	 * @see ScheduledStatus ScheduledStatus
	 * */
	@ApiModelProperty(value = "Status of the screening")
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private ScheduledStatus scheduledStatus;

	/** The track from the AdminService that the candidate is training in. */
	@ApiModelProperty(value = "The track from the AdminService that the candidate is training in")
	@Column(name = "TRACK_ID")
	private int trackId;

	/** The date of the screening. */
	@ApiModelProperty(value = "The date of the screening")
	@Column(name = "SCHEDULED_DATE")
	private Date scheduledDate;

	/**
	 * Instantiates a new scheduled screening.
	 */
	public ScheduledScreening() {
		super();
	}
	
	/**
	 * Instantiates a new scheduled screening.
	 *
	 * @param scheduledScreeningId the scheduled screening id
	 * @param candidate the candidate
	 * @param scheduledStatus the scheduled status
	 * @param trackId the track id
	 * @param scheduledDate the scheduled date
	 */
	public ScheduledScreening(int scheduledScreeningId, Candidate candidate, ScheduledStatus scheduledStatus,
							  int trackId, Date scheduledDate) {
		super();
		this.scheduledScreeningId = scheduledScreeningId;
		this.candidate = candidate;
		this.scheduledStatus = scheduledStatus;
		this.trackId = trackId;
		this.scheduledDate = scheduledDate;
	}

	/**
	 * Gets the scheduled screening id.
	 *
	 * @return the scheduled screening id
	 */
	public int getScheduledScreeningId() {
		return scheduledScreeningId;
	}

	/**
	 * Sets the scheduled screening id.
	 *
	 * @param scheduledScreeningId the new scheduled screening id
	 */
	public void setScheduledScreeningId(int scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}

	/**
	 * Gets the candidate.
	 *
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * Sets the candidate.
	 *
	 * @param candidate the new candidate
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * Gets the scheduled status.
	 *
	 * @return the scheduled status
	 */
	public ScheduledStatus getScheduledStatus() {
		return scheduledStatus;
	}

	/**
	 * Sets the scheduled status.
	 *
	 * @param scheduledStatus the new scheduled status
	 */
	public void setScheduledStatus(ScheduledStatus scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}

	/**
	 * Gets the track id.
	 *
	 * @return the track id
	 */
	public int getTrackId() {
		return trackId;
	}

	/**
	 * Sets the track id.
	 *
	 * @param trackId the new track id
	 */
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	/**
	 * Gets the scheduled date.
	 *
	 * @return the scheduled date
	 */
	public Date getScheduledDate() {
		return scheduledDate;
	}

	/**
	 * Sets the scheduled date.
	 *
	 * @param scheduledDate the new scheduled date
	 */
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
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
		ScheduledScreening that = (ScheduledScreening) o;
		return getScheduledScreeningId() == that.getScheduledScreeningId() &&
				getTrackId() == that.getTrackId() &&
				Objects.equals(getCandidate(), that.getCandidate()) &&
				Objects.equals(getScheduledStatus(), that.getScheduledStatus()) &&
				Objects.equals(getScheduledDate(), that.getScheduledDate());
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getScheduledScreeningId(), getCandidate(), getScheduledStatus(), getTrackId(), getScheduledDate());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ScheduledScreening{" +
				"scheduledScreeningId=" + scheduledScreeningId +
				", candidate=" + candidate +
				", scheduledStatus='" + scheduledStatus + '\'' +
				", trackId=" + trackId +
				", scheduledDate=" + scheduledDate +
				'}';
	}
}
