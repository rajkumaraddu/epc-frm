package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.CropMasterEntity;

@Repository
public interface CropMasterRepo extends JpaRepository<CropMasterEntity,Integer> {

}
