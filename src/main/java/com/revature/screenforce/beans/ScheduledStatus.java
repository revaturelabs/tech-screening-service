package com.revature.screenforce.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Enum ScheduledStatus, indicates status of a Scheduled Screening.
 */
public enum ScheduledStatus {
	
	/** Indicates a screening is pending. */
	@JsonProperty("PENDING")
	PENDING,
	
	/** Indicated a screening has been completed. */
	@JsonProperty("SCREENED")
	SCREENED
}