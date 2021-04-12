package com.mahindra.epcfrm.repository;

import org.springframework.data.repository.CrudRepository;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.entity.CustomerMasterEntity;
import java.util.List;
import java.util.Optional;

public interface LeadMasterRepo extends CrudRepository<LeadMasterEntity, Integer> {

	Optional<LeadMasterEntity> findByFarmerId(CustomerMasterEntity farmerId);

}
