/**
 * 
 */
package com.mahindra.epcfrm.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Raju.Addu
 *
 */
@Entity
@Table(name = "LeadMaster")
public class LeadMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 1331398974558006304L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	private FarmerMasterEntity farmerMaster;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SiteSurveyMasterEntity siteSurveyMaster;
		
	@OneToOne(cascade = CascadeType.ALL)
	private MaterialDeliveryMaster materialDeliveryMaster;
	
	@OneToOne(cascade = CascadeType.ALL)
	private RegistrationDetailsMasterEntity regDetailsMaster;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MaterialInstallationMasterEntity materialInstallMaster;
	
	@Column(length = 50)
	private String enquirySource;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerMasterEntity farmerId;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressMasterEntity farmerAddId;

//	@Column(length = 50)
//	private String communicationId;

	@Column(length = 50)
	private String cropName;
	@Column(length = 50)
	private String misProduct;
	@Column(length = 50)
	private String govtPortalRegNo;
	@Column(length = 50)
	private String regStatusOnGovtPortal;//

	// status

	@Column(length = 50)
	private String workOrderStatus;// tobedeleted

	/*
	 * @Column(length = 50) private String workOrderNo;
	 */
	@Column(length = 50)
	private String kycStatus;
	@Column(length = 50)
	private String quotationStatus;

	/*
	 * @Column(length = 50) private String manualApprovalTriggered;
	 * 
	 * @Column(length = 50) private String approvalStatus;
	 * 
	 * @Column(length = 50) private String convertedTo;
	 * 
	 * @Column(length = 50) private String faId;
	 */
	@Column(length = 50)
	private String asmId;

	// @Column(length = 50)
	// private String dealerUserId;

	@Column(length = 50)
	private String onlinePortalStatus;
	// @Column(length = 50)
	// private String overallStatus;

	// @Column(length = 50)
	// private String estPurchaseMonth;

	@Column(length = 50)
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
	@OneToOne(cascade = CascadeType.ALL)
	private KYCMasterEntity kycId;

	@Column(length = 15)
	private Long userMobile;//

	// status
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "instReportPhotoId")
	private List<InstReportPhotosEntity> instReportPhoto;

	private String instReportVideo;

	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "deliveryChalanId")
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

	public AddressMasterEntity getFarmerAddId() {
		return farmerAddId;
	}

	public void setFarmerAddId(AddressMasterEntity farmerAddId) {
		this.farmerAddId = farmerAddId;
	}

	public KYCMasterEntity getKycId() {
		return kycId;
	}

	public void setKycId(KYCMasterEntity kycId) {
		this.kycId = kycId;
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

	public double getTotalQuotAmt() {
		return totalQuotAmt;
	}

	public void setTotalQuotAmt(double totalQuotAmt) {
		this.totalQuotAmt = totalQuotAmt;
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

	public CustomerMasterEntity getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(CustomerMasterEntity farmerId) {
		this.farmerId = farmerId;
	}

	public String getRegStatusOnGovtPortal() {
		return regStatusOnGovtPortal;
	}

	public void setRegStatusOnGovtPortal(String regStatusOnGovtPortal) {
		this.regStatusOnGovtPortal = regStatusOnGovtPortal;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public FarmerMasterEntity getFarmerMaster() {
		return farmerMaster;
	}

	public void setFarmerMaster(FarmerMasterEntity farmerMaster) {
		this.farmerMaster = farmerMaster;
	}

	public SiteSurveyMasterEntity getSiteSurveyMaster() {
		return siteSurveyMaster;
	}

	public void setSiteSurveyMaster(SiteSurveyMasterEntity siteSurveyMaster) {
		this.siteSurveyMaster = siteSurveyMaster;
	}

	public MaterialDeliveryMaster getMaterialDeliveryMaster() {
		return materialDeliveryMaster;
	}

	public void setMaterialDeliveryMaster(MaterialDeliveryMaster materialDeliveryMaster) {
		this.materialDeliveryMaster = materialDeliveryMaster;
	}

	public RegistrationDetailsMasterEntity getRegDetailsMaster() {
		return regDetailsMaster;
	}

	public void setRegDetailsMaster(RegistrationDetailsMasterEntity regDetailsMaster) {
		this.regDetailsMaster = regDetailsMaster;
	}

	public MaterialInstallationMasterEntity getMaterialInstallMaster() {
		return materialInstallMaster;
	}

	public void setMaterialInstallMaster(MaterialInstallationMasterEntity materialInstallMaster) {
		this.materialInstallMaster = materialInstallMaster;
	}	
	
}
