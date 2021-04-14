package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.CityRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.CityMasterEntity;
import com.mahindra.epcfrm.exception.DataNotFoundException;
import com.mahindra.epcfrm.repository.CityMasterRepo;
import com.mahindra.epcfrm.service.CityMasterService;

@Service
public class CityMasterServiceImpl implements CityMasterService {

	Logger log = LoggerFactory.getLogger(CityMasterServiceImpl.class);

	@Autowired
	CityMasterRepo cityMasterRepo;

	@Override
	public MasterResponseDto getAllCities() {
		log.info("inside getAllCites service");
		log.debug("inside getAllCites service");
		MasterResponseDto citiesResp = new MasterResponseDto();
		List<CityMasterEntity> citiesList = cityMasterRepo.findAll();
		if (citiesList.isEmpty()) {
			citiesResp.setStatusCode(1);
			citiesResp.setMessage("Cities not available");
			citiesResp.setData(null);	
		} else {
			citiesResp.setStatusCode(0);
			citiesResp.setMessage("success");
			citiesResp.setData(citiesList);	
		}
		return citiesResp;
	}

	@Override
	public MasterResponseDto getCitiesByStateCode(CityRequestDto reqDto) {
		log.info("inside getCitiesByStateCode service");
		log.debug("inside getCitiesByStateCode service");
		MasterResponseDto citiesResp = new MasterResponseDto();
		List<CityMasterEntity> citiesList = cityMasterRepo.findByStateCode(reqDto.getStateCode());
		if (citiesList.isEmpty()) {
			citiesResp.setStatusCode(1);
			citiesResp.setMessage("Cities not available");
			citiesResp.setData(null);	
		} else {
			citiesResp.setStatusCode(0);
			citiesResp.setMessage("success");
			citiesResp.setData(citiesList);	
		}
		return citiesResp;
	}
}
