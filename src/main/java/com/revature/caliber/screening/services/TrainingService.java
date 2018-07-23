package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.SimpleTrainee;
import com.revature.caliber.beans.SimpleTrainer;

public interface TrainingService {
//	public SimpleTrainee getOneTrainee(Integer id);

	public List<SimpleTrainee> getAllTrainees();

	List<SimpleTrainer> getAllTrainers();
}
