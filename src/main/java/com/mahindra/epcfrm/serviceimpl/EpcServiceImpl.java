/**
 * 
 */
package com.mahindra.epcfrm.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindra.epcfrm.dto.CropRespDto;
import com.mahindra.epcfrm.dto.DlrRespDto;
import com.mahindra.epcfrm.dto.LeadMasterDataRespDto;
import com.mahindra.epcfrm.dto.MISRespDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.StateSubsidyRespDto;
import com.mahindra.epcfrm.entity.CropMasterEntity;
import com.mahindra.epcfrm.entity.EpcDealerMasterEntity;
import com.mahindra.epcfrm.entity.MISProductEntity;
import com.mahindra.epcfrm.entity.StateMasterEntity;
import com.mahindra.epcfrm.entity.SubsidyMasterEntity;
import com.mahindra.epcfrm.repository.CropMasterRepo;
import com.mahindra.epcfrm.repository.EpcDealerMasterRepo;
import com.mahindra.epcfrm.repository.MISProductRepo;
import com.mahindra.epcfrm.repository.StateMasterRepo;
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
	@Autowired
	StateMasterRepo stateRepo;
	@Autowired
	CropMasterRepo cropRepo;
	@Autowired
	MISProductRepo misRepo;

	Logger log = LoggerFactory.getLogger(EpcServiceImpl.class);
	LeadMasterDataRespDto resp = new LeadMasterDataRespDto();
	private static final String SUCCESSMSG = "success";

	@Override
	public MasterResponseDto getAllDealers() {
		MasterResponseDto dealerResp = new MasterResponseDto();
		List<EpcDealerMasterEntity> dlrMstList = dlrMstRepo.findAll();
		if (dlrMstList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("Dealers not available");
			dealerResp.setData(null);
		} else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage(SUCCESSMSG);
			dealerResp.setData(dlrMstList);
		}
		return dealerResp;
	}

	@Override
	public MasterResponseDto getSubsidy(int stateCode) {
		List<SubsidyMasterEntity> subsidyList = subsidyRepo.findByStateCode(stateCode);
		MasterResponseDto dealerResp = new MasterResponseDto();
		if (subsidyList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("Subsidy not available");
			dealerResp.setData(null);
		} else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage(SUCCESSMSG);
			dealerResp.setData(subsidyList);
		}
		return dealerResp;
	}

	@Override
	public MasterResponseDto getAllSubsidy() {
		List<SubsidyMasterEntity> subsidyList = subsidyRepo.findAll();
		MasterResponseDto dealerResp = new MasterResponseDto();
		if (subsidyList.isEmpty()) {
			dealerResp.setStatusCode(1);
			dealerResp.setMessage("Subsidy not available");
			dealerResp.setData(null);
		} else {
			dealerResp.setStatusCode(0);
			dealerResp.setMessage(SUCCESSMSG);
			dealerResp.setData(subsidyList);
		}
		return dealerResp;
	}

	@Override
	public LeadMasterDataRespDto getLeadMasterData() {
		List<EpcDealerMasterEntity> dlrMstList = dlrMstRepo.findAll();
		List<SubsidyMasterEntity> subsidyList = subsidyRepo.findAll();
		List<StateMasterEntity> stateList = stateRepo.findAll();
		List<CropMasterEntity> cropsList = cropRepo.findAll();
		List<MISProductEntity> misProdList = misRepo.findAll();

		resp = this.getDlrResp(dlrMstList);
		resp = this.getStSubResp(stateList, subsidyList);
		resp = this.getCropsResp(cropsList);
		resp = this.getMisResp(misProdList);

		if (dlrMstList.isEmpty() && stateList.isEmpty() && cropsList.isEmpty() && misProdList.isEmpty()) {
			resp.setStatusCode(1);
			resp.setMessage("no-data");
		}
		return resp;
	}

	/**
	 * @param misProdList
	 * @return
	 */
	private LeadMasterDataRespDto getMisResp(List<MISProductEntity> misProdList) {
		List<MISRespDto> misProducts = new ArrayList<>();
		if (!misProdList.isEmpty()) {
			for (MISProductEntity mis : misProdList) {
				MISRespDto misDto = new MISRespDto();
				misDto.setId(mis.getId());
				misDto.setMisName(mis.getMisProductName());
				misProducts.add(misDto);
			}
			resp.setMisProducts(misProducts);
			resp.setStatusCode(0);
			resp.setMessage(SUCCESSMSG);
		} else {
			resp.setStatusCode(2);
			resp.setMessage(resp.getMessage().isEmpty() || SUCCESSMSG.equalsIgnoreCase(resp.getMessage()) ? "no-mis"
					: resp.getMessage() + " and no-mis");
		}
		return resp;
	}

	/**
	 * @param cropsList
	 * @param resp
	 * @return
	 */
	private LeadMasterDataRespDto getCropsResp(List<CropMasterEntity> cropsList) {
		List<CropRespDto> crops = new ArrayList<>();
		if (!cropsList.isEmpty()) {
			for (CropMasterEntity crp : cropsList) {
				CropRespDto crop = new CropRespDto();
				crop.setId(crp.getId());
				crop.setCropName(crp.getCropName());
				crops.add(crop);
			}
			resp.setCrops(crops);
			resp.setStatusCode(0);
			resp.setMessage(SUCCESSMSG);
		} else {
			resp.setStatusCode(2);
			resp.setMessage(resp.getMessage().isEmpty() || SUCCESSMSG.equalsIgnoreCase(resp.getMessage()) ? "no-crops"
					: resp.getMessage() + " and no-crops");
		}
		return resp;
	}

	/**
	 * @param stateList
	 * @param subsidyList
	 * @param resp
	 * @return
	 */
	private LeadMasterDataRespDto getStSubResp(List<StateMasterEntity> stateList,
			List<SubsidyMasterEntity> subsidyList) {
		List<StateSubsidyRespDto> stateAndSubsidy = new ArrayList<>();
		if (!stateList.isEmpty()) {
			for (StateMasterEntity st : stateList) {
				StateSubsidyRespDto stSub = new StateSubsidyRespDto();
				List<SubsidyMasterEntity> subsidyList1 = subsidyList.isEmpty() ? null
						: subsidyList.stream().filter(c -> c.getStateCode() == st.getStateCode())
								.collect(Collectors.toList());
				double strSubsidy = subsidyList1 == null ? 0 : subsidyList1.get(0).getSubsidy();
				stSub.setId(st.getId());
				stSub.setStateCode(st.getStateCode());
				stSub.setStateName(st.getStateName());
				stSub.setStateOrUT(st.getStateOrUT());
				stSub.setSubsidy(strSubsidy);
				stateAndSubsidy.add(stSub);
			}
			resp.setStateAndSubsidy(stateAndSubsidy);
			resp.setStatusCode(0);
			resp.setMessage(SUCCESSMSG);
		} else {
			resp.setStatusCode(2);
			resp.setMessage(resp.getMessage().isEmpty() || SUCCESSMSG.equalsIgnoreCase(resp.getMessage()) ? "no-states"
					: resp.getMessage() + " and no-states");
		}
		return resp;
	}

	/**
	 * @param dlrMstList
	 * @param resp
	 * @return
	 */
	private LeadMasterDataRespDto getDlrResp(List<EpcDealerMasterEntity> dlrMstList) {
		List<DlrRespDto> dealers = new ArrayList<>();
		if (!dlrMstList.isEmpty()) {
			for (EpcDealerMasterEntity dlr : dlrMstList) {
				DlrRespDto dealer = new DlrRespDto();
				dealer.setId(dlr.getId());
				dealer.setDealerCode(dlr.getDealerCode());
				dealer.setFirstName(dlr.getFirstName());
				dealer.setLastName(dlr.getLastName());
				dealer.setEmployeeType(dlr.getEmployeeType());
				dealer.setAsmCode(dlr.getAsmCode());
				dealer.setAsmName(dlr.getAsmName());
				dealers.add(dealer);
			}
			resp.setDealers(dealers);
			resp.setStatusCode(0);
			resp.setMessage(SUCCESSMSG);
		} else {
			resp.setStatusCode(2);
			resp.setMessage("no-dealers");
		}
		return resp;
	}

}
