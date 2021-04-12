package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.entity.DistrictMasterEntity;
import com.mahindra.epcfrm.exception.DataNotFoundException;
import com.mahindra.epcfrm.repository.DistrictMasterRepo;
import com.mahindra.epcfrm.service.DistrictMasterService;

@Service
public class DistrictMasterServiceImpl implements DistrictMasterService {

	Logger log = LoggerFactory.getLogger(DistrictMasterServiceImpl.class);

	@Autowired
	DistrictMasterRepo distrctMasterRepo;

	@Override
	public List<DistrictMasterEntity> getDistrictsByStateWise(int stateCode) {
		log.info("inside getDistrictsByStateWise service");
		log.debug("inside getDistrictsByStateWise service");
		List<DistrictMasterEntity> districtList = distrctMasterRepo.findByStateCode(stateCode);
		if (districtList.size() != 0) {
			return districtList;
		} else {
			throw new DataNotFoundException("Districts data not available");
		}
	}

}
