/**
 * 
 */
package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.UserMasterEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface UserMasterRepo extends JpaRepository<UserMasterEntity, Integer> {
	UserMasterEntity findByUserIdOrTokenNo(String username,String tokenNo);

}
