package com.mahindra.epcfrm.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.DistrictMasterEntity;
import com.mahindra.epcfrm.repository.DistrictMasterRepo;
import com.mahindra.epcfrm.service.DistrictMasterService;

@Service
public class DistrictMasterServiceImpl implements DistrictMasterService {

	Logger log = LoggerFactory.getLogger(DistrictMasterServiceImpl.class);

	@Autowired
	DistrictMasterRepo distrctMasterRepo;

	@Override
	public MasterResponseDto getDistrictsByStateWise(int stateCode) {
		log.info("inside getDistrictsByStateWise service");
		log.debug("inside getDistrictsByStateWise service");
		MasterResponseDto masterRes = new MasterResponseDto();
		List<DistrictMasterEntity> districtList = distrctMasterRepo.findByStateCode(stateCode);
		if (districtList.isEmpty()) {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Districts not available");
			masterRes.setData(null);
		} else {
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(districtList);
		}
		return masterRes;
	}

}
