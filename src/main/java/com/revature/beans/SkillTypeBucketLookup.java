package com.revature.beans;

public class SkillTypeBucketLookup {
	
	private Integer skillTypeBucketLookupId;
	
	private SkillType skillType;
	
	private Bucket bucket;
	
	private Double weight;

	public SkillTypeBucketLookup() {
		super();
	}

	public SkillTypeBucketLookup(SkillType skillType, Bucket bucket, Double weight) {
		super();
		this.skillType = skillType;
		this.bucket = bucket;
		this.weight = weight;
	}

	public Integer getSkillTypeBucketLookupId() {
		return skillTypeBucketLookupId;
	}

	public void setSkillTypeBucketLookupId(Integer skillTypeBucketLookupId) {
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
}
