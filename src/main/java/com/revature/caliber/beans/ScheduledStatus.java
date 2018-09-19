package com.revature.caliber.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ScheduledStatus {
	@JsonProperty("PENDING")
	PENDING,
	@JsonProperty("SCREENED")
	SCREENED
}