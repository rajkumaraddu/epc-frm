package com.mahindra.epcfrm.service;

import org.springframework.web.multipart.MultipartFile;

import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;

public interface LeadMasterService {

	public LeadMasterEntity leadCreation(LeadMasterDto leadMasterDTO, MultipartFile farmerPhoto,
			MultipartFile waterTestDoc, MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard,
			MultipartFile rationCard, MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage,
			MultipartFile gpsCaptureImage, MultipartFile otherDoc, MultipartFile attachment1,
			MultipartFile attachmentSurvey2, MultipartFile[] instReportPhoto, MultipartFile instReportVideo,
			MultipartFile[] deliverChalan);

	public LeadMasterEntity leadSearch(LeadSearchDto searchDTO) throws Exception;

}
