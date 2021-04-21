package com.mahindra.epcfrm.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.DashBoardCountResponseDto;
import com.mahindra.epcfrm.dto.DashBoardLeadsResponseDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.service.DashBoardApiService;

@Service
public class DashBoardApiServiceImpl implements DashBoardApiService {

	Logger log = LoggerFactory.getLogger(DashBoardApiServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;

	@SuppressWarnings("unused")

	@Override
	public MasterResponseDto getCountsOnStatus() {
		log.info("inside getCountsOnStatus service");
		log.debug("inside getCountsOnStatus service");
		MasterResponseDto masterRes = new MasterResponseDto();
		DashBoardCountResponseDto dbCRes = new DashBoardCountResponseDto();
		List<LeadMasterEntity> leadsList = leadMasterRepo.findLeads();
		List<LeadMasterEntity> woPendLeads = leadsList.stream()
				.filter(e -> e.getWorkOrderStatus().equalsIgnoreCase("WoPending")).collect(Collectors.toList());
		List<LeadMasterEntity> kycPendLeads = leadsList.stream()
				.filter(e -> e.getKycStatus().equalsIgnoreCase("KycPending")).collect(Collectors.toList());
		List<LeadMasterEntity> qtpPendLeads = leadsList.stream()
				.filter(e -> e.getQuotationStatus().equalsIgnoreCase("QuPending")).collect(Collectors.toList());
		dbCRes.setWorkOrderStatusCount(woPendLeads.size());
		dbCRes.setKycStatusCount(kycPendLeads.size());
		dbCRes.setQuotaionStatusCount(qtpPendLeads.size());
		if (dbCRes != null) {
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(dbCRes);
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Count is not available");
			masterRes.setData(null);
		}
		return masterRes;
	}

	@SuppressWarnings("unused")
	@Override
	public MasterResponseDto getListOfPendingLeads(DashBoardCountRequestDto reqDto) {
		log.info("inside getListOfPendingLeads service");
		log.debug("inside getListOfPendingLeads service");
		MasterResponseDto masterRes = new MasterResponseDto();
		DashBoardLeadsResponseDto dbLRes = new DashBoardLeadsResponseDto();
		List<LeadMasterEntity> leadList = new ArrayList<>();
		List<LeadMasterEntity> allLeadsList = leadMasterRepo.findLeads();
		
		String tag = reqDto.getTag();
		masterRes.setStatusCode(0);
		masterRes.setMessage("success");
		masterRes.setData(dbLRes);
		if (tag.equalsIgnoreCase("WOP")) {
			leadList = allLeadsList.stream()
					.filter(e -> e.getWorkOrderStatus().equalsIgnoreCase("WoPending")).collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else if (tag.equalsIgnoreCase("KYC")) {
			leadList = allLeadsList.stream()
					.filter(e -> e.getKycStatus().equalsIgnoreCase("KycPending")).collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else if (tag.equalsIgnoreCase("QTP")) {
			leadList = allLeadsList.stream()
					.filter(e -> e.getQuotationStatus().equalsIgnoreCase("QuPending")).collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage("Leads is not available");
			masterRes.setData(null);
		}
		return masterRes;
	}
}
