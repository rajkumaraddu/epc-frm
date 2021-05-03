package com.mahindra.epcfrm.dto;

import java.time.LocalDate;
import java.util.List;
import com.mahindra.epcfrm.entity.AddressMasterEntity;
import com.mahindra.epcfrm.entity.BaseEntity;
import com.mahindra.epcfrm.entity.CustomerMasterEntity;
import com.mahindra.epcfrm.entity.DeliveryChalanEntity;
import com.mahindra.epcfrm.entity.InstReportPhotosEntity;
import com.mahindra.epcfrm.entity.KYCMasterEntity;

/**
 * @author Birla.Manoj
 *
 */

public class LeadMasterDto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String enquirySource;

	private CustomerMasterEntity farmerId;

	private AddressMasterEntity farmerAddId;

	// private String communicationId;
	private String cropName;
	private String misProduct;
	private String govtPortalRegNo;
	private String regStatusOnGovtPortal;//
	// status
	private String workOrderStatus;
	// private String workOrderNo;
	private String kycStatus;
	private String quotationStatus;
	/*
	 * private String manualApprovalTriggered; private String approvalStatus;
	 * private String convertedTo; private String faId;
	 */
	private String asmId;
	// private String dealerUserId;//dealer
	private String onlinePortalStatus;
	// private String overallStatus;
	// private String estPurchaseMonth;
	private String enquiryType;
	private double farmerContriAmt;
	private double subsidyPct;

	// QuotationTime
	private double totalQuotAmt;
	private String attachment1;

	// SiteSurvey initial Quotation
	private double initialAmt;
	private String attachmentSurvey2;
	private LocalDate visitDate;

	// kyc new entity
	private KYCMasterEntity kycId;
	private Long userMobile;//

	// status
	private List<InstReportPhotosEntity> instReportPhoto;
	private String instReportVideo;

	private List<DeliveryChalanEntity> deliveryChalan;

	private Long otp;
	// private String gps;

	private double gpsLat;
	private double gpsLong;

	private String timeStamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnquirySource() {
		return enquirySource;
	}

	public void setEnquirySource(String enquirySource) {
		this.enquirySource = enquirySource;
	}

	public CustomerMasterEntity getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(CustomerMasterEntity farmerId) {
		this.farmerId = farmerId;
	}

	public AddressMasterEntity getFarmerAddId() {
		return farmerAddId;
	}

	public void setFarmerAddId(AddressMasterEntity farmerAddId) {
		this.farmerAddId = farmerAddId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getMisProduct() {
		return misProduct;
	}

	public void setMisProduct(String misProduct) {
		this.misProduct = misProduct;
	}

	public String getGovtPortalRegNo() {
		return govtPortalRegNo;
	}

	public void setGovtPortalRegNo(String govtPortalRegNo) {
		this.govtPortalRegNo = govtPortalRegNo;
	}

	public String getRegStatusOnGovtPortal() {
		return regStatusOnGovtPortal;
	}

	public void setRegStatusOnGovtPortal(String regStatusOnGovtPortal) {
		this.regStatusOnGovtPortal = regStatusOnGovtPortal;
	}

	public String getWorkOrderStatus() {
		return workOrderStatus;
	}

	public void setWorkOrderStatus(String workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}

	public String getAsmId() {
		return asmId;
	}

	public void setAsmId(String asmId) {
		this.asmId = asmId;
	}

	public String getOnlinePortalStatus() {
		return onlinePortalStatus;
	}

	public void setOnlinePortalStatus(String onlinePortalStatus) {
		this.onlinePortalStatus = onlinePortalStatus;
	}

	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public double getFarmerContriAmt() {
		return farmerContriAmt;
	}

	public void setFarmerContriAmt(double farmerContriAmt) {
		this.farmerContriAmt = farmerContriAmt;
	}

	public double getSubsidyPct() {
		return subsidyPct;
	}

	public void setSubsidyPct(double subsidyPct) {
		this.subsidyPct = subsidyPct;
	}

	public double getTotalQuotAmt() {
		return totalQuotAmt;
	}

	public void setTotalQuotAmt(double totalQuotAmt) {
		this.totalQuotAmt = totalQuotAmt;
	}

	public String getAttachment1() {
		return attachment1;
	}

	public void setAttachment1(String attachment1) {
		this.attachment1 = attachment1;
	}

	public double getInitialAmt() {
		return initialAmt;
	}

	public void setInitialAmt(double initialAmt) {
		this.initialAmt = initialAmt;
	}

	public String getAttachmentSurvey2() {
		return attachmentSurvey2;
	}

	public void setAttachmentSurvey2(String attachmentSurvey2) {
		this.attachmentSurvey2 = attachmentSurvey2;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public KYCMasterEntity getKycId() {
		return kycId;
	}

	public void setKycId(KYCMasterEntity kycId) {
		this.kycId = kycId;
	}

	public List<InstReportPhotosEntity> getInstReportPhoto() {
		return instReportPhoto;
	}

	public void setInstReportPhoto(List<InstReportPhotosEntity> instReportPhoto) {
		this.instReportPhoto = instReportPhoto;
	}

	public String getInstReportVideo() {
		return instReportVideo;
	}

	public void setInstReportVideo(String instReportVideo) {
		this.instReportVideo = instReportVideo;
	}

	public List<DeliveryChalanEntity> getDeliveryChalan() {
		return deliveryChalan;
	}

	public void setDeliveryChalan(List<DeliveryChalanEntity> deliveryChalan) {
		this.deliveryChalan = deliveryChalan;
	}

	public double getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}

	public double getGpsLong() {
		return gpsLong;
	}

	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getQuotationStatus() {
		return quotationStatus;
	}

	public void setQuotationStatus(String quotationStatus) {
		this.quotationStatus = quotationStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
