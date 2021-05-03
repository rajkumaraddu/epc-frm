package com.mahindra.epcfrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindra.epcfrm.entity.MaterialInstallationMasterEntity;

public interface MaterialInstallationMasterRepo extends JpaRepository<MaterialInstallationMasterEntity, Integer>{

	Optional<MaterialInstallationMasterEntity> findByLeadId(int leadId);
}
