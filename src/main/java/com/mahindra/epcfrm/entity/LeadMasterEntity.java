/**
 * 
 */
package com.mahindra.epcfrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(length = 50)
	private String enquirySource;
	@Column(length = 50)
	private String farmerId;
	@Column(length = 50)
	private String fieldAddId;
	@Column(length = 50)
	private String communicationId;
	@Column(length = 50)
	private String cropName;
	@Column(length = 50)
	private String misProduct;
	@Column(length = 50)
	private String govtPortalRegNo;
	@Column(length = 50)
	private String workOrderStatus;
	@Column(length = 50)
	private String workOrderNo;
	@Column(length = 50)
	private String manualApprovalTriggered;
	@Column(length = 50)
	private String approvalStatus;
	@Column(length = 50)
	private String convertedTo;
	@Column(length = 50)
	private String faId;
	@Column(length = 50)
	private String asmId;
	@Column(length = 50)
	private String dealerUserId;
	@Column(length = 50)
	private String onlinePortalStatus;
	@Column(length = 50)
	private String overallStatus;
	@Column(length = 50)
	private String estPurchaseMonth;
	@Column(length = 50)
	private String enquiryType;
	private double totalQuotAmt;
	private double farmerContriAmt;
	private double subsidyPct;
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
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	public String getFieldAddId() {
		return fieldAddId;
	}
	public void setFieldAddId(String fieldAddId) {
		this.fieldAddId = fieldAddId;
	}
	public String getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(String communicationId) {
		this.communicationId = communicationId;
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
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	public String getManualApprovalTriggered() {
		return manualApprovalTriggered;
	}
	public void setManualApprovalTriggered(String manualApprovalTriggered) {
		this.manualApprovalTriggered = manualApprovalTriggered;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getConvertedTo() {
		return convertedTo;
	}
	public void setConvertedTo(String convertedTo) {
		this.convertedTo = convertedTo;
	}
	public String getFaId() {
		return faId;
	}
	public void setFaId(String faId) {
		this.faId = faId;
	}
	public String getAsmId() {
		return asmId;
	}
	public void setAsmId(String asmId) {
		this.asmId = asmId;
	}
	public String getDealerUserId() {
		return dealerUserId;
	}
	public void setDealerUserId(String dealerUserId) {
		this.dealerUserId = dealerUserId;
	}
	public String getOnlinePortalStatus() {
		return onlinePortalStatus;
	}
	public void setOnlinePortalStatus(String onlinePortalStatus) {
		this.onlinePortalStatus = onlinePortalStatus;
	}
	public String getOverallStatus() {
		return overallStatus;
	}
	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}
	public String getEstPurchaseMonth() {
		return estPurchaseMonth;
	}
	public void setEstPurchaseMonth(String estPurchaseMonth) {
		this.estPurchaseMonth = estPurchaseMonth;
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
	
	

}
