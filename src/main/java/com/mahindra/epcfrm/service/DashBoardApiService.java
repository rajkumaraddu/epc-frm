package com.mahindra.epcfrm.service;

import javax.servlet.http.HttpSession;

import com.mahindra.epcfrm.dto.ActivityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;

public interface DashBoardApiService {
	
	MasterResponseDto getCountsOnStatus();

	MasterResponseDto getListOfPendingLeads(DashBoardCountRequestDto reqDto);

	/**
	 * @param date
	 * @param request 
	 * @return
	 */
	MasterResponseDto getActivity(String date, HttpSession session);

	/**
	 * @param actReqDto
	 * @param session
	 * @return
	 */
	CreateUpdateRespDto createUpdateActivity(ActivityRequestDto actReqDto, HttpSession session);
}
