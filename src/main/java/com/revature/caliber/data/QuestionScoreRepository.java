package com.revature.caliber.data;

import com.revature.caliber.beans.SimpleQuestionScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The DAO for Question Score.
 * 
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 *
 */

@Repository
public interface QuestionScoreRepository extends JpaRepository<SimpleQuestionScore, Integer> {

	/**
	 * Finds question scores containing given screening id
	 * 
	 * @param screeningId Id of Screening
	 * @return List of question scores
	 */
	List<SimpleQuestionScore> findByScreeningId(Integer screeningId);
	
}
