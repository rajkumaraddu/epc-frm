package com.mahindra.epcfrm.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.ActivityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DashBoardCountRequestDto;
import com.mahindra.epcfrm.dto.DashBoardCountResponseDto;
import com.mahindra.epcfrm.dto.DashBoardLeadsResponseDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.ActivityHistoryEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.repository.ActivityHistoryRepo;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.service.DashBoardApiService;

@Service
public class DashBoardApiServiceImpl implements DashBoardApiService {

	Logger log = LoggerFactory.getLogger(DashBoardApiServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;
	@Autowired
	ActivityHistoryRepo activityRepo;

	private static final String SUCCESSMSG = "success";

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
			masterRes.setMessage(SUCCESSMSG);
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
		masterRes.setMessage(SUCCESSMSG);
		masterRes.setData(dbLRes);
		if (tag.equalsIgnoreCase("WOP")) {
			leadList = allLeadsList.stream().filter(e -> e.getWorkOrderStatus().equalsIgnoreCase("WoPending"))
					.collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else if (tag.equalsIgnoreCase("KYC")) {
			leadList = allLeadsList.stream().filter(e -> e.getKycStatus().equalsIgnoreCase("KycPending"))
					.collect(Collectors.toList());
			dbLRes.setLeadsOnWoPending(leadList);
			log.info("count of leadList:" + leadList.size());
			masterRes.setData(dbLRes);
		} else if (tag.equalsIgnoreCase("QTP")) {
			leadList = allLeadsList.stream().filter(e -> e.getQuotationStatus().equalsIgnoreCase("QuPending"))
					.collect(Collectors.toList());
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

	@Override
	public MasterResponseDto getActivity(String date, HttpSession session) {
		String user = (String) session.getAttribute("loginUser");
		log.info("user name is {}", user);
		LocalDate activityDate = date == null ? LocalDate.now() : LocalDate.parse(date);
		log.info("activityDate {}", activityDate);
		List<ActivityHistoryEntity> activityList = activityRepo.getActivity(user, activityDate);

		MasterResponseDto dealerResp = new MasterResponseDto();
		if (activityList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("No activity found");
			dealerResp.setData(null);
		} else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage(SUCCESSMSG);
			dealerResp.setData(activityList);
		}
		return dealerResp;

	}

	@Override
	public CreateUpdateRespDto createUpdateActivity(ActivityRequestDto actReqDto, HttpSession session) {

		CreateUpdateRespDto respDto = new CreateUpdateRespDto();
		
		if (actReqDto == null) {
			respDto.setStatusCode(1);
			respDto.setMessage("Requested with no-data");
			return respDto;
		} else if (actReqDto.getDate() == null || actReqDto.getFromTime() == null || actReqDto.getToTime() == null) {
			respDto.setStatusCode(1);
			respDto.setMessage("Mandatory field(s) found empty");
			return respDto;
		} else if (LocalDate.now().isAfter(actReqDto.getDate())) {
			respDto.setStatusCode(1);
			respDto.setMessage("Activity date should be greaterthan or equals to the current date");
			return respDto;
		} else {
			String user = (String) session.getAttribute("loginUser");
			ActivityHistoryEntity activityEntity = new ActivityHistoryEntity();
			LocalDate activityDate = actReqDto.getDate();
			LocalTime fromTime = actReqDto.getFromTime();
			ActivityHistoryEntity activityDb = activityRepo.getUserActivity(user, activityDate, fromTime);
			
			if(activityDb == null) {
				activityEntity.setCreatedBy(user);
				activityEntity.setActivityType(actReqDto.getActivityType());
				activityEntity.setArea(actReqDto.getArea());
				activityEntity.setCustomerMobile(actReqDto.getCustomerMobile());
				activityEntity.setCustomerName(actReqDto.getCustomerName());
				activityEntity.setDate(activityDate);
				activityEntity.setFromTime(actReqDto.getFromTime());
				activityEntity.setToTime(actReqDto.getToTime());
				activityEntity.setIrrSystem(actReqDto.getIrrSystem());
				activityEntity.setPin(actReqDto.getPin());
				activityEntity.setUserId(user);
				activityEntity.setVillage(actReqDto.getVillage());
				activityRepo.save(activityEntity);
				
				respDto.setStatusCode(0);
				respDto.setMessage("Activity created");
			}else {
				activityDb.setModifiedBy(user);
				activityDb.setActivityType(actReqDto.getActivityType());
				activityDb.setArea(actReqDto.getArea());
				activityDb.setCustomerMobile(actReqDto.getCustomerMobile());
				activityDb.setCustomerName(actReqDto.getCustomerName());
				activityDb.setDate(activityDate);
				activityDb.setFromTime(actReqDto.getFromTime());
				activityDb.setToTime(actReqDto.getToTime());
				activityDb.setIrrSystem(actReqDto.getIrrSystem());
				activityDb.setPin(actReqDto.getPin());
				activityDb.setUserId(user);
				activityDb.setVillage(actReqDto.getVillage());
				activityRepo.save(activityDb);
				
				respDto.setStatusCode(0);
				respDto.setMessage("Activity updated");
			}

			return respDto;
		}
	}
}
