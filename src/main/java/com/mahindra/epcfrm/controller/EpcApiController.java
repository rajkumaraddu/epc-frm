/**
 * 
 */
package com.mahindra.epcfrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mahindra.epcfrm.dto.ApiResponseDto;
import com.mahindra.epcfrm.dto.CityRequestDto;
import com.mahindra.epcfrm.dto.CreateUpdateRespDto;
import com.mahindra.epcfrm.dto.DistrictRequestDto;
import com.mahindra.epcfrm.dto.FormerOtpRequestDto;
import com.mahindra.epcfrm.dto.FarmerMasterDto;
import com.mahindra.epcfrm.dto.KycMasterDto;
import com.mahindra.epcfrm.dto.LeadMasterDataRespDto;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.MaterialDeliveryMasterDto;
import com.mahindra.epcfrm.dto.MaterialInstallationMasterDto;
import com.mahindra.epcfrm.dto.RegistrationDetailsMasterDto;
import com.mahindra.epcfrm.dto.SiteSurveyMasterDto;
import com.mahindra.epcfrm.entity.MaterialDeliveryMaster;														 
import com.mahindra.epcfrm.service.CityMasterService;
import com.mahindra.epcfrm.service.CropMasterService;
import com.mahindra.epcfrm.service.DistrictMasterService;
import com.mahindra.epcfrm.service.EpcService;
import com.mahindra.epcfrm.service.LeadMasterService;
import com.mahindra.epcfrm.service.LoginService;
import com.mahindra.epcfrm.service.StateMasterService;

/**
 * @author Raju.Addu
 *
 */
@RestController
@RequestMapping("/epc/")
public class EpcApiController {

	Logger log = LoggerFactory.getLogger(EpcApiController.class);

	@Autowired
	LeadMasterService leadMasterService;
	@Autowired
	StateMasterService stateMasterService;
	@Autowired
	CropMasterService cropMasterService;

	@Autowired
	DistrictMasterService districtMasterService;

	@Autowired
	CityMasterService cityMasterService;

	@Autowired
	EpcService epcService;
	@Autowired
	private LoginService loginService;

	@GetMapping("getLead")
	public String getLead() {
		return "lead generated";
	}

	@GetMapping("/")
	public String getWelcome() {
		return "Welcome to EPC!";
	}

	@PostMapping("/getFormerOtp")
	public ResponseEntity<CreateUpdateRespDto> getFormerOtp(@RequestBody FormerOtpRequestDto formerReqDto,
			HttpSession session) {
		ApiResponseDto apiRespDto = null;
		CreateUpdateRespDto resp = new CreateUpdateRespDto();
		int leadId = formerReqDto.getLeadId();
		String mobile = formerReqDto.getFormarMobileNo();
		String otpType = formerReqDto.getOtpType();
		apiRespDto = loginService.getOtp(mobile, "Former", leadId, otpType, session);
		if(apiRespDto != null) {
			resp.setStatusCode(1);
			resp.setMessage(apiRespDto.getMessage());
			if("success".equalsIgnoreCase(apiRespDto.getStatus())) {
				resp.setStatusCode(0);
				resp.setMessage("OTP is sent to Mobile No. ending with "+apiRespDto.getMobile());
			}
		}
		return ResponseEntity.ok(resp);
	}
	
	@PostMapping("/validateFormerOtp")
	public ResponseEntity<CreateUpdateRespDto> validateFormerOtp(@RequestBody FormerOtpRequestDto formerReqDto,
			HttpSession session){
		int leadId = formerReqDto.getLeadId();
		String mobile = formerReqDto.getFormarMobileNo();
		String otpType = formerReqDto.getOtpType();
		String otp = formerReqDto.getOtp();
		return ResponseEntity.ok(loginService.validateFormerOtp(mobile, leadId, otp, otpType, session));
	}

