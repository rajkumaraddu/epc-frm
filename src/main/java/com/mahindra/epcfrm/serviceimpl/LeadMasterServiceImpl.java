package com.mahindra.epcfrm.serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mahindra.epcfrm.entity.DeliveryChalanEntity;
import com.mahindra.epcfrm.entity.FarmerMasterEntity;
import com.mahindra.epcfrm.entity.InstReportPhotosEntity;
import com.mahindra.epcfrm.entity.KYCMasterEntity;
import com.mahindra.epcfrm.entity.LeadMasterEntity;
import com.mahindra.epcfrm.entity.MaterialDeliveryMaster;
import com.mahindra.epcfrm.entity.MaterialDeliveryPhotosEntity;
import com.mahindra.epcfrm.entity.MaterialInstallationMasterEntity;
import com.mahindra.epcfrm.entity.RegistrationDetailsMasterEntity;
import com.mahindra.epcfrm.entity.SiteSurveyMasterEntity;
import com.mahindra.epcfrm.dto.FarmerMasterDto;
import com.mahindra.epcfrm.dto.KycMasterDto;
import com.mahindra.epcfrm.dto.LeadMasterDto;
import com.mahindra.epcfrm.dto.LeadSearchDto;
import com.mahindra.epcfrm.dto.MasterResponseDto;
import com.mahindra.epcfrm.dto.MaterialDeliveryMasterDto;
import com.mahindra.epcfrm.dto.MaterialInstallationMasterDto;
import com.mahindra.epcfrm.dto.RegistrationDetailsMasterDto;
import com.mahindra.epcfrm.dto.SiteSurveyMasterDto;
import com.mahindra.epcfrm.exception.FileStorageException;
import com.mahindra.epcfrm.repository.CustomerMasterRepo;
import com.mahindra.epcfrm.repository.KycMasterRepo;
import com.mahindra.epcfrm.repository.LeadMasterRepo;
import com.mahindra.epcfrm.repository.MaterialDeliveryMasterRepo;
import com.mahindra.epcfrm.repository.MaterialInstallationMasterRepo;
import com.mahindra.epcfrm.repository.RegistrationDetailsMasterRepo;
import com.mahindra.epcfrm.repository.SiteSurveyMasterRepo;
import com.mahindra.epcfrm.service.LeadMasterService;

@Service
public class LeadMasterServiceImpl implements LeadMasterService {

	Logger log = LoggerFactory.getLogger(LeadMasterServiceImpl.class);

	@Autowired
	LeadMasterRepo leadMasterRepo;

	@Autowired
	CustomerMasterRepo customerMasterRepo;

	@Autowired
	KycMasterRepo kycMasterRepo;

	@Autowired
	SiteSurveyMasterRepo siteSurveyMasterRepo;

	@Autowired
	MaterialDeliveryMasterRepo materialDeliverMasterRepo;

	@Autowired
	RegistrationDetailsMasterRepo regDetailsMasterRepo;
	
	@Autowired
	MaterialInstallationMasterRepo materialInstMasterRepo;

	private final Path root = Paths.get("uploads");

