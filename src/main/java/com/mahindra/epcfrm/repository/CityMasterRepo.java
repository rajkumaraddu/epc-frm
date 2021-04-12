package com.mahindra.epcfrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.CityMasterEntity;

@Repository
public interface CityMasterRepo extends JpaRepository<CityMasterEntity,Integer>{

	List<CityMasterEntity> findByStateCode(int stateCode);
}
