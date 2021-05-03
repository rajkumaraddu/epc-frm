package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;

@Repository
public interface FarmerMasterRepo extends JpaRepository<FarmerMasterEntity,Integer> {

}
