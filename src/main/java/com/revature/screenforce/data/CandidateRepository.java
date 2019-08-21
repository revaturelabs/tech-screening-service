package com.revature.screenforce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Candidate;
import com.revature.screenforce.beans.SimpleQuestionScore;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
		
	}

