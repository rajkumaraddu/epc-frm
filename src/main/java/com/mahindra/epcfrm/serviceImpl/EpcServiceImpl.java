/**
 * 
 */
package com.mahindra.epcfrm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.entity.EpcDealerMasterEntity;
import com.mahindra.epcfrm.entity.SubsidyMasterEntity;
import com.mahindra.epcfrm.repository.EpcDealerMasterRepo;
import com.mahindra.epcfrm.repository.SubsidyMasterRepo;
import com.mahindra.epcfrm.service.EpcService;

/**
 * @author Raju.Addu
 *
 */
@Service
public class EpcServiceImpl implements EpcService {
	@Autowired
	EpcDealerMasterRepo dlrMstRepo;
	@Autowired
	SubsidyMasterRepo subsidyRepo;

	@Override
	public MasterResponseDto getAllDealers() {
		MasterResponseDto dealerResp = new MasterResponseDto();
		List<EpcDealerMasterEntity> dlrMstList = dlrMstRepo.findAll();
		if(dlrMstList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("Dealers not available");
			dealerResp.setData(null);			
		}else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage("success");
			dealerResp.setData(dlrMstList);	
		}
		return dealerResp;
	}

	@Override
	public MasterResponseDto getSubsidy(int stateCode) {
		List<SubsidyMasterEntity> subsidyList = subsidyRepo.findByStateCode(stateCode); 
		MasterResponseDto dealerResp = new MasterResponseDto();
		if(subsidyList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("Subsidy not available");
			dealerResp.setData(null);			
		}else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage("success");
			dealerResp.setData(subsidyList);	
		}
		return dealerResp;
	}
}
