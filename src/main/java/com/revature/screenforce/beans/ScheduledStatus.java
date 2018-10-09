package com.revature.screenforce.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ScheduledStatus {
	@JsonProperty("PENDING")
	PENDING,
	@JsonProperty("SCREENED")
	SCREENED
}