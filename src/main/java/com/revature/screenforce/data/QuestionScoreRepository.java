package com.revature.screenforce.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.SimpleQuestionScore;

import java.util.List;

/**
 * The DAO for Question Score.
 *
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@Repository
public interface QuestionScoreRepository extends JpaRepository<SimpleQuestionScore, Integer> {

	/**
	 * Finds question scores containing given screening id
	 *
	 * @param screeningId Id of Screening
	 * @return List of question scores
	 */
	List<SimpleQuestionScore> findAllByScreeningScreeningId(int screeningId);

}
