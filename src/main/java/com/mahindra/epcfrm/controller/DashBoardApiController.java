package com.mahindra.epcfrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.service.DashBoardApiService;

@RestController
@RequestMapping("/epc/")
public class DashBoardApiController {

	Logger log = LoggerFactory.getLogger(DashBoardApiController.class);
	
	@Autowired
	DashBoardApiService dashBordService;
	
	@GetMapping(value = "getCountOnStatus")
	public MasterResponseDto getCountOnStatus() throws Exception {
		log.info("request processing of getCountOnStatus in dashBoardController");
		return dashBordService.getCountsOnStatus();
	}
	
	@PostMapping(value = "getLeadsOnPenStatus")
	public MasterResponseDto getLeadsOnPenStatus(@RequestBody DashBoardCountRequestDto reqDto) throws Exception {
		log.info("request processing of getLeadsOnPenStatus in dashBoardController");
		return dashBordService.getListOfPendingLeads(reqDto);
	}
	
	
}
