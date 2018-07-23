package com.revature.caliber.beans;

import java.io.Serializable;

public class Note implements Serializable {
	private static final long serialVersionUID = -4960654794116385953L;

	private Integer noteId;
	private String content;
	private Short week;
	private Batch batch;
	private Candidate Candidate;
	private TrainerRole maxVisibility;
	private NoteType type;
	private Boolean qcFeedback;
	private QCStatus qcStatus;

	public Note() {
		super();
		this.maxVisibility = TrainerRole.ROLE_TRAINER;
	}

	/**
	 * QC Status for the batch. Constructs the note and it's visibility If the
	 * feedback is public, anyone can view. If not, the feedback can only be viewed
	 * by QC and the VP.
	 *
	 * @param content
	 * @param week
	 * @param batch
	 * @param maxVisibility
	 * @param type
	 * @param qcFeedback
	 * @param qcStatus
	 */
	private Note(String content, Short week, Batch batch, NoteType type, QCStatus qcStatus) {
		this();
		this.content = content;
		this.week = week;
		this.batch = batch;
		if (type == NoteType.QC_BATCH)
			this.maxVisibility = TrainerRole.ROLE_QC;
		else
			throw new IllegalArgumentException("Select proper NoteType");
		this.type = type;
		this.qcFeedback = true;
		this.qcStatus = qcStatus;
	}

	public Note(SimpleNote simpleNote){
		this();
		this.noteId = simpleNote.getNoteId();
		this.content = simpleNote.getContent();
		this.week = simpleNote.getWeek();
		this.maxVisibility = simpleNote.getMaxVisibility();
		this.type = simpleNote.getType();
		this.qcFeedback = simpleNote.isQcFeedback();
		this.qcStatus = simpleNote.getQcStatus();
	}

	/**
	 * QC Status for each Candidate. Constructs the note and it's visibility If the
	 * feedback is public, anyone can view. If not, the feedback can only be viewed
	 * by QC and the VP.
	 *
	 * @param content
	 * @param week
	 * @param batch
	 * @param maxVisibility
	 * @param type
	 * @param qcFeedback
	 * @param qcStatus
	 */
	private Note(String content, Short week, Candidate Candidate, NoteType type, QCStatus qcStatus) {
		this();
		this.content = content;
		this.week = week;
		this.Candidate = Candidate;
		if (type == NoteType.QC_Candidate)
			this.maxVisibility = TrainerRole.ROLE_QC;
		else
			throw new IllegalArgumentException("Select proper NoteType");
		this.type = type;
		this.qcFeedback = true;
		this.qcStatus = qcStatus;
	}

	/**
	 * Trainer feedback for a Candidate
	 *
	 * @param content
	 * @param week
	 * @param Candidate
	 * @param maxVisibility
	 * @param type
	 */
	private Note(String content, Short week, Candidate Candidate) {
		this();
		this.content = content;
		this.week = week;
		this.Candidate = Candidate;
		this.maxVisibility = TrainerRole.ROLE_TRAINER;
		this.type = NoteType.Candidate;
		this.qcFeedback = false;
	}

	/**
	 * Trainer feedback for a batch
	 *
	 * @param content
	 * @param week
	 * @param Candidate
	 * @param maxVisibility
	 * @param type
	 */
	private Note(String content, Short week, Batch batch) {
		this();
		this.content = content;
		this.week = week;
		this.batch = batch;
		this.maxVisibility = TrainerRole.ROLE_TRAINER;
		this.type = NoteType.BATCH;
		this.qcFeedback = false;
	}

	/**
	 * Factory method to construct new QC weekly batch note
	 *
	 * @param content
	 * @param week
	 * @param batch
	 * @param qcStatus
	 * @param isPublic
	 * @return
	 */
	public static Note qcBatchNote(String content, Integer week, Batch batch, QCStatus qcStatus) {
		return new Note(content, week.shortValue(), batch, NoteType.QC_BATCH, qcStatus);
	}

	/**
	 * Factory method for creating new QC weekly individual Candidate note
	 *
	 * @param content
	 * @param week
	 * @param Candidate
	 * @param qcStatus
	 * @param isPublic
	 * @return
	 */
	public static Note qcIndividualNote(String content, Integer week, Candidate Candidate, QCStatus qcStatus) {
		return new Note(content, week.shortValue(), Candidate, NoteType.QC_Candidate, qcStatus);
	}

	/**
	 * Factory method for creating a new Trainer weekly batch note
	 *
	 * @param content
	 * @param week
	 * @param batch
	 * @return
	 */
	public static Note trainerBatchNote(String content, Integer week, Batch batch) {
		return new Note(content, week.shortValue(), batch);
	}

	/**
	 * Factory method for creating a new Trainer weekly individual Candidate note
	 *
	 * @param content
	 * @param week
	 * @param Candidate
	 * @return
	 */
	public static Note trainerIndividualNote(String content, Integer week, Candidate Candidate) {
		return new Note(content, week.shortValue(), Candidate);
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Short getWeek() {
		return week;
	}

	public void setWeek(Short week) {
		this.week = week;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Candidate getCandidate() {
		return Candidate;
	}

	public void setCandidate(Candidate Candidate) {
		this.Candidate = Candidate;
	}

	public TrainerRole getMaxVisibility() {
		return maxVisibility;
	}

	public void setMaxVisibility(TrainerRole maxVisibility) {
		this.maxVisibility = maxVisibility;
	}

	public NoteType getType() {
		return type;
	}

	public void setType(NoteType type) {
		this.type = type;
	}

	public Boolean isQcFeedback() {
		return qcFeedback;
	}

	public void setQcFeedback(Boolean qcFeedback) {
		this.qcFeedback = qcFeedback;
	}

	public QCStatus getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(QCStatus qcStatus) {
		this.qcStatus = qcStatus;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((maxVisibility == null) ? 0 : maxVisibility.hashCode());
		result = prime * result + (qcFeedback ? 1231 : 1237);
		result = prime * result + ((qcStatus == null) ? 0 : qcStatus.hashCode());
		result = prime * result + ((Candidate == null) ? 0 : Candidate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
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
		Note other = (Note) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (maxVisibility != other.maxVisibility)
			return false;
		if (qcFeedback != other.qcFeedback)
			return false;
		if (qcStatus != other.qcStatus)
			return false;
		if (Candidate == null) {
			if (other.Candidate != null)
				return false;
		} else if (!Candidate.equals(other.Candidate))
			return false;
		if (type != other.type)
			return false;
		if (week != other.week)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content + ", week=" + week + ", Candidate=" + Candidate
				+ ", maxVisibility=" + maxVisibility + ", type=" + type + ", qcFeedback=" + qcFeedback + ", qcStatus="
				+ qcStatus + "]";
	}

}
