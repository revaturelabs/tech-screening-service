package com.revature.caliber.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Determines if notes are created by Trainer or QC 
 * and where they are applied (to the Candidate or batch).
 * Public notes are made by QC that are not visible to trainers and below.
 * 
 * @author Patrick Walsh
 *
 */
public enum NoteType implements Serializable{
	@JsonProperty("Candidate")
	Candidate,
	@JsonProperty("BATCH")
	BATCH,
	@JsonProperty("QC_Candidate")
	QC_Candidate,
	@JsonProperty("QC_BATCH")
	QC_BATCH
}
