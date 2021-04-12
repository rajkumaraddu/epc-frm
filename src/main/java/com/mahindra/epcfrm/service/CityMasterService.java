package com.mahindra.epcfrm.service;

import java.util.List;

import com.mahindra.epcfrm.dto.CityRequestDto;
import com.mahindra.epcfrm.entity.CityMasterEntity;

public interface CityMasterService {
 
	List<CityMasterEntity> getAllCities(CityRequestDto reqDto);
}
