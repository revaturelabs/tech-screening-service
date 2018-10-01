package com.revature.caliber.beans;

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

	@ApiModelProperty(value = "Id of the Question Score")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_SCORE_ID")
	private int questionScoreId;

	@ApiModelProperty(value = "Id of the question being scored")
	@Column(name = "QUESTION_ID")
	private int questionId;

	@ApiModelProperty(value = "Id of the screening the question was asked on")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SimpleQuestionScore that = (SimpleQuestionScore) o;
		return getQuestionScoreId() == that.getQuestionScoreId() &&
				getQuestionId() == that.getQuestionId() &&
				getScreening() == that.getScreening() &&
				Objects.equals(getScore(), that.getScore()) &&
				Objects.equals(getComment(), that.getComment()) &&
				Objects.equals(getBeginTime(), that.getBeginTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getQuestionScoreId(), getQuestionId(), getScreening(), getScore(), getComment(), getBeginTime());
	}

	@Override
	public String toString() {
		return "SimpleQuestionScore{" +
				"questionScoreId=" + questionScoreId +
				", questionId=" + questionId +
				", screening=" + screening +
				", score=" + score +
				", comment='" + comment + '\'' +
				", beginTime=" + beginTime +
				'}';
	}
}
