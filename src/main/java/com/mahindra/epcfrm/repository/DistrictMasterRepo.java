package com.mahindra.epcfrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindra.epcfrm.entity.DistrictMasterEntity;

public interface DistrictMasterRepo extends JpaRepository<DistrictMasterEntity, Integer> {

	List<DistrictMasterEntity> findByStateCode(int stateCode);
}
