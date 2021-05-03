package com.mahindra.epcfrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;
import com.mahindra.epcfrm.entity.KYCMasterEntity;
import com.mahindra.epcfrm.entity.SiteSurveyMasterEntity;

@Repository
public interface KycMasterRepo extends JpaRepository<KYCMasterEntity,Integer> {

	Optional<KYCMasterEntity> findByLeadId(int leadId);
}
