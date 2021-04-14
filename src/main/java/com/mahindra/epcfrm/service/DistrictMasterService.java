package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.dto.MasterResponseDto;

public interface DistrictMasterService {

	MasterResponseDto getDistrictsByStateWise(int stateCode);
}
