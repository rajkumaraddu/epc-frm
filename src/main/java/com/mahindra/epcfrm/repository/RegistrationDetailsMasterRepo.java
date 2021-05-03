package com.mahindra.epcfrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindra.epcfrm.entity.RegistrationDetailsMasterEntity;

public interface RegistrationDetailsMasterRepo extends JpaRepository<RegistrationDetailsMasterEntity, Integer> {

	Optional<RegistrationDetailsMasterEntity> findByLeadId(int leadId);
}
