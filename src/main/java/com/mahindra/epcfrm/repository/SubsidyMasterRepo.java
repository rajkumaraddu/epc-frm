/**
 * 
 */
package com.mahindra.epcfrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.SubsidyMasterEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface SubsidyMasterRepo extends JpaRepository<SubsidyMasterEntity, Integer> {

	/**
	 * @param stateCode
	 * @return
	 */
	List<SubsidyMasterEntity> findByStateCode(int stateCode);

}
