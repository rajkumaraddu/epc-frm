package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;

public interface DashBoardApiService {
	
	MasterResponseDto getCountsOnStatus();

	MasterResponseDto getListOfPendingLeads(DashBoardCountRequestDto reqDto);
}
