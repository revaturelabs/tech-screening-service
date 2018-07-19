package com.revature.beans;

import java.io.Serializable;

/**
 * The type Simple Trainer.
 */
public class SimpleTrainer implements Serializable {
	private static final long serialVersionUID = 4555033024866490022L;

	private Integer trainerId;
	private String email;
	private String name;
	private String title;
	private TrainerRole tier;

	public SimpleTrainer() {
		super();
	}

	public SimpleTrainer(String email, String name, String title, TrainerRole tier) {
		super();
		this.email = email;
		this.name = name;
		this.title = title;
		this.tier = tier;
	}

	
	public SimpleTrainer(Trainer trainer) {
		super();
		this.trainerId = trainer.getTrainerId();
		this.email = trainer.getEmail();
		this.name = trainer.getName();
		this.title = trainer.getTitle();
		this.tier = trainer.getTier();
	}
	

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TrainerRole getTier() {
		return tier;
	}

	public void setTier(TrainerRole tier) {
		this.tier = tier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
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
		SimpleTrainer other = (SimpleTrainer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tier != other.tier)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", email=" + email + ", name=" + name + ", title=" + title
				+ ", tier=" + tier + "]";
	}

}