	@PostMapping(value = "lead/creation", produces = MediaType.APPLICATION_JSON_VALUE)
	public MasterResponseDto leadCreation(@RequestPart LeadMasterDto leadMasterDTO,
			@RequestPart(value = "farmerPhoto", required = false) MultipartFile farmerPhoto,
			@RequestPart(value = "waterTestDoc", required = false) MultipartFile waterTestDoc,
			@RequestPart(value = "soilTestDoc", required = false) MultipartFile soilTestDoc,
			@RequestPart(value = "bankDoc", required = false) MultipartFile bankDoc,
			@RequestPart(value = "aadharCard", required = false) MultipartFile aadharCard,
			@RequestPart(value = "rationCard", required = false) MultipartFile rationCard,
			@RequestPart(value = "patta", required = false) MultipartFile patta,
			@RequestPart(value = "chitta", required = false) MultipartFile chitta,
			@RequestPart(value = "surveyCaptureImage", required = false) MultipartFile surveyCaptureImage,
			@RequestPart(value = "gpsCaptureImage", required = false) MultipartFile gpsCaptureImage,
			@RequestPart(value = "otherDoc", required = false) MultipartFile otherDoc,
			@RequestPart(value = "attachment1", required = false) MultipartFile attachment1,
			@RequestPart(value = "attachmentSurvey2", required = false) MultipartFile attachmentSurvey2,
			@RequestPart(value = "instReportPhotos", required = false) MultipartFile[] instReportPhotos,
			@RequestPart(value = "instReportVideo", required = false) MultipartFile instReportVideo,
			@RequestPart(value = "deliveryChalan", required = false) MultipartFile[] deliveryChalan) {
		log.info("request processing leadCreation");
		return leadMasterService.leadCreation(leadMasterDTO, farmerPhoto, waterTestDoc, soilTestDoc, bankDoc,
				aadharCard, rationCard, patta, chitta, surveyCaptureImage, gpsCaptureImage, otherDoc, attachment1,
				attachmentSurvey2, instReportPhotos, instReportVideo, deliveryChalan);
	}

	@PostMapping(value = "leadSearch")
	public MasterResponseDto leadSearch(@RequestBody LeadSearchDto leadSearchDTO) throws Exception {
		log.info("request processing of leadSearch");
		return leadMasterService.leadSearch(leadSearchDTO);
	}

	@GetMapping(value = "getAllStates")
	public MasterResponseDto getAllStates() throws Exception {
		log.info("request processing of getAllStates");
		return stateMasterService.getAllStates();
	}

	@GetMapping(value = "getAllCrops")
	public MasterResponseDto getAllCrops() throws Exception {
		log.info("request processing of getAllCrops");
		return cropMasterService.getAllCrops();
	}

	@GetMapping(value = "getDistricts")
	public MasterResponseDto getDistricts(@RequestBody DistrictRequestDto reqDto) throws Exception {
		log.info("request processing of getDistricts");
		return districtMasterService.getDistrictsByStateWise(reqDto.getStateCode());
	}

	@GetMapping(value = "getCitiesByStateCode")
	public MasterResponseDto getCitiesByStateCode(@RequestBody CityRequestDto reqDto) throws Exception {
		log.info("request processing of getAllCities");
		return cityMasterService.getCitiesByStateCode(reqDto);

	}

	@GetMapping(value = "getAllCities")
	public MasterResponseDto getAllCities() throws Exception {
		log.info("request processing of getAllCities");
		return cityMasterService.getAllCities();
	}

	@GetMapping("getAllDealers")
	public MasterResponseDto getAllDealers() {
		return epcService.getAllDealers();
	}

	@GetMapping("getSubsidy")
	public MasterResponseDto getSubsidy(@RequestParam int stateCode) {
		return epcService.getSubsidy(stateCode);
	}

	@GetMapping("getAllSubsidy")
	public MasterResponseDto getAllSubsidy() {
		return epcService.getAllSubsidy();
	}

	@GetMapping("getLeadMasterData")
	public LeadMasterDataRespDto getLeadMasterData() {
		return epcService.getLeadMasterData();
	}


	// next apis multiple partition apis for lead creation

	@PostMapping(value = "farmerInfoReg")
	public MasterResponseDto farmerInfoSave(@RequestBody FarmerMasterDto farmerMasterDto) {
		log.info("request processing of farmerInfoSave");
		return leadMasterService.farmerInfoReg(farmerMasterDto);
	}

