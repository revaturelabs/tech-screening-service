package com.revature.caliber.screening.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Screening;

/**
 * A JpaRepository for interacting with the Screening H2 database
 * 
 * @author batem, echamp, sungkwon
 */
@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	
	/**
	 * Updates the aboutMeCommentary variable of a Screening object
	 * 
	 * @param introComment - the comment to be persisted to the database
	 * @param screeningId - the unique id of a Screening
	 */
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.aboutMeCommentary = ?1 where s.screeningId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void changeAboutMeCommentaryByScreeningId(String introComment, Integer screeningId);
	
	/**
	 * Updates the generalCommentary variable of a Screening object
	 * 
	 * @param generalComment - the comment to be persisted to the database
	 * @param screeningId - the unique id of a Screening
	 */
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.generalCommentary = ?1 where s.screeningId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void changeGeneralCommentaryByScreeningId(String generalComment, Integer screeningId);
	
	/**
	 * Updates the fields of a Screening object
	 * 
	 * @param status - the current status of a Screening
	 * @param softSkillsVerdict - the boolean value representing a pass fail on soft skills
	 * @param softSkillCommentary - the commentary regarding soft skills
	 * @param endDateTime - the end time of a Screening
	 * @param compositeScore - the composite score of a Screening
	 * @param screeningId - the unique id of a Screening object
	 */
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.status = ?1, s.softSkillsVerdict = ?2, s.softSkillCommentary = ?3,"+
			"s.endDateTime = ?4, s.compositeScore = ?5 where s.screeningId = ?6")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void updateScreeningInformationByScreeningId(String status, Boolean softSkillsVerdict, String softSkillCommentary, 
			Date endDateTime, Double compositeScore, Integer screeningId);

	/**
	 * Returns a list of SimpleScreenings based on status.
	 * 
	 * @param status - the pending or complete status of a SimpleScreening
	 * @return List of SimpleScreening objects
	 */
	List<Screening> findByStatus(String status);
}
