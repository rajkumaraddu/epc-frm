/**
 * 
 */
package com.mahindra.epcfrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mahindra.epcfrm.entity.CropMasterEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.entity.StateMasterEntity;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.ResponseDto;
import com.mahindra.epcfrm.service.CropMasterService;
import com.mahindra.epcfrm.service.LeadMasterService;
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

	@GetMapping("getLead")
	public String getLead() {
		return "lead generated";
	}
	@GetMapping("/")
	private String getWelcome() {
		return "Welcome to EPC!";
	}

	// @PostMapping(value = "lead/creation")
	@PostMapping(value = "lead/creation",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto leadCreation(@RequestPart LeadMasterDto leadMasterDTO,
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
		ResponseDto res = new ResponseDto();
		LeadMasterEntity leadCreation = leadMasterService.leadCreation(leadMasterDTO, farmerPhoto, waterTestDoc,
				soilTestDoc, bankDoc, aadharCard, rationCard, patta, chitta, surveyCaptureImage, gpsCaptureImage,
				otherDoc, attachment1, attachmentSurvey2, instReportPhotos, instReportVideo,deliveryChalan);
		res.setData(leadCreation);
		res.setStatus(200);
		res.setSuccess(true);
		res.setMessage("Success fully lead generated");
		return res;
	}

	@PostMapping(value = "leadSearch")
	public ResponseDto leadSearch(@RequestBody LeadSearchDto leadSearchDTO) throws Exception {
		log.info("request processing of leadSearch");
		LeadMasterEntity leadSearch = leadMasterService.leadSearch(leadSearchDTO);
		ResponseDto res = new ResponseDto();
		res.setData(leadSearch);
		res.setStatus(200);
		res.setMessage("Successful lead fetched");
		res.setSuccess(true);
		return res;
	}

	@GetMapping(value = "getAllStates")
	public ResponseDto getAllStates() throws Exception {
		log.info("request processing of getAllStates");
		ResponseDto res = new ResponseDto();
		List<StateMasterEntity> allStates = stateMasterService.getAllStates();
		res.setData(allStates);
		res.setStatus(200);
		res.setMessage("Successful states fetched");
		res.setSuccess(true);
		return res;
	}

	@GetMapping(value = "getAllCrops")
	public ResponseDto getAllCrops() throws Exception {
		log.info("request processing of getAllCrops");
		ResponseDto res = new ResponseDto();
		List<CropMasterEntity> allCrops = cropMasterService.getAllCrops();
		res.setData(allCrops);
		res.setStatus(200);
		res.setMessage("Successful crops fetched");
		res.setSuccess(true);
		return res;
	}

}
