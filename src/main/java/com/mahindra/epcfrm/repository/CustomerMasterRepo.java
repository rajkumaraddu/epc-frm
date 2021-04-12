package com.mahindra.epcfrm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mahindra.epcfrm.entity.CustomerMasterEntity;

public interface CustomerMasterRepo extends CrudRepository<CustomerMasterEntity, Integer> {

	Optional<CustomerMasterEntity> findByContactNumberAndEmailId(Long contactNumber,String emailId);
	
	Optional<CustomerMasterEntity> findByEmailId(String email);
}