	@Override
	public MasterResponseDto leadCreation(LeadMasterDto leadMasterDTO, MultipartFile farmerPhoto,
			MultipartFile waterTestDoc, MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard,
			MultipartFile rationCard, MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage,
			MultipartFile gpsCaptureImage, MultipartFile otherDoc, MultipartFile attachment1,
			MultipartFile attachmentSurvey2, MultipartFile[] instReportPhoto, MultipartFile instReportVideo,
			MultipartFile[] deliverChalan) {
		log.info("inside leadcreation service starts");
		System.out.println();
		MasterResponseDto leadCreationRes = new MasterResponseDto();
		// check otp is valid or not UserMasterEntity user =
		// userRepo.findByMobile(mobile);
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
			kyc.setFarmerPhoto(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ farmerPhoto.getOriginalFilename());
			uploadFiles(farmerPhoto, leadMasterEntity, fileName);
		}
		if (waterTestDoc != null) {
			fileName = "waterTestDoc";
			kyc.setWaterTestDoc(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ waterTestDoc.getOriginalFilename());
			uploadFiles(waterTestDoc, leadMasterEntity, fileName);
		}
		if (soilTestDoc != null) {
			fileName = "soilTestDoc";
			kyc.setSoilTestDoc(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ soilTestDoc.getOriginalFilename());
			uploadFiles(soilTestDoc, leadMasterEntity, fileName);
		}
		if (bankDoc != null) {
			fileName = "bankDoc";
			kyc.setBankDoc(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ bankDoc.getOriginalFilename());
			uploadFiles(bankDoc, leadMasterEntity, fileName);
		}
		if (aadharCard != null) {
			fileName = "aadharCard";
			kyc.setAadharCard(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ aadharCard.getOriginalFilename());
			uploadFiles(aadharCard, leadMasterEntity, fileName);
		}
		if (rationCard != null) {
			fileName = "rationCard";
			kyc.setRationCard(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ rationCard.getOriginalFilename());
			uploadFiles(rationCard, leadMasterEntity, fileName);
		}
		if (patta != null) {
			fileName = "patta";
			kyc.setPatta(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ patta.getOriginalFilename());
			uploadFiles(patta, leadMasterEntity, fileName);
		}
		if (chitta != null) {
			fileName = "chitta";
			kyc.setChitta(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ chitta.getOriginalFilename());
			uploadFiles(chitta, leadMasterEntity, fileName);
		}
		if (surveyCaptureImage != null) {
			fileName = "surveyCaptureImage";
			kyc.setSurveyCaptureImage(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ surveyCaptureImage.getOriginalFilename());
			uploadFiles(surveyCaptureImage, leadMasterEntity, fileName);
		}
		if (gpsCaptureImage != null) {
			fileName = "gpsCaptureImage";
			kyc.setGpsCaptureImage(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ gpsCaptureImage.getOriginalFilename());
			uploadFiles(gpsCaptureImage, leadMasterEntity, fileName);
		}
		if (otherDoc != null) {
			fileName = "otherDoc";
			kyc.setOtherDoc(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ otherDoc.getOriginalFilename());
			uploadFiles(otherDoc, leadMasterEntity, fileName);
		}
		if (attachment1 != null) {
			fileName = "attachment1";
			leadMasterEntity.setAttachment1(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ attachment1.getOriginalFilename());
			uploadFiles(attachment1, leadMasterEntity, fileName);
		}
		if (attachmentSurvey2 != null) {
			fileName = "attachmentSurvey2";
			leadMasterEntity.setAttachmentSurvey2(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName
					+ "_" + attachmentSurvey2.getOriginalFilename());
			uploadFiles(attachmentSurvey2, leadMasterEntity, fileName);
		}
		if (instReportVideo != null) {
			fileName = "instReportVideo";
			leadMasterEntity.setInstReportVideo(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
					+ instReportVideo.getOriginalFilename());
			uploadFiles(instReportVideo, leadMasterEntity, fileName);
		}
		if (instReportPhoto.length != 0) {
			int i = 0;
			List<InstReportPhotosEntity> listOfInstPhoto = new ArrayList<>();
			for (MultipartFile instPhoto : instReportPhoto) {
				InstReportPhotosEntity instRPhoto = new InstReportPhotosEntity();
				i = i + 1;
				fileName = "instReportPhoto" + i;
				instRPhoto.setInstPhotoName(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
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
				deChalan.setDelChalanFileName(leadMasterEntity.getFarmerId().getContactNumber() + "_" + fileName + "_"
						+ chalans.getOriginalFilename());
				uploadFiles(chalans, leadMasterEntity, fileName);
				listOfDelChalan.add(deChalan);
			}
			leadMasterEntity.setDeliveryChalan(listOfDelChalan);
		}
		leadMasterEntity.setKycId(kyc);
		leadMasterEntity.setKycStatus("KycPending");
		leadMasterEntity.setWorkOrderStatus("WoPending");
		leadMasterEntity.setQuotationStatus("QuPending");
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
					leadMaster.getFarmerId().getContactNumber() + "_" + fileName + "_" + file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			log.error("Exception occured in File Uploading", ex);
			throw new FileStorageException("Could not store file " + file + ". Please try again!", ex);
		}
		log.info("inside upload file service ended");
		return file.getOriginalFilename();
	}

	/*
	 * Upload File Service
	 */
	public String newUploadFiles(MultipartFile file, LeadMasterEntity leadMaster, String fileName) {
		try {
			log.info("inside upload file service started");
			log.debug("inside upload file service");
			System.out.println("root ");
			if (root == null) {
				Files.createDirectory(root);
			}
			Path targetLocation = this.root
					.resolve(leadMaster.getId() + "_" + fileName + "_" + file.getOriginalFilename());
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
		MasterResponseDto leadSearchRes = new MasterResponseDto();
		List<LeadMasterEntity> leadList = leadMasterRepo.findByUserMobile(searchDTO.getUserMobile());
		log.info("leadList Count:" + leadList.size());
		if (leadList.size() != 0) {
			leadSearchRes.setStatusCode(0);
			leadSearchRes.setMessage("success");
			leadSearchRes.setData(leadList);
			return leadSearchRes;
		} else {
			leadSearchRes.setStatusCode(1);
			leadSearchRes.setMessage("Lead data is not available for this user " + searchDTO.getUserMobile());
			leadSearchRes.setData(null);
			return leadSearchRes;
		}
	}

	@Override
	public MasterResponseDto farmerInfoReg(FarmerMasterDto farmerMDto) {
		log.info("inside farmerInfoReg save service");
		log.debug("inside farmerInfoReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		FarmerMasterEntity farmer = new FarmerMasterEntity();
		BeanUtils.copyProperties(farmerMDto, farmer);
		LeadMasterEntity lead = new LeadMasterEntity();
		lead.setFarmerMaster(farmer);
		LeadMasterEntity saveLead = leadMasterRepo.save(lead);
		masterRes.setData(saveLead);
		masterRes.setMessage("success");
		masterRes.setStatusCode(0);
		return masterRes;
	}

	@Override
	public MasterResponseDto siteSurveyReg(SiteSurveyMasterDto siteSurveyMDto, MultipartFile iniQuotAttachment) {
		log.info("inside siteSurveyReg save service");
		log.debug("inside siteSurveyReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(siteSurveyMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<SiteSurveyMasterEntity> avlSiteSurvey = siteSurveyMasterRepo
					.findByLeadId(siteSurveyMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			SiteSurveyMasterEntity siteSurvey;
			if (avlSiteSurvey.isPresent()) {
				log.info("inside if block siteSurvey is already available");
				siteSurvey = avlSiteSurvey.get();
				BeanUtils.copyProperties(siteSurveyMDto, siteSurvey);
				siteSurvey.setId(avlSiteSurvey.get().getId());
			} else {
				log.info("inside else block siteSurvey is not available");
				siteSurvey = new SiteSurveyMasterEntity();
				BeanUtils.copyProperties(siteSurveyMDto, siteSurvey);
			}
			String fileName;
			if (iniQuotAttachment != null) {
				fileName = "iniQuotAttachment";
				siteSurvey.setIniQuotAttachment(
						presentLead.get().getId() + "_" + fileName + "_" + iniQuotAttachment.getOriginalFilename());
				newUploadFiles(iniQuotAttachment, leadMasterEntity, fileName);
			}
			leadMasterEntity.setId(presentLead.get().getId());
			leadMasterEntity.setSiteSurveyMaster(siteSurvey);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage( siteSurveyMDto.getLeadId()+ " This lead data is not available ");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto kycReg(KycMasterDto kycMDto, MultipartFile farmerPhoto, MultipartFile waterTestDoc,
			MultipartFile soilTestDoc, MultipartFile bankDoc, MultipartFile aadharCard, MultipartFile rationCard,
			MultipartFile patta, MultipartFile chitta, MultipartFile surveyCaptureImage, MultipartFile gpsCaptureImage,
			MultipartFile otherDoc) {
		log.info("inside kycReg service");
		log.debug("inside kycReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(kycMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<KYCMasterEntity> avlKyc = kycMasterRepo.findByLeadId(kycMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			KYCMasterEntity kyc;
			if (avlKyc.isPresent()) {
				log.info("inside if block kyc already available");
				kyc = avlKyc.get();
				kyc.setAadharNo(kycMDto.getAadharNo());
				kyc.setLeadId(kycMDto.getLeadId());
			} else {
				log.info("inside else block kyc is not available");
				kyc = new KYCMasterEntity();
				kyc.setAadharNo(kycMDto.getAadharNo());
				kyc.setLeadId(kycMDto.getLeadId());
			}
			leadMasterEntity.setId(presentLead.get().getId());
			String fileName;
			if (farmerPhoto != null) {
				fileName = "farmerPhoto";
				kyc.setFarmerPhoto(leadMasterEntity.getId() + "_" + fileName + "_" + farmerPhoto.getOriginalFilename());
				newUploadFiles(farmerPhoto, leadMasterEntity, fileName);
			}
			if (waterTestDoc != null) {
				fileName = "waterTestDoc";
				kyc.setWaterTestDoc(
						leadMasterEntity.getId() + "_" + fileName + "_" + waterTestDoc.getOriginalFilename());
				newUploadFiles(waterTestDoc, leadMasterEntity, fileName);
			}
			if (soilTestDoc != null) {
				fileName = "soilTestDoc";
				kyc.setSoilTestDoc(leadMasterEntity.getId() + "_" + fileName + "_" + soilTestDoc.getOriginalFilename());
				newUploadFiles(soilTestDoc, leadMasterEntity, fileName);
			}
			if (bankDoc != null) {
				fileName = "bankDoc";
				kyc.setBankDoc(leadMasterEntity.getId() + "_" + fileName + "_" + bankDoc.getOriginalFilename());
				newUploadFiles(bankDoc, leadMasterEntity, fileName);
			}
			if (aadharCard != null) {
				fileName = "aadharCard";
				kyc.setAadharCard(leadMasterEntity.getId() + "_" + fileName + "_" + aadharCard.getOriginalFilename());
				newUploadFiles(aadharCard, leadMasterEntity, fileName);
			}
			if (rationCard != null) {
				fileName = "rationCard";
				kyc.setRationCard(leadMasterEntity.getId() + "_" + fileName + "_" + rationCard.getOriginalFilename());
				newUploadFiles(rationCard, leadMasterEntity, fileName);
			}
			if (patta != null) {
				fileName = "patta";
				kyc.setPatta(leadMasterEntity.getId() + "_" + fileName + "_" + patta.getOriginalFilename());
				newUploadFiles(patta, leadMasterEntity, fileName);
			}
			if (chitta != null) {
				fileName = "chitta";
				kyc.setChitta(leadMasterEntity.getId() + "_" + fileName + "_" + chitta.getOriginalFilename());
				newUploadFiles(chitta, leadMasterEntity, fileName);
			}
			if (surveyCaptureImage != null) {
				fileName = "surveyCaptureImage";
				kyc.setSurveyCaptureImage(
						leadMasterEntity.getId() + "_" + fileName + "_" + surveyCaptureImage.getOriginalFilename());
				newUploadFiles(surveyCaptureImage, leadMasterEntity, fileName);
			}
			if (gpsCaptureImage != null) {
				fileName = "gpsCaptureImage";
				kyc.setGpsCaptureImage(
						leadMasterEntity.getId() + "_" + fileName + "_" + gpsCaptureImage.getOriginalFilename());
				newUploadFiles(gpsCaptureImage, leadMasterEntity, fileName);
			}
			if (otherDoc != null) {
				fileName = "otherDoc";
				kyc.setOtherDoc(leadMasterEntity.getId() + "_" + fileName + "_" + otherDoc.getOriginalFilename());
				newUploadFiles(otherDoc, leadMasterEntity, fileName);
			}
			leadMasterEntity.setKycId(kyc);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(kycMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto materialDeliveryReg(MaterialDeliveryMasterDto mdMDto, MultipartFile[] instReportPhoto,
			MultipartFile instReportVideo, MultipartFile perInvoicePhoto, MultipartFile[] deliverChalan) {
		log.info("inside materialDeliveryReg service");
		log.debug("inside materialDeliveryReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(mdMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<MaterialDeliveryMaster> avlMdMDto = materialDeliverMasterRepo.findByLeadId(mdMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			MaterialDeliveryMaster mDeMaster;
			if (avlMdMDto.isPresent()) {
				log.info("inside if block material delivery is already available");
				mDeMaster = avlMdMDto.get();
				BeanUtils.copyProperties(mdMDto, mDeMaster);
				mDeMaster.setId(avlMdMDto.get().getId());
			} else {
				log.info("inside else block material delivery is not available");
				mDeMaster = new MaterialDeliveryMaster();
				BeanUtils.copyProperties(mdMDto, mDeMaster);
			}
			leadMasterEntity.setId(presentLead.get().getId());
			String fileName;
			if (instReportVideo != null) {
				fileName = "MaterialVideo";
				mDeMaster.setUploadVideo(
						leadMasterEntity.getId() + "_" + fileName + "_" + instReportVideo.getOriginalFilename());
				newUploadFiles(instReportVideo, leadMasterEntity, fileName);
			}
			if (perInvoicePhoto != null) {
				fileName = "perInvoicePhoto";
				mDeMaster.setPerInvoicePhoto(
						leadMasterEntity.getId() + "_" + fileName + "_" + instReportVideo.getOriginalFilename());
				newUploadFiles(perInvoicePhoto, leadMasterEntity, fileName);
			}

			if (instReportPhoto.length != 0) {
				int i = 0;
				List<MaterialDeliveryPhotosEntity> listOfMDeliPhoto = new ArrayList<>();
				for (MultipartFile instPhoto : instReportPhoto) {
					MaterialDeliveryPhotosEntity mDeliveryPhoto = new MaterialDeliveryPhotosEntity();
					i = i + 1;
					fileName = "MaterialDeliveryPhoto" + i;
					mDeliveryPhoto.setMaterialPhotosName(
							leadMasterEntity.getId() + "_" + fileName + "_" + instPhoto.getOriginalFilename());
					newUploadFiles(instPhoto, leadMasterEntity, fileName);
					listOfMDeliPhoto.add(mDeliveryPhoto);
				}
				mDeMaster.setMaterialPhotos(listOfMDeliPhoto);
			}
			if (deliverChalan.length != 0) {
				int i = 0;
				List<DeliveryChalanEntity> listOfDelChalan = new ArrayList<>();
				for (MultipartFile chalans : deliverChalan) {
					DeliveryChalanEntity deChalan = new DeliveryChalanEntity();
					i = i + 1;
					fileName = "deliverChalan" + i;
					deChalan.setDelChalanFileName(
							leadMasterEntity.getId() + "_" + fileName + "_" + chalans.getOriginalFilename());
					newUploadFiles(chalans, leadMasterEntity, fileName);
					listOfDelChalan.add(deChalan);
				}
				mDeMaster.setDeliveryChalan(listOfDelChalan);
			}

			leadMasterEntity.setMaterialDeliveryMaster(mDeMaster);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(mdMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}

	@Override
	public MasterResponseDto saveRegDetails(RegistrationDetailsMasterDto regDMDto, MultipartFile quotAttachment,
			MultipartFile ddAttachment, MultipartFile faAcceptAttachment) {
		log.info("inside saveRegDetails  service");
		log.debug("inside saveRegDetails service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(regDMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<RegistrationDetailsMasterEntity> avlRegDetails = regDetailsMasterRepo
					.findByLeadId(regDMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			RegistrationDetailsMasterEntity regDetailsMaster;
			if (avlRegDetails.isPresent()) {
				log.info("inside if block registration details is already available");
				regDetailsMaster = avlRegDetails.get();
				BeanUtils.copyProperties(regDMDto, regDetailsMaster);
				
				regDetailsMaster.setId(avlRegDetails.get().getId());
			} else {
				log.info("inside else block registration details is not available");
				regDetailsMaster = new RegistrationDetailsMasterEntity();
				BeanUtils.copyProperties(regDMDto, regDetailsMaster);
				System.out.println(regDMDto.getFarmerRegNo()+" fareg "+regDetailsMaster.getFarmerRegNo());
			}
			leadMasterEntity.setId(presentLead.get().getId());
			String fileName;
			if (quotAttachment != null) {
				fileName = "Quotation";
				regDetailsMaster.setQuotAttachment(
						leadMasterEntity.getId() + "_" + fileName + "_" + quotAttachment.getOriginalFilename());
				newUploadFiles(quotAttachment, leadMasterEntity, fileName);
			}
			if(ddAttachment!=null) {
				fileName = "DD";
				regDetailsMaster.setDdAttachment(
						leadMasterEntity.getId() + "_" + fileName + "_" + ddAttachment.getOriginalFilename());
				newUploadFiles(ddAttachment, leadMasterEntity, fileName);
			}
			if(faAcceptAttachment!=null) {
				fileName = "FarmerAcceptance";
				regDetailsMaster.setFaAcceptAttachment(
						leadMasterEntity.getId() + "_" + fileName + "_" + faAcceptAttachment.getOriginalFilename());
				newUploadFiles(faAcceptAttachment, leadMasterEntity, fileName);
			}

			leadMasterEntity.setRegDetailsMaster(regDetailsMaster);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(regDMDto.getLeadId() + " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}
	
	@Override
	public MasterResponseDto materialInstaReg(MaterialInstallationMasterDto mIMDto, MultipartFile[] instPhotos,
			MultipartFile instVideo, MultipartFile[] deliverChalan) {
		log.info("inside materialInstaReg service");
		log.debug("inside materialInstaReg service");
		MasterResponseDto masterRes = new MasterResponseDto();
		Optional<LeadMasterEntity> presentLead = leadMasterRepo.findById(mIMDto.getLeadId());
		if (presentLead.isPresent()) {
			Optional<MaterialInstallationMasterEntity> avlMIMDto = materialInstMasterRepo.findByLeadId(mIMDto.getLeadId());
			LeadMasterEntity leadMasterEntity = presentLead.get();
			MaterialInstallationMasterEntity mInstaMaster;
			if (avlMIMDto.isPresent()) {
				log.info("inside if block material installation is already available");
				mInstaMaster = avlMIMDto.get();
				BeanUtils.copyProperties(mIMDto, mInstaMaster);
				mInstaMaster.setId(avlMIMDto.get().getId());
			} else {
				log.info("inside else block material installation is not available");
				mInstaMaster = new MaterialInstallationMasterEntity();
				BeanUtils.copyProperties(mIMDto, mInstaMaster);
			}
			leadMasterEntity.setId(presentLead.get().getId());
			String fileName;
			if (instVideo != null) {
				fileName = "MInstallationVideo";
				mInstaMaster.setUploadVideo(
						leadMasterEntity.getId() + "_" + fileName + "_" + instVideo.getOriginalFilename());
				newUploadFiles(instVideo, leadMasterEntity, fileName);
			}
			if (instPhotos.length != 0) {
				int i = 0;
				List<InstReportPhotosEntity> listOfMInstaPhoto = new ArrayList<>();
				for (MultipartFile instPhoto : instPhotos) {
					InstReportPhotosEntity mInstaPhoto = new InstReportPhotosEntity();
					i = i + 1;
					fileName = "MaterialInstallationPhoto" + i;
					mInstaPhoto.setInstPhotoName(
							leadMasterEntity.getId() + "_" + fileName + "_" + instPhoto.getOriginalFilename());
					newUploadFiles(instPhoto, leadMasterEntity, fileName);
					listOfMInstaPhoto.add(mInstaPhoto);
				}
				mInstaMaster.setInstaPhotos(listOfMInstaPhoto);
			}
			if (deliverChalan.length != 0) {
				int i = 0;
				List<DeliveryChalanEntity> listOfDelChalan = new ArrayList<>();
				for (MultipartFile chalans : deliverChalan) {
					DeliveryChalanEntity deChalan = new DeliveryChalanEntity();
					i = i + 1;
					fileName = "MterialInstDeliveryChalan" + i;
					deChalan.setDelChalanFileName(
							leadMasterEntity.getId() + "_" + fileName + "_" + chalans.getOriginalFilename());
					newUploadFiles(chalans, leadMasterEntity, fileName);
					listOfDelChalan.add(deChalan);
				}
				mInstaMaster.setDeliveryChalan(listOfDelChalan);
			}

			leadMasterEntity.setMaterialInstallMaster(mInstaMaster);
			LeadMasterEntity newLead = leadMasterRepo.save(leadMasterEntity);
			masterRes.setStatusCode(0);
			masterRes.setMessage("success");
			masterRes.setData(newLead);
			return masterRes;
		} else {
			masterRes.setStatusCode(1);
			masterRes.setMessage(mIMDto.getLeadId()+ " This lead data is not available");
			masterRes.setData(null);
			return masterRes;
		}
	}
	
}
