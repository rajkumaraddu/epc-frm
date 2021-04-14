package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.CityMasterEntity;
import com.mahindra.epcfrm.entity.CropMasterEntity;
import com.mahindra.epcfrm.exception.DataNotFoundException;
import com.mahindra.epcfrm.repository.CropMasterRepo;
import com.mahindra.epcfrm.service.CropMasterService;

@Service
public class CropMasterServiceImpl implements CropMasterService {

	Logger log = LoggerFactory.getLogger(CropMasterServiceImpl.class);

	@Autowired
	CropMasterRepo cropMasterRepo;

	@Override
	public MasterResponseDto getAllCrops() {
		log.info("inside getAllCrops service");
		log.debug("inside getAllCrops service");
		MasterResponseDto masterRes = new MasterResponseDto();
		List<CropMasterEntity> listOfCrops = (List<CropMasterEntity>) cropMasterRepo.findAll();
		if (listOfCrops.isEmpty()) {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Crop not available");
			masterRes.setData(null);	
		} else {
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(listOfCrops);	
		}
		return masterRes;
	}
}
