package com.mahindra.epcfrm.service;

import org.springframework.web.multipart.MultipartFile;

import com.mahindra.epcfrm.dto.FarmerMasterDto;
import com.mahindra.epcfrm.dto.KycMasterDto;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.MaterialDeliveryMasterDto;
import com.mahindra.epcfrm.dto.MaterialInstallationMasterDto;
import com.mahindra.epcfrm.dto.RegistrationDetailsMasterDto;
import com.mahindra.epcfrm.dto.SiteSurveyMasterDto;
import com.mahindra.epcfrm.entity.RegistrationDetailsMasterEntity;

public interface LeadMasterService {

	public MasterResponseDto leadCreation(LeadMasterDto leadMasterDTO, MultipartFile farmerPhoto,
			MultipartFile waterTestDoc, MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard,
			MultipartFile rationCard, MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage,
			MultipartFile gpsCaptureImage, MultipartFile otherDoc, MultipartFile attachment1,
			MultipartFile attachmentSurvey2, MultipartFile[] instReportPhoto, MultipartFile instReportVideo,
			MultipartFile[] deliverChalan);

	public MasterResponseDto leadSearch(LeadSearchDto searchDTO) throws Exception;
	
	public MasterResponseDto farmerInfoReg(FarmerMasterDto farmerMDto);
	
	public MasterResponseDto siteSurveyReg(SiteSurveyMasterDto siteSurveyMDto,MultipartFile iniQuotAttachment);
	
	public MasterResponseDto kycReg(KycMasterDto kycMDto, MultipartFile farmerPhoto,
			MultipartFile waterTestDoc, MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard,
			MultipartFile rationCard, MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage,
			MultipartFile gpsCaptureImage, MultipartFile otherDoc);

    public MasterResponseDto materialDeliveryReg(MaterialDeliveryMasterDto mdMDto,
    		 MultipartFile[] instReportPhoto, MultipartFile instReportVideo,MultipartFile perInvoicePhoto,
 			MultipartFile[] deliverChalan);
    
    public MasterResponseDto saveRegDetails(RegistrationDetailsMasterDto regDMDto,MultipartFile quotAttachment,
    		MultipartFile ddAttachment,
    		MultipartFile faAcceptAttachment);
    
    public MasterResponseDto materialInstaReg(MaterialInstallationMasterDto mIMDto,
   		 MultipartFile[] instPhotos, MultipartFile instVideo,
			MultipartFile[] deliverChalan);
}
