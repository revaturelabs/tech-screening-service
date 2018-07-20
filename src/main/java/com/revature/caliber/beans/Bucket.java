package com.revature.caliber.beans;

public class Bucket {
	
	private Integer bucketId;
	
	private String bucketCategory;
	
	private String bucketDescription;
	
	private Boolean isActive;

	public Bucket() {
		super();
	}

	public Bucket(String bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}

	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	public String getBucketCategory() {
		return bucketCategory;
	}

	public void setBucketCategory(String bucketCategory) {
		this.bucketCategory = bucketCategory;
	}

	public String getBucketDescription() {
		return bucketDescription;
	}

	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
