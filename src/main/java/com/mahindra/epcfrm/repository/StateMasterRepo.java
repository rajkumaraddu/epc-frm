package com.mahindra.epcfrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahindra.epcfrm.entity.StateMasterEntity;

@Repository
public interface StateMasterRepo extends JpaRepository<StateMasterEntity,Integer>{

}
