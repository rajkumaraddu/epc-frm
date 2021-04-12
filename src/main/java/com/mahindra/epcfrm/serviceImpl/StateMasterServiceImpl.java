package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.entity.StateMasterEntity;
import com.mahindra.epcfrm.exception.DataNotFoundException;
import com.mahindra.epcfrm.repository.StateMasterRepo;
import com.mahindra.epcfrm.service.StateMasterService;

@Service
public class StateMasterServiceImpl implements StateMasterService {

	Logger log = LoggerFactory.getLogger(StateMasterServiceImpl.class);

	@Autowired
	StateMasterRepo stateMasterRepo;

	@Override
	public List<StateMasterEntity> getAllStates() {
		log.info("inside getAllStates service");
		log.debug("inside getAllStates service");
		List<StateMasterEntity> listOfStates = (List<StateMasterEntity>) stateMasterRepo.findAll();
		if (listOfStates.size() != 0) {
			return listOfStates;
		} else {
			throw new DataNotFoundException("States data not available");
		}
	}
}
