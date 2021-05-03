/**
 * 
 */
package com.mahindra.epcfrm.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.ActivityHistoryEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface ActivityHistoryRepo extends JpaRepository<ActivityHistoryEntity, Integer> {

	/**
	 * @param user
	 * @param today
	 * @param nextday
	 * @return
	 */
	@Query("select a from ActivityHistoryEntity a where a.userId = :user and date = :activityDate ")
	List<ActivityHistoryEntity> getActivity(String user, LocalDate activityDate);

	/**
	 * @param user
	 * @param activityDate
	 * @param fromTime
	 * @return
	 */
	@Query("select a from ActivityHistoryEntity a where a.userId = :user and date = :activityDate and fromTime = :fromTime")
	ActivityHistoryEntity getUserActivity(String user, LocalDate activityDate, LocalTime fromTime);

}
