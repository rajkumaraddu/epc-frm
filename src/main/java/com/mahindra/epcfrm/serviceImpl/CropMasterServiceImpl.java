package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<CropMasterEntity> getAllCrops() {
		log.info("inside getAllCrops service");
		log.debug("inside getAllCrops service");
		List<CropMasterEntity> listOfCrops = (List<CropMasterEntity>) cropMasterRepo.findAll();
		if (listOfCrops.size() != 0) {
			return listOfCrops;
		} else {
			throw new DataNotFoundException("Crops data not available");
		}
	}
}
