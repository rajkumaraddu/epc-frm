package com.mahindra.epcfrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.CustomerMasterEntity;

@Repository
public interface CustomerMasterRepo extends JpaRepository<CustomerMasterEntity, Integer> {

	Optional<CustomerMasterEntity> findByContactNumberAndEmailId(Long contactNumber,String emailId);
	
	Optional<CustomerMasterEntity> findByEmailId(String email);
}
