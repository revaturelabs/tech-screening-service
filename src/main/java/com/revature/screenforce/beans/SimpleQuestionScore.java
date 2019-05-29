package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Question Score", description = "Object representing the score a candidate achieved on a question")
@Entity
@Table(name = "QUESTION_SCORE")
public class SimpleQuestionScore {

	//variables
	@ApiModelProperty(value = "Id of the Question Score")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_SCORE_ID")
	private int questionScoreId;

	@ApiModelProperty(value = "Id of the question being scored")
	@Column(name = "QUESTION_ID")
	private int questionId;

	@ApiModelProperty(value = "Id of the bucket containing the question")
	@Column(name = "BUCKET_ID")
	private int bucketId;

	@ApiModelProperty(value = "Id of the screening the question was asked on")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCREENING_ID")
	private Screening screening;

	@ApiModelProperty(value = "Score achieved on the question")
	@Column(name = "SCORE")
	private Double score;

	@ApiModelProperty(value = "Any comments about the answer to the question")
	@Column(name = "COMMENT")
	private String comment;

	@ApiModelProperty(value = "Time question was asked")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME")
	private Date beginTime;

	//constructor
	public SimpleQuestionScore(Integer questionId, Screening screeningId, Double score, String comment, Date beginTime) {
		super();
		this.questionId = questionId;
		this.screening = screeningId;
		this.score = score;
		this.comment = comment;
		this.beginTime = beginTime;
	}
	public SimpleQuestionScore() {
		super();
	}

	//getters and setters
	public int getQuestionScoreId() {
		return questionScoreId;
	}

	public void setQuestionScoreId(int questionScoreId) {
		this.questionScoreId = questionScoreId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public int getBucketId() {
		return bucketId;
	}

	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}

	//equals and hashcode
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
	@Override
	public int hashCode() {
		return Objects.hash(getQuestionScoreId(), getQuestionId(), getBucketId(), getScreening(), getScore(), getComment(), getBeginTime());
	}

	//toString
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
