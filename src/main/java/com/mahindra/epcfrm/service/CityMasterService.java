package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.dto.CityRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;

public interface CityMasterService {
 
	MasterResponseDto getAllCities();
	MasterResponseDto getCitiesByStateCode(CityRequestDto reqDto);

}
