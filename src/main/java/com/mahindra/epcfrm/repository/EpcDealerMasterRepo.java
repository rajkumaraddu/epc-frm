/**
 * 
 */
package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.EpcDealerMasterEntity;

/**
 * @author Raju.Addu
 *
 */
@Repository
public interface EpcDealerMasterRepo extends JpaRepository<EpcDealerMasterEntity, Integer> {

}
