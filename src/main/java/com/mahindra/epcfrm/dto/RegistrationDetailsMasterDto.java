package com.mahindra.epcfrm.dto;

import java.time.LocalDate;

public class RegistrationDetailsMasterDto {

    private int leadId;
	
	private String farmerRegNo;
	private String quotAttachment;
	private String quotAmount;
	
	//farmer Contribution
	private Long ddNo;
	private double ddAmount;
	private String ddAttachment;
	private LocalDate ddDate;
	private LocalDate preInspectionDate;
	private String faAcceptAttachment;
	
	//work order
	private String wOStatus;
	private String wONumber;
	
	private String apprStatusValue;
	private String manualApprTriggered;
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getFarmerRegNo() {
		return farmerRegNo;
	}
	public void setFarmerRegNo(String farmerRegNo) {
		this.farmerRegNo = farmerRegNo;
	}
	public String getQuotAttachment() {
		return quotAttachment;
	}
	public void setQuotAttachment(String quotAttachment) {
		this.quotAttachment = quotAttachment;
	}
	public String getQuotAmount() {
		return quotAmount;
	}
	public void setQuotAmount(String quotAmount) {
		this.quotAmount = quotAmount;
	}
	public Long getDdNo() {
		return ddNo;
	}
	public void setDdNo(Long ddNo) {
		this.ddNo = ddNo;
	}
	public double getDdAmount() {
		return ddAmount;
	}
	public void setDdAmount(double ddAmount) {
		this.ddAmount = ddAmount;
	}
	public String getDdAttachment() {
		return ddAttachment;
	}
	public void setDdAttachment(String ddAttachment) {
		this.ddAttachment = ddAttachment;
	}
	public LocalDate getDdDate() {
		return ddDate;
	}
	public void setDdDate(LocalDate ddDate) {
		this.ddDate = ddDate;
	}
	public LocalDate getPreInspectionDate() {
		return preInspectionDate;
	}
	public void setPreInspectionDate(LocalDate preInspectionDate) {
		this.preInspectionDate = preInspectionDate;
	}
	public String getFaAcceptAttachment() {
		return faAcceptAttachment;
	}
	public void setFaAcceptAttachment(String faAcceptAttachment) {
		this.faAcceptAttachment = faAcceptAttachment;
	}
	public String getwOStatus() {
		return wOStatus;
	}
	public void setwOStatus(String wOStatus) {
		this.wOStatus = wOStatus;
	}
	public String getwONumber() {
		return wONumber;
	}
	public void setwONumber(String wONumber) {
		this.wONumber = wONumber;
	}
	public String getApprStatusValue() {
		return apprStatusValue;
	}
	public void setApprStatusValue(String apprStatusValue) {
		this.apprStatusValue = apprStatusValue;
	}
	public String getManualApprTriggered() {
		return manualApprTriggered;
	}
	public void setManualApprTriggered(String manualApprTriggered) {
		this.manualApprTriggered = manualApprTriggered;
	}
	
	
	
}
