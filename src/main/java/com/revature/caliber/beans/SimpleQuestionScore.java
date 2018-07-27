package com.revature.caliber.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="QUESTION_SCORE")
public class SimpleQuestionScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="QUESTION_SCORE_SEQUENCE")
	@SequenceGenerator(name="QUESTION_SCORE_SEQUENCE",sequenceName="QUESTION_SCORE_SEQUENCE", allocationSize=1)
	@Column(name="ID")
	private Integer questionScoreId;
	
	@Column(name="QUESTION_ID")
	private Integer questionId;
	
	@Column(name="SCREENING_ID")
	private Integer screeningId;
	
	@Column(name="SCORE")
	private Double score;
	
	@Column(name="COMMENT")
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME")
	private Date beginTime;

	public SimpleQuestionScore(Integer questionId, Integer screeningId, Double score, String comment, Date beginTime) {
		super();
		this.questionId = questionId;
		this.screeningId = screeningId;
		this.score = score;
		this.comment = comment;
		this.beginTime = beginTime;
	}
	

	public SimpleQuestionScore() {
		super();
	}


	public Integer getQuestionScoreId() {
		return questionScoreId;
	}


	public void setQuestionScoreId(Integer questionScoreId) {
		this.questionScoreId = questionScoreId;
	}


	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public Integer getScreeningId() {
		return screeningId;
	}


	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((questionScoreId == null) ? 0 : questionScoreId.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
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
		SimpleQuestionScore other = (SimpleQuestionScore) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (questionScoreId == null) {
			if (other.questionScoreId != null)
				return false;
		} else if (!questionScoreId.equals(other.questionScoreId))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SimpleQuestionScore [questionScoreId=" + questionScoreId + ", questionId=" + questionId
				+ ", screeningId=" + screeningId + ", score=" + score + ", comment=" + comment + ", beginTime="
				+ beginTime + "]";
	}
	
	


	
}
