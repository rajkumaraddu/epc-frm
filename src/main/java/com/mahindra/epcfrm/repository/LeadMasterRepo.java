package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.entity.CustomerMasterEntity;
import java.util.List;
import java.util.Optional;



@Repository
public interface LeadMasterRepo extends JpaRepository<LeadMasterEntity, Integer> {

	Optional<LeadMasterEntity> findByFarmerId(CustomerMasterEntity farmerId);
	List<LeadMasterEntity> findByUserMobile(Long userMobile);
	
	@Query("SELECT l FROM LeadMasterEntity l where l.workOrderStatus ='WoPending' or l.kycStatus ='KycPending' or l.quotationStatus = 'QuPending'")
	List<LeadMasterEntity> findLeads();
}
