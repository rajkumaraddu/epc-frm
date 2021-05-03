package com.mahindra.epcfrm.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahindra.epcfrm.dto.ActivityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.service.DashBoardApiService;

@RestController
@RequestMapping("/epc/")
public class DashBoardApiController {

	Logger log = LoggerFactory.getLogger(DashBoardApiController.class);
	
	@Autowired
	DashBoardApiService dashboardService;
	
	@GetMapping(value = "getCountOnStatus")
	public MasterResponseDto getCountOnStatus() throws Exception {
		log.info("request processing of getCountOnStatus in dashBoardController");
		return dashboardService.getCountsOnStatus();
	}
	
	@PostMapping(value = "getLeadsOnPenStatus")
	public MasterResponseDto getLeadsOnPenStatus(@RequestBody DashBoardCountRequestDto reqDto) throws Exception {
		log.info("request processing of getLeadsOnPenStatus in dashBoardController");
		return dashboardService.getListOfPendingLeads(reqDto);
	}
	
	@PostMapping("/createUpdateActivity")
	public CreateUpdateRespDto createUpdateActivity(@RequestBody ActivityRequestDto actReqDto,HttpSession session) {
		return dashboardService.createUpdateActivity(actReqDto,session);
	}
	
	@GetMapping("/getActivity")
	public MasterResponseDto getActivity(@RequestParam String date,HttpSession session) {
		return dashboardService.getActivity(date,session);
	}
	
	
}