	@PostMapping(value = "siteSurveyReg")
	public MasterResponseDto siteSurveyReg(@RequestPart SiteSurveyMasterDto siteSurveyDto,
			@RequestPart(value = "iniQuAttachment", required = false) MultipartFile iniQuAttachment) {
		log.info("request processing of siteSurveyReg");
		return leadMasterService.siteSurveyReg(siteSurveyDto,iniQuAttachment);
	}
	
	
	@PostMapping(value = "kycReg")
	public MasterResponseDto kycReg(@RequestPart KycMasterDto kycMasterDto,
			@RequestPart(value = "farmerPhoto", required = false) MultipartFile farmerPhoto,
			@RequestPart(value = "waterTestDoc", required = false) MultipartFile waterTestDoc,
			@RequestPart(value = "soilTestDoc", required = false) MultipartFile soilTestDoc,
			@RequestPart(value = "bankDoc", required = false) MultipartFile bankDoc,
			@RequestPart(value = "aadharCard", required = false) MultipartFile aadharCard,
			@RequestPart(value = "rationCard", required = false) MultipartFile rationCard,
			@RequestPart(value = "patta", required = false) MultipartFile patta,
			@RequestPart(value = "chitta", required = false) MultipartFile chitta,
			@RequestPart(value = "surveyCaptureImage", required = false) MultipartFile surveyCaptureImage,
			@RequestPart(value = "gpsCaptureImage", required = false) MultipartFile gpsCaptureImage,
			@RequestPart(value = "otherDoc", required = false) MultipartFile otherDoc) {
		log.info("request processing of kycReg");
		return leadMasterService.kycReg(kycMasterDto, farmerPhoto, waterTestDoc,
				soilTestDoc, bankDoc, aadharCard,rationCard, patta, chitta, 
				surveyCaptureImage, gpsCaptureImage,otherDoc);
	}
	
	
	@PostMapping(value = "materialDeliReg")
	public MasterResponseDto materialDeliReg(@RequestPart MaterialDeliveryMasterDto mDMDto,
			@RequestPart(value = "materialPhotos", required = false) MultipartFile[] materialPhotos,
			@RequestPart(value = "uploadVideo", required = false) MultipartFile uploadVideo,
			@RequestPart(value = "perInvoicePhoto", required = false) MultipartFile perInvoicePhoto,
			@RequestPart(value = "deliveryChalan", required = false) MultipartFile[] deliveryChalan) {
			log.info("request processing of materialDeliReg");
		return leadMasterService.materialDeliveryReg(mDMDto,materialPhotos, uploadVideo, perInvoicePhoto, deliveryChalan);
	}
	
	@PostMapping(value = "saveRegDetails")
	public MasterResponseDto saveRegDetails(@RequestPart RegistrationDetailsMasterDto regDMDto,
			@RequestPart(value = "quotAttachment", required = false) MultipartFile quotAttachment,
			@RequestPart(value = "ddAttachment", required = false) MultipartFile ddAttachment,
			@RequestPart(value = "faAcceptAttachment", required = false) MultipartFile faAcceptAttachment) {
			log.info("request processing of materialDeliReg");
		return leadMasterService.saveRegDetails(regDMDto, quotAttachment, ddAttachment, faAcceptAttachment);
	}
	
	
	@PostMapping(value = "materialInstaReg")
	public MasterResponseDto materialInstaReg(@RequestPart MaterialInstallationMasterDto mIMDto,
			@RequestPart(value = "instaMaterialPhotos", required = false) MultipartFile[] instaMaterialPhotos,
			@RequestPart(value = "uploadMIVideo", required = false) MultipartFile instVideo,
			@RequestPart(value = "deliveryChalan", required = false) MultipartFile[] deliveryChalan) {
			log.info("request processing of materialInstallation Reg");
		return leadMasterService.materialInstaReg(mIMDto,instaMaterialPhotos, instVideo, deliveryChalan);
	}

}
