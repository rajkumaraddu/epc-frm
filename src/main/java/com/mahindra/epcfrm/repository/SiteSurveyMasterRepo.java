package com.mahindra.epcfrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.FarmerMasterEntity;
import com.mahindra.epcfrm.entity.SiteSurveyMasterEntity;

@Repository
public interface SiteSurveyMasterRepo extends JpaRepository<SiteSurveyMasterEntity,Integer> {

	Optional<SiteSurveyMasterEntity> findByLeadId(int leadId);
}
