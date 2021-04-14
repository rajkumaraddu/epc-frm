package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.DistrictMasterEntity;
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
	public MasterResponseDto getAllStates() {
		log.info("inside getAllStates service");
		log.debug("inside getAllStates service");
		MasterResponseDto masterRes = new MasterResponseDto();
		List<StateMasterEntity> listOfStates = (List<StateMasterEntity>) stateMasterRepo.findAll();
		if (listOfStates.isEmpty()) {
			masterRes.setStatusCode(1);
			masterRes.setMessage("States not available");
			masterRes.setData(null);
		} else {
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(listOfStates);
		}
		return masterRes;
	}
}
