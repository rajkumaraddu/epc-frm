package com.mahindra.epcfrm.serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mahindra.epcfrm.entity.DeliveryChalanEntity;
import com.mahindra.epcfrm.entity.InstReportPhotosEntity;
import com.mahindra.epcfrm.entity.KYCMasterEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.exception.FileStorageException;
import com.mahindra.epcfrm.repository.CustomerMasterRepo;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.service.LeadMasterService;

@Service
public class LeadMasterServiceImpl implements LeadMasterService {

	Logger log = LoggerFactory.getLogger(LeadMasterServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;

	@Autowired
	CustomerMasterRepo customerMasterRepo;

	private final Path root = Paths.get("uploads");

	@Override
	public MasterResponseDto leadCreation(LeadMasterDto leadMasterDTO, MultipartFile farmerPhoto,
			MultipartFile waterTestDoc, MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard,
			MultipartFile rationCard, MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage,
			MultipartFile gpsCaptureImage, MultipartFile otherDoc, MultipartFile attachment1,
			MultipartFile attachmentSurvey2, MultipartFile[] instReportPhoto, MultipartFile instReportVideo,
			MultipartFile[] deliverChalan) {
		log.info("inside leadcreation service starts");
        MasterResponseDto leadCreationRes=new MasterResponseDto();
		/*
		 * Optional<CustomerMasterEntity> farmerData = customerMasterRepo
		 * .findByEmailId(leadMasterDTO.getFarmerId().getEmailId()); if
		 * (farmerData.isPresent()) { throw new ResourceAlreadyExistsException(
		 * leadMasterDTO.getFarmerId().getEmailId() +
		 * " this email is already registered "); } else {
		 */
			LeadMasterEntity leadMasterEntity = new LeadMasterEntity();
			BeanUtils.copyProperties(leadMasterDTO, leadMasterEntity);
			System.out.println("fam " + farmerPhoto);
			KYCMasterEntity kyc = new KYCMasterEntity();
			String fileName;
			if (farmerPhoto != null) {
				fileName = "farmerPhoto";
				kyc.setFarmerPhoto(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ farmerPhoto.getOriginalFilename());
				uploadFiles(farmerPhoto, leadMasterEntity, fileName);
			}
			if (waterTestDoc != null) {
				fileName = "waterTestDoc";
				kyc.setWaterTestDoc(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ waterTestDoc.getOriginalFilename());
				uploadFiles(waterTestDoc, leadMasterEntity, fileName);
			}
			if (soilTestDoc != null) {
				fileName = "soilTestDoc";
				kyc.setSoilTestDoc(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ soilTestDoc.getOriginalFilename());
				uploadFiles(soilTestDoc, leadMasterEntity, fileName);
			}
			if (bankDoc != null) {
				fileName = "bankDoc";
				kyc.setBankDoc(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ bankDoc.getOriginalFilename());
				uploadFiles(bankDoc, leadMasterEntity, fileName);
			}
			if (aadharCard != null) {
				fileName = "aadharCard";
				kyc.setAadharCard(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ aadharCard.getOriginalFilename());
				uploadFiles(aadharCard, leadMasterEntity, fileName);
			}
			if (rationCard != null) {
				fileName = "rationCard";
				kyc.setRationCard(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ rationCard.getOriginalFilename());
				uploadFiles(rationCard, leadMasterEntity, fileName);
			}
			if (patta != null) {
				fileName = "patta";
				kyc.setPatta(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ patta.getOriginalFilename());
				uploadFiles(patta, leadMasterEntity, fileName);
			}
			if (chitta != null) {
				fileName = "chitta";
				kyc.setChitta(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ chitta.getOriginalFilename());
				uploadFiles(chitta, leadMasterEntity, fileName);
			}
			if (surveyCaptureImage != null) {
				fileName = "surveyCaptureImage";
				kyc.setSurveyCaptureImage(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ surveyCaptureImage.getOriginalFilename());
				uploadFiles(surveyCaptureImage, leadMasterEntity, fileName);
			}
			if (gpsCaptureImage != null) {
				fileName = "gpsCaptureImage";
				kyc.setGpsCaptureImage(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ gpsCaptureImage.getOriginalFilename());
				uploadFiles(gpsCaptureImage, leadMasterEntity, fileName);
			}
			if (otherDoc != null) {
				fileName = "otherDoc";
				kyc.setOtherDoc(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ otherDoc.getOriginalFilename());
				uploadFiles(otherDoc, leadMasterEntity, fileName);
			}
			if (attachment1 != null) {
				fileName = "attachment1";
				leadMasterEntity.setAttachment1(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
						+ attachment1.getOriginalFilename());
				uploadFiles(attachment1, leadMasterEntity, fileName);
			}
			if (attachmentSurvey2 != null) {
				fileName = "attachmentSurvey2";
				leadMasterEntity.setAttachmentSurvey2(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName
						+ "_" + attachmentSurvey2.getOriginalFilename());
				uploadFiles(attachmentSurvey2, leadMasterEntity, fileName);
			}
			if (instReportVideo != null) {
				fileName = "instReportVideo";
				leadMasterEntity.setInstReportVideo(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName
						+ "_" + instReportVideo.getOriginalFilename());
				uploadFiles(instReportVideo, leadMasterEntity, fileName);
			}
			if (instReportPhoto.length != 0) {
				int i = 0;
				List<InstReportPhotosEntity> listOfInstPhoto = new ArrayList<>();
				for (MultipartFile instPhoto : instReportPhoto) {
					InstReportPhotosEntity instRPhoto = new InstReportPhotosEntity();
					i = i + 1;
					fileName = "instReportPhoto" + i;
					instRPhoto.setInstPhotoName(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
							+ instPhoto.getOriginalFilename());
					uploadFiles(instPhoto, leadMasterEntity, fileName);
					listOfInstPhoto.add(instRPhoto);
				}
				leadMasterEntity.setInstReportPhoto(listOfInstPhoto);
			}
			if (deliverChalan.length != 0) {
				int i = 0;
				List<DeliveryChalanEntity> listOfDelChalan = new ArrayList<>();
				for (MultipartFile chalans : deliverChalan) {
					DeliveryChalanEntity deChalan = new DeliveryChalanEntity();
					i = i + 1;
					fileName = "deliverChalan" + i;
					deChalan.setDelChalanFileName(leadMasterEntity.getFarmerId().getCustomerId() + "_" + fileName + "_"
							+ chalans.getOriginalFilename());
					uploadFiles(chalans, leadMasterEntity, fileName);
					listOfDelChalan.add(deChalan);
				}
				leadMasterEntity.setDeliveryChalan(listOfDelChalan);
			}
			leadMasterEntity.setKycId(kyc);
			LeadMasterEntity lead = leadMasterRepo.save(leadMasterEntity);
			leadCreationRes.setStatusCode(0);
			leadCreationRes.setMessage("success");
			leadCreationRes.setData(lead);
			log.info("inside leadcreation service ended");
			return leadCreationRes;
	}

	/*
	 * Upload File Service
	 */
	public String uploadFiles(MultipartFile file, LeadMasterEntity leadMaster, String fileName) {
		try {
			log.info("inside upload file service started");
			log.debug("inside upload file service");
			System.out.println("root ");
			if (root == null) {
				Files.createDirectory(root);
			}
			// Path targetLocation = this.root.resolve(map.getEmpId() + "_" +
			// map.getVehicleRegNo() + "_" + file.getOriginalFilename());
			Path targetLocation = this.root.resolve(
					leadMaster.getFarmerId().getCustomerId() + "_" + fileName + "_" + file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			log.error("Exception occured in File Uploading", ex);
			throw new FileStorageException("Could not store file " + file + ". Please try again!", ex);
		}
		log.info("inside upload file service ended");
		return file.getOriginalFilename();
	}

	@Override
	public MasterResponseDto leadSearch(LeadSearchDto searchDTO) throws Exception {
		log.info("inside leadSearch service");
		log.debug("inside leadSearch service");
		MasterResponseDto leadSearchRes=new MasterResponseDto();
		List<LeadMasterEntity> leadList = leadMasterRepo.findByUserMobile(searchDTO.getUserMobile());
		log.info("leadList Count:"+leadList.size());
		if (leadList.size()!=0) {
			leadSearchRes.setStatusCode(0);
			leadSearchRes.setMessage("success");
			leadSearchRes.setData(leadList);
			return leadSearchRes;
		} else {
			leadSearchRes.setStatusCode(1);
			leadSearchRes.setMessage("Lead data is not available for this user "+searchDTO.getUserMobile());
			leadSearchRes.setData(null);
			return leadSearchRes;
		}
	}
}
