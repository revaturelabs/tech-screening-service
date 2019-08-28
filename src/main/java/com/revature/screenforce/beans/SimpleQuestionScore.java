package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The Class SimpleQuestionScore, meant to represent the score a candidate received on a question.
 *
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Question Score", description = "Object representing the score a candidate received on a question")
@Entity
@Table(name = "QUESTION_SCORE")
public class SimpleQuestionScore {

	/** ID of the Question Score. */
	@ApiModelProperty(value = "Id of the Question Score")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_SCORE_ID")
	private int questionScoreId;

	/** ID of the question being scored. */
	@ApiModelProperty(value = "Id of the question being scored")
	@Column(name = "QUESTION_ID")
	private int questionId;

	/** The bucket (category) id. */
	@ApiModelProperty(value = "Id of the bucket containing the question")
	@Column(name = "BUCKET_ID")
	private int bucketId;

	/** The ID of the screening in which the question was asked. */
	@ApiModelProperty(value = "The ID of the screening in which the question was asked.")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private Screening screening;

	/** The score received. */
	@ApiModelProperty(value = "Score received on the question")
	@Column(name = "SCORE")
	private Double score;

	/** Any comments about the answer to the question */
	@ApiModelProperty(value = "Any comments about the answer to the question")
	@Column(name = "COMMENT")
	private String comment;

	/** Time question was asked */
	@ApiModelProperty(value = "Time question was asked")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME")
	private Date beginTime;

	/**
	 * Instantiates a new simple question score.
	 *
	 * @param questionId the question id
	 * @param screeningId the screening id
	 * @param score the score
	 * @param comment the comment
	 * @param beginTime the begin time
	 */
	public SimpleQuestionScore(Integer questionId, Screening screeningId, Double score, String comment, Date beginTime) {
		super();
		this.questionId = questionId;
		this.screening = screeningId;
		this.score = score;
		this.comment = comment;
		this.beginTime = beginTime;
	}
	
	/**
	 * Instantiates a new simple question score.
	 */
	public SimpleQuestionScore() {
		super();
	}

	/**
	 * Gets the question score id.
	 *
	 * @return the question score id
	 */
	public int getQuestionScoreId() {
		return questionScoreId;
	}

	/**
	 * Sets the question score id.
	 *
	 * @param questionScoreId the new question score id
	 */
	public void setQuestionScoreId(int questionScoreId) {
		this.questionScoreId = questionScoreId;
	}

	/**
	 * Gets the question id.
	 *
	 * @return the question id
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * Sets the question id.
	 *
	 * @param questionId the new question id
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * Gets the screening.
	 *
	 * @return the screening
	 */
	public Screening getScreening() {
		return screening;
	}

	/**
	 * Sets the screening.
	 *
	 * @param screening the new screening
	 */
	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the begin time.
	 *
	 * @return the begin time
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * Sets the begin time.
	 *
	 * @param beginTime the new begin time
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * Gets the bucket id.
	 *
	 * @return the bucket id
	 */
	public int getBucketId() {
		return bucketId;
	}

	/**
	 * Sets the bucket id.
	 *
	 * @param bucketId the new bucket id
	 */
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
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
		SimpleQuestionScore score1 = (SimpleQuestionScore) o;
		return getQuestionScoreId() == score1.getQuestionScoreId() &&
				getQuestionId() == score1.getQuestionId() &&
				getBucketId() == score1.getBucketId() &&
				Objects.equals(getScreening(), score1.getScreening()) &&
				Objects.equals(getScore(), score1.getScore()) &&
				Objects.equals(getComment(), score1.getComment()) &&
				Objects.equals(getBeginTime(), score1.getBeginTime());
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getQuestionScoreId(), getQuestionId(), getBucketId(), getScreening(), getScore(), getComment(), getBeginTime());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SimpleQuestionScore{" +
				"questionScoreId=" + questionScoreId +
				", questionId=" + questionId +
				", bucketId=" + bucketId +
				", screening=" + screening +
				", score=" + score +
				", comment='" + comment + '\'' +
				", beginTime=" + beginTime +
				'}';
	}
}
